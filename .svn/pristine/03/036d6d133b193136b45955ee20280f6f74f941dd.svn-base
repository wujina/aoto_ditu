/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：UserDetailsImpl.java
 * 文件名称：UserDetailsImpl.java
 * 系统编号：mips
 * 系统名称：mips
 * 模块编号：
 * 模块名称：
 * 作          者：jiangp
 * 完成日期：2013年9月22日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.commons.userdetails;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Base64Utils;

import com.aoto.framework.commons.beans.JsonUtils;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author jiangp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User
{
    private static final long serialVersionUID = -4936074098814627190L;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUser.class);
    
    /**
     * [简要描述]:将功能权限转换成json对象,在js文件中使用
     * @author hongxz
     */
    private String functionJson;

    /**
     * [简要描述]:
     * @author zongwj
     */
    private final int userId;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String realName;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private final int orgId;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private final String orgCode; 
    /**
     * [简要描述]:
     * @author zongwj
     */
    private final String orgName;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private final String inheritedName;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String lastLoginIp;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private Date lastLoginDate;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String sessionId;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private final List<Map<String, Object>> menus;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private Map<String, Boolean> function;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String userPicSuffix;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private Byte[] userPicData;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String userPicDataStr;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private Integer age;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private Date birthday;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String about;

   
    /**
     * [简要描述]:创建一个新的实例 UserDetailsImpl.
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @param username String
     * @param password String
     * @param enabled boolean
     * @param accountNonExpired boolean
     * @param credentialsNonExpired boolean
     * @param accountNonLocked boolean
     * @param authorities Collection<? extends GrantedAuthority>
     * @param userId int
     * @param realName String
     * @param orgId int
     * @param orgCode String
     * @param orgName String
     * @param inheritedName String
     * @param menus List<Map<String, Object>>
     * @param function Map<String, Boolean>
     * @param userPicSuffix String
     * @param userPicData Byte[]
     * @param age Integer
     * @param birthday Date
     * @param about String
     */
    public CurrentUser(String username, String password, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
            int userId, String realName, int orgId, String orgCode, String orgName, String inheritedName,
            List<Map<String, Object>> menus, Map<String, Boolean> function, String userPicSuffix, Byte[] userPicData,
            Integer age, Date birthday, String about)
    {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

        this.userId = userId;
        this.realName = realName;
        this.orgId = orgId;
        this.orgCode = orgCode;
        this.orgName = orgName;
        this.inheritedName =inheritedName;
        this.menus = menus;
        this.function = function;
        this.userPicSuffix = userPicSuffix;
        this.userPicData = userPicData;
        if (null != userPicData && StringUtils.isNotBlank(userPicSuffix)) {
            this.userPicDataStr = userPicSuffix + "base64,"
                    + Base64Utils.encodeToString(translateByteArray(userPicData));
        }
        this.age = age;
        this.birthday = birthday;
        this.about = about;
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param ip String
     * @param date Date
     * @param sessionId String
     */
    public void setLoginInfo(String ip, Date date, String sessionId)
    {
        this.lastLoginIp = ip;
        this.lastLoginDate = date;
        this.sessionId = sessionId;
    }
    
    public void setUserPicDataStr(String userPicDataStr) {
        this.userPicDataStr = userPicDataStr;
    }
    
    public String getUserPicDataStr() {
        return userPicDataStr;
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param array Byte[]
     * @return byte[]
     */
    private byte[] translateByteArray(Byte[] array) {
        byte[] newArray = new byte[array.length];
        for (int i = 0 ; i < array.length ; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    public void setUserPicSuffix(String userPicSuffix) {
        this.userPicSuffix = userPicSuffix;
    }

    public void setUserPicData(Byte[] userPicData) {
        this.userPicData = userPicData;
    }
    
    public String getUserPicSuffix() {
        return userPicSuffix;
    }

    public Byte[] getUserPicData() {
        return userPicData;
    }

    public int getUserId()
    {
        return userId;
    }

    public String getRealName()
    {
        return realName;
    }
    
    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getOrgId()
    {
        return orgId;
    }

    public String getOrgCode()
    {
        return orgCode;
    }
    
    public String getOrgName()
    {
        return orgName;
    }
    
    public String getInheritedName()
    {
        return inheritedName;
    }

    public String getLastLoginIp()
    {
        return lastLoginIp;
    }

    public Date getLastLoginDate()
    {
        return lastLoginDate;
    }
    
    public String getSessionId()
    {
        return sessionId;
    }
    
    public List<Map<String, Object>> getMenus()
    {
        return this.menus;
    }

    public Map<String, Boolean> getFunction()
    {
        return function;
    }
    
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return String
     */
    public String getBirthday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        if (null != birthday) {
            return sdf.format(birthday);
        }
        else {
            return null;
        }
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author hongxz
     * @return String
     */
    public String getFunctionJson() {
        try {
            return JsonUtils.obj2json(function);
        } 
        catch (Exception e) {
            LOGGER.error("object转化为json异常！", e);
            e.printStackTrace();
        }
        
        return functionJson;
    }

    public void setFunctionJson(String functionJson) {
        this.functionJson = functionJson;
    }
}