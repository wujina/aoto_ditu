package com.aoto.framework.mybatis.pagination.dialect;

import java.util.Map;

import com.aoto.framework.commons.pagination.SortDirection;

/**
 * 类似hibernate的Dialect,但只精简出分页部分
 */
public interface Dialect {

    /**
     * 数据库本身是否支持分页当前的分页查询方式
     * 如果数据库不支持的话，则不进行数据库分页
     *
     * @return true：支持当前的分页查询方式
     */
    boolean supportsPaging();

    /**
     * 将sql转换为分页SQL，分别调用分页sql
     *
     * @param sql    SQL语句
     * @param offset 开始条数
     * @param limit  每页显示多少纪录条数
     * @param sortField  排序的字段
     * @return 分页查询的sql
     */
    String getPagingSql(String sql, int offset, int limit, Map<String, SortDirection> sortField);

    /**
     * 将sql转换为总记录数SQL
     * @param sql SQL语句
     * @return 总记录数的sql
     */
    String getCountSql(String sql);
}
