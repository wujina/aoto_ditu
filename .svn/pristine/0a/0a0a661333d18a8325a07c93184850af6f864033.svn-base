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

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.aoto.framework.commons.beans.JsonResult;
import com.aoto.framework.commons.userdetails.CurrentUserHolder;
import com.aoto.framework.security.models.OrgModel;
import com.aoto.framework.security.models.ResFileModel;
import com.aoto.framework.security.service.inf.OrgService;

/**
 * OrgController 接受客户端的请求访问，基于rest url 风格 rest url约定 :
 * http://microformats.org/wiki/rest/urls
 * 
 * @author jiangp
 * @see
 * @since 1.0
 */
@Controller
public class OrgController
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected OrgService orgService;

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/orgs/new", method = RequestMethod.GET)
    public ModelAndView newOrg()
    {
        return new ModelAndView("system/org/new");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/orgs/edit", method = RequestMethod.GET)
    public ModelAndView editOrg()
    {
        return new ModelAndView("system/org/edit");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/orgs/show", method = RequestMethod.GET)
    public ModelAndView showOrg()
    {
        return new ModelAndView("system/org/show");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/orgs/import", method = RequestMethod.GET)
    public ModelAndView importOrg()
    {
        return new ModelAndView("system/org/import");
    }
    
    @RequestMapping(value = "/system/orgs/list", method = RequestMethod.GET)
    public ModelAndView getOrgsInHtml()
    {
        return new ModelAndView("system/org/list");
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return List<Map<String, Object>>
     */
    @RequestMapping(value = "/system/orgs/list", method = RequestMethod.GET, produces = { "application/json" })
    @ResponseBody
    public List<Map<String, Object>> getOrgsInTreeJson()
    {
        int orgId = CurrentUserHolder.getCurrentUser().getOrgId();
        return orgService.getOrgs(orgId);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model OrgModel
     * @return JsonResult
     */
    @RequestMapping(value = "/system/orgs", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult newOrg(OrgModel model)
    {
        String errorCode = orgService.createOrg(model);
        return JsonResult.json(errorCode);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model OrgModel
     * @return JsonResult
     */
    @RequestMapping(value = "/system/orgs/{orgId}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResult editOrg(OrgModel model)
    {
        String errorCode = orgService.editOrg(model);
        return JsonResult.json(errorCode);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param orgId int
     * @return JsonResult
     */
    @RequestMapping(value = "/system/orgs/{orgId}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResult removeOrg(@PathVariable("orgId") int orgId)
    {
        orgService.removeOrg(orgId);
        return JsonResult.json();
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param orgId int
     * @param parentId int
     * @param parentLevelNum int
     * @param pMap Map<String, Object>
     * @return JsonResult
     */
    @RequestMapping(value = "/system/orgs/{orgId}/parent/{parentId}/{parentLevelNum}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResult moveOrg(@PathVariable("orgId") int orgId, @PathVariable("parentId") int parentId,
            @PathVariable("parentLevelNum") int parentLevelNum, @RequestBody Map<String, Object> pMap) {
        orgService.moveOrg(orgId, parentId, parentLevelNum, pMap);
        return JsonResult.json();
    }
    
    /**
     * [简要描述]:excel import 导入
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param file MultipartFile
     * @param accept String
     * @param model ResFileModel
     * @return ResponseEntity<Map<String, Object>>
     * @throws IOException IOException
     */
    @RequestMapping(value = "/system/orgs/import", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> importExcel(@RequestParam(value = "files") MultipartFile file,
            @RequestHeader(value = "accept") String accept, ResFileModel model) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        String errorCode = orgService.importOrg(file);

        if (errorCode != null)
        {
            map.put("msg", errorCode);
        }
        else
        {
            map.put("msg", "success");
            // 返回浏览器json
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            map.put("suffix", suffix);
        }

        // 不同浏览器返回头accept判断
        HttpHeaders headers = new HttpHeaders();

        if (accept.contains(MediaType.APPLICATION_JSON_VALUE))
        {
            headers.setContentType(MediaType.APPLICATION_JSON);
        }
        else
        {
            headers.setContentType(MediaType.TEXT_PLAIN);
        }

        return new ResponseEntity<Map<String, Object>>(map, headers, HttpStatus.OK);
    }

    /**
     * [简要描述]:exportExcel 导出
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ResponseEntity<byte[]>
     * @throws IOException IOException
     */
    @RequestMapping(value = "/system/orgs/export", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportQueryToExcel() throws IOException
    {
        String path = orgService.exportOrg();
        String filenameWithExt = path.substring(path.lastIndexOf("\\") + 1);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentDispositionFormData("attachment", filenameWithExt);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(path)), httpHeaders, HttpStatus.OK);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author hongxz
     * @return List<Map<String, Object>>
     */
    @RequestMapping(value = "/system/orgs/ztree", method = RequestMethod.GET, produces = { "application/json" })
    @ResponseBody
    public Object getOrgsZtreeJson()
    {
        int orgId = CurrentUserHolder.getCurrentUser().getOrgId();
        List<Map<String, Object>> list = orgService.getOrgsForZtree(orgId);
        return list;
    }
}