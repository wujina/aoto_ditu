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
package com.aoto.framework.security.web.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aoto.framework.commons.beans.JsonResult;
import com.aoto.framework.commons.userdetails.CurrentUserHolder;
import com.aoto.framework.security.models.FunModel;
import com.aoto.framework.security.service.inf.FunctionService;
import com.aoto.framework.security.service.inf.UrlService;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author shir
 * @see    [相关类/方法]（可选）
 * @since  [产品/模块版本] （必须）
 */
@Controller
public class FunctionController
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected FunctionService functionService;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected UrlService urlService;
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/funs/new", method = RequestMethod.GET)
    public ModelAndView newFun()
    {
        return new ModelAndView("system/function/new");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/funs/edit", method = RequestMethod.GET)
    public ModelAndView editFun()
    {
        return new ModelAndView("system/function/edit");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/funs/show", method = RequestMethod.GET)
    public ModelAndView showFun()
    {
        return new ModelAndView("system/function/show");
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/funs/select", method = RequestMethod.GET)
    public ModelAndView selectFuns()
    {
        List<Map<String, Object>> functions = functionService.getFunctionsForTree(
                CurrentUserHolder.getCurrentUser().getUserId(), 1);
        return new ModelAndView("system/function/select", "functions", functions);
    }
    
    @RequestMapping(value = "/system/funs/list", method = RequestMethod.GET)
    public ModelAndView getFunsInHtml()
    {
        return new ModelAndView("system/function/list");
    }

    @RequestMapping(value = "/system/funs/list", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public List<Map<String, Object>> getFunsInTreeJson()
    {
        return functionService.getFunsByParentId(CurrentUserHolder.getCurrentUser().getUserId(), 0);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model FunModel
     * @return JsonResult
     */
    @RequestMapping(value = "/system/funs", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult newFun(FunModel model)
    {
        String errorCode = functionService.createFun(model);
        return JsonResult.json(errorCode);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model FunModel
     * @return JsonResult
     */
    @RequestMapping(value = "/system/funs/{funId}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResult editFun(FunModel model)
    {
        String errorCode = functionService.editFun(model);
        return JsonResult.json(errorCode);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param id int
     * @return JsonResult
     */
    @RequestMapping(value = "/system/funs/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResult removeFun(@PathVariable("id") int id)
    {
        functionService.removeFun(id);
        return JsonResult.json();
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param id int
     * @param parentId int
     * @param parentLevelNum int
     * @param list List<FunModel>
     * @return JsonResult
     */
    @RequestMapping(value = "/system/funs/{id}/parent/{parentId}/{parentLevelNum}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResult moveFun(@PathVariable("id") int id, @PathVariable("parentId") int parentId,
            @PathVariable("parentLevelNum") int parentLevelNum, @RequestBody List<FunModel> list) {
        functionService.moveFun(id, parentId, parentLevelNum, list);
        return JsonResult.json();
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param funId int
     * @param list List<Integer>
     * @return JsonResult
     */
    @RequestMapping(value = "/system/funs/{funId}/urls", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult newFunUrl(@PathVariable("funId") int funId, @RequestBody List<Integer> list)
    {
        functionService.createFunUrl(funId, list);
        return JsonResult.json();
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param funId int
     * @return JsonResult
     */
    @RequestMapping(value = "/system/funs/{funId}/urls", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getUrlsByFunId(@PathVariable("funId") int funId)
    {
        List<Map<String, Object>> list = urlService.getUrlsByFunId(funId);
        return JsonResult.json(list.size(), list);
    }
}
