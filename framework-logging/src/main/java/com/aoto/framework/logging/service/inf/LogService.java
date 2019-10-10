/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：LogService.java
 * 文件名称：LogService.java
 * 系统编号：mips
 * 系统名称：mips
 * 模块编号：
 * 模块名称：
 * 作          者：shir
 * 完成日期：2013-12-10
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.logging.service.inf;

import java.util.List;
import java.util.Map;

import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.logging.models.LoginLogModel;
import com.aoto.framework.logging.models.LoginLogQuery;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author shir
 * @see    [相关类/方法]（可选）
 * @since  [产品/模块版本] （必须）
 */
public interface LogService
{
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model LoginLogModel
     */
    void createLoginLog(LoginLogModel model);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param code String
     * @param args String...
     * @return int
     */
    int createBehaviorLog(String code, String... args);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param action String
     * @param dataChanged boolean
     * @return int
     */
    int createBehaviorLog(String action, boolean dataChanged);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateLogoutDate(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param behaviorId int
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getDataLogsByBehavioId(int behaviorId);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param pagingCriteria PagingCriteria
     * @param model LoginLogQuery
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getLoginLogsByPage(PagingCriteria pagingCriteria, LoginLogQuery model);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param pagingCriteria PagingCriteria
     * @param model LoginLogQuery
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getBehaviorLogsByPage(PagingCriteria pagingCriteria, LoginLogQuery model);
}
