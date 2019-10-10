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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.aoto.framework.commons.beans.JsonResult;
import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.security.models.UrlModel;
import com.aoto.framework.security.models.UrlQuery;
import com.aoto.framework.security.service.inf.FunctionService;
import com.aoto.framework.security.service.inf.UrlService;
import com.aoto.framework.security.service.inf.UserService;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author lih
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必5须）
 */
@Controller
public class UrlController
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected UrlService urlService;

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
    @RequestMapping(value = "/system/urls/new", method = RequestMethod.GET)
    public ModelAndView newUrl()
    {
        return new ModelAndView("system/url/new");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/urls/edit", method = RequestMethod.GET)
    public ModelAndView editUrl()
    {
        return new ModelAndView("system/url/edit");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/urls/show", method = RequestMethod.GET)
    public ModelAndView showUrl()
    {
        return new ModelAndView("system/url/show");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/urls/select", method = RequestMethod.GET)
    public ModelAndView selectUrl()
    {
        return new ModelAndView("system/url/select");
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
    @RequestMapping(value = "/system/urls/list", method = RequestMethod.GET)
    public ModelAndView showUrls()
    {
        /*List<Map<String, Object>> functions = functionService.getFunctionsForTree(
                CurrentUserHolder.getCurrentUser().getUserId(), 0);*/
        return new ModelAndView("system/url/list");
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model UrlQuery
     * @return JsonResult
     */
    @RequestMapping(value = "/system/urls/list", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public JsonResult getUrls(UrlQuery model)
    {
        PagingCriteria pagingCriteria = new PagingCriteria(model.getPage() - 1, model.getRows(), model.getSort(),
                model.getOrder());
        List<Map<String, Object>> list = urlService.getUrlByPage(pagingCriteria, model);

        return JsonResult.json(pagingCriteria.getTotal(), list);
    }

    /**
     * 新增一个菜单，rest url : /roles， method : POST，
     * 客户端请求类似这样的地址：http://localhost/mips/roles
     * 
     * @author lih
     * @param model 用户信息实体，表单html标签的name值必须和role属性名一一对应
     * @return 保存成功后跳转到用户列表页面的路径
     * @throws NoSuchAlgorithmException
     * @see
     * @since 1.0
     */

    @RequestMapping(value = "/system/urls", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult newUrl(UrlModel model)
    {
        String errorCode = urlService.createUrl(model);
        return JsonResult.json(errorCode);
    }

    /**
     * 根据用户id物理删除用户信息，rest url : /roles/1， method : DELETE， 由于 method :
     * DELETE并不是所有浏览器和web容器都支持， 采用post /roles/1?_method=delete来代替 value="DELETE"
     * 
     * @author lih
     * @param list List<Integer>
     * @return 保存成功后跳转到用户列表页面的路径
     * @throws NoSuchAlgorithmException
     * @see
     * @since 1.0
     */

    @RequestMapping(value = "/system/urls", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResult removeUrls(@RequestBody List<Integer> list)
    {
        urlService.removeUrls(list);
        return JsonResult.json();
    }

    /**
     * 编辑一个角色信息，rest url : /roles， method : PUT，
     * 客户端请求类似这样的地址：http://localhost/mips/roles 由于 method :
     * PUT并不是所有浏览器和web容器都支持， 采用POST /roles/1?_method=PUT来代替，提交的form必须包含一个hidden，
     * hidden name="_method" value="PUT"
     * 
     * @author lih
     * @param model UrlModel
     * @return 编辑成功后跳转到用户列表页面的路径
     * @throws NoSuchAlgorithmException
     * @since 1.0
     */

    @RequestMapping(value = "/system/urls/{urlId}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResult editUrl(UrlModel model)
    {
        String errorCode = urlService.editUrl(model);
        return JsonResult.json(errorCode);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model UrlQuery
     * @return JsonResult
     */
    @RequestMapping(value = "/system/urls/excepted", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getUrlsExcepted(UrlQuery model)
    {
        PagingCriteria pagingCriteria = new PagingCriteria(model.getPage() - 1, model.getRows(), model.getSort(),
                model.getOrder());
        List<Map<String, Object>> list = urlService.getUrlsExceptByPage(pagingCriteria, model);

        return JsonResult.json(pagingCriteria.getTotal(), list);
    }
}
