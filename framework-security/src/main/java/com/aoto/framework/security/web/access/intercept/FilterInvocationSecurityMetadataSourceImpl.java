/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：MyInvocationSecurityMetadataSourceService.java
 * 文件名称：MyInvocationSecurityMetadataSourceService.java
 * 系统编号：mips
 * 系统名称：mips
 * 模块编号：
 * 模块名称：
 * 作          者：jiangp
 * 完成日期：2013年9月30日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.security.web.access.intercept;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

import com.aoto.framework.commons.constant.BeanProperty.LoginLog;
import com.aoto.framework.commons.constant.BeanProperty.Url;
import com.aoto.framework.commons.constant.Constants;
import com.aoto.framework.commons.constant.NumberEnum;
import com.aoto.framework.commons.lang.StringUtils4Aoto;
import com.aoto.framework.commons.userdetails.CurrentUserHolder;
import com.aoto.framework.logging.service.inf.LogService;
import com.aoto.framework.security.service.inf.FunctionService;

/**
 * 〈一句话功能简述〉 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。
 * 此类在初始化时，应该取到所有资源及其对应角色的定义。
 * 
 * @author jiangp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public class FilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(FilterInvocationSecurityMetadataSourceImpl.class);
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private final RegexRequestMatcher heartbeatMatcher;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private final RegexRequestMatcher loginMatcher;

    /**
     * [简要描述]:
     * @author zongwj
     */
    private HashMap<String, AccessUrl> access;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int timeout;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Value("${heartbeat.interval}")
    private int heartbeatInterval;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Value("${log.behavior.enabled}")
    private boolean logBehaviorEnabled;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    private FunctionService functionService;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    private LogService logService;

    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    private SessionRegistry sessionRegistry;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int heartbeatTimeout;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private Collection<ConfigAttribute> userConfigAttr;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private Collection<ConfigAttribute> adminConfigAttr;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private Map<String, RegexRequestMatcher> permitAllMap;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private Map<String, RegexRequestMatcher> map;
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @param loginPattern String
     * @param heartbeatPattern String
     * @param permitAllPattern String[]
     */
    public FilterInvocationSecurityMetadataSourceImpl(String loginPattern, String heartbeatPattern,
            String[] permitAllPattern)
    {
        map = new HashMap<String, RegexRequestMatcher>();
        permitAllMap = new HashMap<String, RegexRequestMatcher>();
        access = new HashMap<String, AccessUrl>();
        userConfigAttr = SecurityConfig.createListFromCommaDelimitedString("user");
        adminConfigAttr = SecurityConfig.createListFromCommaDelimitedString("-1");
        
        String urlPattern = null;
        String httpMethod = null;
        int index = loginPattern.lastIndexOf(",");
        urlPattern = loginPattern.substring(0, index);
        httpMethod = loginPattern.substring(index + 1);
        
        loginMatcher = new RegexRequestMatcher(urlPattern, httpMethod);
        
        index = heartbeatPattern.lastIndexOf(",");
        urlPattern = heartbeatPattern.substring(0, index);
        httpMethod = heartbeatPattern.substring(index + 1);

        heartbeatMatcher = new RegexRequestMatcher(urlPattern, httpMethod);
        
        RegexRequestMatcher matcher = null;
        
        if (null != permitAllPattern && permitAllPattern.length > 0)
        {
            for (String s : permitAllPattern)
            {
                index = s.lastIndexOf(",");
                urlPattern = s.substring(0, index);
                httpMethod = s.substring(index + 1);

                matcher = new RegexRequestMatcher(urlPattern, httpMethod);
                
                if (!permitAllMap.containsKey(s))
                {
                    permitAllMap.put(s, matcher);
                }
            }
        }
    }

    public Collection<ConfigAttribute> getAllConfigAttributes()
    {
        return null;
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param object Object
     * @return Collection<ConfigAttribute>
     * @exception 
     * @see org.springframework.security.access.SecurityMetadataSource#getAttributes(java.lang.Object)
     */
    public Collection<ConfigAttribute> getAttributes(Object object)
    {
        HttpServletRequest request = ((FilterInvocation) object).getRequest();
        LOGGER.info("request path: {}, method: {}", request.getRequestURI(), request.getMethod());
        boolean isSecurityRequest = request instanceof SecurityContextHolderAwareRequestWrapper;

        if (!isSecurityRequest)
        {
            return null;
        }

        if (loginMatcher.matches(request))
        {
            LOGGER.info("matcher: /login");
            return null;
        }
        
        Principal p = request.getUserPrincipal();

        if (null == p)
        {
            return userConfigAttr;
        }

        HttpSession session = request.getSession(false);

        if (null == session)
        {
            return userConfigAttr;
        }
        
        if (0 == timeout)
        {
            timeout = session.getMaxInactiveInterval() * Constants.SECOND_TO_MILLISECONDS_UNIT;
        }

        if (0 == heartbeatTimeout)
        {
            heartbeatTimeout = (heartbeatInterval + NumberEnum.NUMBER_10.getNum())
                    * Constants.SECOND_TO_MILLISECONDS_UNIT;
        }
        
        String url = request.getRequestURI();
        String sessionId = session.getId();
        AccessUrl accessUrl = access.get(sessionId);
        long now = System.currentTimeMillis();

        if (null == accessUrl)
        {
            accessUrl = new AccessUrl();
            access.put(sessionId, accessUrl);
        }

        accessUrl.setLastHeartbeatTime(now);
        
        if (heartbeatMatcher.matches(request))
        {
            LOGGER.info("matcher: /system/logs/heartbeat");
            return userConfigAttr;
        }
            
        accessUrl.setUrl(url);
        accessUrl.setLastAccessTime(now);
        
        Iterator<Entry<String, RegexRequestMatcher>> iterator = permitAllMap.entrySet().iterator();
        Entry<String, RegexRequestMatcher> entry = null;
        
        while (iterator.hasNext()) 
        {
            entry = iterator.next();
            
            if (entry.getValue().matches(request))
            {
                LOGGER.info("matcher: {}", entry.getKey());
                return userConfigAttr;
            }
        }

        RegexRequestMatcher matcher = null;
        String urlPattern = null;
        String httpMethod = null;
        String action = null;
        String args = null;
        boolean changed = false;
        String message = null;
        String key = null;
        List<Map<String, Object>> list = functionService.getRequestMap();
        
        for (Map<String, Object> m : list)
        {
            urlPattern = (String) m.get(Url.URL_PATTERN);
            httpMethod = (String) m.get(Url.HTTP_METHOD);
            key = urlPattern + "," + httpMethod;
            matcher = map.get(key);
            
            if (null == matcher)
            {
                matcher = new RegexRequestMatcher(urlPattern, httpMethod);
                map.put(key, matcher);
            }

            if (matcher.matches(request))
            {
                LOGGER.info("matcher: {}", key);
                
                if (logBehaviorEnabled)
                {
                    action = (null == m.get(Url.ACTION_CODE)) ? null : (String) m.get(Url.ACTION_CODE);
                    args = (null == m.get(Url.ARGS_CODE)) ? null : (String) m.get(Url.ARGS_CODE);
                    changed = null != m.get(Url.LOGGED_DATA_CHANGED) && (Boolean) m.get(Url.LOGGED_DATA_CHANGED);
                    message = StringUtils4Aoto.getAction(action,
                            StringUtils4Aoto.isNotEmpty(args) ? StringUtils4Aoto.split(args, ",") : null);
                    
                    if (StringUtils4Aoto.isNotEmpty(message))
                    {
                        int logId = logService.createBehaviorLog(message, changed);
                        request.setAttribute(CurrentUserHolder.BEHAVIOR_ID, logId);
                    }
                }
                
                if (null == m.get("roles"))
                {
                    return adminConfigAttr;
                }
                
                String roles = (String)m.get("roles");
                List<ConfigAttribute> attrs = SecurityConfig.createListFromCommaDelimitedString(roles);
                
                return attrs;
            }
        }

        return adminConfigAttr;
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param clazz Class<?>
     * @return boolean
     * @exception 
     * @see org.springframework.security.access.SecurityMetadataSource#supports(java.lang.Class)
     */
    public boolean supports(Class<?> clazz)
    {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     */
    public void watch()
    {
        // logger.debug("access map size: {}", access.size());
        Iterator<Map.Entry<String, AccessUrl>> iterator = access.entrySet().iterator();
        Map.Entry<String, AccessUrl> entry = null;
        String sessionId = null;
        AccessUrl accessUrl = null;
        long now = System.currentTimeMillis();
        List<String> list = new ArrayList<String>();

        while (iterator.hasNext())
        {
            entry = iterator.next();
            accessUrl = entry.getValue();
            sessionId = entry.getKey();

            // logger.debug("accessUrl: {}", accessUrl);
            // logger.debug("sessionId: {}", sessionId);
            // logger.debug("heartbeat diff: {}", now -
            // accessUrl.getLastHeartbeatTime());
            // logger.debug("heartbeatTimeout: {}", heartbeatTimeout);
            // logger.debug("timeout diff: {}", now -
            // accessUrl.getLastAccessTime());
            // logger.debug("timeout: {}", timeout);

            if ((now - accessUrl.getLastHeartbeatTime() > heartbeatTimeout)
                    || (now - accessUrl.getLastAccessTime() > timeout)) {
                list.add(sessionId);
            }
        }

        SessionInformation info = null;

        for (String id : list)
        {
            access.remove(id);
            info = sessionRegistry.getSessionInformation(id);

            if (null != info)
            {
                info.expireNow();
            }

            Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
            map.put(LoginLog.SESSION_ID, id);
            map.put(LoginLog.LOGOUT_DATE, new Date(now));

            logService.updateLogoutDate(map);
        }
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @version 1.0, 2017年6月2日
     */
    class AccessUrl
    {
        /**
         * [简要描述]:
         * @author zongwj
         */
        private String url;
        
        /**
         * [简要描述]:
         * @author zongwj
         */
        private long lastAccessTime;
        
        /**
         * [简要描述]:
         * @author zongwj
         */
        private long lastHeartbeatTime;

        public String getUrl()
        {
            return url;
        }

        public void setUrl(String url)
        {
            this.url = url;
        }

        public long getLastAccessTime()
        {
            return lastAccessTime;
        }

        public void setLastAccessTime(long lastAccessTime)
        {
            this.lastAccessTime = lastAccessTime;
        }

        public long getLastHeartbeatTime()
        {
            return lastHeartbeatTime;
        }

        public void setLastHeartbeatTime(long lastHeartbeatTime)
        {
            this.lastHeartbeatTime = lastHeartbeatTime;
        }

        @Override
        public String toString() {
            return "AccessUrl [url=" + url + ", lastAccessTime=" + lastAccessTime + ", lastHeartbeatTime="
                    + lastHeartbeatTime + "]";
        }
    }
}
