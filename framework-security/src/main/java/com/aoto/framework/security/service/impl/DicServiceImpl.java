package com.aoto.framework.security.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aoto.framework.commons.constant.NumberEnum;
import com.aoto.framework.commons.constant.BeanProperty.Bean;
import com.aoto.framework.commons.constant.BeanProperty.Cache;
import com.aoto.framework.commons.constant.BeanProperty.Dic;
import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.commons.userdetails.CurrentUserHolder;
import com.aoto.framework.security.models.DicModel;
import com.aoto.framework.security.models.DicQueryModel;
import com.aoto.framework.security.persistence.inf.DicMapper;
import com.aoto.framework.security.service.inf.DicService;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月2日
 */
@Service
public class DicServiceImpl implements DicService
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected DicMapper dicMapper;

    /**
     * 分页查询
     */
    @Override
    public List<Map<String, Object>> getDicsByPageMap(PagingCriteria pagingCriteria, DicQueryModel model)
    {
        Map<String, Object> map = new HashMap<String, Object>(2);
        map.put(Bean.PAGING, pagingCriteria);
        map.put(Dic.DIC_NAME, model.getDicName());
        map.put(Dic.DIC_TYPE, model.getDicType());
        List<Map<String, Object>> list = dicMapper.getDicsByPage(map);
        return list;
    }

    @Override
    public List<Map<String, Object>> getDics()
    {
        List<Map<String, Object>> list = dicMapper.getDics();
        List<Map<String, Object>> newList = new ArrayList<Map<String, Object>>();
        Set<String> dicSet = new LinkedHashSet<String>();
        Map<String, Object> newMap = null;
        Map<String, Object> childMap = null;
        List<Map<String, Object>> childrenList = null;
        for (Map<String, Object> map : list)
        {
            if (!dicSet.contains(map.get("dicType") + "," + (String) map.get("dicName")))
            {
                dicSet.add(map.get("dicType") + "," + (String) map.get("dicName"));
            }
        }
        for (String dicStr : dicSet)
        {
            newMap = new LinkedHashMap<String, Object>();
            String dicTypeString = dicStr.split(",")[0];
            String dicNameString = dicStr.split(",")[1];
            newMap.put("id", Integer.parseInt(dicTypeString));
            newMap.put("text", dicNameString);
            childrenList = new ArrayList<Map<String, Object>>();
            for (Map<String, Object> map : list)
            {
                if (Integer.parseInt(dicTypeString) == (Integer) map.get("dicType"))
                {
                    childMap = new LinkedHashMap<String, Object>();
                    childMap.put("id", map.get("dicKey"));
                    childMap.put("name", map.get("dicValue"));
                    childMap.put("symbol", map.get("dicSymbol"));
                    childrenList.add(childMap);
                }
            }
            newMap.put("value", childrenList);
            newList.add(newMap);
        }
        return newList;
    }

    /**
     * 新增数据字典
     */
    @Override
    @CacheEvict(value = Cache.DIC_CACHE, allEntries = true)
    @Transactional
    public String newDic(List<DicModel> list)
    {
        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();
        Date now = new Date();
        
        // 判断类型名称不能重复
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_16.getNum());
        map.put(Dic.DIC_ID, 0);
        map.put(Dic.DIC_NAME, list.get(0).getDicName());
        
        int countDicName = dicMapper.selectDicNumListDicNameForInsert(map);
        
        if (countDicName > 0)
        {
            return "类型名称不能重复";
        }
        
        // 判断类型不能重复
        map.put(Dic.DIC_ID, 0);
        map.put(Dic.DIC_TYPE, list.get(0).getDicType());
        int countDicType = dicMapper.selectDicNumListDicTypeForInsert(map);
        
        if (countDicType > 0)
        {
            return "类型不能重复";
        }
        
        for (DicModel model : list)
        {
            map.put(Dic.PRIMARY_KEY, 0);
            map.put(Dic.DIC_NAME, model.getDicName());
            map.put(Dic.DIC_TYPE, model.getDicType());
            map.put(Dic.DIC_KEY, model.getDicKey());
            map.put(Dic.DIC_VALUE, model.getDicValue());
            map.put(Dic.DIC_SYMBOL, model.getDicSymbol());
            map.put(Dic.CREATED_BY, currentUserId);
            map.put(Dic.CREATED_DATE, now);
            map.put(Dic.LAST_UPDATED_BY, currentUserId);
            map.put(Dic.LAST_UPDATED_DATE, now);
            dicMapper.insertDic(map);
        }

        return null;
    }

    /**
     * 根据dicType查找字典表详细信息 加分页
     */
    @Override
    public List<Map<String, Object>> getDicByDicTypeByPage(PagingCriteria pagingCriteria, DicQueryModel model)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Bean.PAGING, pagingCriteria);
        map.put(Dic.DIC_TYPE, model.getDicType());
        map.put(Dic.DIC_KEY, model.getDicKey());
        map.put(Dic.DIC_VALUE, model.getDicValue());
        map.put(Dic.DIC_SYMBOL, model.getDicSymbol());
        List<Map<String, Object>> list = dicMapper.getDicByDicTypeByPage(map);
        return list;
    }

    /**
     * 根据dicType查找字典表详细信息
     */
    @Override
    public List<Map<String, Object>> getDicByDicType(DicQueryModel model)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Dic.DIC_TYPE, model.getDicType());
        map.put(Dic.DIC_KEY, model.getDicKey());
        map.put(Dic.DIC_VALUE, model.getDicValue());
        map.put(Dic.DIC_SYMBOL, model.getDicSymbol());
        List<Map<String, Object>> list = dicMapper.getDicByDicType(map);
        return list;
    }
    
    /**
     * 根据dicType查找字典表详细信息
     */
    @Override
    @Cacheable(value = Cache.DIC_CACHE, key = "#root.targetClass + #root.methodName + #dicType + '_' + #dicKey")
    public String getDicValue(String dicType, String dicKey)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Dic.DIC_TYPE, dicType);
        map.put(Dic.DIC_KEY, dicKey);
        List<Map<String, Object>> list = dicMapper.getDicByDicType(map);
        String dicValueString = "";
        if (null!=list&&list.size()>0){
            dicValueString = (String) list.get(0).get(Dic.DIC_VALUE);
        }
        return dicValueString;
    }

    /**
     * 编辑数据字典
     */
    @Override
    @CacheEvict(value = Cache.DIC_CACHE, allEntries = true)
    @Transactional
    public String editDic(List<DicModel> list)
    {
        Date now = new Date();
        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();
        int tmpDicId = 0;
        for (DicModel model : list)
        {
            if (model.getDicId() > 0) {
                tmpDicId = model.getDicId();
            }
        }
        // 判断类型名称不能重复
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_16.getNum());
        map.put(Dic.DIC_ID, tmpDicId);
        map.put(Dic.DIC_NAME, list.get(0).getDicName());
        
        int countDicName = dicMapper.selectDicNumListDicNameForInsert(map);
        
        if (countDicName > 0)
        {
            return "类型名称不能重复";
        }
        
        // 判断类型不能重复
        map.put(Dic.DIC_ID, tmpDicId);
        map.put(Dic.DIC_TYPE, list.get(0).getDicType());
        int countDicType = dicMapper.selectDicNumListDicTypeForInsert(map);
        
        if (countDicType > 0)
        {
            return "类型不能重复";
        }
        
        String status = "";

        // oldDicType dicType 传入 用以判断
        for (DicModel model : list)
        {
            status = model.getStatus();
            if (status.equals("inserted"))
            {
                map.put(Dic.PRIMARY_KEY, 0);
                map.put(Dic.DIC_NAME, model.getDicName());
                map.put(Dic.DIC_TYPE, model.getDicType());
                map.put(Dic.DIC_KEY, model.getDicKey());
                map.put(Dic.DIC_VALUE, model.getDicValue());
                map.put(Dic.DIC_SYMBOL, model.getDicSymbol());
                map.put(Dic.CREATED_BY, currentUserId);
                map.put(Dic.CREATED_DATE, now);
                map.put(Dic.LAST_UPDATED_BY, currentUserId);
                map.put(Dic.LAST_UPDATED_DATE, now);
                dicMapper.insertDic(map);
            }
            else if (status.equals("deleted"))
            {
                map.put(Dic.PRIMARY_KEY, model.getDicId());
                map.put(Dic.LAST_UPDATED_BY, currentUserId);
                map.put(Dic.LAST_UPDATED_DATE, now);
                dicMapper.deleteDic(map);
            }
            else if (status.equals("updated"))
            {
                map = new HashMap<String, Object>();
                map.put(Dic.PRIMARY_KEY, model.getDicId());
                map.put(Dic.DIC_NAME, model.getDicName());
                map.put(Dic.DIC_TYPE, model.getDicType());
                map.put(Dic.DIC_KEY, model.getDicKey());
                map.put(Dic.DIC_VALUE, model.getDicValue());
                map.put(Dic.DIC_SYMBOL, model.getDicSymbol());
                map.put(Dic.LAST_UPDATED_BY, currentUserId);
                map.put(Dic.LAST_UPDATED_DATE, now);
                dicMapper.updateDic(map);
            }
        }
        return null;
    }

    /**
     * 删除数据字典
     */
    @Override
    @CacheEvict(value = Cache.DIC_CACHE, allEntries = true)
    @Transactional
    public String deleteDic(List<String> list)
    {
        for (String dicType : list)
        {
            dicMapper.deleteDicByDicType(dicType);
        }
        
        return "";
    }
}
