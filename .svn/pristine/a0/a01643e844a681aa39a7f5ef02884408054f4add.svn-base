package com.aoto.framework.logging.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.aoto.framework.commons.pagination.PaginationQuery;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月2日
 */
public class LoginLogQuery extends PaginationQuery
{
    private static final long serialVersionUID = -6879136527592763413L;
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
    private boolean dataChanged;
    /**
     * [简要描述]:
     * @author zongwj
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    /**
     * [简要描述]:
     * @author zongwj
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

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

    public boolean isDataChanged()
    {
        return dataChanged;
    }

    public void setDataChanged(boolean dataChanged)
    {
        this.dataChanged = dataChanged;
    }

    public Date getBeginDate()
    {
        return beginDate;
    }

    public void setBeginDate(Date beginDate)
    {
        this.beginDate = beginDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }
}
