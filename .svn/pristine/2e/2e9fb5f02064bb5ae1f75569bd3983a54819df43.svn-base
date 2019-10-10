/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：RoleServiceImpl.java
 * 文件名称：RoleServiceImpl.java
 * 系统编号：framewrok
 * 系统名称：framewrok
 * 模块编号：
 * 模块名称：
 * 作          者：lih
 * 完成日期：2013年9月25日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.security.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aoto.framework.commons.constant.BeanProperty.Bean;
import com.aoto.framework.commons.constant.BeanProperty.Cache;
import com.aoto.framework.commons.constant.BeanProperty.Function;
import com.aoto.framework.commons.constant.BeanProperty.Org;
import com.aoto.framework.commons.constant.BeanProperty.Role;
import com.aoto.framework.commons.constant.BeanProperty.User;
import com.aoto.framework.commons.constant.NumberEnum;
import com.aoto.framework.commons.constant.RoleTypeEnum;
import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.commons.userdetails.CurrentUserHolder;
import com.aoto.framework.security.models.RoleModel;
import com.aoto.framework.security.models.RoleQuery;
import com.aoto.framework.security.persistence.inf.RoleMapper;
import com.aoto.framework.security.service.inf.RoleService;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author lih
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Service
public class RoleServiceImpl implements RoleService
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected RoleMapper roleMapper;

    @Override
    @Transactional
    public String createRole(RoleModel model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_8.getNum());
        String errorCode = validateRole(model, map);
        
        if (!StringUtils.isEmpty(errorCode))
        {
            return errorCode;
        }

        Date now = new Date();
        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();

        map.put(Bean.DELETED, false);
        map.put(Bean.CREATED_BY, currentUserId);
        map.put(Bean.CREATED_DATE, now);
        map.put(Bean.LAST_UPDATED_BY, currentUserId);
        map.put(Bean.LAST_UPDATED_DATE, now);

        roleMapper.insertRole(map);

        return null;
    }
    
    @Override
    @Transactional
    @CacheEvict(value = { Cache.MENU_CACHE, Cache.PERMISSION_CACHE }, allEntries = true)
    public void createRoleFun(int roleId, List<Integer> list)
    {
        roleMapper.deleteRoleFun(roleId);
        
        if (null != list && list.size() > 0)
        {
            Map<String, Object> map = new HashMap<String, Object>(2);
            
            for (int funId : list)
            {
                map.put(Role.ROLE_ID, roleId);
                map.put(Function.FUN_ID, funId);
                
                roleMapper.insertRoleFun(map);
            }
        }
    }
    
    @Override
    @Transactional
    @CacheEvict(value = { Cache.MENU_CACHE, Cache.PERMISSION_CACHE }, allEntries = true)
    public void createRoleUser(int roleId, List<Integer> list)
    {
        roleMapper.deleteRoleUser(roleId);
        
        if (null != list && list.size() > 0)
        {
            Map<String, Object> map = new HashMap<String, Object>(2);
            
            for (int userId : list)
            {
                map.put(Role.ROLE_ID, roleId);
                map.put(User.USER_ID, userId);
                
                roleMapper.insertRoleUser(map);
            }
        }
    }
    
    @Override
    @Transactional
    @CacheEvict(value = { Cache.MENU_CACHE, Cache.PERMISSION_CACHE }, allEntries = true)
    public void createRoleUser(int roleId, int orgId, List<Integer> list)
    {
        Map<String, Object> map = new HashMap<String, Object>(2);
        map.put(Role.ROLE_ID, roleId);
        map.put(Org.ORG_ID, orgId);
        roleMapper.deleteCommRoleUser(map);
        
        if (null != list && list.size() > 0)
        {
            map = new HashMap<String, Object>(2);
            
            for (int userId : list)
            {
                map.put(Role.ROLE_ID, roleId);
                map.put(User.USER_ID, userId);
                
                roleMapper.insertRoleUser(map);
            }
        }
    }

    @Override
    public List<Map<String, Object>> getRolesByPage(PagingCriteria pagingCriteria, RoleQuery model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());

        map.put(Bean.PAGING, pagingCriteria);
        map.put(Role.ROLE_NAME, StringUtils.trim(model.getRoleName()));
        map.put(Org.ORG_ID, model.getOrgId());
        map.put(Org.CONTAIN_SUB, model.isContainSub());
        map.put(Role.ROLE_TYPE, model.getRoleType().getCode());
        
        if (RoleTypeEnum.GENERAL_ROLE.equals(model.getRoleType())) {
            return roleMapper.selectRolesByPage(map);
        }
        else {
            return roleMapper.selectCommRolesByPage(map);
        }
    }

    @Override
    @Transactional
    public String editRole(RoleModel model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
        String errorCode = validateRole(model, map);
        
        if (!StringUtils.isEmpty(errorCode))
        {
            return errorCode;
        }

        Date now = new Date();
        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();

        map.remove(Org.ORG_ID);
        map.put(Bean.LAST_UPDATED_BY, currentUserId);
        map.put(Bean.LAST_UPDATED_DATE, now);

        roleMapper.updateRole(map);
        return null;
    }
    
    @Override
    @Transactional
    public void removeRoles(List<Integer> list)
    {
        for (int roleId : list)
        {
            roleMapper.deleteRoleFun(roleId);
            roleMapper.deleteRoleUser(roleId);
            roleMapper.deleteRole(roleId);
        }
    }
    
    @Override
    public List<Map<String, Object>> getRolesByUserId(int userId)
    {
        return roleMapper.selectRolesByUserId(userId);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model RoleModel
     * @param map Map<String, Object>
     * @return String
     */
    private String validateRole(RoleModel model, Map<String, Object> map)
    {
        String roleName = StringUtils.trim(model.getRoleName());

        map.put(Role.ROLE_ID, model.getRoleId());
        map.put(Role.ROLE_NAME, roleName);
        
        if (null != model.getOrgId()) {
            map.put(Org.ORG_ID, model.getOrgId());
            map.put(Role.ROLE_TYPE, RoleTypeEnum.GENERAL_ROLE.getCode());
        }
        else {
            map.put(Role.ROLE_TYPE, RoleTypeEnum.COMM_BUSINESS_ROLE.getCode());
        }
        
        int count = roleMapper.selectCountByNameAndOrgId(map);
        
        if (count > 0) {
            return "role.validation.message5";
        }
        
        map.remove(Role.ROLE_ID);
        map.put(Role.PRIMARY_KEY, model.getRoleId());
        map.put(Role.REMARK, StringUtils.trim(model.getRemark()));
 
        return null;
    }
}
