/*
 * 版权信息：Copyright (c) 2014, Aoto. All rights reserved.
 * 文件编号：CurrentUserHolder.java
 * 文件名称：CurrentUserHolder.java
 * 系统编号：mips
 * 系统名称：mips
 * 模块编号：
 * 模块名称：
 * 作          者：jiangp
 * 完成日期：2014年5月27日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.commons.userdetails;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author jiangp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public final class CurrentUserHolder
{
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    public static final String BEHAVIOR_ID = "__BEHAVIOR_ID__";

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return CurrentUser
     */
    public static CurrentUser getCurrentUser()
    {
        CurrentUser currentUser = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (null == authentication)
        {
            currentUser = null;
        }
        else
        {
            Object principal = authentication.getPrincipal();

            if (principal instanceof CurrentUser)
            {
                currentUser = (CurrentUser) principal;
            }
            else
            {
                currentUser = null;
            }
        }

        return currentUser;
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return int
     */
    public static int getBehaviorId()
    {
        RequestAttributes r = RequestContextHolder.getRequestAttributes();
        
        if (null == r)
        {
            return 0;
        }
        
        HttpServletRequest request = ((ServletRequestAttributes) r).getRequest();
        
        if (null == request)
        {
            return 0;
        }
        
        Object o = request.getAttribute(BEHAVIOR_ID);
        return (null == o) ? 0 : (Integer)o;
    }
}