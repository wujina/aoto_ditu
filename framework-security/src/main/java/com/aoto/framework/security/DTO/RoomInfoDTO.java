package com.aoto.framework.security.DTO;

/**
 * @program: framework-web
 * @description:
 * @author: Mr.wuj
 * @create: 2019-09-23 11:22
 **/
public class RoomInfoDTO {
    private int Limit;

    private int Total;



    public int getLimit() {
        return Limit;
    }

    public void setLimit(int limit) {
        Limit = limit;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }
}
