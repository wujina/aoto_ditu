package com.aoto.framework.mybatis.pagination;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.mybatis.pagination.dialect.Dialect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月1日
 */
@Intercepts({ @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class }) })
public class PagingInterceptor implements Interceptor
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PagingInterceptor.class);
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final ReflectorFactory DEFAULT_REFLECTOR_FACTORY = new DefaultReflectorFactory();
    /**
     * [简要描述]:
     * @author zongwj
     */
    private Dialect dialect;
    /**
     * [简要描述]:
     * @author zongwj
     */
    private String sqlRegex;
    
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        processIntercept(invocation);
        return invocation.proceed();
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param invocation Invocation
     * @throws Throwable SQLException
     */
    private void processIntercept(Invocation invocation) throws Throwable
    {
        // 对于StatementHandler其实只有两个实现类，一个是RoutingStatementHandler，另一个是抽象类BaseStatementHandler，
        // BaseStatementHandler有三个子类，分别是SimpleStatementHandler，PreparedStatementHandler和CallableStatementHandler，
        // SimpleStatementHandler是用于处理Statement的，PreparedStatementHandler是处理PreparedStatement的，
        // 而CallableStatementHandler是处理CallableStatement的。Mybatis在进行Sql语句处理的时候都是建立的RoutingStatementHandler，
        // 而在RoutingStatementHandler里面拥有一个StatementHandler类型的delegate属性，RoutingStatementHandler会依据Statement
        // 的不同建立对应的BaseStatementHandler，即SimpleStatementHandler、PreparedStatementHandler或CallableStatementHandler，
        // 在RoutingStatementHandler里面所有StatementHandler接口方法的实现都是调用的delegate对应的方法。我们在PageInterceptor类上已经用
        // @Signature标记了该Interceptor只拦截StatementHandler接口的prepare方法，又因为Mybatis只有在建立RoutingStatementHandler的时候
        // 是通过Interceptor的plugin方法进行包裹的，所以我们这里拦截到的目标对象肯定是RoutingStatementHandler对象。
        RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(handler, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY,
                DEFAULT_REFLECTOR_FACTORY);

        // 通过反射获取delegate父类BaseStatementHandler的mappedStatement属性
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        
        if (!mappedStatement.getId().matches(sqlRegex))
        {
            return;
        }

        // 通过反射获取到当前RoutingStatementHandler对象的delegate属性
        StatementHandler delegate = (StatementHandler) metaObject.getValue("delegate");

        // 获取到当前StatementHandler的
        // boundSql，这里不管是调用handler.getBoundSql()还是直接调用delegate.getBoundSql()结果是一样的，因为之前已经说过了
        // RoutingStatementHandler实现的所有StatementHandler接口方法里面都是调用的delegate对应的方法。
        BoundSql boundSql = delegate.getBoundSql();

        // 拿到当前绑定Sql的参数对象，就是我们在调用对应的Mapper映射语句时所传入的参数对象
        Object parameter = boundSql.getParameterObject();

        PagingCriteria criteria = PagingCriteriaFinder.instance.find(parameter);

        // 这里我们简单的通过传入的是Page对象就认定它是需要进行分页操作的。
        if (null == criteria)
        {
            return;
        }

        // 拦截到的prepare方法参数是一个Connection对象
        Connection connection = (Connection) invocation.getArgs()[0];

        // 获取当前要执行的Sql语句，也就是我们直接在Mapper映射语句中写的Sql语句
        String sql = boundSql.getSql();

        // 给当前的page参数对象设置总记录数
        this.setTotal(criteria, parameter, mappedStatement, connection);

        // 获取分页Sql语句
        String pagingSql = dialect.getPagingSql(sql, criteria.getOffset(), criteria.getLimit(),
                criteria.getSortField());

        // 利用反射设置当前BoundSql对应的sql属性为我们建立好的分页Sql语句
        metaObject.setValue("delegate.boundSql.sql", pagingSql);

        // 采用物理分页后，就不需要mybatis的内存分页了，所以重置下面的两个参数
        metaObject.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
        metaObject.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

    /**
     * 给当前的参数对象page设置总记录数
     * 
     * @param criteria          PagingCriteria
     * @param parameter         Object
     * @param mappedStatement   Mapper映射语句
     * @param connection        当前的数据库连接
     * @throws SQLException     SQLException
     */
    private void setTotal(PagingCriteria criteria, Object parameter, MappedStatement mappedStatement,
            Connection connection) throws SQLException
    {
        // 获取对应的BoundSql，这个BoundSql其实跟我们利用StatementHandler获取到的BoundSql是同一个对象。
        // delegate里面的boundSql也是通过mappedStatement.getBoundSql(paramObj)方法获取到的。
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);

        // 获取到我们自己写在Mapper映射语句中对应的Sql语句
        String sql = boundSql.getSql();

        // 通过查询Sql语句获取到对应的计算总记录数的sql语句
        String countSql = dialect.getCountSql(sql);

        // 通过BoundSql获取对应的参数映射
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();

        // 利用Configuration、查询记录数的Sql语句countSql、参数映射关系parameterMappings和参数对象page建立查询记录数对应的BoundSql对象。
        BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings,
                parameter);

        // 通过mappedStatement、参数对象page和BoundSql对象countBoundSql建立一个用于设定参数的ParameterHandler对象
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameter, countBoundSql);

        // 通过connection建立一个countSql对应的PreparedStatement对象。
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try
        {
            pstmt = connection.prepareStatement(countSql);

            // 通过parameterHandler给PreparedStatement对象设置参数
            parameterHandler.setParameters(pstmt);

            // 之后就是执行获取总记录数的Sql语句和获取结果了。
            rs = pstmt.executeQuery();

            if (rs.next())
            {
                int total = rs.getInt(1);

                // 给当前的参数page对象设置总记录数
                criteria.setTotal(total);
            }
        }
        finally
        {
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    LOGGER.error("Close the ResultSet error.", e);
                }
            }

            if (pstmt != null)
            {
                try
                {
                    pstmt.close();
                }
                catch (SQLException e)
                {
                    LOGGER.error("Close the preparedStatement error.", e);
                }
            }
        }
    }

    public void setSqlRegex(String sqlRegex)
    {
        this.sqlRegex = sqlRegex;
    }

    public void setDialect(Dialect dialect)
    {
        this.dialect = dialect;
    }
}
