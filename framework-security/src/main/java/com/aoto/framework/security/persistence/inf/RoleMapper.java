/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：RoleMapper.java
 * 文件名称：RoleMapper.java
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

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author lih
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public interface RoleMapper
{
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void insertRole(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void insertRoleFun(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void insertRoleUser(Map<String, Object> map);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param roleId int
     */
    void deleteRole(int roleId);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param roleId int
     */
    void deleteRoleFun(int roleId);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param roleId int
     */
    void deleteRoleUser(int roleId);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void deleteCommRoleUser(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateRole(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     * @return int
     */
    int selectCountByNameAndOrgId(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param userId int
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> selectRolesByUserId(int userId);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param funId int
     * @return List<Integer>
     */
    List<Integer> selectRolesByFunId(int funId);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> selectRolesByPage(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> selectCommRolesByPage(Map<String, Object> map);
}
