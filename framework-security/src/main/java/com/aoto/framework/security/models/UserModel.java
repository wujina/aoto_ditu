package com.aoto.framework.security.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aoto.framework.commons.beans.Model;
import com.aoto.framework.commons.lang.StringUtils4Aoto;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月2日
 */
public class UserModel implements Model
{
    private static final long serialVersionUID = -7160643588438970503L;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserModel.class);
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int userId;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String username;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String realName;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String pwd;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int orgId;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String phone;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String mobile;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String email;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String address;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String remark;
    
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Date getBirthday() {
        return birthday;
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param birthdayStr String
     */
    public void setBirthday(String birthdayStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            if (StringUtils4Aoto.isNotBlank(birthdayStr)) {
                this.birthday = sdf.parse(birthdayStr);
            }
        }
        catch (ParseException e) {
            LOGGER.error("日期=[" + birthdayStr + "]，格式错误，无法转化为[yyyy-mm-dd]", birthdayStr, e);
        }
    }
    
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getRealName()
    {
        return realName;
    }

    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    public String getPwd()
    {
        return pwd;
    }

    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }

    public int getOrgId()
    {
        return orgId;
    }

    public void setOrgId(int orgId)
    {
        this.orgId = orgId;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }
}
