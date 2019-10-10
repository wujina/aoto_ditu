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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aoto.framework.commons.constant.NumberEnum;
import com.aoto.framework.commons.constant.BeanProperty.Bean;
import com.aoto.framework.commons.constant.BeanProperty.Url;
import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.commons.userdetails.CurrentUserHolder;
import com.aoto.framework.security.models.UrlModel;
import com.aoto.framework.security.models.UrlQuery;
import com.aoto.framework.security.persistence.inf.UrlMapper;
import com.aoto.framework.security.service.inf.UrlService;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author lih
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Service
public class UrlServiceImpl implements UrlService
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected UrlMapper urlMapper;
    
    @Override
    public List<Map<String, Object>> getUrlByPage(PagingCriteria pagingCriteria, UrlQuery model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
        map.put(Bean.PAGING, pagingCriteria);
        map.put("urlName", StringUtils.trim(model.getUrlName()));
        return urlMapper.selectUrlByPage(map);
    }

    @Override
    @Transactional
    public String createUrl(UrlModel model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
        Date now = new Date();
        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();
        map.put(Url.PRIMARY_KEY, 0);
        map.put(Url.URL_NAME, model.getUrlName());
        
        int count = urlMapper.selectCountName(map);
        if (count > 0)
        {
            return "url.validation.message5";
        }
        
        map.put(Url.URL_PATTERN, model.getUrlPattern());
        map.put(Url.HTTP_METHOD, model.getHttpMethod());
        map.put(Url.ACTION_CODE, model.getActionCode());
        map.put(Url.ARGS_CODE, model.getArgsCode());
        if ("GET".equals(model.getHttpMethod())){
            map.put(Url.LOGGED_DATA_CHANGED, 0);
        }
        else {
            map.put(Url.LOGGED_DATA_CHANGED, 1);
        }
        
        map.put(Bean.DELETED, false);
        map.put(Bean.CREATED_BY, currentUserId);
        map.put(Bean.CREATED_DATE, now);
        map.put(Bean.LAST_UPDATED_BY, currentUserId);
        map.put(Bean.LAST_UPDATED_DATE, now);
        urlMapper.insertUrl(map);
        return null;
    }

    @Override
    @Transactional
    public String editUrl(UrlModel model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
        Date now = new Date();
        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();
        map.put(Url.PRIMARY_KEY, model.getUrlId());
        map.put(Url.URL_ID, model.getUrlId());
        map.put(Url.URL_NAME, model.getUrlName());
        

        int count = urlMapper.selectCountName(map);
        if (count > 0)
        {
            return "url.validation.message5";
        }
        
        map.put(Url.URL_PATTERN, model.getUrlPattern());
        map.put(Url.HTTP_METHOD, model.getHttpMethod());
        map.put(Url.ACTION_CODE, model.getActionCode());
        map.put(Url.ARGS_CODE, model.getArgsCode());
        if ("GET".equals(model.getHttpMethod())) {
            map.put(Url.LOGGED_DATA_CHANGED, 0);
        }
        else {
            map.put(Url.LOGGED_DATA_CHANGED, 1);
        }
        map.put(Bean.LAST_UPDATED_BY, currentUserId);
        map.put(Bean.LAST_UPDATED_DATE, now);
        urlMapper.updateUrl(map);
        return null;
    }

    @Override
    @Transactional
    public void removeUrls(List<Integer> list)
    {
        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());

        for (int urlId : list)
        {
            map.put(Url.PRIMARY_KEY, urlId);
            map.put(Bean.DELETED, true);
            map.put(Bean.LAST_UPDATED_BY, currentUserId);
            map.put(Bean.LAST_UPDATED_DATE, new Date());
            urlMapper.deleteUrl(map);
        }
    }

    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param pagingCriteria PagingCriteria
     * @param model UrlQuery
     * @return List<Map<String, Object>>
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public List<Map<String, Object>> getUrlsExceptByPage(PagingCriteria pagingCriteria, UrlQuery model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_8.getNum());

        map.put(Bean.PAGING, pagingCriteria);
        map.put("excepted", model.getNotIn());
        map.put(Url.URL_NAME, StringUtils.trim(model.getUrlName()));

        return urlMapper.selectUrlsExceptByPage(map);
    }

    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param funId int
     * @return List<Map<String, Object>>
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public List<Map<String, Object>> getUrlsByFunId(int funId)
    {
        return urlMapper.selectUrlsByFunId(funId);
    }

}
