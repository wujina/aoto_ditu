/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：ExceptionHandler.java
 * 文件名称：ExceptionHandler.java
 * 系统编号：mips
 * 系统名称：mips
 * 模块编号：
 * 模块名称：
 * 作          者：jiangp
 * 完成日期：2013年11月18日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.aoto.framework.commons.constant.ErrorCodeEnum;
import com.aoto.framework.exception.ApplicationException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author jiangp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    /**
     * [简要描述]:
     * @author zongwj
     */
    private ObjectMapper mapper = new ObjectMapper();

    /**
     * 〈一句话功能简述〉
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param handler Object
     * @param ex Exception
     * @return 〈功能详细描述〉
     * @author jiangp
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex)
    {
        int status = ErrorCodeEnum.ERROR_500.getCode();
        String code = "error";
        
        if (ex instanceof ApplicationException)
        {
            status = ErrorCodeEnum.ERROR_801.getCode();
            code = ex.getMessage();
        }
        
        response.setStatus(status);
        LOGGER.error("ExceptionHandler.resolveException", ex);
        String ajax = request.getHeader("X-Requested-With");

        if (!StringUtils.isEmpty(ajax))
        {
            response.setContentType("application/json");
            
            try
            {
                mapper.writeValue(response.getOutputStream(), code);
            }
            catch (IOException e)
            {
                LOGGER.error("mapper.writeValue error", e);
            }

            return null;
        }

        ModelAndView view = new ModelAndView("shared/error");
        return view;
    }
}
