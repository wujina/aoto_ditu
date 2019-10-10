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
package com.aoto.framework.logging.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aoto.framework.commons.constant.BeanProperty.Bean;
import com.aoto.framework.commons.constant.BeanProperty.BehaviorLog;
import com.aoto.framework.commons.constant.BeanProperty.LoginLog;
import com.aoto.framework.commons.constant.BeanProperty.Org;
import com.aoto.framework.commons.constant.BeanProperty.User;
import com.aoto.framework.commons.constant.Constants;
import com.aoto.framework.commons.constant.NumberEnum;
import com.aoto.framework.commons.lang.StringUtils4Aoto;
import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.commons.userdetails.CurrentUser;
import com.aoto.framework.commons.userdetails.CurrentUserHolder;
import com.aoto.framework.logging.models.LoginLogModel;
import com.aoto.framework.logging.models.LoginLogQuery;
import com.aoto.framework.logging.persistence.inf.LogMapper;
import com.aoto.framework.logging.service.inf.LogService;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author shir
 * @see    [相关类/方法]（可选）
 * @since  [产品/模块版本] （必须）
 */
@Service
public class LogServiceImpl implements LogService
{   
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected LogMapper logMapper;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected MessageSource messageSource;

    /**
     * 〈一句话功能简述〉
     * 〈功能详细描述〉
     * @author jiangp
     * @param model LoginLogModel    
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see   [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    @Transactional
    public void createLoginLog(LoginLogModel model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
        map.put(User.USER_ID, model.getUserId());
        map.put(User.LAST_LOGIN_DATE, model.getLoginDate());
        map.put(User.LAST_LOGIN_IP, model.getIp());
        map.put(User.ERROR_TIME, 0);
        logMapper.updateUserLogin(map);
         
        String userAgent = StringUtils4Aoto.trim(model.getUserAgent());
        String os = null;
        String browser = null;
        
        if (!StringUtils4Aoto.isEmpty(userAgent))
        {
            String[] arr = StringUtils4Aoto.analyzeUserAgent(model.getUserAgent());
            os = arr[0];
            browser = arr[1];
        }
        
        map.clear();
        map.put(LoginLog.SESSION_ID, model.getSessionId());
        map.put(User.USER_ID, model.getUserId());
        map.put(User.USERNAME, model.getUsername());
        map.put(User.REAL_NAME, model.getRealName());
        map.put(LoginLog.IP, model.getIp());
        map.put(Org.ORG_ID, model.getOrgId());
        map.put(Org.ORG_NAME, model.getOrgName());
        map.put(Org.INHERITED_NAME, model.getInheritedName());
        map.put(LoginLog.LOGIN_DATE, model.getLoginDate());
        map.put(LoginLog.OS, os);
        map.put(LoginLog.BROWSER, browser);
        map.put(LoginLog.USER_AGENT, userAgent);

        logMapper.insertLoginLog(map);
    }

    /**
     * 〈一句话功能简述〉
     * 〈功能详细描述〉
     * @author jiangp
     * @param map     Map<String, Object>
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see   [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public void updateLogoutDate(Map<String, Object> map)
    {
        logMapper.updateLogoutDate(map);
    }

    /**
     * 〈一句话功能简述〉
     * 〈功能详细描述〉
     * @author jiangp
     * @param pagingCriteria PagingCriteria
     * @param model LoginLogQuery
     * @return  List<Map<String, Object>>
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see   [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public List<Map<String, Object>> getLoginLogsByPage(PagingCriteria pagingCriteria, LoginLogQuery model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
        Date endDate = DateUtils.addMilliseconds(model.getEndDate(), Constants.END_DATE_ADD_MILLISECONDS);
        
        map.put(Bean.PAGING, pagingCriteria);
        map.put(Bean.BEGIN_DATE, model.getBeginDate());
        map.put(Bean.END_DATE, endDate);
        map.put(User.USERNAME, StringUtils4Aoto.trim(model.getUsername()));
        map.put(User.ORG_ID, model.getOrgId());
        map.put(Org.CONTAIN_SUB, model.isContainSub());
        
        return logMapper.selectLoginLogsByPage(map);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param action String
     * @param dataChanged boolean
     * @return int
     * @exception 
     * @see com.aoto.framework.logging.service.inf.LogService#createBehaviorLog(java.lang.String, boolean)
     */
    public int createBehaviorLog(String action, boolean dataChanged)
    {
        CurrentUser u = CurrentUserHolder.getCurrentUser();
        
        if (null != u)
        {
            String sessionId = CurrentUserHolder.getCurrentUser().getSessionId();
            
            Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
            map.put(LoginLog.SESSION_ID, sessionId);
            map.put(BehaviorLog.LOGGED_DATE, new Date());
            map.put(BehaviorLog.ACTION, action);
            map.put(BehaviorLog.DATA_CHANGED, dataChanged);
            logMapper.insertBehaviorLog(map);
            if (map.get(BehaviorLog.BEHAVIOR_ID) instanceof BigInteger) {
                return ((BigInteger)map.get(BehaviorLog.BEHAVIOR_ID)).intValue();
            }
            if (map.get(BehaviorLog.BEHAVIOR_ID) instanceof Long) {
                return ((Long)map.get(BehaviorLog.BEHAVIOR_ID)).intValue();
            }
            return (Integer)map.get(BehaviorLog.BEHAVIOR_ID);
        }
        
        return 0;
    }

    /**
     * 〈一句话功能简述〉
     * 〈功能详细描述〉
     * @author jiangp
     * @param code String
     * @param args String...
     * @return  int
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see   [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public int createBehaviorLog(String code, String... args)
    {
        String[] params = null;
        
        if (null != args && args.length > 0)
        {
            List<String> list = new ArrayList<String>(2);
            
            for (String str : args)
            {
                list.add(messageSource.getMessage(str, null, Locale.CHINESE));
            }
            
            params = new String[list.size()];
            list.toArray(params);
        }
        
        String action = messageSource.getMessage(code, params, Locale.CHINESE);
        return createBehaviorLog(action, false);
    }

    /**
     * 〈一句话功能简述〉
     * 〈功能详细描述〉
     * @author jiangp
     * @param pagingCriteria PagingCriteria
     * @param model LoginLogQuery
     * @return  List<Map<String, Object>>
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see   [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public List<Map<String, Object>> getBehaviorLogsByPage(PagingCriteria pagingCriteria, LoginLogQuery model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
        Date endDate = DateUtils.addMilliseconds(model.getEndDate(), Constants.END_DATE_ADD_MILLISECONDS);
        
        map.put(Bean.PAGING, pagingCriteria);
        map.put(Bean.BEGIN_DATE, model.getBeginDate());
        map.put(Bean.END_DATE, endDate);
        map.put(User.USERNAME, StringUtils4Aoto.trim(model.getUsername()));
        map.put(User.ORG_ID, model.getOrgId());
        map.put(Org.CONTAIN_SUB, model.isContainSub());
        map.put(BehaviorLog.DATA_CHANGED, model.isDataChanged());
        
        return logMapper.selectBehaviorLogsByPage(map);
    }
    
    @Override
    public List<Map<String, Object>> getDataLogsByBehavioId(int behaviorId)
    {
        return logMapper.selectDataLogsByBehaviorId(behaviorId);
    }
}
