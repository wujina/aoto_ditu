package com.aoto.framework.security.DTO;

/**
 * @program: framework-web
 * @description:
 * @author: Mr.wuj
 * @create: 2019-09-17 11:54
 **/
public class TotalDTO {

    private String mac_addess;

    private String ip_addess;

    private int Limit;

    private int Total;


    public String getMac_addess() {
        return mac_addess;
    }

    public void setMac_addess(String mac_addess) {
        this.mac_addess = mac_addess;
    }

    public String getIp_addess() {
        return ip_addess;
    }

    public void setIp_addess(String ip_addess) {
        this.ip_addess = ip_addess;
    }

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
