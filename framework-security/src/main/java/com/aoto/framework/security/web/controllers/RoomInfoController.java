package com.aoto.framework.security.web.controllers;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;

import com.aoto.framework.commons.beans.JsonResult;
import com.aoto.framework.commons.lang.StringUtils4Aoto;
import com.aoto.framework.commons.pagination.PaginationQuery;
import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.security.DTO.RoomInfoDTO;
import com.aoto.framework.security.DTO.TotalDTO;
import com.aoto.framework.security.Ecmybatis.Dao;
import com.aoto.framework.security.models.*;
import com.aoto.framework.security.service.inf.CitycoordinatesService;
import com.aoto.framework.security.service.inf.RoomInfoService;
import com.aoto.framework.security.service.inf.UserLogService;
import com.aoto.framework.security.service.inf.UserService;
import com.aoto.framework.security.web.Util.ServerUtil;
import com.jcraft.jsch.SftpException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RoomInfoController {


    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected RoomInfoService roomInfoService;

    @Autowired
    protected UserService userService;

    @Autowired
    protected UserLogService userLogService;

    @Autowired
    protected CitycoordinatesService citycoordinatesService;


    /**
     * 进入房源信息页面
     * @author humz
     */
    @RequestMapping(value = "/system/roominfo/list", method = RequestMethod.GET)
    public ModelAndView enterCusInfoPage()
    {
        return new ModelAndView("system/roominfo/list");
    }

    /**
     * 进入资料审核页面
     * @author humz
     */
    @RequestMapping(value = "/system/roomaudit/list", method = RequestMethod.GET)
    public ModelAndView auditCusInfoPage()
    {
        return new ModelAndView("system/roomaudit/list");
    }


    @RequestMapping(value = "/system/roomaudit/edit", method = RequestMethod.GET)
    public ModelAndView auditShowPage()
    {
        return new ModelAndView("system/roomaudit/edit");
    }

    @RequestMapping(value = "/system/roomaudit/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> editRoomaudit(RoomInfoModel infomodel,
                                                            HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        String errorCode=roomInfoService.editAudit(infomodel);
        if (errorCode != null)
        {
            map.put("msg", errorCode);

        }
        else
        {

            map.put("msg", roomInfoService.selectRoomID(infomodel.getRoomID()));
            // 返回浏览器json
            return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
        }

        return new ResponseEntity<Map<String, Object>>(map,HttpStatus.NOT_IMPLEMENTED);
    }




    @RequestMapping(value = "/system/roominfo/list", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public JsonResult getUrls(RoominfoQuery model,HttpServletRequest request) throws UnsupportedEncodingException {
        if( ServerUtil.isTomcat()){//tomcat server
            if(model.getAdministrativeArea()!=null&&model.getAdministrativeArea()!=""){
                model.setAdministrativeArea(new String(model.getAdministrativeArea().trim().getBytes("ISO-8859-1"), "UTF-8"));
            }
            if(model.getRoomName()!=null&&model.getRoomName()!=""){
                model.setRoomName(new String(model.getRoomName().trim().getBytes("ISO-8859-1"), "UTF-8"));
            }
            if(model.getRoomType()!=null&&model.getRoomType()!=""){
                model.setRoomType(new String(model.getRoomType().trim().getBytes("ISO-8859-1"), "UTF-8"));
            }
            if(model.getRoomStatus()!=null&&model.getRoomStatus()!=""){
                model.setRoomStatus(new String(model.getRoomStatus().trim().getBytes("ISO-8859-1"), "UTF-8"));
            }
        }
        PagingCriteria pagingCriteria = new PagingCriteria(model.getPage() - 1, model.getRows(), model.getSort(),
                model.getOrder());
        List<Map<String, Object>> list = roomInfoService.getUrlByPage(pagingCriteria, model,request);
        JsonResult mode = JsonResult.json(pagingCriteria.getTotal(), list);
        return JsonResult.json(pagingCriteria.getTotal(), list);
    }

	/**
	 * 导入房源数据
	 * @param accept
	 * @return
	 * @throws IOException
	 */
    @RequestMapping(value = "/system/roominfo/import", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> importExcel(
            @RequestParam(value = "file1_excel") MultipartFile file1,
            @RequestParam(value = "file2_zip") MultipartFile file2,
            @RequestHeader(value = "accept") String accept, HttpSession httpSession) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        String errorCode = roomInfoService.importRoomInfo(file1,file2,httpSession);
        if (errorCode != null)
        {
            map.put("msg", errorCode);

        }
        else
        {
            map.put("msg", "success");
            // 返回浏览器json
            String suffix = file1.getOriginalFilename().substring(file1.getOriginalFilename().lastIndexOf("."));
            map.put("suffix", suffix);
            return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
        }

        return new ResponseEntity<Map<String, Object>>(map,HttpStatus.NOT_IMPLEMENTED);

    }

    @RequestMapping(value = "/system/roominfo/new", method = RequestMethod.GET)
    public ModelAndView newRoominfo()
    {
        return new ModelAndView("system/roominfo/new");
    }


    @RequestMapping(value = "/system/roominfo/edit", method = RequestMethod.GET)
    public ModelAndView editRoominfo()
    {
        return new ModelAndView("system/roominfo/edit");
    }

    @RequestMapping(value = "/system/roominfo/import", method = RequestMethod.GET)
    public ModelAndView importRoominfo()
    {
        return new ModelAndView("system/roominfo/import");
    }



    /**
     * 删除
     * @param list
     * @return
     */
    @RequestMapping(value = "/system/roominfo", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResult deleteRoominfo(@RequestBody List<Integer>list)
    {
        roomInfoService.removeRoomInfo(list);
        return JsonResult.json();
    }

    /**
     * 修改
     * @param
     * @return
     */
    @RequestMapping(value = "/system/roominfo/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> editRoominfo(RoomInfoEditModel infomodel,
                               HttpServletRequest request
    ) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        String errorCode=roomInfoService.editRoomInfo(infomodel,request);
        if (errorCode != null)
        {
            map.put("msg", errorCode);

        }
        else
        {
            map.put("msg","succed");
            // 返回浏览器json
            return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
        }

        return new ResponseEntity<Map<String, Object>>(map,HttpStatus.NOT_FOUND);
    }

    /**
     * 增加
     * @param
     * @return
     */
    @RequestMapping(value = "/system/roominfo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>>newRoominfo(RoomInfoNewModel infomodel,
                                          HttpServletRequest request,HttpSession session
                                                          ) throws IOException, SftpException {
        Map<String, Object> map = new HashMap<String, Object>();
        String errorCode=roomInfoService.newRoomInfo(infomodel,request,session);
        if (errorCode != null)
        {
            map.put("msg", errorCode);

        }
        else
        {
            map.put("msg", "success");
            // 返回浏览器json
            return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
        }

        return new ResponseEntity<Map<String, Object>>(map,HttpStatus.NOT_IMPLEMENTED);
    }


    @RequestMapping(value = "/system/roominfo/show", method = RequestMethod.GET)
    public ModelAndView showRoominfo()
    {
        return new ModelAndView("system/roominfo/show");
    }

    /**
     * [简要描述]:exportExcel 下载模板
     * [详细描述]:<br/>
     *
     * @author
     * @return ResponseEntity<byte[]>
     * @throws IOException IOException
     */
    @RequestMapping(value = "/system/roominfo/export", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportQueryToExcel() throws IOException
    {
        String path = roomInfoService.exportroominfo();
        String filenameWithExt = path.substring(path.lastIndexOf("\\") + 1);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentDispositionFormData("attachment", filenameWithExt);
       return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(path)),httpHeaders, HttpStatus.OK);
    }
    /**
     * 获取所有大区
     * @param
     * @return
     */
    @RequestMapping(value = "/system/roominfo/istrative", method = RequestMethod.POST)
    @ResponseBody
    public List<String>  getRAdministrativeArea(
                               HttpServletRequest request
    ) {

        return roomInfoService.administrativeAreaAll(request);
    }

    @RequestMapping(value = "/system/roominfo/roomInfoTotal", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> roomInfoTotal(TotalDTO dto,HttpServletRequest request) throws Exception {
        String ip=getIP(request);
        Map<String, Object> map = new HashMap<String, Object>();
        int index=roomInfoService.roomInfoTotal(request);
        if (index ==-1)
        {
            map.put("msg","用户不存在");
            map.put("code","404");
        }
        if(dto.getIp_addess()==null||dto.getMac_addess()==null){
            map.put("msg","ip和mac地址不能为空");
            map.put("code","400");
            return new ResponseEntity<Map<String, Object>>(map,HttpStatus.BAD_REQUEST);
        }
        else
        {
            String patternMac="^[A-F0-9]{2}(-[A-F0-9]{2}){5}$";
            Pattern pattern = Pattern.compile( "^((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])$" );
            if(!Pattern.compile(patternMac).matcher(dto.getMac_addess()).find()){
                map.put("msg","MAC地址格式或者大小写错误");
                map.put("code","400");
                return new ResponseEntity<Map<String, Object>>(map,HttpStatus.BAD_REQUEST);
            }
            if(!pattern.matcher(dto.getIp_addess()).find()){
                map.put("msg","IP地址格式不正确");
                map.put("code","400");
                return new ResponseEntity<Map<String, Object>>(map,HttpStatus.BAD_REQUEST);
            }
            map.put("msg", "success");
            map.put("codo",200);
            map.put("total",index);
            map.put("ip",ip);
            // 返回浏览器json
            userLogService.add(dto,request,"请求房源数量");

            return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
        }

    }


    @RequestMapping(value = "/system/roominfo/roomInfoPage", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getroomInfoPage(TotalDTO dto, HttpServletRequest request)throws Exception {
        String ip=getIP(request);
        Map<String,Object> map=userService.checkToken(request.getHeader("token"));
        Map<String, Object>roomInfoMap=new HashMap<String, Object>();
        if (map == null)
        {
            roomInfoMap.put("msg","用户不存在");
            roomInfoMap.put("code","404");
            return new ResponseEntity<Map<String, Object>>(roomInfoMap,HttpStatus.NOT_FOUND);
        }
        if(dto.getTotal()==0){
            roomInfoMap.put("msg","Total不能为0");
            roomInfoMap.put("code","404");
            return new ResponseEntity<Map<String, Object>>(roomInfoMap,HttpStatus.NOT_FOUND);
        }
        if(dto.getIp_addess()==null||dto.getMac_addess()==null){
            roomInfoMap.put("msg","ip和mac地址不能为空");
            roomInfoMap.put("code","400");
            return new ResponseEntity<Map<String, Object>>(roomInfoMap,HttpStatus.BAD_REQUEST);
        }
        else
        {
            String patternMac="^[A-F0-9]{2}(-[A-F0-9]{2}){5}$";
            Pattern pattern = Pattern.compile( "^((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])$" );
            if(!Pattern.compile(patternMac).matcher(dto.getMac_addess()).find()){
                map.put("msg","MAC地址格式或者大小写错误");
                map.put("code","400");
                return new ResponseEntity<Map<String, Object>>(map,HttpStatus.BAD_REQUEST);
            }
            if(!pattern.matcher(dto.getIp_addess()).find()){
                map.put("msg","IP地址格式不正确");
                map.put("code","400");
                return new ResponseEntity<Map<String, Object>>(map,HttpStatus.BAD_REQUEST);
            }
            roomInfoMap.put("msg", "success");
            roomInfoMap.put("codo",200);
            roomInfoMap.put("ip",ip);

            List<Map<String, Object>> list =roomInfoService.getRoomInfoPage(dto, (Integer) map.get("userId"));
            roomInfoMap.put("list",list);
            userLogService.add(dto,request,"请求房源数量");
//            userLogService.add(dto,request,"请求房源信息");
            // 返回浏览器json
            return new ResponseEntity<Map<String, Object>>(roomInfoMap,HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/system/roominfo/citycoordinatesSave", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult depositgetcitycoor(@RequestBody List<Citycoordinates>model,TotalDTO dto,HttpServletRequest request)throws Exception{
        Map<String,Object> map_temp=userService.checkToken(request.getHeader("token"));
        Map<String, Object>map=new HashMap<String, Object>();
        String string= citycoordinatesService.save(model);
        String ip=getIP(request);
        if(map_temp==null){
            map.put("msg","用户不存在");
            map.put("code","404");
             return  JsonResult.json(map);
        }
        if(string!=null){
            map.put("msg",string);
            map.put("code","400");
            return  JsonResult.json(map);
        }
        else {
            map.put("msg", "success");
            map.put("codo",200);
            map.put("ip",ip);
            userLogService.add(dto,request,"存入数据地区信息");
        }
        return  JsonResult.json(map);
    }

    @RequestMapping(value = "/system/roominfo/citycoordinatesAll", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getcitycoor(TotalDTO dto,HttpServletRequest request)throws Exception{
        Map<String,Object> map_temp=userService.checkToken(request.getHeader("token"));
        Map<String, Object>map=new HashMap<String, Object>();
        if(map_temp==null){
            map.put("msg","用户不存在");
            map.put("code","404");
            return JsonResult.json(map);
        }
        else {
            String ip=getIP(request);
            List<Citycoordinates>citycoordinates=citycoordinatesService.getAll();
            map.put("msg", "success");
            map.put("codo",200);
            map.put("list",citycoordinates);
            userLogService.add(dto,request,"获取全部城市信息");
        }
        return JsonResult.json(map);
    }




    public static String getIP(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.contains(",")) {
            ip =ip.split(",")[0];
        }
        return ip;
    }






}
