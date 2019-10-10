package com.aoto.framework.mybatis.pagination;

import com.aoto.framework.commons.pagination.PagingCriteria;

import java.util.Map;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月1日
 */
public enum PagingCriteriaFinder
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    instance;

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     */
    PagingCriteriaFinder()
    {

    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param object Object
     * @return PagingCriteria
     */
    public PagingCriteria find(Object object)
    {
        if (object == null)
        {
            return null;
        }

        return findFromObject(object);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param object Object
     * @return PagingCriteria
     */
    private PagingCriteria findFromObject(Object object)
    {
        PagingCriteria p = null;

        if (object instanceof PagingCriteria)
        {
            p = (PagingCriteria) object;
        }
        else if (object instanceof Map)
        {
            p = findFromMap((Map<?, ?>) object);
        }
        else
        {
            p = null;
        }

        return p;
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<?, ?>
     * @return PagingCriteria
     */
    private PagingCriteria findFromMap(Map<?, ?> map)
    {
        PagingCriteria p = null;

        for (Object o : map.values())
        {
            p = findFromObject(o);

            if (null != p)
            {
                return p;
            }
        }

        return null;
    }
}