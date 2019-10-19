package com.aoto.framework.security.persistence.inf;

import com.aoto.framework.commons.pagination.PagingCriteria;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface RoomInfoMapper {
    /**
     *
     * @param map map
     */
    void insertRoomInfo(Map<String, Object> map);

    /**
     * 
     * @param houseID houseid
     * @return map
     */
    Map<String, Object> selectRoomInfoByHouseID(String houseID);

    /**
     *
     * @param roomInfo roominfo
     */
    void updateOrg4Import(Map<String, Object> roomInfo);

    /**
     *
     * @param houseID houseid
     */
    void deleteRoomInfo(String houseID);

    /**
     *
     * @param map map
     * @return list
     */
    List<Map<String, Object>> selectUrlByPage(Map<String, Object> map);

    /**
     *
     * @return list
     */
    List<String>administrativeAreaAll(int userId);

    List<String>communityAll(int userId);

    /**
     *
     * @param roomid
     * @return
     */
    Map<String,Object>selectRoomID(int roomid);

    /**
     * 删除
     * @param roomID
     */
    void deleteRoominfo(int roomID);

    /**
     * 获取主键id
     * @return
     */
    int getRoomID();

    void updateImages(Map<String, Object> roomInfo);

    int roomInfoTotal(int userid);

    List<Map<String, Object>> getRoomInfoPage(Map<String, Object> map);
}
