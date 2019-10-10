package com.aoto.framework.security.models;

import com.aoto.framework.commons.pagination.PaginationQuery;

/**
 *
 */
public class RoominfoQuery extends PaginationQuery {

    /**
     * [简要描述]:
     * @author
     */
    private String administrativeArea  ;

    /**
     * [简要描述]:
     * @author zongwj
     */
    private String roomName;

    private String roomType;

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    private String roomStatus;

    public String getAdministrativeArea() {
        return administrativeArea;
    }

    public void setAdministrativeArea(String administrativeArea) {
        this.administrativeArea = administrativeArea;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
