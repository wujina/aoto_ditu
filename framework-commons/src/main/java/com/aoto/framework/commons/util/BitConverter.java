/*
 * 版权信息：Copyright (c) 2015, Aoto. All rights reserved.
 * 文件编号：BitConverter.java
 * 文件名称：BitConverter.java
 * 系统编号：socketTest
 * 系统名称：socketTest
 * 模块编号：
 * 模块名称：
 * 作          者：jiangp
 * 完成日期：2015年9月16日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.commons.util;

import com.aoto.framework.commons.constant.Constants;
import com.aoto.framework.commons.constant.NumberEnum;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author jiangp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public class BitConverter
{
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param number long
     * @return byte[]
     */
    public static byte[] getUIntBytes(final long number)
    {
        return getBytes(number, NumberEnum.NUMBER_4.getNum());
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param number int
     * @return byte[]
     */
    public static byte[] getUShortBytes(final int number)
    {
        return getBytes(number, 2);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param number int
     * @return byte
     */
    public static byte getUByte(final int number)
    {
        return Integer.valueOf(number & Constants.INT_0XFF).byteValue();
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param number long
     * @param length int
     * @return byte[]
     */
    private static byte[] getBytes(final long number, int length)
    {
        long shiftedNumber = number;
        byte[] b = new byte[length];

        for (int i = 0; i < b.length; i++)
        {
            // 将最低位保存在最低位
            b[i] = Long.valueOf(shiftedNumber & Constants.INT_0XFF).byteValue();

            // 向右移8位
            shiftedNumber = shiftedNumber >> NumberEnum.NUMBER_8.getNum();
        }

        return b;
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param b byte[]
     * @param startIndex int
     * @return int
     */
    public static int toUByte(byte[] b, int startIndex)
    {
        return b[startIndex] & Constants.INT_0XFF;
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param b byte[]
     * @param startIndex int
     * @return int
     */
    public static int toUShort(byte[] b, int startIndex)
    {
        int s0 = b[startIndex] & Constants.INT_0XFF;
        int s1 = b[startIndex + 1] & Constants.INT_0XFF; 
        s1 <<= NumberEnum.NUMBER_8.getNum(); 

        return s0 | s1; 
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param b byte[]
     * @param startIndex int
     * @return long
     */
    public static long toUInt(byte[] b, int startIndex)
    {
        long s0 = b[startIndex] & Constants.INT_0XFF;
        long s1 = b[startIndex + 1] & Constants.INT_0XFF; 
        long s2 = b[startIndex + 2] & Constants.INT_0XFF; 
        long s3 = b[startIndex + NumberEnum.NUMBER_3.getNum()] & Constants.INT_0XFF; 
        s3 <<= NumberEnum.NUMBER_24.getNum();
        s2 <<= NumberEnum.NUMBER_16.getNum();
        s1 <<= NumberEnum.NUMBER_8.getNum();
        
        return s0 | s1 | s2 | s3; 
    }
}
