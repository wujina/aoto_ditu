/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：Role.java
 * 文件名称：Role.java
 * 系统编号：mips
 * 系统名称：mips
 * 模块编号：
 * 模块名称：
 * 作          者：lih
 * 完成日期：2013年9月24日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.security.models;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author lih
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public class UrlModel implements Serializable
{
    private static final long serialVersionUID = -4130169418427937964L;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int urlId;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String urlName;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String urlPattern;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String httpMethod;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int loggedDataChanged;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String actionCode;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String argsCode;
    
    public String getActionCode() {
        return actionCode;
    }
    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }
    public String getArgsCode() {
        return argsCode;
    }
    public void setArgsCode(String argsCode) {
        this.argsCode = argsCode;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public int getLoggedDataChanged() {
        return loggedDataChanged;
    }
    public void setLoggedDataChanged(int loggedDataChanged) {
        this.loggedDataChanged = loggedDataChanged;
    }
    public int getUrlId() {
        return urlId;
    }
    public void setUrlId(int urlId) {
        this.urlId = urlId;
    }
    public String getUrlName() {
        return urlName;
    }
    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }
    public String getUrlPattern() {
        return urlPattern;
    }
    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }
    public String getHttpMethod() {
        return httpMethod;
    }
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }   
}
