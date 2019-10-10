/*
 * 版权信息：Copyright (c) 2014, Aoto. All rights reserved.
 * 文件编号：Model.java
 * 文件名称：Model.java
 * 系统编号：aotoframework
 * 系统名称：aotoframework
 * 模块编号：
 * 模块名称：
 * 作          者：jiangp
 * 完成日期：2014年5月19日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.commons.beans;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author jiangp
 * @see    [相关类/方法]（可选）
 * @since  [产品/模块版本] （必须）
 */
public class Entity extends HashMap<String, Object>
{
    private static final long serialVersionUID = 9015789994745862473L;

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     */
    public Entity()
    {
        super();
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @param initialCapacity int
     */
    public Entity(int initialCapacity)
    {
        super(initialCapacity);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @param map Map<String, Object>
     */
    public Entity(Map<String, Object> map)
    {
        super(map);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param key String
     * @return String
     */
    public String getString(String key)
    {
        return (String) this.get(key);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param key String
     * @return int
     */
    public int getInt(String key)
    {
        return (Integer) this.get(key);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param key String
     * @return Date
     */
    public Date getDate(String key)
    {
        return (Date) this.get(key);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param key String
     * @return boolean
     */
    public boolean getBoolean(String key)
    {
        return (Boolean) this.get(key);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param key String
     * @return double
     */
    public double getDouble(String key)
    {
        return (Double) this.get(key);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param key String
     * @return float
     */
    public float getFloat(String key)
    {
        return (Float) this.get(key);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param key String
     * @return long
     */
    public long getLong(String key)
    {
        return (Long) this.get(key);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param key String
     * @return byte
     */
    public byte getByte(String key)
    {
        return (Byte) this.get(key);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param key String
     * @return BigDecimal
     */
    public BigDecimal getBigDecimal(String key)
    {
        return (BigDecimal) this.get(key);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return Map<String, Object>
     */
    public Map<String, Object> asMap()
    {
        return (Map<String, Object>)this;
    }
}
