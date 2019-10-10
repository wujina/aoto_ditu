/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：ZipUtils.java
 * 文件名称：ZipUtils.java
 * 系统编号：mips
 * 系统名称：mips
 * 模块编号：
 * 模块名称：
 * 作          者：jiangp
 * 完成日期：2013年12月8日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.commons.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author jiangp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public class ZipUtils
{
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param src String
     * @param dest String
     * @throws Exception FileNotFoundException
     */
    public static void compress(String src, String dest) throws Exception
    {
        compress(new File(src), new File(dest));
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param src File
     * @param dest File
     * @throws Exception FileNotFoundException
     */
    public static void compress(File src, File dest) throws Exception
    {
        ZipOutputStream out = null;
        
        try
        {
            out = new ZipOutputStream(new FileOutputStream(dest));
            compress(src, out, "");
        }
        finally
        {
            IOUtils.closeQuietly(out);
        }
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param src File
     * @param out ZipOutputStream
     * @param base String
     * @throws Exception FileNotFoundException
     */
    public static void compress(File src, ZipOutputStream out, String base) throws Exception
    {
        if (src.isDirectory())
        {
            File[] files = src.listFiles();
            out.putNextEntry(new ZipEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";

            if (ArrayUtils.isNotEmpty(files)) {
                for (File file : files)
                {
                    compress(file, out, base + file.getName());
                }
            }
        }
        else
        {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = null;

            try
            {
                in = new FileInputStream(src);
                IOUtils.copy(in, out);
            }
            finally
            {
                IOUtils.closeQuietly(in);
            }
        }
    }
}
