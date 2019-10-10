/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：LoginSuccessHandler.java
 * 文件名称：LoginSuccessHandler.java
 * 系统编号：mips
 * 系统名称：mips
 * 模块编号：
 * 模块名称：
 * 作          者：jiangp
 * 完成日期：2013年9月23日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.security.web.authentication;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import com.aoto.framework.commons.constant.NumberEnum;
import com.aoto.framework.commons.constant.BeanProperty.LoginLog;
import com.aoto.framework.commons.userdetails.CurrentUser;
import com.aoto.framework.logging.service.inf.LogService;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author jiangp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected LogService logService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException
    {
        if (null != authentication)
        {
            CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
            Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
            map.put(LoginLog.SESSION_ID, currentUser.getSessionId());
            map.put(LoginLog.LOGOUT_DATE, new Date());
            logService.updateLogoutDate(map);
        }

        super.onLogoutSuccess(request, response, authentication);
    }
}
