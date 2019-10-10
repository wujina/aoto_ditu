package com.aoto.framework.mybatis.pagination.dialect;

import java.util.Iterator;
import java.util.Map;

import com.aoto.framework.commons.lang.StringUtils4Aoto;
import com.aoto.framework.commons.pagination.SortDirection;

/**
 * Oracle的方言实现
 */
public class OracleDialect implements Dialect
{
    @Override
    public boolean supportsPaging()
    {
        return true;
    }

    @Override
    public String getPagingSql(String sql, int offset, int limit, Map<String, SortDirection> sortField)
    {
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
        
        sqlBuffer.insert(0, "SELECT t_.*, rownum r_ FROM (").append(") t_ WHERE rownum <= ").append(offset + limit);  
        sqlBuffer.insert(0, "SELECT * FROM (").append(") t2_ WHERE r_ > ").append(offset);  
        
        // 上面的Sql语句拼接之后大概是这个样子：  
        // select * from (select t_.*, rownum r_ from (select * from sys_user) t_  
        // where rownum <= 10) where r_ > 0
        return sqlBuffer.toString();  
    }

    @Override
    public String getCountSql(String sql)
    {
        return "SELECT COUNT(1) FROM (" + StringUtils4Aoto.substringBefore(sql.toUpperCase(), "ORDER BY") + ") t_";
    }
}