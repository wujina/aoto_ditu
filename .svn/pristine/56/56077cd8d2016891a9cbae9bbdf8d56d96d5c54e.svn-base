/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：RoleService.java
 * 文件名称：RoleService.java
 * 系统编号：mips
 * 系统名称：mips
 * 模块编号：
 * 模块名称：
 * 作          者：lih
 * 完成日期：2013年9月25日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.security.service.inf;

import java.util.List;
import java.util.Map;

import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.security.models.UrlModel;
import com.aoto.framework.security.models.UrlQuery;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author lih
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public interface UrlService
{
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model UrlModel
     * @return String
     */
    String createUrl(UrlModel model);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model UrlModel
     * @return String
     */
    String editUrl(UrlModel model);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param list List<Integer>
     */
    void removeUrls(List<Integer> list);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param pagingCriteria PagingCriteria
     * @param model UrlQuery
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getUrlByPage(PagingCriteria pagingCriteria, UrlQuery model);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param pagingCriteria PagingCriteria
     * @param model UrlQuery
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getUrlsExceptByPage(PagingCriteria pagingCriteria, UrlQuery model);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param funId int
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getUrlsByFunId(int funId);
}
