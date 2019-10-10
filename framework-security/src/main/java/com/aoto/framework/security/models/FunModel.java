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
public class FunModel implements Serializable
{
    private static final long serialVersionUID = -4130169418427937964L;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int funId;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int parentId;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String funName;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int levelNum;

    /**
     * [简要描述]:
     * @author zongwj
     */
    private String sortNum;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int menuId;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String parentName;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getFunId() {
        return funId;
    }

    public void setFunId(int funId) {
        this.funId = funId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getFunName() {
        return funName;
    }

    public void setFunName(String funName) {
        this.funName = funName;
    }

    public int getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
    }

    public String getSortNum() {
        return sortNum;
    }

    public void setSortNum(String sortNum) {
        this.sortNum = sortNum;
    }

    public String getParentName() {
        return parentName;
    }
    
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
