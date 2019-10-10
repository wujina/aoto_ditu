/*
 * 版权信息：Copyright (c) 2014, Aoto. All rights reserved.
 * 文件编号：AntPathRequestMatcher.java
 * 文件名称：AntPathRequestMatcher.java
 * 系统编号：aotoframework
 * 系统名称：aotoframework
 * 模块编号：
 * 模块名称：
 * 作          者：jiangp
 * 完成日期：2014年6月9日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.commons.util.matcher;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Assert;

import com.aoto.framework.commons.constant.NumberEnum;
import com.aoto.framework.commons.lang.StringUtils4Aoto;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author jiangp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
@Deprecated
public final class AntPathRequestMatcher implements RequestMatcher
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AntPathRequestMatcher.class);
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final String MATCH_ALL = "/**";

    /**
     * [简要描述]:
     * @author zongwj
     */
    private final Matcher matcher;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private final String pattern;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private final HttpMethod httpMethod;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private final boolean caseSensitive;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private final String action;

    public String getAction()
    {
        return action;
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @param pattern String
     * @param httpMethod String
     */
    public AntPathRequestMatcher(String pattern, String httpMethod)
    {
        this(pattern, httpMethod, false, null, null);
    }
    
    /**
     * Creates a matcher with the supplied pattern and HTTP method in a case
     * insensitive manner.
     * 
     * @param pattern
     *            the ant pattern to use for matching
     * @param httpMethod
     *            the HTTP method. The {@code matches} method will return false
     *            if the incoming request doesn't have the same method.
     * @param actionCode String
     * @param argsCode String
     */
    public AntPathRequestMatcher(String pattern, String httpMethod, String actionCode, String argsCode)
    {
        this(pattern, httpMethod, false, actionCode, argsCode);
    }

    /**
     * Creates a matcher with the supplied pattern which will match the
     * specified Http method
     * 
     * @param pattern
     *            the ant pattern to use for matching
     * @param httpMethod
     *            the HTTP method. The {@code matches} method will return false
     *            if the incoming request doesn't doesn't have the same method.
     * @param caseSensitive
     *            true if the matcher should consider case, else false
     * @param actionCode String
     * @param argsCode String
     */
    public AntPathRequestMatcher(String pattern, String httpMethod, boolean caseSensitive, String actionCode,
            String argsCode)
    {
        Assert.hasText(pattern, "Pattern cannot be null or empty");
        this.caseSensitive = caseSensitive;
        this.action = StringUtils4Aoto.getAction(actionCode,
                StringUtils4Aoto.isNotEmpty(argsCode) ? StringUtils4Aoto.split(argsCode, ",") : null);

        if (pattern.equals(MATCH_ALL) || pattern.equals("**"))
        {
            pattern = MATCH_ALL;
            matcher = null;
        }
        else
        {
            if (!caseSensitive)
            {
                pattern = pattern.toLowerCase();
            }

            // If the pattern ends with {@code /**} and has no other wildcards,
            // then optimize to a sub-path match
            if (pattern.endsWith(MATCH_ALL) && pattern.indexOf('?') == -1
                    && pattern.indexOf("*") == pattern.length() - 2)
            {
                matcher = new SubpathMatcher(pattern.substring(0, pattern.length() - NumberEnum.NUMBER_3.getNum()));
            }
            else
            {
                matcher = new SpringAntMatcher(pattern);
            }
        }

        this.pattern = pattern;
        this.httpMethod = StringUtils4Aoto.isNotBlank(httpMethod) ? HttpMethod.valueOf(httpMethod) : null;
    }

    /**
     * Returns true if the configured pattern (and HTTP-Method) match those of
     * the supplied request.
     * 
     * @param request
     *            the request to match against. The ant pattern will be matched
     *            against the {@code servletPath} + {@code pathInfo} of the
     *            request.
     * @return boolean
     */
    public boolean matches(HttpServletRequest request)
    {
        if (httpMethod != null && request.getMethod() != null && httpMethod != HttpMethod.valueOf(request.getMethod()))
        {
            LOGGER.debug("Request '" + request.getMethod() + " " + getRequestPath(request) + "'" + " doesn't match '"
                    + httpMethod + " " + pattern);
            return false;
        }

        if (pattern.equals(MATCH_ALL))
        {            
            LOGGER.debug("Request '" + getRequestPath(request) + "' matched by universal pattern '/**'");
            return true;
        }

        String url = getRequestPath(request);
        LOGGER.debug("Checking match of request : '" + url + "'; against '" + pattern + "'");
        return matcher.matches(url);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param request HttpServletRequest
     * @return String
     */
    private String getRequestPath(HttpServletRequest request)
    {
        String url = request.getServletPath();

        if (request.getPathInfo() != null)
        {
            url += request.getPathInfo();
        }

        if (!caseSensitive)
        {
            url = url.toLowerCase();
        }

        return url;
    }

    public String getPattern()
    {
        return pattern;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof AntPathRequestMatcher))
        {
            return false;
        }

        AntPathRequestMatcher other = (AntPathRequestMatcher) obj;
        return this.pattern.equals(other.pattern) && this.httpMethod == other.httpMethod
                && this.caseSensitive == other.caseSensitive;
    }

    @Override
    public int hashCode()
    {
        int code = NumberEnum.NUMBER_31.getNum() ^ pattern.hashCode();
        if (httpMethod != null)
        {
            code ^= httpMethod.hashCode();
        }
        return code;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Ant [pattern='").append(pattern).append("'");

        if (httpMethod != null)
        {
            sb.append(", ").append(httpMethod);
        }

        sb.append("]");

        return sb.toString();
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @version 1.0, 2017年6月1日
     */
    private interface Matcher
    {
        /**
         * [简要描述]:<br/>
         * [详细描述]:<br/>
         * 
         * @author zongwj
         * @param path String
         * @return boolean
         */
        boolean matches(String path);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @version 1.0, 2017年6月1日
     */
    private static class SpringAntMatcher implements Matcher
    {
        /**
         * [简要描述]:
         * @author zongwj
         */
        private static final AntPathMatcher ANT_MATCHER = new AntPathMatcher();

        /**
         * [简要描述]:
         * @author zongwj
         */
        private final String pattern;

        /**
         * [简要描述]:<br/>
         * [详细描述]:<br/>
         *
         * @author zongwj
         * @param pattern String
         */
        private SpringAntMatcher(String pattern)
        {
            this.pattern = pattern;
        }

        /**
         * [简要描述]:<br/>
         * [详细描述]:<br/>
         * 
         * @author zongwj
         * @param path String
         * @return boolean
         * @exception 
         * @see com.aoto.framework.commons.util.matcher.AntPathRequestMatcher.Matcher#matches(java.lang.String)
         */
        public boolean matches(String path)
        {
            return ANT_MATCHER.match(pattern, path);
        }
    }

    /**
     * Optimized matcher for trailing wildcards
     */
    private static class SubpathMatcher implements Matcher
    {
        /**
         * [简要描述]:
         * @author zongwj
         */
        private final String subpath;
        /**
         * [简要描述]:
         * @author zongwj
         */
        private final int length;

        /**
         * [简要描述]:<br/>
         * [详细描述]:<br/>
         *
         * @author zongwj
         * @param subpath String
         */
        private SubpathMatcher(String subpath)
        {
            assert !subpath.contains("*");
            this.subpath = subpath;
            this.length = subpath.length();
        }

        /**
         * [简要描述]:<br/>
         * [详细描述]:<br/>
         * 
         * @author zongwj
         * @param path String
         * @return boolean
         * @exception 
         * @see com.aoto.framework.commons.util.matcher.AntPathRequestMatcher.Matcher#matches(java.lang.String)
         */
        public boolean matches(String path)
        {
            return path.startsWith(subpath) && (path.length() == length || path.charAt(length) == '/');
        }
    }
}
