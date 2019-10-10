/*
 * 版权信息：Copyright (c) 2014, Aoto. All rights reserved.
 * 文件编号：DeviceModel.java
 * 文件名称：DeviceModel.java
 * 系统编号：pff
 * 系统名称：pff
 * 模块编号：
 * 模块名称：
 * 作          者：jiangp
 * 完成日期：2014年8月18日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.security.models;

import com.aoto.framework.commons.beans.Model;
import com.aoto.framework.commons.pagination.PaginationQuery;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author fengx
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public class ResFileModel extends PaginationQuery implements Model 
{
    private static final long serialVersionUID = 8728136549040095783L;

    /**
     * [简要描述]:
     * @author zongwj
     */
    private String fileName;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private long fileSize;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int fileType;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String remarks;
    
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public long getFileSize() {
        return fileSize;
    }
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
    public int getFileType() {
        return fileType;
    }
    public void setFileType(int fileType) {
        this.fileType = fileType;
    }
    public String getRemarks()
    {
        return remarks;
    }
    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }
}
