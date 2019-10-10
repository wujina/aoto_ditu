/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：RoleController.java
 * 文件名称：RoleController.java
 * 系统编号：mips
 * 系统名称：mips
 * 模块编号：
 * 模块名称：
 * 作          者：lih
 * 完成日期：2013年9月25日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.security.web.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aoto.framework.commons.beans.JsonResult;
import com.aoto.framework.commons.constant.RoleTypeEnum;
import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.security.models.RoleModel;
import com.aoto.framework.security.models.RoleQuery;
import com.aoto.framework.security.service.inf.FunctionService;
import com.aoto.framework.security.service.inf.RoleService;
import com.aoto.framework.security.service.inf.UserService;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author lih
 * @see    [相关类/方法]（可选）
 * @since  [产品/模块版本] （必须）
 */
@Controller
public class RoleController
{   
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected RoleService roleService;
    
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
    protected UserService userService;
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/roles/new", method = RequestMethod.GET)
    public ModelAndView newRole()
    {
        return new ModelAndView("system/role/new");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/commroles/new", method = RequestMethod.GET)
    public ModelAndView newCommRole()
    {
        return new ModelAndView("system/commrole/new");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/commroles/edit", method = RequestMethod.GET)
    public ModelAndView editCommRole()
    {
        return new ModelAndView("system/commrole/edit");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/roles/edit", method = RequestMethod.GET)
    public ModelAndView editRole()
    {
        return new ModelAndView("system/role/edit");
    }
    
    /**
     * 获取所有角色列表，rest url : /roles， method : GET，
     * 客户端请求类似这样的地址：http://localhost/mips/roles
     * 把用户list添加到视图中，在WEB-INF/views/account/role/list.jsp中绑定
     * 
     * @author lih
     * @return org.springframework.web.servlet.ModelAndView
     * @see 
     * @since 1.0
     */
    @RequestMapping(value = "/system/roles/list", method = RequestMethod.GET)
    public ModelAndView showRoles()
    {
        /*List<Map<String, Object>> functions = functionService.getFunctionsForTree(
                CurrentUserHolder.getCurrentUser().getUserId(), 1);*/
        return new ModelAndView("system/role/list");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model RoleQuery
     * @return JsonResult
     */
    @RequestMapping(value = "/system/roles/list", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public JsonResult getRoles(RoleQuery model)
    {
        model.setRoleType(RoleTypeEnum.GENERAL_ROLE);
        PagingCriteria pagingCriteria = new PagingCriteria(model.getPage() - 1, model.getRows(), model.getSort(),
                model.getOrder());
        List<Map<String, Object>> list = roleService.getRolesByPage(pagingCriteria, model);
        
        return JsonResult.json(pagingCriteria.getTotal(), list);
    }
    
    /**
     * 获取所有通用业务角色列表，rest url : /commroles， method : GET，
     * 客户端请求类似这样的地址：http://localhost/mips/commroles
     * 把用户list添加到视图中，在WEB-INF/views/account/commrole/list.jsp中绑定
     * 
     * @author lih
     * @return org.springframework.web.servlet.ModelAndView
     * @see 
     * @since 1.0
     */
    @RequestMapping(value = "/system/commroles/list", method = RequestMethod.GET)
    public ModelAndView showCommRoles()
    {
        /*List<Map<String, Object>> functions = functionService.getFunctionsForTree(
                CurrentUserHolder.getCurrentUser().getUserId(), 1);*/
        return new ModelAndView("system/commrole/list");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model RoleQuery
     * @return JsonResult
     */
    @RequestMapping(value = "/system/commroles/list", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public JsonResult getCommRoles(RoleQuery model)
    {
        model.setRoleType(RoleTypeEnum.COMM_BUSINESS_ROLE);
        PagingCriteria pagingCriteria = new PagingCriteria(model.getPage() - 1, model.getRows(), model.getSort(),
                model.getOrder());
        List<Map<String, Object>> list = roleService.getRolesByPage(pagingCriteria, model);
        
        return JsonResult.json(pagingCriteria.getTotal(), list);
    }
    
    /**
     * 新增一个角色，rest url : /roles， method : POST，
     * 客户端请求类似这样的地址：http://localhost/mips/roles
     * 
     * @author lih
     * @param model 用户信息实体，表单html标签的name值必须和role属性名一一对应
     * @return 保存成功后跳转到用户列表页面的路径
     * @throws NoSuchAlgorithmException
     * @see 
     * @since 1.0
     */
    @RequestMapping(value = "/system/roles", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult newRole(RoleModel model)
    {
        String errorCode = roleService.createRole(model);
        return JsonResult.json(errorCode);
    }

    /**
     * 根据用户id物理删除用户信息，rest url : /roles/1， method : DELETE， 由于 method :
     * DELETE并不是所有浏览器和web容器都支持， 采用post /roles/1?_method=delete来代替 value="DELETE"
     * @author lih
     * @param list List<Integer>
     * @return 保存成功后跳转到用户列表页面的路径
     * @throws NoSuchAlgorithmException
     * @see 
     * @since 1.0
     */
    @RequestMapping(value = "/system/roles", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResult removeRoles (@RequestBody List<Integer> list)
    {
        roleService.removeRoles(list);
        return JsonResult.json();
    }

    /**
     * 编辑一个角色信息，rest url : /roles， method : PUT，
     * 客户端请求类似这样的地址：http://localhost/mips/roles 由于 method :
     * PUT并不是所有浏览器和web容器都支持， 采用POST /roles/1?_method=PUT来代替，提交的form必须包含一个hidden，
     * hidden name="_method" value="PUT"
     * 
     * @author lih
     * @param model 用户信息实体，表单html标签的name值必须和user属性名一一对应
     * @return 编辑成功后跳转到用户列表页面的路径
     * @throws NoSuchAlgorithmException
     * @since 1.0
     */
    @RequestMapping(value = "/system/roles/{roleId}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResult editRole(RoleModel model)
    {
        String errorCode = roleService.editRole(model);
        return JsonResult.json(errorCode);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param roleId int
     * @return List<Integer>
     */
    @RequestMapping(value = "/system/roles/{roleId}/funs", method = RequestMethod.GET)
    @ResponseBody
    public List<Integer> getFunctionsByRoleId(@PathVariable("roleId") int roleId)
    {
        return functionService.getFunctionsByRoleId(roleId);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param roleId int
     * @param list List<Integer>
     * @return JsonResult
     */
    @RequestMapping(value = "/system/roles/{roleId}/funs", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult newRoleFun(@PathVariable("roleId") int roleId, @RequestBody List<Integer> list)
    {
        roleService.createRoleFun(roleId, list);
        return JsonResult.json();
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param roleId int
     * @param list List<Integer>
     * @return JsonResult
     */
    @RequestMapping(value = "/system/roles/{roleId}/users", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult newRoleUser(@PathVariable("roleId") int roleId, @RequestBody List<Integer> list)
    {
        roleService.createRoleUser(roleId, list);
        return JsonResult.json();
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param roleId int
     * @return JsonResult
     */
    @RequestMapping(value = "/system/roles/{roleId}/users", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getUsersByRoleId(@PathVariable("roleId") int roleId)
    {
        List<Map<String, Object>> list = userService.getUsersByRoleId(roleId);
        return JsonResult.json(list.size(), list);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param roleId int
     * @param orgId int
     * @param list List<Integer>
     * @return JsonResult
     */
    @RequestMapping(value = "/system/commroles/{roleId}/users/{orgId}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult newCommRoleUser(@PathVariable("roleId") int roleId, @PathVariable("orgId") int orgId,
            @RequestBody List<Integer> list) {
        roleService.createRoleUser(roleId, orgId, list);
        return JsonResult.json();
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param roleId int
     * @param orgId int
     * @return JsonResult
     */
    @RequestMapping(value = "/system/commroles/{roleId}/users", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getUsersBycommRoleId(@PathVariable("roleId") int roleId, @RequestParam("orgId") int orgId)
    {
        List<Map<String, Object>> list = userService.getUsersByCommRoleId(roleId, orgId);
        return JsonResult.json(list.size(), list);
    }
}
