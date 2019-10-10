package com.aoto.framework.security.models;

import com.aoto.framework.commons.pagination.PaginationQuery;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月2日
 */
public class UserQuery extends PaginationQuery
{
    private static final long serialVersionUID = -7160643588438970503L;
    
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
}
