package com.aoto.framework.security.service.impl;

import com.aoto.framework.commons.constant.BeanProperty;
import com.aoto.framework.commons.constant.BeanProperty.Bean;
import com.aoto.framework.commons.constant.NumberEnum;
import com.aoto.framework.commons.lang.StringUtils4Aoto;
import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.commons.userdetails.CurrentUserHolder;
import com.aoto.framework.commons.util.ExcelUtils;
import com.aoto.framework.security.DTO.TotalDTO;
import com.aoto.framework.security.models.*;
import com.aoto.framework.security.persistence.inf.LabelMapper;
import com.aoto.framework.security.persistence.inf.RoomInfoMapper;
import com.aoto.framework.security.persistence.inf.UserMapper;
import com.aoto.framework.security.service.inf.RoomInfoService;
import com.aoto.framework.security.web.Util.FtpJSch;
import com.jcraft.jsch.SftpException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import com.aoto.framework.commons.constant.BeanProperty.RoomInfo;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


@Service
public class RoomInfoServiceImpl implements RoomInfoService {

    @Autowired
    protected RoomInfoMapper roomInfoMapper;

    @Autowired
    protected LabelMapper labelMapper;

    @Autowired
    protected UserMapper userMapper;


    /**
     * [简要描述]:
     * @author zongwj
     */
    @Value("${file.root}")
    protected String fileRoot;


    /**
     * 导入房源信息
     * @author
     */
    protected static final long MAXSIZE = 62914560;

    @Override
    @CacheEvict(value = BeanProperty.Cache.ORG_CACHE, allEntries = true)
    @Transactional
    public String importRoomInfo(MultipartFile file, MultipartFile file2, HttpSession httpSession) throws IOException {
        String img_jpg="jpg".toLowerCase();
        String img_png="png".toLowerCase();
        String img_gif="gif".toLowerCase();
        if(file2.getSize()>0) {
            int count=0;
            String path_url = "E:\\ibank\\imagezip\\";
            path_url = FilenameUtils.concat(path_url, file2.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file2.getInputStream(), new File(path_url));
            File zipfile = new File(path_url);
            File pathFile = new File("E:\\ibank");
            if (!pathFile.exists()) {
                pathFile.mkdirs();
            }
            ZipFile zip = null;
            String zip_name = "";
            int count_zip = 0;
            //指定编码，否则压缩包里面不能有中文目录
            int for_count = 0;
            zip = new ZipFile(zipfile, Charset.forName("gbk"));

            for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();
                if (count>0){
                    String format_img = zipEntryName.substring(zipEntryName.length() - 3);
                    String format_temp_img = format_img.toLowerCase();
                    if(format_temp_img.equals(img_jpg) || format_temp_img.equals(img_png)){

                    }
                    else {
                        return "上传图片格式有误,只支持png,jpg格式";
                    }
                }
                count++;
            }
        }

        String errorCode = "";
        if (file != null)
        {
            long fileSize = file.getSize();
            String ext = FilenameUtils.getExtension(StringUtils4Aoto.trim(file.getOriginalFilename()));

            // 最大60M
            if (fileSize > MAXSIZE)
            {
                errorCode = "overSize";
            }
            else if (!"xls".equals(ext) && !"xlsx".equals(ext))
            {
                errorCode = "传入附件类型错误";
            }
            else if (file.isEmpty())
            {
                errorCode =  "传入附件为空";
            }
        }
        else
        {
            errorCode = "未传入附件";
        }
        if (!StringUtils4Aoto.isEmpty(errorCode))
        {
            return errorCode;
        }
        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();
        Date now = new Date();
        String date = DateFormatUtils.format(now, "yyyyMMddHHmmss");
        String path = FilenameUtils.concat(fileRoot, "excel");
        path = FilenameUtils.concat(path, "import");
        path = FilenameUtils.concat(path, "Mapshowingthe" + date + ".xls");
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));

        /*
         *  上传excel文件,并读取excel 存放到指定的 tmpList中
         */
        List<List<? extends Object>> tmpList = new ArrayList<List<? extends Object>>();
        String[] headers = { "编号", "名称", "小区名称", "租金(元/月)", "户型", "朝向","出租类型","房间面积（平米）",
                "地址（需要添加街道）","室内结构","颜色编码","详细介绍","付款方式","建筑类型","大区","室内设施标签","室外设施标签",
                "房屋优势标签","图片地址","二维码地址","看房时间","所在楼层","房源类型","窗户数量（块）","车位类型","建筑年代","装修程度",
                "发布时间","更新时间","房源编号","小区经度","小区纬度","房源经度","房源纬度","房源类型"};
        errorCode = ExcelUtils.importHousingExcel(tmpList, headers, path);
        Set<String> set_text = new HashSet<String>();
        for (int i=0;i<tmpList.size();i++){

            if (tmpList.get(i).get(0)==""||tmpList.get(i).get(0)==null){
                return "编号不能为空";
            }
            set_text.add((String)tmpList.get(i).get(0));
        }
        if(set_text.size()!=tmpList.size()){
            return "编号不能重复";
        }
        if (!StringUtils4Aoto.isEmpty(errorCode))
        {
            return errorCode;
        }

        /*
         * 较验  tmpList 并组装成指定格式的list
         */
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<Integer, String> temp = new HashMap<Integer, String>();
        temp.put(1,"roomName");
        temp.put(2,"community");
        temp.put(3,"rent");
        temp.put(4,"houseType");
        temp.put(5,"oriented");
        temp.put(6,"rentType");
        temp.put(7,"roomSize");
        temp.put(8,"address");
        temp.put(9,"indoorStructure");
        temp.put(10,"colour");
        temp.put(11,"detailedIntroduction");
        temp.put(12,"paymentMethod");
        temp.put(13,"buildingType");
        temp.put(14,"administrativeArea");
        temp.put(15,"indoorFacilities");
        temp.put(16,"outdoorFacilities");
        temp.put(17,"houseAdvantage");
        temp.put(18,"images");
        temp.put(19,"qrcode");
        temp.put(20,"visitTime");
        temp.put(21,"floor");
        temp.put(22,"publishingMethod");
        temp.put(23,"windowNum");
        temp.put(24,"parkSpace");
        temp.put(25,"buildYear");
        temp.put(26,"decoration");
        temp.put(27,"publicDate");
        temp.put(28,"updateDate");
        temp.put(29,"houseID");
        temp.put(30,"communityLongitude");
        temp.put(31,"communityDimension");
        temp.put(32,"roomLongitude");
        temp.put(33,"roomDimension");
        temp.put(34,"roomType");
        List<Integer>id_excel=new ArrayList<>();
        Map<Integer,Integer>id_houseid=new HashMap<>();

        int parentCodeCount = 0;
        int count=0;
        for (List<? extends Object> rowList : tmpList) {
            count++;
            Map<String, Object> RoomInfoMap = new HashMap<String, Object>();
            for (int i=0;i<rowList.size();i++){
                if(i==0){

                    id_excel.add(Integer.parseInt((String)rowList.get(i)));
                }
                else {

                    RoomInfoMap.put(temp.get(i),rowList.get(i));
                }
            }
            list.add(RoomInfoMap);
        }
        for (Map<String, Object> roominfoMap : list) {
            if(roominfoMap.get("roomType")==null){
                return "房源类型不能为空";
            }
        }
        String regEx = "[`~!@#$%^&*+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);

        for (int i=0;i<list.size();i++){
            if( p.matcher((CharSequence) list.get(i).get("roomName")).find()){
                return "房源名不能出现特殊字符";
            }
            if (p.matcher((CharSequence) list.get(i).get("community")).find()){

                return "小区名不能出现特殊字符";
            }
            if(p.matcher((CharSequence) list.get(i).get(RoomInfo.ADMINISTRATIVE_AREA)).find()){
                return "大区不能出现特殊字符";
            }
            if (list.get(i).get("roomName")==null||list.get(i).get("roomName")==""){
                return "房源名不能为空";
            }
            if (list.get(i).get("community")==null||list.get(i).get("community")==""){
                return "小区名不能为空";
            }
            if (list.get(i).get("rent")==null||list.get(i).get("rent")==""){
                return "租金不能为空";
            }
            if (list.get(i).get(RoomInfo.HOUSE_TYPE)==null||list.get(i).get(RoomInfo.HOUSE_TYPE)==""){
                return "户型不能为空";
            }
            if (list.get(i).get(RoomInfo.ORIENTED)==null||list.get(i).get(RoomInfo.ORIENTED)==""){
                return "朝向不能为空";
            }
            if (list.get(i).get(RoomInfo.RENT_TYPE)==null||list.get(i).get(RoomInfo.RENT_TYPE)==""){
                return "出租类型不能为空";
            }
            if (list.get(i).get(RoomInfo.ROOM_SIZE)==null||list.get(i).get(RoomInfo.ROOM_SIZE)==""){
                return "房间面积不能为空";
            }
            if (list.get(i).get(RoomInfo.ADDRESS)==null||list.get(i).get(RoomInfo.ADDRESS)==""){
                return "地址不能为空";
            }
            if (list.get(i).get(RoomInfo.INDOOR_STRUCTURE)==null||list.get(i).get(RoomInfo.INDOOR_STRUCTURE)==""){
                return "室内结构不能为空";
            }
            if (list.get(i).get(RoomInfo.COLOUR)==null||list.get(i).get(RoomInfo.COLOUR)==""){
                return "颜色编码不能为空";
            }
            if (list.get(i).get(RoomInfo.PAYMENT_METHOD)==null||list.get(i).get(RoomInfo.PAYMENT_METHOD)==""){
                return "付款方式不能为空";
            }
            if (list.get(i).get(RoomInfo.ADMINISTRATIVE_AREA)==null||list.get(i).get(RoomInfo.ADMINISTRATIVE_AREA)==""){
                return "大区不能为空";
            }
            if (list.get(i).get(RoomInfo.BUILDING_TYPE)==null||list.get(i).get(RoomInfo.BUILDING_TYPE)==""){
                return "建筑类型不能为空";
            }

        }
        /*
         *  根据list 更新数据库
         */
        //Boolean flagBoolean = true;
        Map<String, Object> pOrg = null;
        int count_temp=0;
        if (list != null && list.size() > 0){
            count=0;
            for (Map<String, Object> roominfoMap : list) {
                count++;
                    for (int i=1;i<temp.size();i++){
                        roominfoMap.put(temp.get(i),roominfoMap.get(temp.get(i)));
                    }
                    for(int i=15;i<18;i++){
                        Map<String,Object>tempMap=new HashMap<>();
                        String tempStr=(String) roominfoMap.get(temp.get(i));
                        List<String> tempResult = Arrays.asList(tempStr.split(","));
                        for(String str:tempResult){
                            Map<String,Object>tempResultMap=tempMap;
                            tempResultMap.put("labelName",temp.get(i));
                            tempResultMap.put("labelValue",str);
                            Map<String,Object>selectLabelmap=labelMapper.selectLabel(tempResultMap);
                            if(selectLabelmap==null){
                                labelMapper.insertLabel(tempResultMap);
                            }
                        }
                    }
                    roominfoMap.put(RoomInfo.Room_Status,"待审核");
                    roominfoMap.put(RoomInfo.Room_Check,"未审核");
                    roominfoMap.put("userID",httpSession.getAttribute("userID"));
                    roomInfoMapper.insertRoomInfo(roominfoMap);
                    id_houseid.put(id_excel.get(count_temp),roomInfoMapper.getRoomID());
                    count_temp++;
                }
            }
        String path_url="E:\\ibank\\imagezip\\";
        List<String> image_zip=new ArrayList<>();
        path_url = FilenameUtils.concat(path_url, file2.getOriginalFilename());
        FileUtils.copyInputStreamToFile(file2.getInputStream(), new File(path_url));
        HashSet<String>set=new HashSet<>();
        boolean flag = false;
        File zipfile=new File(path_url);
        List<String> urlList=new ArrayList<>();
        File pathFile = new File("E:\\ibank");
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }
        ZipFile zip = null;
        String zip_name="";
        int count_zip=0;
        try {
            //指定编码，否则压缩包里面不能有中文目录
            int for_count=0;
            zip = new ZipFile(zipfile, Charset.forName("gbk"));
            for(Enumeration entries = zip.entries(); entries.hasMoreElements();){
                ZipEntry entry = (ZipEntry)entries.nextElement();
                String zipEntryName = entry.getName();
                if(count_zip==0){
                    zip_name=zipEntryName;
                }
                InputStream in = zip.getInputStream(entry);
                String image_name=zipEntryName.replace(zip_name,"");
                image_zip.add(image_name);
                String string_array[];
                string_array=image_name.split("-");
                set.add(string_array[0]);
                String outPath ="";
                outPath=("E:\\ibank\\images\\"+zipEntryName).replace("/", File.separator);
                count_zip++;
                for (int id:id_houseid.keySet()){
                    if(for_count<1){
                        outPath=("E:\\ibank\\images\\"+id_houseid.get(id)+"\\"+image_name).replace("/", File.separator);
                        break;
                    }
                    if(string_array[1].equals(String.valueOf(id))){
                        outPath=("E:\\ibank\\images\\"+id_houseid.get(id)+"\\"+image_name).replace("/", File.separator);

                    }
                }
                for_count++;
                //判断路径是否存在,不存在则创建文件路径
                File files = new File(outPath.substring(0, outPath.lastIndexOf(File.separator)));
                if(!files.exists()){
                    files.mkdirs();
                }
                //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
                if(new File(outPath).isDirectory()){
                    continue;
                }
                //保存文件路径信息
                urlList.add(outPath);
                OutputStream out = new FileOutputStream(outPath);
                byte[] buf1 = new byte[2048];
                int len;
                while((len=in.read(buf1))>0){
                    out.write(buf1,0,len);
                }
                in.close();
                out.close();
            }
            flag = true;
            //必须关闭，否则无法删除该zip文件
            zip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String temp_name="";
        String string_name="";
        String string_array[];
        Map<Integer,String>map_images=new HashMap<>();
        for (int i=1;i<image_zip.size();i++){
            string_array= image_zip.get(i).split("-");
            if (i==1){
                temp_name=string_array[1];
            }
            if(temp_name.equals(string_array[1])){
                string_name+=image_zip.get(i)+',';
            }
            else {
                map_images.put(id_houseid.get(Integer.parseInt(string_array[1])-1),string_name);
                string_name=image_zip.get(i)+',';
            }

            temp_name = image_zip.get(i).split("-")[1];
        }
       map_images.put(id_houseid.get(Integer.parseInt(temp_name)),string_name);

        for (String images:map_images.values()){
            String id[];
            id=images.split("-");
            images=images.substring(0,images.length()-1);
            Map<String, Object> map = new HashMap<>();
            map.put(RoomInfo.IMAGES,images);
            map.put(RoomInfo.ROOM_ID,id_houseid.get(Integer.parseInt(id[1])));
            roomInfoMapper.updateImages(map);
        }

        return null;
    }

    /**
     * 批量删除
     * @param list
     */
    @Transactional
    @Override
    public String removeRoomInfo(List<Integer> list) {
        for(int roomId:list){
            roomInfoMapper.deleteRoominfo(roomId);
            if(roomId!=0){{
                deleteDir("E:\\ibank\\images\\"+roomId+"");
                deleteDir("E:\\ibank\\qrcode\\"+roomId+"");
            }}
        }
        return "删除成功";
    }

    /**
     * 分页获取数据
     * @param pagingCriteria
     * @param
     * @return
     */
    @Override
    public List<Map<String, Object>> getUrlByPage(PagingCriteria pagingCriteria, RoominfoQuery model,HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
        if(model.getAdministrativeArea()!=null){
            if(model.getAdministrativeArea().equals("请选择")){
                model.setAdministrativeArea(null);
            }
        }
        if(model.getCommunity()!=null){
            if(model.getCommunity().equals("请选择")){
                model.setCommunity(null);
            }
        }
        if(model.getRoomType()!=null){
            if(model.getRoomType().equals("请选择")){
                model.setRoomType(null);
            }
        }
        if(model.getRoomStatus()!=null){
            if(model.getRoomStatus().equals("全部")){
                model.setRoomStatus(null);
            }
        }
        map.put(Bean.PAGING, pagingCriteria);
        map.put("administrativeArea", StringUtils.trim(model.getAdministrativeArea()));
        map.put("roomName", StringUtils.trim(model.getRoomName()));
        map.put("roomType",StringUtils.trim(model.getRoomType()));
        map.put("community",StringUtils.trim(model.getCommunity()));
        map.put("roomStatus",StringUtils.trim(model.getRoomStatus()));
        map.put("userID",request.getSession().getAttribute("userID"));
        List<Map<String,Object>>list=roomInfoMapper.selectUrlByPage(map);
        return list;
    }

    /**
     * 修改房源信息
     * @param model
     * @return
     */
    @Override
    @Transactional
    public String editRoomInfo(RoomInfoEditModel model,HttpServletRequest request)throws IOException{
        String errorCode="";
        if(model.getDelete_img().startsWith(",")){
            model.setDelete_img(model.getDelete_img().substring(1));
        }
        if(model.getDelete_img().endsWith(",")){
            model.setDelete_img(model.getDelete_img().substring(0,model.getDelete_img().length()-1));
        }
        String regEx = "[ `~!@#$%^&*+=|{}':;',\\[\\].<>/?~！@#￥%……&*——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        if( p.matcher(model.getRoomName()).find()){
            return "房源名不能出现特殊字符";
        }
        if (p.matcher(model.getCommunity()).find()){

            return "小区名不能出现特殊字符";
        }
        if(p.matcher(model.getAdministrativeArea()).find()){
            return "大区不能出现特殊字符";
        }



        MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest)request;
        MultiValueMap<String, MultipartFile> fileMap = multipartRequest.getMultiFileMap();
        if(fileMap.get("file2_edit").get(0).getSize()>0){
            String ext2 = FilenameUtils.getExtension(StringUtils4Aoto.trim(fileMap.get("file2_edit").get(0).getOriginalFilename()));
            if(!ext2.equalsIgnoreCase("jpg")&& ext2.equalsIgnoreCase("png")){
                errorCode="只能上传jpg和png文件";
                return errorCode;
            }
        }
        for (MultipartFile temp:fileMap.get("file1_edit")){
            if(temp!=null&&temp.getOriginalFilename()!=""&&temp.getOriginalFilename()!=null){
                String ext1 = FilenameUtils.getExtension(StringUtils4Aoto.trim(temp.getOriginalFilename()));
                if(!ext1.equalsIgnoreCase("jpg")||ext1.equalsIgnoreCase("png")){
                    errorCode="只能上传jpg和png文件";
                    return  errorCode;
                }
            }
        }
        Map<String,Object>roominfo=roomInfoMapper.selectRoomID(model.getRoomID());
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
        String imagesStr =(String) roominfo.get("images");
        String imgaesAfter[]=imagesStr.split(",");
        String imagesFront[]=model.getDelete_img().split(",");
        String Qrcode=  fileMap.get("file2_edit").get(0).getOriginalFilename();
        String urlImg = "E:\\ibank\\images";
        String urlQrcode = "E:\\ibank\\qrcode";
        Date now = new Date();
        List<String>data_images=new ArrayList<>();
        Collections.addAll(data_images,imgaesAfter);

        List<String>after_images=new ArrayList<>();
        Collections.addAll(after_images,imagesFront);

        List<String>temp_list=new ArrayList<>();

        for (String temp :data_images){
            if(!after_images.contains(temp)){
                temp_list.add(temp);
            }
        }
        String Images="";
        if( fileMap.get("file1_edit") == null ||  fileMap.get("file1_edit").get(0).getSize() ==0){
            if(roominfo.get(RoomInfo.IMAGES)!=model.getDelete_img()){
                for (String string:temp_list){
                    File file=new File("E:\\ibank\\images\\"+roominfo.get("roomID")+"\\"+string+"");
                    file.delete();
                }
            }
            Images=model.getDelete_img();
        }
        else if( fileMap.get("file1_edit")!=null&& fileMap.get("file1_edit").get(0).getSize()>0&&temp_list.size()>0){
            Images=model.getDelete_img();
            for (int i = 0; i <  fileMap.get("file1_edit").size(); i++) {
                MultipartFile filex =  fileMap.get("file1_edit").get(i);
                String tempImg= fileMap.get("file1_edit").get(i).getOriginalFilename()+",";
                // 保存文件
                saveFile(urlImg,filex,model.getRoomID());
            }
            for (MultipartFile temp: fileMap.get("file1_edit")){
                Images+=","+temp.getOriginalFilename();
            }

            for (String string:temp_list){
                File file=new File("E:\\ibank\\images\\"+roominfo.get("roomID")+"\\"+string+"");
                file.delete();
            }
        }
        else if( fileMap.get("file1_edit")!=null&& fileMap.get("file1_edit").get(0).getSize()>0&&temp_list.size()==0){
            Images=model.getDelete_img();
            for (int i = 0; i <  fileMap.get("file1_edit").size(); i++) {
                MultipartFile filex =  fileMap.get("file1_edit").get(i);
                String tempImg=fileMap.get("file1_edit").get(i).getOriginalFilename()+",";
                // 保存文件
                saveFile(urlImg,filex,model.getRoomID());
            }
            for (MultipartFile temp: fileMap.get("file1_edit")){
                Images+=","+temp.getOriginalFilename();
            }
        }
        if(roominfo.get("qrcode")== fileMap.get("file2_edit").get(0).getName()){
            File file=new File("E:\\ibank\\qrcode\\"+roominfo.get("roomID")+"\\"+fileMap.get("file2_edit").get(0).getName()+"");
            file.delete();
        }

        if( fileMap.get("file2_edit")!=null&& fileMap.get("file2_edit").get(0).getSize()>0){
            saveFile(urlQrcode, fileMap.get("file2_edit").get(0),model.getRoomID());
            Qrcode=fileMap.get("file2_edit").get(0).getOriginalFilename();
        }
        else{
            Qrcode=(String) roominfo.get(RoomInfo.QRCODE);
        }
        if(Images.startsWith(",")){
            Images=Images.substring(1);
        }
            map.put(RoomInfo.ROOM_ID,model.getRoomID());
            map.put(RoomInfo.ROOM_NAME,model.getRoomName());
            map.put(RoomInfo.COMMUNITY,model.getCommunity());
            map.put(RoomInfo.RENT,model.getRent());
            map.put(RoomInfo.HOUSE_TYPE,model.getHouseType());
            map.put(RoomInfo.ORIENTED,model.getOriented());
            map.put(RoomInfo.RENT_TYPE,model.getRentType());
            map.put(RoomInfo.ROOM_SIZE,model.getRoomSize());
            map.put(RoomInfo.ADDRESS,model.getAddress());
            map.put(RoomInfo.INDOOR_STRUCTURE,model.getIndoorStructure());
            map.put(RoomInfo.COLOUR,model.getColour());
            map.put(RoomInfo.DETAILED_INTRODUCTION,model.getDetailedIntroduction());
            map.put(RoomInfo.PAYMENT_METHOD,model.getPaymentMethod());
            map.put(RoomInfo.BUILDING_TYPE,model.getBuildingType());
            map.put(RoomInfo.ADMINISTRATIVE_AREA,model.getAdministrativeArea());
            map.put(RoomInfo.INDOOR_FACILITIES,model.getIndoorFacilities());
            map.put(RoomInfo.OUTDOOR_FACILITIES,model.getOutdoorFacilities());
            map.put(RoomInfo.HOUSE_ADVANTAGE,model.getHouseAdvantage());
            map.put(RoomInfo.VISIT_TIME,model.getVisitTime());
            map.put(RoomInfo.FLOOR,model.getFloor());
            map.put(RoomInfo.IMAGES,Images);
            map.put(RoomInfo.QRCODE,Qrcode);
            map.put(RoomInfo.PUBLISHING_METHOD,model.getPublishingMethod());
            map.put(RoomInfo.WINDOW_NUM,model.getWindowNum());
            map.put(RoomInfo.PARK_SPACE,model.getParkSpace());
            map.put(RoomInfo.BUILD_YEAR,model.getBuildYear());
            map.put(RoomInfo.DECORATION,model.getDecoration());
            map.put(RoomInfo.PUBLIC_DATE,roominfo.get("publicDate"));
            map.put(RoomInfo.UPDATE_DATE,now);
            map.put(RoomInfo.HOUSE_ID,model.getHouseID());
            map.put(RoomInfo.COMMUNITY_LONGITUDE,model.getCommunityLongitude());
            map.put(RoomInfo.COMMUNITYDIMENSION,model.getCommunityDimension());
            map.put(RoomInfo.ROOM_LONGITUDE,model.getRoomLongitude());
            map.put(RoomInfo.ROOM_DIMENSION,model.getRoomDimension());
            map.put(RoomInfo.ROOM_TYPE,model.getRoomType());
            map.put(RoomInfo.Room_Check,model.getRoomCheck());
            map.put(RoomInfo.Room_Status,model.getRoomStatus());
            roomInfoMapper.updateOrg4Import(map);
            return null;

    }

    /**
     * 添加房源信息
     * @param model
     * @return
     */
    @Override
    public String insertRoomInfo(RoomInfoModel model) {
        String regEx = "[ `~!@#$%^&*+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        if( p.matcher(model.getRoomName()).find()){
            return "房源名不能出现特殊字符";
        }
        if (p.matcher(model.getCommunity()).find()){

            return "小区名不能出现特殊字符";
        }
        if(p.matcher(model.getAdministrativeArea()).find()){
            return "大区不能出现特殊字符";
        }

        if(model.getRoomName()==null||model.getRoomName()==""){
            return "房源名不能为空";
        }
        if(model.getCommunity()==null||model.getCommunity()==""){
            return "小区名不能为空";
        }
        if(model.getRent()<0){
            return "租金不能为负数";
        }
        if(model.getHouseType()==null||model.getHouseType()==""){
            return "户型不能为空";
        }
        if(model.getOriented()==null||model.getOriented()==""){
            return "朝向名不能为空";
        }
        if(model.getRentType()==null||model.getRentType()==""){
            return "出租类型不能为空";
        }
        if(model.getRoomSize()<0){
            return "房间面积不能为负数";
        }
        if(model.getAddress()==null||model.getAddress()==""){
            return "地址不能为空";
        }
        if(model.getIndoorStructure()==null||model.getIndoorStructure()==""){
            return "室内结构不能为空";
        }
        if(model.getColour()==null||model.getColour()==""){
            return "颜色编码不能为空";
        }
        if(model.getPaymentMethod()==null||model.getPaymentMethod()==""){
            return "付款方式不能为空";
        }
        if(model.getBuildingType()==null||model.getBuildingType()==""){
            return "建筑类型不能为空";
        }
        if(model.getAdministrativeArea()==null||model.getAdministrativeArea()==""){
            return "大区不能为空";
        }
        if(model.getRoomType()==null||model.getRoomType()==""){
            return  "房源类型不能为空";
        }

        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
        map.put(RoomInfo.ROOM_NAME,model.getRoomName());
        map.put(RoomInfo.COMMUNITY,model.getCommunity());
        map.put(RoomInfo.RENT,model.getRent());
        map.put(RoomInfo.HOUSE_TYPE,model.getHouseType());
        map.put(RoomInfo.ORIENTED,model.getOriented());
        map.put(RoomInfo.RENT_TYPE,model.getRentType());
        map.put(RoomInfo.ROOM_SIZE,model.getRoomSize());
        map.put(RoomInfo.ADDRESS,model.getAddress());
        map.put(RoomInfo.INDOOR_STRUCTURE,model.getIndoorStructure());
        map.put(RoomInfo.COLOUR,model.getColour());
        map.put(RoomInfo.DETAILED_INTRODUCTION,model.getDetailedIntroduction());
        map.put(RoomInfo.PAYMENT_METHOD,model.getPaymentMethod());
        map.put(RoomInfo.BUILDING_TYPE,model.getBuildingType());
        map.put(RoomInfo.ADMINISTRATIVE_AREA,model.getAdministrativeArea());
        map.put(RoomInfo.INDOOR_FACILITIES,model.getIndoorFacilities());
        map.put(RoomInfo.OUTDOOR_FACILITIES,model.getOutdoorFacilities());
        map.put(RoomInfo.HOUSE_ADVANTAGE,model.getHouseAdvantage());
        map.put(RoomInfo.IMAGES,model.getImages());
        map.put(RoomInfo.QRCODE,model.getQrcode());
        map.put(RoomInfo.VISIT_TIME,model.getVisitTime());
        map.put(RoomInfo.FLOOR,model.getFloor());
        map.put(RoomInfo.PUBLISHING_METHOD,model.getPublishingMethod());
        map.put(RoomInfo.WINDOW_NUM,model.getWindowNum());
        map.put(RoomInfo.PARK_SPACE,model.getParkSpace());
        map.put(RoomInfo.BUILD_YEAR,model.getBuildYear());
        map.put(RoomInfo.DECORATION,model.getDecoration());
        map.put(RoomInfo.PUBLIC_DATE,model.getPublicDate());
        map.put(RoomInfo.UPDATE_DATE,model.getUpdateDate());
        map.put(RoomInfo.HOUSE_ID,model.getHouseID());
        map.put(RoomInfo.COMMUNITY_LONGITUDE,model.getCommunityLongitude());
        map.put(RoomInfo.COMMUNITYDIMENSION,model.getCommunityDimension());
        map.put(RoomInfo.ROOM_LONGITUDE,model.getRoomLongitude());
        map.put(RoomInfo.ROOM_DIMENSION,model.getRoomDimension());
        map.put(RoomInfo.ROOM_TYPE,model.getRoomType());
        roomInfoMapper.insertRoomInfo(map);
        return null;
    }

    /**
     * 上传图片
     * @param file
     * @return
     * @throws IOException
     */
    @Override
    @CacheEvict(value = BeanProperty.Cache.ORG_CACHE, allEntries = true)
    @Transactional
    public String importImages(MultipartFile file) throws IOException {
        String errorCode = "";
        if (file != null)
        {
            long fileSize = file.getSize();
            String ext = FilenameUtils.getExtension(StringUtils4Aoto.trim(file.getOriginalFilename()));

            // 最大60M
            if (fileSize > MAXSIZE)
            {
                errorCode = "overSize";
            }
        }
        else
        {
            errorCode = "未传入附件";
        }
        if (!StringUtils4Aoto.isEmpty(errorCode))
        {
            return errorCode;
        }
        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();
        Date now = new Date();
        String date = DateFormatUtils.format(now, "yyyyMMddHHmmss");
        String path = FilenameUtils.concat(fileRoot, "excel");
        path = FilenameUtils.concat(path, "import");
        path = FilenameUtils.concat(path, "Mapshowingthe" + date + ".xls");
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));
        return null;
    }

    @Override
    public List<String> administrativeAreaAll(HttpServletRequest request) {

        int userID=(int)request.getSession().getAttribute("userID");
        return roomInfoMapper.administrativeAreaAll(userID);
    }

    @Override
    public List<String> communityAll(HttpServletRequest request) {
        int userID=(int)request.getSession().getAttribute("userID");
        return roomInfoMapper.communityAll(userID);
    }

    @Override
    public String newRoomInfo(RoomInfoNewModel model,HttpServletRequest request,HttpSession session) throws IOException, SftpException {
        String regEx = "[ `~!@#$%^&*+=|{}':;',\\[\\].<>/?~！@#￥%……&*——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        if( p.matcher(model.getRoomName()).find()){
            return "房源名不能出现特殊字符";
        }
        if (p.matcher(model.getCommunity()).find()){

            return "小区名不能出现特殊字符";
        }
        if(p.matcher(model.getAdministrativeArea()).find()){
            return "大区不能出现特殊字符";
        }

        if(model.getCommunity()==null||model.getCommunity()==""){
            return "小区名不能为空";
        }
        if(model.getRent()<0){
            return "租金不能为负数";
        }
        if(model.getHouseType()==null||model.getHouseType()==""){
            return "户型不能为空";
        }
        if(model.getOriented()==null||model.getOriented()==""){
            return "朝向名不能为空";
        }
        if(model.getRentType()==null||model.getRentType()==""){
            return "出租类型不能为空";
        }
        if(model.getRoomSize()<0){
            return "房间面积不能为负数";
        }
        if(model.getAddress()==null||model.getAddress()==""){
            return "地址不能为空";
        }
        if(model.getIndoorStructure()==null||model.getIndoorStructure()==""){
            return "室内结构不能为空";
        }
        if(model.getColour()==null||model.getColour()==""){
            return "颜色编码不能为空";
        }
        if(model.getPaymentMethod()==null||model.getPaymentMethod()==""){
            return "付款方式不能为空";
        }
        if(model.getBuildingType()==null||model.getBuildingType()==""){
            return "建筑类型不能为空";
        }
        if(model.getAdministrativeArea()==null||model.getAdministrativeArea()==""){
            return "大区不能为空";
        }
        if(model.getRoomType()==null||model.getRoomType()==""){
            return  "房源类型不能为空";
        }
        String errorCode = "";
        MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest)request;
        MultiValueMap<String, MultipartFile> fileMap = multipartRequest.getMultiFileMap();

         if(fileMap.get("file2_new").get(0).getSize()>0){
             String ext2 = FilenameUtils.getExtension(StringUtils4Aoto.trim(fileMap.get("file2_new").get(0).getOriginalFilename()));
             if(!ext2.equalsIgnoreCase("jpg")&& ext2.equalsIgnoreCase("png")){
                 errorCode="只能上传jpg和png文件";
                 return errorCode;
             }
         }


        for (MultipartFile temp:fileMap.get("file1_new")){
            if(temp.getSize()>0){
                String ext1 = FilenameUtils.getExtension(StringUtils4Aoto.trim(temp.getOriginalFilename()));
                if(!ext1.equalsIgnoreCase("jpg")||ext1.equalsIgnoreCase("png")){
                    errorCode="只能上传jpg和png文件";
                    return  errorCode;
                }
            }
        }

        Date now = new Date();
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
        map.put(RoomInfo.ROOM_NAME,model.getRoomName());
        map.put(RoomInfo.COMMUNITY,model.getCommunity());
        map.put(RoomInfo.RENT,model.getRent());
        map.put(RoomInfo.HOUSE_TYPE,model.getHouseType());
        map.put(RoomInfo.ORIENTED,model.getOriented());
        map.put(RoomInfo.RENT_TYPE,model.getRentType());
        map.put(RoomInfo.ROOM_SIZE,model.getRoomSize());
        map.put(RoomInfo.ADDRESS,model.getAddress());
        map.put(RoomInfo.INDOOR_STRUCTURE,model.getIndoorStructure());
        map.put(RoomInfo.COLOUR,model.getColour());
        map.put(RoomInfo.DETAILED_INTRODUCTION,model.getDetailedIntroduction());
        map.put(RoomInfo.PAYMENT_METHOD,model.getPaymentMethod());
        map.put(RoomInfo.BUILDING_TYPE,model.getBuildingType());
        map.put(RoomInfo.ADMINISTRATIVE_AREA,model.getAdministrativeArea());

        map.put(RoomInfo.INDOOR_FACILITIES,model.getIndoorFacilities());
        map.put(RoomInfo.OUTDOOR_FACILITIES,model.getOutdoorFacilities());
        map.put(RoomInfo.HOUSE_ADVANTAGE,model.getHouseAdvantage());

        map.put(RoomInfo.VISIT_TIME,model.getVisitTime());
        map.put(RoomInfo.IMAGES,"");
        map.put(RoomInfo.QRCODE,"");
        map.put(RoomInfo.FLOOR,model.getFloor());
        map.put(RoomInfo.PUBLISHING_METHOD,model.getPublishingMethod());
        map.put(RoomInfo.WINDOW_NUM,model.getWindowNum());
        map.put(RoomInfo.PARK_SPACE,model.getParkSpace());
        map.put(RoomInfo.BUILD_YEAR,model.getBuildYear());
        map.put(RoomInfo.DECORATION,model.getDecoration());
        map.put(RoomInfo.PUBLIC_DATE,now);
        map.put(RoomInfo.UPDATE_DATE,now);
        map.put(RoomInfo.HOUSE_ID,model.getHouseID());
        map.put(RoomInfo.COMMUNITY_LONGITUDE,model.getCommunityLongitude());
        map.put(RoomInfo.COMMUNITYDIMENSION,model.getCommunityDimension());
        map.put(RoomInfo.ROOM_LONGITUDE,model.getRoomLongitude());
        map.put(RoomInfo.ROOM_DIMENSION,model.getRoomDimension());
        map.put(RoomInfo.ROOM_TYPE,model.getRoomType());
        map.put(RoomInfo.Room_Status,"待审核");
        map.put(RoomInfo.Room_Check,"未审核");
        map.put("userID",session.getAttribute("userID"));
        roomInfoMapper.insertRoomInfo(map);
        RoomInfoModel model11=new RoomInfoModel();
        model11.setRoomID(roomInfoMapper.getRoomID());

        String Images="";
        String Qrcode="";
        String urlImg = "E:\\ibank\\images";
        String urlQrcode = "E:\\ibank\\qrcode";
        if ( fileMap.get("file1_new").get(0).getSize()>0) {

            for (int i = 0; i < fileMap.get("file1_new").size(); i++) {
                MultipartFile filex = fileMap.get("file1_new").get(i);
                String tempImg = fileMap.get("file1_new").get(i).getOriginalFilename() + ",";
                Images += tempImg;
                // 保存文件
//                String urlUpload=urlImg+'\\'+model11.getRoomID();
//                FtpJSch ftpJSch=new FtpJSch();
//                ftpJSch.getConnect();
//                ftpJSch.upload(filex,"/var/www/images/904");
//              ftpJSch.deletedir("/var/www/images/904/");
//                //ftpJSch.upload(file,"/var/www/images/904/");
//                ftpJSch.closeFptConnect();

                saveFile(urlImg, filex, model11.getRoomID());
            }
            Images=Images.substring(0, Images.length() - 1);
        }
        if (fileMap.get("file2_new").get(0).getSize()>0) {
            saveFile(urlQrcode,fileMap.get("file2_new").get(0),model11.getRoomID());
            Qrcode=fileMap.get("file2_new").get(0).getOriginalFilename();
        }
        map.put(RoomInfo.IMAGES,Images);
        map.put(RoomInfo.QRCODE,Qrcode);
        roomInfoMapper.updateOrg4Import(map);

        return null;
    }

    @Override
    public String editAudit(RoomInfoModel model) {
        Date now = new Date();
        Map<String, Object> map = new HashMap<>();
        map.put(RoomInfo.ROOM_ID,model.getRoomID());
        map.put(RoomInfo.ROOM_NAME,model.getRoomName());
        map.put(RoomInfo.COMMUNITY,model.getCommunity());
        map.put(RoomInfo.RENT,model.getRent());
        map.put(RoomInfo.HOUSE_TYPE,model.getHouseType());
        map.put(RoomInfo.ORIENTED,model.getOriented());
        map.put(RoomInfo.RENT_TYPE,model.getRentType());
        map.put(RoomInfo.ROOM_SIZE,model.getRoomSize());
        map.put(RoomInfo.ADDRESS,model.getAddress());
        map.put(RoomInfo.INDOOR_STRUCTURE,model.getIndoorStructure());
        map.put(RoomInfo.COLOUR,model.getColour());
        map.put(RoomInfo.DETAILED_INTRODUCTION,model.getDetailedIntroduction());
        map.put(RoomInfo.PAYMENT_METHOD,model.getPaymentMethod());
        map.put(RoomInfo.BUILDING_TYPE,model.getBuildingType());
        map.put(RoomInfo.ADMINISTRATIVE_AREA,model.getAdministrativeArea());
        map.put(RoomInfo.INDOOR_FACILITIES,model.getIndoorFacilities());
        map.put(RoomInfo.OUTDOOR_FACILITIES,model.getOutdoorFacilities());
        map.put(RoomInfo.HOUSE_ADVANTAGE,model.getHouseAdvantage());
        map.put(RoomInfo.IMAGES,model.getImages());
        map.put(RoomInfo.QRCODE,model.getQrcode());
        map.put(RoomInfo.VISIT_TIME,model.getVisitTime());
        map.put(RoomInfo.FLOOR,model.getFloor());
        map.put(RoomInfo.PUBLISHING_METHOD,model.getPublishingMethod());
        map.put(RoomInfo.WINDOW_NUM,model.getWindowNum());
        map.put(RoomInfo.PARK_SPACE,model.getParkSpace());
        map.put(RoomInfo.BUILD_YEAR,model.getBuildYear());
        map.put(RoomInfo.DECORATION,model.getDecoration());
        map.put(RoomInfo.PUBLIC_DATE,model.getPublicDate());
        map.put(RoomInfo.UPDATE_DATE,now);
        map.put(RoomInfo.HOUSE_ID,model.getHouseID());
        map.put(RoomInfo.COMMUNITY_LONGITUDE,model.getCommunityLongitude());
        map.put(RoomInfo.COMMUNITYDIMENSION,model.getCommunityDimension());
        map.put(RoomInfo.ROOM_LONGITUDE,model.getRoomLongitude());
        map.put(RoomInfo.ROOM_DIMENSION,model.getRoomDimension());
        map.put(RoomInfo.ROOM_TYPE,model.getRoomType());
        map.put(RoomInfo.Room_Check,"已审核");
        if(model.getRoomStatus().equals("通过")){
            map.put(RoomInfo.Room_Status,"已通过");
        }
        else {
            map.put(RoomInfo.Room_Status,model.getRoomStatus());
        }
        map.put(RoomInfo.Room_Cause,model.getRoomCause());
        roomInfoMapper.updateOrg4Import(map);
        return null;
    }

    @Override
    public int roomInfoTotal(HttpServletRequest request) {
       Map<String,Object> user=userMapper.checkToken(request.getHeader("token"));
       if (user!=null){
           int index =roomInfoMapper.roomInfoTotal((Integer) user.get("userId"));
           return index;
       }
       return -1;

    }

    @Override
    public List<Map<String, Object>> getRoomInfoPage(TotalDTO dto, int userID) {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
        map.put("limit",dto.getLimit());
        map.put("total",dto.getTotal());
        map.put("userID",userID);
        List<Map<String,Object>>list=roomInfoMapper.getRoomInfoPage(map);
        return list;
    }

    @Override
    public String selectRoomID(int roomid) {
        Map<String,Object>map=roomInfoMapper.selectRoomID(roomid);
        if(map.get("roomStatus").equals("已通过")){
            return "审核通过";
        }
        return "审核不通过";

    }

    /**
     * 下载模板
     * @return
     */
    @Override
    public String exportroominfo() {
        List<OrgExportModel> resList = new ArrayList<OrgExportModel>();
        String[] headers = { "编号(需与图片名对应)(必填)", "名称(必填)", "小区名称(必填)", "租金(元/月)(必填)", "户型(必填)", "朝向(必填)","出租类型(必填)","房间面积（平米）(必填)",
                "地址（需要添加街道）(必填)","室内结构(必填)","颜色编码(必填)","详细介绍","付款方式(必填)","建筑类型(必填)","大区(必填)","室内设施标签","室外设施标签",
                "房屋优势标签","图片地址","二维码地址","看房时间","所在楼层","房源类型","窗户数量（块）","车位类型","建筑年代","装修程度",
                "发布时间","更新时间","房源编号","小区经度","小区纬度","房源经度","房源纬度","房源类型(必填)"};
        String path = FilenameUtils.concat(fileRoot, "excel");
        String date = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
        path = FilenameUtils.concat(path, "export");
        path = FilenameUtils.concat(path, "房源导入模板" + date+ ".xls");

        File file = new File(path);
        if (!file.getParentFile().exists())
        {
            file.getParentFile().mkdirs();
        }
        ExcelUtils.exportExcel("房源信息", headers, resList, path);
        return path;
    }


    public static void saveFile(String path,MultipartFile file,int model) throws IOException {

        String roomID = String.valueOf(model);
        String originalUrl = file.getOriginalFilename();
        String path_url = FilenameUtils.concat(path, roomID);
        path_url = FilenameUtils.concat(path_url, originalUrl);
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path_url));
    }

    public static String deleteDir(String dirPath)
    {
        File file = new File(dirPath);
        if(!file.exists()){
            // 文件不存在
            file.mkdirs();


        }
        if(file.isFile())
        {
            file.delete();
        }else
        {
            File[] files = file.listFiles();
            if(files == null)
            {
                file.delete();
            }else
            {
                for (int i = 0; i < files.length; i++)
                {
                    deleteDir(files[i].getAbsolutePath());
                }
                file.delete();
            }
        }
        return "";
    }


}
