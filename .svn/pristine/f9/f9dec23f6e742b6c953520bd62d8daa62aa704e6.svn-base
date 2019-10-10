package com.aoto.framework.commons.pagination;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月1日
 */
public enum SortDirection
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    ASC("ASC"), 
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    DESC("DESC");
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String direction;

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @param direction String
     */
    SortDirection(String direction)
    {
        this.direction = direction;
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param value String
     * @return SortDirection
     */
    public static SortDirection valueOfCaseInsensitive(String value)
    {
        String valueUpper = value.toUpperCase();
        return SortDirection.valueOf(valueUpper);
    }

    public String getDirection()
    {
        return this.direction;
    }
}
