/*
 * Nanjing Aoto 2017, All rights reserved.
 * 文件名  :MysqlDialect.java
 * 创建人  :zongwj
 * 创建时间:2017年6月14日
*/

package com.aoto.framework.mybatis.pagination.dialect;

import java.util.Iterator;
import java.util.Map;

import com.aoto.framework.commons.lang.StringUtils4Aoto;
import com.aoto.framework.commons.pagination.SortDirection;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月14日
 */
public class MysqlDialect implements Dialect {

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return
     * @exception 
     * @see com.aoto.framework.mybatis.pagination.dialect.Dialect#supportsPaging()
     */
    @Override
    public boolean supportsPaging() {        
        return true;
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param sql
     * @param offset
     * @param limit
     * @param sortField
     * @return
     * @exception 
     * @see 
     * com.aoto.framework.mybatis.pagination.dialect.Dialect#getPagingSql(java.lang.String, int, int, java.util.Map)
     */
    @Override
    public String getPagingSql(String sql, int offset, int limit, Map<String, SortDirection> sortField) {
        StringBuffer sqlBuffer = null;
        
        if (null == sortField || sortField.isEmpty())
        {
            sqlBuffer = new StringBuffer(sql);
        }
        else
        {
            sqlBuffer = new StringBuffer(StringUtils4Aoto.substringBeforeLast(sql.toUpperCase(), "ORDER"));
            sqlBuffer.append(" ORDER BY ");
            Iterator<Map.Entry<String, SortDirection>> iterator = sortField.entrySet().iterator();
            Map.Entry<String, SortDirection> entry = null;
            String column = null;
            
            while (iterator.hasNext())
            {
                entry = iterator.next();
                column = StringUtils4Aoto.camelCaseToSnakeCase(entry.getKey());
                
                sqlBuffer.append(column.toUpperCase()).append(" ").append(entry.getValue()).append(",");
            }
            
            sqlBuffer.deleteCharAt(sqlBuffer.length() - 1);
        }
        
        sqlBuffer.insert(0, "SELECT @x:=IFNULL(@x,0)+1 rownum, tx_.* FROM(").append(") tx_");
        sqlBuffer.insert(0, "SELECT t_.* FROM (").append(") t_ WHERE rownum <= ").append(offset + limit).append(
                " and rownum > ").append(offset);

        // 上面的Sql语句拼接之后大概是这个样子：  
        // select * from (select t_.*, rownum r_ from (select * from sys_user) t_  
        // where rownum <= 10) where r_ > 0
        return sqlBuffer.toString();
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param sql
     * @return
     * @exception 
     * @see com.aoto.framework.mybatis.pagination.dialect.Dialect#getCountSql(java.lang.String)
     */
    @Override
    public String getCountSql(String sql) {        
        return "SELECT COUNT(1) FROM (" + StringUtils4Aoto.substringBefore(sql.toUpperCase(), "ORDER BY") + ") t_";
    }

}
