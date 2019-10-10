/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：RoleServiceImpl.java
 * 文件名称：RoleServiceImpl.java
 * 系统编号：framework
 * 系统名称：framework
 * 模块编号：
 * 模块名称：
 * 作          者：lih
 * 完成日期：2013年9月25日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.security.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aoto.framework.commons.constant.AccessTypeEnum;
import com.aoto.framework.commons.constant.BeanProperty.Bean;
import com.aoto.framework.commons.constant.BeanProperty.Cache;
import com.aoto.framework.commons.constant.BeanProperty.Function;
import com.aoto.framework.commons.constant.BeanProperty.Url;
import com.aoto.framework.commons.constant.NumberEnum;
import com.aoto.framework.commons.userdetails.CurrentUserHolder;
import com.aoto.framework.security.models.FunModel;
import com.aoto.framework.security.persistence.inf.FunctionMapper;
import com.aoto.framework.security.persistence.inf.UrlMapper;
import com.aoto.framework.security.service.inf.FunctionService;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author lih
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Service
public class FunctionServiceImpl implements FunctionService
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected FunctionMapper functionMapper;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected UrlMapper urlMapper;

    @Override
    @Transactional
    @CacheEvict(value = { Cache.PERMISSION_CACHE }, allEntries = true)
    public void createFunUrl(int funId, List<Integer> list)
    {
        functionMapper.deleteFunUrl(funId);

        if (null != list && list.size() > 0)
        {
            Map<String, Object> map = new HashMap<String, Object>(2);

            for (int urlId : list)
            {
                map.put(Function.FUN_ID, funId);
                map.put(Url.URL_ID, urlId);

                functionMapper.insertFunUrl(map);
            }
        }
    }

    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param userId int
     * @param parentId int
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public List<Map<String, Object>> getFunctionsForTree(int userId, int parentId)
    {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        map.put("userId", userId);
        map.put("parentId", parentId);        
        List<Map<String, Object>> list = functionMapper.selectFunctionsForTree(map);
        return list;
    }

    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param userId int
     * @param parentId int
     * @return List<Map<String, Object>>
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public List<Map<String, Object>> getFunsByParentId(int userId, int parentId)
    {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        map.put("userId", userId);
        map.put("parentId", parentId);        
        List<Map<String, Object>> list = functionMapper.selectFunsByParentId(map);
        return list;
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model FunModel
     * @param map Map<String, Object>
     * @param access AccessTypeEnum
     * @return String
     */
    private String validateFun(FunModel model, Map<String, Object> map, AccessTypeEnum access)
    {
        map.put(Function.PRIMARY_KEY, model.getFunId());
        map.put(Function.FUN_NAME, StringUtils.trim(model.getFunName()));
        map.put(Function.PARENT_ID, model.getParentId());

        map.put(Function.FUN_ID, model.getFunId());
        map.put(Function.PRIMARY_KEY, model.getFunId());
        map.put(Function.SORT_NUM, model.getSortNum());
        if (AccessTypeEnum.UPDATE.equals(access)) {
            return null;
        }
        int count = functionMapper.selectCountByFunId(map);
        if (count > 0)
        {
            return "fun.validation.message8";
        }
        count = functionMapper.selectCountByNameAndParentId(map);
        if (count > 0)
        {
            return "fun.validation.message5";
        }
        return null;
    }

    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param model FunModel
     * @return String
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public String createFun(FunModel model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_8.getNum());
        String errorCode = validateFun(model, map, AccessTypeEnum.CREATE);

        if (!StringUtils.isEmpty(errorCode))
        {
            return errorCode;
        }

        map.put(Function.LEVEL_NUM, model.getLevelNum());
        map.put(Bean.DELETED, false);
        
        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();
        Date now = new Date();
        map.put(Bean.CREATED_BY, currentUserId);
        map.put(Bean.CREATED_DATE, now);
        map.put(Bean.LAST_UPDATED_BY, currentUserId);
        map.put(Bean.LAST_UPDATED_DATE, now);

        functionMapper.insertFun(map);

        return null;
    }

    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param model FunModel
     * @return String
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public String editFun(FunModel model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_8.getNum());
        String errorCode = validateFun(model, map, AccessTypeEnum.UPDATE);

        if (!StringUtils.isEmpty(errorCode))
        {
            return errorCode;
        }
        
        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();
        Date now = new Date();
        map.put(Bean.LAST_UPDATED_BY, currentUserId);
        map.put(Bean.LAST_UPDATED_DATE, now);
        functionMapper.updateFun(map);

        return null;
    }

    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param id int
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public void removeFun(int id)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());

        map.put(Function.PRIMARY_KEY, id);
        map.put(Bean.DELETED, true);

        functionMapper.deleteFun(map);
    }

    // 更新子节点 更新子节点的层级关系
    @Override
    @Transactional
    public void moveFun(int id, int parentId, int parentLevelNum, List<FunModel> list)
    {
        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();
        Date now = new Date();
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_8.getNum());
        
        // 更新排序号 更新其父节点的所有儿子的排序号 由前端传过来 map <String id,int sortNum>
        for (FunModel model : list)
        {
            map.put(Function.PRIMARY_KEY, model.getFunId());
            map.put(Function.SORT_NUM, model.getSortNum());
            map.put(Bean.LAST_UPDATED_BY, currentUserId);
            map.put(Bean.LAST_UPDATED_DATE, now);
            functionMapper.updateFunSortNum(map);
        }
        int levelNum = parentLevelNum + 1;
        map.put(Function.PRIMARY_KEY, id);
        map.put(Function.PARENT_ID, parentId);
        map.put(Function.LEVEL_NUM, levelNum);
        map.put(Bean.LAST_UPDATED_BY, currentUserId);
        map.put(Bean.LAST_UPDATED_DATE, now);
        functionMapper.updateFunParent(map);
        
//        Map<String, Integer> m = new HashMap<String, Integer>(2);
//        m.put("userId", -1);
//        m.put("parentId", id);
        
        List<Map<String, Object>> l = functionMapper.selectFunsByParentId(id);
        
        map.put(Function.LEVEL_NUM, parentLevelNum + 1);
        updateChildren(l, levelNum, currentUserId, now);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param list List<Map<String, Object>>
     * @param parentLevelNum int
     * @param currentUserId int
     * @param now Date
     */
    @SuppressWarnings("unchecked")
    private void updateChildren(List<Map<String, Object>> list, int parentLevelNum, int currentUserId, Date now)
    {
        int levelNum = parentLevelNum + 1;
        int funId = 0;
        List<Map<String, Object>> children = null;
        
        for (Map<String, Object> m : list)
        {
            if (null != m.get("children"))
            {
                children = (List<Map<String, Object>>)m.get("children");
            }
            
            funId = (Integer)m.get("id");
            
            m.clear();
            m.put(Function.PRIMARY_KEY, funId);
            m.put(Function.LEVEL_NUM, levelNum);
            m.put(Bean.LAST_UPDATED_BY, currentUserId);
            m.put(Bean.LAST_UPDATED_DATE, now);
            
            // 更新所有子节点本身
            functionMapper.updateFunLevel(m);
            
            if (null != children && children.size() > 0)
            {
                updateChildren(children, levelNum, currentUserId, now);
            }
        }        
    }

    @Override
    public List<Integer> getFunctionsByRoleId(int roleId)
    {
        return functionMapper.selectFunctionsByRoleId(roleId);
    }

    @Override
    @Cacheable(value = Cache.PERMISSION_CACHE, key = "#root.targetClass + #root.methodName")
    public List<Map<String, Object>> getRequestMap()
    {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> getUrls = urlMapper.selectUrlsByMethod("GET");
        List<Map<String, Object>> postUrls = urlMapper.selectUrlsByMethod("POST");
        List<Map<String, Object>> putUrls = urlMapper.selectUrlsByMethod("PUT");
        List<Map<String, Object>> deleteUrls = urlMapper.selectUrlsByMethod("DELETE");

        for (Map<String, Object> url : getUrls)
        {
            addUrlItem(url, list);
        }

        for (Map<String, Object> url : postUrls)
        {
            addUrlItem(url, list);
        }

        for (Map<String, Object> url : putUrls)
        {
            addUrlItem(url, list);
        }

        for (Map<String, Object> url : deleteUrls)
        {
            addUrlItem(url, list);
        }

        return list;
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param url Map<String, Object>
     * @param list List<Map<String, Object>>
     */
    private void addUrlItem(Map<String, Object> url, List<Map<String, Object>> list)
    {
        String u = (String) url.get(Url.URL_PATTERN);
        String m = (String) url.get(Url.HTTP_METHOD);
        String r = url.get("roleId").toString();
        String ro = "";

        for (Map<String, Object> map : list)
        {
            if (u.equals(map.get(Url.URL_PATTERN)) && m.equals(map.get(Url.HTTP_METHOD)))
            {
                ro = (String) map.get("roles") + ",";

                if (!StringUtils.contains(ro, r + ","))
                {
                    ro += r + ",";
                }

                ro = StringUtils.removeEnd(ro, ",");
                map.put("roles", ro);
                return;
            }
        }

        url.put("roles", r);
        list.add(url);
    }

    @Override
    public Map<String, Boolean> getFunctionsByUserId(int userId)
    {
        List<Map<String, Object>> list = functionMapper.selectFunctionsByUserId(userId);
        Map<String, Boolean> map = new HashMap<String, Boolean>(NumberEnum.NUMBER_32.getNum());

        for (Map<String, Object> m : list)
        {
            map.put(String.valueOf(m.get(Function.FUN_ID)), (Boolean) m.get(Function.ENABLED));
        }

        return map;
    }
}
