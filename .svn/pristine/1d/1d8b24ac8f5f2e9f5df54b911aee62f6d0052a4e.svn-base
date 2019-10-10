/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：SpringContextHolder.java
 * 文件名称：SpringContextHolder.java
 * 系统编号：mips
 * 系统名称：mips
 * 模块编号：
 * 模块名称：
 * 作          者：jiangp
 * 完成日期：2013年12月4日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.spring;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author jiangp
 * @see    [相关类/方法]（可选）
 * @since  [产品/模块版本] （必须）
 */
import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月1日
 */
public class SpringContextHolder implements ApplicationContextAware
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static ApplicationContext applicationContext = null;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private @Value("${web.staticPath}") String staticPath;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private @Value("${log.behavior.enabled}") boolean logBehaviorEnabled;
    
    public static void setApplicationContext4Static(ApplicationContext applicationContext) {
        SpringContextHolder.applicationContext = applicationContext;
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
    {        
        setApplicationContext4Static(applicationContext);
        
        if (applicationContext instanceof WebApplicationContext)
        {
            ServletContext servletContext = ((WebApplicationContext)applicationContext).getServletContext();
            String contextPath = servletContext.getContextPath();
            
            if (StringUtils.isEmpty(staticPath))
            {
                staticPath = contextPath;
            }

            servletContext.setAttribute("staticPath", staticPath);
            servletContext.setAttribute("contextPath", contextPath);
            servletContext.setAttribute("logBehaviorEnabled", logBehaviorEnabled);
        }
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param name String
     * @return Object
     */
    public static Object getBean(String name)
    {
        return applicationContext.getBean(name);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param requiredType Class<T>
     * @param <T> T
     * @return T
     */
    public static <T> T getBean(Class<T> requiredType)
    {
        return applicationContext.getBean(requiredType);
    }
}