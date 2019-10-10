/*
 * 版权信息：Copyright (c) 2014, Aoto. All rights reserved.
 * 文件编号：StringUtils.java
 * 文件名称：StringUtils.java
 * 系统编号：aotoframework
 * 系统名称：aotoframework
 * 模块编号：
 * 模块名称：
 * 作          者：jiangp
 * 完成日期：2014年5月16日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.commons.lang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;

import com.aoto.framework.commons.constant.NumberEnum;
import com.aoto.framework.spring.SpringContextHolder;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author jiangp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public final class StringUtils4Aoto extends StringUtils
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final LinkedHashMap<String, String> OS_WINDOWS;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final LinkedHashMap<String, String> IE_BROWSERS;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final MessageSource MESSAGE_SOURCE;

    static
    {
        MESSAGE_SOURCE = SpringContextHolder.getBean(MessageSource.class);
        
        OS_WINDOWS = new LinkedHashMap<String, String>();
        OS_WINDOWS.put("Windows NT 6.1", "Windows 7");
        OS_WINDOWS.put("Windows NT 5.1", "Windows XP");
        OS_WINDOWS.put("Windows NT 6.3", "Windows 8.1");
        OS_WINDOWS.put("Windows NT 6.2", "Windows 8");
        OS_WINDOWS.put("Windows NT 5.2", "Windows Server 2003");
        OS_WINDOWS.put("Windows NT 5.0", "Windows 2000");
        OS_WINDOWS.put("Windows NT 6.0", "Windows Vista");

        IE_BROWSERS = new LinkedHashMap<String, String>();
        IE_BROWSERS.put("MSIE 7.0", "Internet Explorer 7");
        IE_BROWSERS.put("MSIE 8.0", "Internet Explorer 8");
        IE_BROWSERS.put("MSIE 9.0", "Internet Explorer 9");
        IE_BROWSERS.put("rv:11.0", "Internet Explorer 11");
        IE_BROWSERS.put("rv 11.0", "Internet Explorer 11");
        IE_BROWSERS.put("MSIE 10.0", "Internet Explorer 10");
        IE_BROWSERS.put("MSIE 6.0", "Internet Explorer 6");
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param camel String
     * @return String
     */
    public static String camelCaseToSnakeCase(String camel)
    {
        String separator = "_";
        StringBuilder snakeCaseBuilder = new StringBuilder();
        
        for (char c : camel.toCharArray())
        {
            if (c >= NumberEnum.NUMBER_65.getNum() && c <= NumberEnum.NUMBER_90.getNum())
            {
                snakeCaseBuilder.append(separator).append(c);
            }
            else if (c >= NumberEnum.NUMBER_97.getNum() && c <= NumberEnum.NUMBER_122.getNum())
            {
                snakeCaseBuilder.append((char)(c - NumberEnum.NUMBER_32.getNum()));
            }
            else
            {
                snakeCaseBuilder.append(c);
            }
        }

        return snakeCaseBuilder.toString();
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param snake String
     * @return String
     */
    public static String snakeCaseToCamelCase(String snake)
    {
        StringBuilder camelBuilder = new StringBuilder();
        char separator = '_';
        boolean upper = false;

        for (char c : snake.toCharArray())
        {
            if (c >= NumberEnum.NUMBER_65.getNum() && c <= NumberEnum.NUMBER_90.getNum())
            {
                camelBuilder.append(upper ? c : (char)(c + NumberEnum.NUMBER_32.getNum()));
                upper = false;
            }
            else if (c >= NumberEnum.NUMBER_97.getNum() && c <= NumberEnum.NUMBER_122.getNum())
            {
                camelBuilder.append(upper ? (char)(c - NumberEnum.NUMBER_32.getNum()) : c);
                upper = false;
            }
            else if (separator == c)
            {
                upper = true;
            }
            else
            {
                camelBuilder.append(c);
            }
        }

        return camelBuilder.toString();
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param userAgent String
     * @return String[]
     */
    public static String[] analyzeUserAgent(String userAgent)
    {
        String os = null;
        String browser = null;
        Iterator<Map.Entry<String, String>> iterator = OS_WINDOWS.entrySet().iterator();
        Map.Entry<String, String> entry = null;

        while (iterator.hasNext())
        {
            entry = iterator.next();

            if (StringUtils4Aoto.containsIgnoreCase(userAgent, entry.getKey()))
            {
                os = entry.getValue();
                break;
            }
        }

        iterator = IE_BROWSERS.entrySet().iterator();

        while (iterator.hasNext())
        {
            entry = iterator.next();

            if (StringUtils4Aoto.containsIgnoreCase(userAgent, entry.getKey()))
            {
                browser = entry.getValue();
                break;
            }
        }

        if (StringUtils4Aoto.isEmpty(browser))
        {
            int index = StringUtils4Aoto.indexOfIgnoreCase(userAgent, "Chrome");
            String browserVersion = null;

            if (-1 != index)
            {
                int end = StringUtils4Aoto.indexOfIgnoreCase(userAgent, " ", index);
                browserVersion = StringUtils4Aoto.substring(userAgent, index + NumberEnum.NUMBER_7.getNum(), end);
                browser = "Chrome " + trim(browserVersion);
            }
            else
            {
                index = StringUtils4Aoto.indexOfIgnoreCase(userAgent, "Firefox");

                if (-1 != index)
                {
                    browserVersion = StringUtils4Aoto.substring(userAgent, index + NumberEnum.NUMBER_8.getNum());
                    browser = "Firefox " + trim(browserVersion);
                }
            }
        }

        int length = StringUtils4Aoto.length(os);

        if (length > NumberEnum.NUMBER_32.getNum())
        {
            os = StringUtils4Aoto.substring(os, 0, NumberEnum.NUMBER_32.getNum());
        }

        length = StringUtils4Aoto.length(browser);

        if (length > NumberEnum.NUMBER_32.getNum())
        {
            browser = StringUtils4Aoto.substring(browser, 0, NumberEnum.NUMBER_32.getNum());
        }

        return new String[] { os, browser };
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param code String
     * @param args String...
     * @return String
     */
    public static String getAction(String code, String... args)
    {
        String[] params = null;
        
        if (StringUtils4Aoto.isEmpty(code))
        {
            return StringUtils4Aoto.EMPTY;
        }
        
        if (null != args && args.length > 0)
        {
            List<String> list = new ArrayList<String>(2);
            
            for (String str : args)
            {
                list.add(MESSAGE_SOURCE.getMessage(str, null, Locale.CHINESE));
            }
            
            params = new String[list.size()];
            list.toArray(params);
        }
        
        return MESSAGE_SOURCE.getMessage(code, params, Locale.CHINESE);
    }
}
