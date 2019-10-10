package com.aoto.framework.commons.pagination;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.aoto.framework.commons.lang.StringUtils4Aoto;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author jiangp
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public class PagingCriteria implements Serializable
{
    private static final long serialVersionUID = -3268034789084546269L;

    /**
     * [简要描述]:
     * @author zongwj
     */
    private int pageIndex;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int pageSize;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int total;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private LinkedHashMap<String, SortDirection> sortField;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private HashMap<String, Object> condition;

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @param pageIndex int
     * @param pageSize int
     * @param field String
     * @param direction String
     */
    public PagingCriteria(int pageIndex, int pageSize, String field, String direction)
    {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;

        setCondition(new HashMap<String, Object>());
        addSortField(field, direction);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param field String
     * @param direction String
     */
    public final void addSortField(String field, String direction)
    {
        if (StringUtils4Aoto.isNotEmpty(field) && StringUtils4Aoto.isNotEmpty(direction))
        {
            addSortField(field, SortDirection.valueOfCaseInsensitive(direction));
        }
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param field String
     * @param direction SortDirection
     */
    public final void addSortField(String field, SortDirection direction)
    {
        if (null == sortField)
        {
            sortField = new LinkedHashMap<String, SortDirection>();
        }

        if (!sortField.containsKey(field))
        {
            sortField.put(field, direction);
        }
    }

    public Map<String, SortDirection> getSortField()
    {
        return sortField;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public int getOffset()
    {
        return pageSize * pageIndex;
    }

    public int getLimit()
    {
        return pageSize;
    }

    public HashMap<String, Object> getCondition()
    {
        return condition;
    }

    public void setCondition(HashMap<String, Object> condition)
    {
        this.condition = condition;
    }
}
