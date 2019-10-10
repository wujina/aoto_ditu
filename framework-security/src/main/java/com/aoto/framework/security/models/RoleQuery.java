package com.aoto.framework.security.models;

import com.aoto.framework.commons.constant.RoleTypeEnum;
import com.aoto.framework.commons.pagination.PaginationQuery;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月2日
 */
public class RoleQuery extends PaginationQuery
{
    private static final long serialVersionUID = -721133815397442895L;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String roleName;
    
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
    private RoleTypeEnum roleType;

    public RoleTypeEnum getRoleType()
    {
        return roleType;
    }

    public void setRoleType(RoleTypeEnum roleType)
    {
        this.roleType = roleType;
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

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }
}
