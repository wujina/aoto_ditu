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
public class UserSelectorQuery extends PaginationQuery
{
    private static final long serialVersionUID = -3183058002580299975L;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String username;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int orgId;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private boolean containSub;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String excepted;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int getOrgId()
    {
        return orgId;
    }

    public void setOrgId(int orgId)
    {
        this.orgId = orgId;
    }

    public boolean isContainSub()
    {
        return containSub;
    }

    public void setContainSub(boolean containSub)
    {
        this.containSub = containSub;
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
