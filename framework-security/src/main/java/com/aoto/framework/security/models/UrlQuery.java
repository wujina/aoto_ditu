package com.aoto.framework.security.models;

import com.aoto.framework.commons.lang.StringUtils4Aoto;
import com.aoto.framework.commons.pagination.PaginationQuery;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月2日
 */
public class UrlQuery extends PaginationQuery
{
    private static final long serialVersionUID = -721133815397442895L;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String urlName;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String urlPattern;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String httpMethod;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String excepted;

    public String getUrlName()
    {
        return urlName;
    }

    public void setUrlName(String urlName)
    {
        this.urlName = urlName;
    }

    public String getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }
    
    public String getExcepted()
    {
        return excepted;
    }

    public void setExcepted(String excepted)
    {
        this.excepted = excepted;
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return String
     */
    public String getNotIn()
    {
        if (StringUtils4Aoto.isEmpty(excepted))
        {
            return null;
        }
        else
        {
            String notIn = StringUtils4Aoto.EMPTY;
            int id = 0;
            
            if (!StringUtils4Aoto.isEmpty(excepted))
            {
                String[] arr = StringUtils4Aoto.split(excepted, ',');

                for (String str : arr)
                {
                    id = Integer.parseInt(str);
                    notIn += id + ",";
                }
            }
            
            return StringUtils4Aoto.removeEnd(notIn, ",");
        }
    }
    
}