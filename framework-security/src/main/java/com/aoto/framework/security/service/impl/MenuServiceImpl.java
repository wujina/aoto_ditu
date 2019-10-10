/*
 * 版权信息：Copyright (c) 2009, Aoto. All rights reserved.
 * 文件编号：
 * 文件名称：
 * 系统编号：
 * 系统名称：
 * 模块编号：
 * 模块名称：
 * 作          者：
 * 完成日期：
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
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aoto.framework.commons.constant.NumberEnum;
import com.aoto.framework.commons.constant.BeanProperty.Bean;
import com.aoto.framework.commons.constant.BeanProperty.Cache;
import com.aoto.framework.commons.constant.BeanProperty.Menu;
import com.aoto.framework.commons.userdetails.CurrentUserHolder;
import com.aoto.framework.security.models.MenuModel;
import com.aoto.framework.security.persistence.inf.MenuMapper;
import com.aoto.framework.security.service.inf.MenuService;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月2日
 */
@Service
public class MenuServiceImpl implements MenuService
{    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected MenuMapper menuMapper;

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model MenuModel
     * @param map Map<String, Object>
     * @return String
     */
    private String validateMenu(MenuModel model, Map<String, Object> map)
    {
        map.put(Menu.PRIMARY_KEY, model.getMenuId());
        map.put(Menu.MENU_NAME, StringUtils.trim(model.getMenuName()));
        map.put(Menu.MENU_URL, StringUtils.isBlank(model.getMenuUrl()) ? null : StringUtils.trim(model.getMenuUrl()));
        map.put(Menu.ICON, StringUtils.trim(model.getIcon()));
        map.put(Menu.FUN_ID, model.getFunId());
        map.put(Menu.PARENT_ID, model.getParentId());

        int count = menuMapper.selectCountByNameAndParentId(map);
        if (count > 0)
        {
            return "menu.validation.message5";
        }

        map.put(Menu.SORT_NUM, model.getSortNum());

        return null;
    }

    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param model MenuModel
     * @return String
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    @CacheEvict(value = Cache.MENU_CACHE, allEntries = true)
    public String createMenu(MenuModel model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_8.getNum());
        String errorCode = validateMenu(model, map);

        if (!StringUtils.isEmpty(errorCode))
        {
            return errorCode;
        }

        map.put(Menu.PRIMARY_KEY, 0);
        map.put(Menu.LEVEL_NUM, model.getLevelNum());
        map.put(Bean.DELETED, false);

        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();
        Date now = new Date();
        map.put(Bean.CREATED_BY, currentUserId);
        map.put(Bean.CREATED_DATE, now);
        map.put(Bean.LAST_UPDATED_BY, currentUserId);
        map.put(Bean.LAST_UPDATED_DATE, now);
        
        menuMapper.insertMenu(map);

        return null;
    }

    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param model MenuModel
     * @return String
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    @CacheEvict(value = Cache.MENU_CACHE, allEntries = true)
    public String editMenu(MenuModel model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_8.getNum());
        map.put(Menu.PRIMARY_KEY, model.getMenuId());
        map.put(Menu.MENU_ID, model.getMenuId());
        String errorCode = validateMenu(model, map);

        if (!StringUtils.isEmpty(errorCode))
        {
            return errorCode;
        }
        
        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();
        Date now = new Date();
        map.put(Bean.LAST_UPDATED_BY, currentUserId);
        map.put(Bean.LAST_UPDATED_DATE, now);
        menuMapper.updateMenu(map);

        return null;
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param id int
     * @exception 
     * @see com.aoto.framework.security.service.inf.MenuService#removeMenu(int)
     */
    @Override
    @CacheEvict(value = Cache.MENU_CACHE, allEntries = true)
    public void removeMenu(int id)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());

        map.put(Menu.PRIMARY_KEY, id);
        map.put(Bean.DELETED, true);

        menuMapper.deleteMenu(map);
    }

    // 更新子节点 更新子节点的层级关系
    @Override
    @Transactional
    @CacheEvict(value = Cache.MENU_CACHE, allEntries = true)
    public void moveMenu(int id, int parentId, int parentLevelNum, List<MenuModel> list)
    {
        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();
        Date now = new Date();
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());

        // 更新排序号 更新其父节点的所有儿子的排序号 由前端传过来 map <String id,int sortNum>
        for (MenuModel model : list)
        {
            map.put(Menu.PRIMARY_KEY, model.getMenuId());
            map.put(Menu.SORT_NUM, model.getSortNum());
            map.put(Bean.LAST_UPDATED_BY, currentUserId);
            map.put(Bean.LAST_UPDATED_DATE, now);
            
            menuMapper.updateMenuSortNum(map);
        }
        
        int levelNum = parentLevelNum + 1;
        
        map.put(Menu.PRIMARY_KEY, id);
        map.put(Menu.PARENT_ID, parentId);
        map.put(Menu.LEVEL_NUM, levelNum);
        map.put(Bean.LAST_UPDATED_BY, currentUserId);
        map.put(Bean.LAST_UPDATED_DATE, now);
        menuMapper.updateMenuParent(map);
        
        Map<String, Integer> m = new HashMap<String, Integer>(2);
        m.put("userId", -1);
        m.put("parentId", id);
        
        List<Map<String, Object>> l = menuMapper.selectMenusByParentId(m);
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
        int menuId = 0;
        List<Map<String, Object>> children = null;
        
        for (Map<String, Object> m : list)
        {
            if (null != m.get("children"))
            {
                children = (List<Map<String, Object>>)m.get("children");
            }
            
            menuId = (Integer)m.get("id");
            
            m.clear();
            m.put(Menu.PRIMARY_KEY, menuId);
            m.put(Menu.LEVEL_NUM, levelNum);
            m.put(Bean.LAST_UPDATED_BY, currentUserId);
            m.put(Bean.LAST_UPDATED_DATE, now);
            
            // 更新所有子节点本身
            menuMapper.updateMenuLevel(m);
            
            if (null != children && children.size() > 0)
            {
                updateChildren(children, levelNum, currentUserId, now);
            }
        }
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
    @Cacheable(value = Cache.MENU_CACHE, key = "#root.targetClass + #root.methodName + #userId + '_' + #parentId")
    public List<Map<String, Object>> getMenusByParentId(int userId, int parentId)
    {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        map.put("userId", userId);
        map.put("parentId", parentId);
        List<Map<String, Object>> list = menuMapper.selectMenusByParentId(map);

        return list;
    }
}
