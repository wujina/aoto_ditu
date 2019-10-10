/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：PerMapper.java
 * 文件名称：PerMapper.java
 * 系统编号：mips
 * 系统名称：mips
 * 模块编号：
 * 模块名称：
 * 作          者：lih
 * 完成日期：2013年9月24日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.security.persistence.inf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author lih
 * @see    [相关类/方法]（可选）
 * @since  [产品/模块版本] （必须）
 */
public interface FunctionMapper
{
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void insertFunUrl(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param funId int
     */
    void deleteFunUrl(int funId);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return List<Integer>
     */
    List<Integer> selectFunctions();
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param roleId int
     * @return List<Integer>
     */
    List<Integer> selectFunctionsByRoleId(int roleId);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param userId int
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> selectFunctionsByUserId(int userId);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     * @return int
     */
    int selectCountByFunId(Map<String, Object> map);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     * @return int
     */
    int selectCountByNameAndParentId(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void insertFun(Map<String, Object> map);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateFun(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateFunParent(Map<String, Object> map);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void deleteFun(Map<String, Object> map);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param parentId int
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> selectFunsByParentId(int parentId);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateFunLevel(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateFunSortNum(Map<String, Object> map);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map HashMap<String, Integer>
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> selectFunctionsForTree(HashMap<String, Integer> map);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map HashMap<String, Integer>
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> selectFunsByParentId(HashMap<String, Integer> map);
    
}