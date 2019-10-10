package com.aoto.framework.security.models;




/**
 * The Citycoordinates
 *
 * @author ecmybatis
 */

public class Citycoordinates  {

  private String cityID; //城市ID
  private String cityName; //城市名称
  private String administrativeAreaID; //行政区ID
  private String administrativeAreaName; //行政区名称
  private String center_x; //行政区经度
  private String center_y; //行政区维度


    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAdministrativeAreaID() {
        return administrativeAreaID;
    }

    public void setAdministrativeAreaID(String administrativeAreaID) {
        this.administrativeAreaID = administrativeAreaID;
    }

    public String getAdministrativeAreaName() {
        return administrativeAreaName;
    }

    public void setAdministrativeAreaName(String administrativeAreaName) {
        this.administrativeAreaName = administrativeAreaName;
    }

    public String getCenter_x() {
        return center_x;
    }

    public void setCenter_x(String center_x) {
        this.center_x = center_x;
    }

    public String getCenter_y() {
        return center_y;
    }

    public void setCenter_y(String center_y) {
        this.center_y = center_y;
    }
}
