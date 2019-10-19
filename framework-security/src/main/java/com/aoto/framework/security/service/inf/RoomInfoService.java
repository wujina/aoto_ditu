package com.aoto.framework.security.service.inf;

import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.security.DTO.RoomInfoDTO;
import com.aoto.framework.security.DTO.TotalDTO;
import com.aoto.framework.security.models.*;
import com.jcraft.jsch.SftpException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface RoomInfoService {
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *  批量导入
     * @author
     * @param file MultipartFile
     * @return String
     * @throws IOException IOException
     */
    String importRoomInfo(MultipartFile file, MultipartFile file2, HttpSession httpSession) throws IOException;

    /**
     * 删除房源信息
     * @param list
     */
    String removeRoomInfo(List<Integer> list);

    /**
     * 分页获取
     * @param pagingCriteria
     * @param model
     * @return
     */
    List<Map<String, Object>> getUrlByPage(PagingCriteria pagingCriteria, RoominfoQuery model,HttpServletRequest request);

    /**
     * 修改房源信息
     * @param model
     * @return
     */
    String editRoomInfo(RoomInfoEditModel model, HttpServletRequest request)throws IOException;


    /**
     * 添加房源信息
     * @param model
     * @return
     */
    String insertRoomInfo(RoomInfoModel model);

    String exportroominfo();

    String importImages(MultipartFile file) throws IOException;

    List<String>administrativeAreaAll(HttpServletRequest request);

    List<String>communityAll(HttpServletRequest request);

    String newRoomInfo(RoomInfoNewModel model, HttpServletRequest request, HttpSession session) throws IOException, SftpException;

    String editAudit(RoomInfoModel model);

    int roomInfoTotal(HttpServletRequest request);

    List<Map<String, Object>> getRoomInfoPage(TotalDTO dto, int userID);

   String selectRoomID(int roomid);



}
