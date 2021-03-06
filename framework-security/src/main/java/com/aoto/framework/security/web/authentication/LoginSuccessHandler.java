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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aoto.framework.security.web.Util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.aoto.framework.commons.userdetails.CurrentUser;
import com.aoto.framework.logging.models.LoginLogModel;
import com.aoto.framework.logging.service.inf.LogService;



/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author jiangp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected LogService logService;

    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param authentication Authentication
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException
    {
        String token = TokenUtil.getInstance().makeToken();//创建令牌
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        String ip = request.getRemoteAddr();
        HttpSession session = request.getSession(true);

        String sessionId = session.getId();
        Date now = new Date();
        session.setAttribute("userID",currentUser.getUserId());
        currentUser.setLoginInfo(ip, now, sessionId);
        super.onAuthenticationSuccess(request, response, authentication);
        
        LoginLogModel model = new LoginLogModel();
        model.setSessionId(sessionId);
        model.setUserId(currentUser.getUserId());
        model.setUsername(currentUser.getUsername());
        model.setRealName(currentUser.getRealName());
        model.setIp(ip);
        model.setOrgId(currentUser.getOrgId());
        model.setOrgName(currentUser.getOrgName());
        model.setInheritedName(currentUser.getInheritedName());
        model.setLoginDate(now);
        model.setUserAgent(request.getHeader("USER-AGENT"));
        
        logService.createLoginLog(model);
    }


}
