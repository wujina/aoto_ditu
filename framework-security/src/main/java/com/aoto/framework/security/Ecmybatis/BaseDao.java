package com.aoto.framework.security.Ecmybatis;

/**
 * 数据访问对象，假定实体编号类型为长整型
 * 
 * @author ecmybatis
 * @param <T> 实体对象类型
 */
public interface BaseDao<UserLog extends Model<Long>> extends Dao<UserLog, Long> {


}
