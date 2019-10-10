/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：OrgController.java
 * 文件名称：用户资源控制器
 * 系统编号：MIPS
 * 系统名称：综合发布系统（Multimedia information publishing system）
 * 模块编号：M01_Account
 * 模块名称：用户管理
 * 作          者：jiangp
 * 完成日期：2013年9月3号
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.security.web.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aoto.framework.commons.beans.JsonResult;
import com.aoto.framework.commons.constant.Constants;
import com.aoto.framework.commons.userdetails.CurrentUserHolder;
import com.aoto.framework.security.models.MenuModel;
import com.aoto.framework.security.service.inf.MenuService;

/**
 * OrgController 接受客户端的请求访问，基于rest url 风格 rest url约定 :
 * http://microformats.org/wiki/rest/urls
 * 
 * @author jiangp
 * @see
 * @since 1.0
 */
@Controller
public class MenuController
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected MenuService menuService;

    /**
     * [简要描述]:
     * @author zongwj
     */
    @Value("${heartbeat.interval}")
    protected int heartbeatInterval;
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/menus/new", method = RequestMethod.GET)
    public ModelAndView newMenu()
    {
        return new ModelAndView("system/menu/new");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/menus/edit", method = RequestMethod.GET)
    public ModelAndView editMenu()
    {
        return new ModelAndView("system/menu/edit");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/menus/show", method = RequestMethod.GET)
    public ModelAndView showMenu()
    {
        return new ModelAndView("system/menu/show");
    }
    
    @RequestMapping(value = "/system/menus/list", method = RequestMethod.GET)
    public ModelAndView getMenusInHtml()
    {
        return new ModelAndView("system/menu/list");
    }

    @RequestMapping(value = "/system/menus/list", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public List<Map<String, Object>> getMenusInTreeJson()
    {
        return menuService.getMenusByParentId(CurrentUserHolder.getCurrentUser().getUserId(), 0);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model MenuModel
     * @return JsonResult
     */
    @RequestMapping(value = "/system/menus", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult newMenu(MenuModel model)
    {
        String errorCode = menuService.createMenu(model);
        return JsonResult.json(errorCode);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model MenuModel
     * @return JsonResult
     */
    @RequestMapping(value = "/system/menus/{menuId}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResult editMenu(MenuModel model)
    {
        String errorCode = menuService.editMenu(model);
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
    @RequestMapping(value = "/system/menus/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResult removeMenu(@PathVariable("id") int id)
    {
        menuService.removeMenu(id);
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
     * @param list List<MenuModel>
     * @return JsonResult
     */
    @RequestMapping(value = "/system/menus/{id}/parent/{parentId}/{parentLevelNum}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResult moveMenu(@PathVariable("id") int id, @PathVariable("parentId") int parentId,
            @PathVariable("parentLevelNum") int parentLevelNum, @RequestBody List<MenuModel> list) {
        menuService.moveMenu(id, parentId, parentLevelNum, list);
        return JsonResult.json();
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView showIndex()
    {
        ModelAndView view = new ModelAndView("shared/index", "heartbeatInterval",
                heartbeatInterval * Constants.SECOND_TO_MILLISECONDS_UNIT);
        
        return view;
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public ModelAndView accessDenied()
    {
        return new ModelAndView("shared/denied");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return List<Map<String, Object>>
     */
    @RequestMapping(value = "/system/my/menus", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public List<Map<String, Object>> getMenus()
    {
        return CurrentUserHolder.getCurrentUser().getMenus();
    }
}