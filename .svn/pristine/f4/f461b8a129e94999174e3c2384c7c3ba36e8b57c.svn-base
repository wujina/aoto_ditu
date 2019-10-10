/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：LogController.java
 * 文件名称：LogController.java
 * 系统编号：mips
 * 系统名称：mips
 * 模块编号：
 * 模块名称：
 * 作          者：shir
 * 完成日期：2013-12-10
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.logging.web.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aoto.framework.commons.beans.JsonResult;
import com.aoto.framework.commons.constant.Constants;
import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.logging.models.LoginLogQuery;
import com.aoto.framework.logging.service.inf.LogService;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author shir
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Controller
public class LogController
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    private LogService logService;

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/logs/login", method = RequestMethod.GET)
    public ModelAndView showLoginLogs()
    {
        ModelAndView view = new ModelAndView("system/log/login");
        Date now = new Date();

        view.addObject("beginDate",
                DateFormatUtils.ISO_DATE_FORMAT.format(DateUtils.addDays(now, Constants.PREVIOUS_WEEK_DAYS)));
        view.addObject("endDate", DateFormatUtils.ISO_DATE_FORMAT.format(now));

        return view;
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model LoginLogQuery
     * @return JsonResult
     */
    @RequestMapping(value = "/system/logs/login", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public JsonResult getLoginLogs(LoginLogQuery model)
    {
        PagingCriteria pagingCriteria = new PagingCriteria(model.getPage() - 1, model.getRows(), model.getSort(),
                model.getOrder());
        List<Map<String, Object>> list = logService.getLoginLogsByPage(pagingCriteria, model);

        return JsonResult.json(pagingCriteria.getTotal(), list);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/logs/behavior", method = RequestMethod.GET)
    public ModelAndView showBehaviorLogs()
    {
        ModelAndView view = new ModelAndView("system/log/behavior");
        Date now = new Date();

        view.addObject("beginDate",
                DateFormatUtils.ISO_DATE_FORMAT.format(DateUtils.addDays(now, Constants.PREVIOUS_WEEK_DAYS)));
        view.addObject("endDate", DateFormatUtils.ISO_DATE_FORMAT.format(now));

        return view;
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model LoginLogQuery
     * @return JsonResult
     */
    @RequestMapping(value = "/system/logs/behavior", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public JsonResult getBehaviorLogs(LoginLogQuery model)
    {
        PagingCriteria pagingCriteria = new PagingCriteria(model.getPage() - 1, model.getRows(), model.getSort(),
                model.getOrder());
        List<Map<String, Object>> list = logService.getBehaviorLogsByPage(pagingCriteria, model);

        return JsonResult.json(pagingCriteria.getTotal(), list);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param behaviorId int
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/logs/data", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showDataLogs(@RequestParam("behaviorId") int behaviorId)
    {
        List<Map<String, Object>> logs = logService.getDataLogsByBehavioId(behaviorId);
        return new ModelAndView("system/log/show", "logs", logs);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     */
    @RequestMapping(value = "/system/logs/heartbeat", method = RequestMethod.PUT)
    @ResponseBody
    public void heartbeat()
    {
        
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param code String
     * @param args String[]
     */
    @RequestMapping(value = "/system/logs/behavior", method = RequestMethod.POST)
    @ResponseBody
    public void newBehavior(@RequestParam("code") String code, @RequestParam("args[]") String[] args)
    {
        logService.createBehaviorLog(code, args);
    }
}
