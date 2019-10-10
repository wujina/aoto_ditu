/*
 * 版权信息：Copyright (c) 2014, Aoto. All rights reserved.
 * 文件编号：Snippet.java
 * 文件名称：Snippet.java
 * 系统编号：aotoframework
 * 系统名称：aotoframework
 * 模块编号：
 * 模块名称：
 * 作          者：jiangp
 * 完成日期：2014年6月18日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.commons.util.matcher;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpMethod;
import org.springframework.security.web.util.matcher.RequestMatcher;

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
public final class RegexRequestMatcher implements RequestMatcher
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    private final Pattern pattern;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private final HttpMethod httpMethod;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private final boolean caseInsensitive;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private final boolean loggedDataChanged;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private final String action;

    public String getAction()
    {
        return action;
    }
    
    public boolean getLoggedDataChanged()
    {
        return loggedDataChanged;
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @param pattern String
     * @param httpMethod String
     */
    public RegexRequestMatcher(String pattern, String httpMethod)
    {
        this(pattern, httpMethod, false, null, null, false);
    }
    
    /**
     * Creates a case-sensitive {@code Pattern} instance to match against the
     * request.
     * 
     * @param pattern
     *            the regular expression to compile into a pattern.
     * @param httpMethod
     *            the HTTP method to match. May be null to match all methods.
     * @param actionCode String
     * @param argsCode String
     * @param loggedDataChanged boolean
     */
    public RegexRequestMatcher(String pattern, String httpMethod, String actionCode, String argsCode,
            boolean loggedDataChanged)
    {
        this(pattern, httpMethod, false, actionCode, argsCode, loggedDataChanged);
    }

    /**
     * As above, but allows setting of whether case-insensitive matching should
     * be used.
     * 
     * @param pattern
     *            the regular expression to compile into a pattern.
     * @param httpMethod
     *            the HTTP method to match. May be null to match all methods.
     * @param caseInsensitive
     *            if true, the pattern will be compiled with the
     *            {@link Pattern#CASE_INSENSITIVE} flag set.
     * @param actionCode String
     * @param argsCode String
     * @param loggedDataChanged boolean
     */
    public RegexRequestMatcher(String pattern, String httpMethod, boolean caseInsensitive, String actionCode,
            String argsCode, boolean loggedDataChanged)
    {
        this.caseInsensitive = caseInsensitive;
        this.loggedDataChanged = loggedDataChanged;
        
        if (caseInsensitive)
        {
            this.pattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        }
        else
        {
            this.pattern = Pattern.compile(pattern);
        }
        
        this.httpMethod = StringUtils4Aoto.isNotBlank(httpMethod) ? HttpMethod.valueOf(httpMethod) : null;
        this.action = StringUtils4Aoto.getAction(actionCode,
                StringUtils4Aoto.isNotEmpty(argsCode) ? StringUtils4Aoto.split(argsCode, ",") : null);
    }

    /**
     * Performs the match of the request URL (
     * {@code servletPath + pathInfo + queryString}) against the compiled
     * pattern. If the query string is present, a question mark will be
     * prepended.
     * 
     * @param request
     *            the request to match
     * @return true if the pattern matches the URL, false otherwise.
     */
    public boolean matches(HttpServletRequest request)
    {
        if (httpMethod != null && request.getMethod() != null && httpMethod != HttpMethod.valueOf(request.getMethod()))
        {
            return false;
        }

        String url = request.getServletPath();
        String pathInfo = request.getPathInfo();

        if (pathInfo != null)
        {
            StringBuilder sb = new StringBuilder(url);

            if (pathInfo != null)
            {
                sb.append(pathInfo);
            }

            url = sb.toString();
        }

        return pattern.matcher(url).matches();
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof RegexRequestMatcher))
        {
            return false;
        }

        RegexRequestMatcher other = (RegexRequestMatcher) obj;
        return this.pattern.pattern().equals(other.pattern.pattern()) && this.httpMethod == other.httpMethod
                && this.caseInsensitive == other.caseInsensitive;
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
        return "[" + this.pattern.pattern() + "," + this.httpMethod + "]";
    }
}
