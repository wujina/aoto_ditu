package com.aoto.framework.security.models;

import com.aoto.framework.security.Ecmybatis.BaseModel;

import java.time.LocalDateTime;

/**
 * The UserLog
 *
 * @author ecmybatis
 */


public class UserLog extends BaseModel {

  private Integer userLogId; //
  private Integer userLogUser; //用户Id
  private String userLogOperator; //操作
  private String userLogIp; //
  private java.util.Date userLogCallTime; //
  private String userLogBrower; //浏览器
  private String userLogOperating; //操作系统
  private String userLogMacAddress; //
  private String userLogIpAddess; //

  public Integer getUserLogId() {
    return userLogId;
  }

  public void setUserLogId(Integer userLogId) {
    this.userLogId = userLogId;
  }

  public Integer getUserLogUser() {
    return userLogUser;
  }

  public void setUserLogUser(Integer userLogUser) {
    this.userLogUser = userLogUser;
  }

  public String getUserLogOperator() {
    return userLogOperator;
  }

  public void setUserLogOperator(String userLogOperator) {
    this.userLogOperator = userLogOperator;
  }

  public String getUserLogIp() {
    return userLogIp;
  }

  public void setUserLogIp(String userLogIp) {
    this.userLogIp = userLogIp;
  }

  public java.util.Date getUserLogCallTime() {
    return userLogCallTime;
  }

  public void setUserLogCallTime(java.util.Date userLogCallTime) {
    this.userLogCallTime = userLogCallTime;
  }

  public String getUserLogBrower() {
    return userLogBrower;
  }

  public void setUserLogBrower(String userLogBrower) {
    this.userLogBrower = userLogBrower;
  }

  public String getUserLogOperating() {
    return userLogOperating;
  }

  public void setUserLogOperating(String userLogOperating) {
    this.userLogOperating = userLogOperating;
  }

  public String getUserLogMacAddress() {
    return userLogMacAddress;
  }

  public void setUserLogMacAddress(String userLogMacAddress) {
    this.userLogMacAddress = userLogMacAddress;
  }

  public String getUserLogIpAddess() {
    return userLogIpAddess;
  }

  public void setUserLogIpAddess(String userLogIpAddess) {
    this.userLogIpAddess = userLogIpAddess;
  }
}
