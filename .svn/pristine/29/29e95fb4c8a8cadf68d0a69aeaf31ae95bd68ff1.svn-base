package com.aoto.framework.mybatis;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.aoto.framework.commons.constant.DBTypeEnum;
import com.aoto.framework.commons.constant.NumberEnum;
import com.aoto.framework.commons.lang.StringUtils4Aoto;
import com.aoto.framework.commons.userdetails.CurrentUserHolder;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import oracle.sql.TIMESTAMP;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月1日
 */
@Intercepts({ @Signature(method = "update", type = Executor.class, args ={ MappedStatement.class, Object.class }) })
public class UpdateInterceptor implements Interceptor
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateInterceptor.class);
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private @Value("${db.type}") String dbType;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final String PK_PREFIX = "pk_";
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final String INSERT = "__INSERT__";
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final String DELETE = "__DELETE__";
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final String DATA_LOG_INSERT = "INSERT INTO SYS_DATA_LOG (BEHAVIOR_ID, LOGGED_DATE, TABLE_NAME, "
            + "COLUMN_NAME, KEY_VALUE, OLD_VALUE, NEW_VALUE) VALUES (?,?,?,?,?,?,?)";
    /**
     * [简要描述]:
     * @author zongwj
     */
    private List<String> excepted;
    
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        processIntercept(invocation);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        
    }

    public void setExcepted(List<String> excepted)
    {
        this.excepted = excepted;
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
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        String id = mappedStatement.getId();

        if (exclude(sqlCommandType, id))
        {
            return;
        }
        
        if (!(args[1] instanceof Map))
        {
            return;
        }
        
        @SuppressWarnings("unchecked")
        Map<String, Object> map = (Map<String, Object>) args[1];
        SimpleExecutor executor = (SimpleExecutor) invocation.getTarget();
        Connection conn = executor.getTransaction().getConnection();
        int behaviorId = CurrentUserHolder.getBehaviorId();
        
        if (SqlCommandType.INSERT.equals(sqlCommandType))
        {
            createInsertDataLog(conn, mappedStatement, map, behaviorId);
        }
        else if (SqlCommandType.UPDATE.equals(sqlCommandType))
        {
            createUpdateDataLog(conn, mappedStatement, map, behaviorId);
        }
        else if (SqlCommandType.DELETE.equals(sqlCommandType))
        {
            createDeleteDataLog(conn, mappedStatement, map, behaviorId);
        }
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param conn Connection
     * @param mappedStatement MappedStatement
     * @param map Map<String, Object>
     * @param behaviorId int
     * @throws SQLException SQLException
     */
    private void createDeleteDataLog(Connection conn, MappedStatement mappedStatement, Map<String, Object> map,
            int behaviorId) throws SQLException {
        PrimaryKey primaryKey = findPrimaryKey(map);
        
        if (null == primaryKey || primaryKey.getId() <= 0)
        {
            return;
        }
        
        if (behaviorId <= 0)
        {
            return;
        }
        
        String sql = mappedStatement.getBoundSql(null).getSql();
        String tableName = StringUtils4Aoto.trim(
                StringUtils4Aoto.substringBetween(sql, "DELETE FROM", "WHERE")).toUpperCase();

        insertDataLog(conn, new DataLog(behaviorId, tableName, DELETE, primaryKey.getId(), null, null));
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param conn Connection
     * @param mappedStatement MappedStatement
     * @param map Map<String, Object>
     * @param behaviorId int
     * @throws SQLException SQLException
     */
    private void createInsertDataLog(Connection conn, MappedStatement mappedStatement, Map<String, Object> map,
            int behaviorId) throws SQLException {
        PrimaryKey primaryKey = findPrimaryKey(map);
        
        if (null == primaryKey)
        {
            return;
        }
        
        String sql = mappedStatement.getBoundSql(null).getSql();
        String tableName = StringUtils4Aoto.trim(StringUtils4Aoto.substringBetween(sql, "INTO", "(")).toUpperCase();
        
        int dbTypeInteger = DBTypeEnum.ORACLE.getCode();
        try {
            dbTypeInteger = Integer.parseInt(dbType);
        }
        catch (NumberFormatException e) {
            LOGGER.error("paramters.properties文件中配置的db.type为非整型，请修改！", e);
        }
        
        if (0 == primaryKey.getId() && dbTypeInteger == DBTypeEnum.ORACLE.getCode())
        {
            String seqSql = "SELECT SEQ_" + tableName + ".NEXTVAL FROM DUAL";
            Statement statement = null;
            ResultSet rs = null;

            try
            {
                statement = conn.createStatement();
                rs = statement.executeQuery(seqSql);

                if (rs.next())
                {
                    primaryKey.setId(rs.getInt(1));
                    map.put(primaryKey.getProperty(), primaryKey.getId());
                }
            }
            finally
            {
                if (null != rs)
                {
                    rs.close();
                }

                if (null != statement)
                {
                    statement.close();
                }
            }
        }
        
        if (behaviorId <= 0)
        {
            return;
        }
        
        insertDataLog(conn, new DataLog(behaviorId, tableName, INSERT, primaryKey.getId(), null, null));
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param conn Connection
     * @param mappedStatement MappedStatement
     * @param map Map<String, Object>
     * @param behaviorId int
     * @throws SQLException SQLException
     */
    private void createUpdateDataLog(Connection conn, MappedStatement mappedStatement, Map<String, Object> map,
            int behaviorId) throws SQLException {
        PrimaryKey primaryKey = findPrimaryKey(map);

        if (null == primaryKey || primaryKey.getId() <= 0)
        {
            return;
        }
        
        if (behaviorId <= 0)
        {
            return;
        }

        String sql = mappedStatement.getBoundSql(null).getSql();
        String tableName = StringUtils4Aoto.trim(StringUtils4Aoto.substringBetween(sql, "UPDATE", "SET")).toUpperCase();
        String selectSql = "SELECT * FROM " + tableName + " WHERE " + primaryKey.getColumn() + " = ?";
        PreparedStatement statement = null;
        ResultSet rs = null;

        try
        {
            statement = conn.prepareStatement(selectSql);
            statement.setInt(1, primaryKey.getId());
            rs = statement.executeQuery();

            if (!rs.next())
            {
                return;
            }

            Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
            Entry<String, Object> entry = null;
            Object o = null;
            Object n = null;
            String column = null;

            ArrayList<DataLog> list = new ArrayList<DataLog>();
            DataLog log = null;

            while (iterator.hasNext())
            {
                entry = iterator.next();
                column = StringUtils4Aoto.camelCaseToSnakeCase(entry.getKey());
                o = rs.getObject(column);
                n = entry.getValue();
                
                if (equals(n, o))
                {
                    continue;
                }
                
                log = new DataLog(behaviorId, tableName, column, primaryKey.getId(), convertToString(o),
                        convertToString(n));
                list.add(log);
            }
            
            insertDataLog(conn, list);
        }
        finally
        {
            if (null != rs)
            {
                rs.close();
            }

            if (null != statement)
            {
                statement.close();
            }
        }
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param conn Connection
     * @param log DataLog
     * @throws SQLException SQLException
     */
    private void insertDataLog(Connection conn, DataLog log) throws SQLException
    {
        ArrayList<DataLog> list = new ArrayList<DataLog>();
        list.add(log);
        
        insertDataLog( conn, list);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param conn Connection
     * @param list List<DataLog>
     * @throws SQLException SQLException
     */
    private void insertDataLog(Connection conn, List<DataLog> list) throws SQLException
    {
        PreparedStatement statement = null;

        try
        {
            statement = conn.prepareStatement(DATA_LOG_INSERT);
            
            for (DataLog log : list)
            {
                statement.setInt(1, log.getBehaviorId());
                statement.setTimestamp(2, new Timestamp(new Date().getTime()));
                statement.setString(NumberEnum.NUMBER_3.getNum(), log.getTableName());
                statement.setString(NumberEnum.NUMBER_4.getNum(), log.getColumnName());
                statement.setInt(NumberEnum.NUMBER_5.getNum(), log.getKeyValue());
                statement.setString(NumberEnum.NUMBER_6.getNum(), log.getOldValue());
                statement.setString(NumberEnum.NUMBER_7.getNum(), log.getNewValue());
                statement.execute();
            }
        }
        finally
        {
            if (null != statement)
            {
                statement.close();
            }
        }
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param n Object
     * @param o Object
     * @return boolean
     * @throws SQLException SQLException
     */
    private boolean equals(Object n, Object o) throws SQLException
    {
        if (null == n && null == o)
        {
            return true;
        }
        else if (null == n && null != o)
        {
            return o instanceof String && StringUtils4Aoto.isEmpty((String) o);
        }
        else if (null != n && null == o)
        {
            return n instanceof String && StringUtils4Aoto.isEmpty((String) n);
        }
        
        if (o instanceof TIMESTAMP)
        {
            return ((Date) n).getTime() == ((TIMESTAMP) o).timestampValue().getTime();
        }
        else if (o instanceof BigDecimal)
        {
            if (n instanceof Integer)
            {
                return (Integer)n == ((BigDecimal)o).intValue();
            }
            else if (n instanceof Boolean)
            {
                if (((BigDecimal)o).intValue() == 1 && ((Boolean)n).booleanValue())
                {
                    return true;
                }
                
                if (((BigDecimal)o).intValue() == 0 && !((Boolean)n).booleanValue())
                {
                    return true;
                }
            }
            else if (n instanceof Float)
            {
                return 0 == ((Float)n).compareTo(((BigDecimal)o).floatValue());
            }
            else if (n instanceof Double)
            {
                return 0 == ((Double)n).compareTo(((BigDecimal)o).doubleValue());
            }
        }
        else
        {
            return n.equals(o);
        }
        
        return false;
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param obj Object
     * @return String
     * @throws SQLException SQLException
     */
    private String convertToString(Object obj) throws SQLException
    {        
        if (null == obj)
        {
            return null;
        }
        if (obj instanceof String)
        {
            return StringUtils4Aoto.defaultIfEmpty((String)obj, StringUtils4Aoto.EMPTY);
        }
        else if (obj instanceof Date)
        {
            return DateFormatUtils.format((Date)obj, "yyyy-MM-dd HH:mm:ss.SSS");
        }
        else if (obj instanceof TIMESTAMP)
        {
            return DateFormatUtils.format(((TIMESTAMP)obj).timestampValue(), "yyyy-MM-dd HH:mm:ss.SSS");
        }
        else if (obj instanceof Boolean)
        {
            return ((Boolean)obj).booleanValue() ? "1" : "0";
        }
        else 
        {
            return String.valueOf(obj);
        }
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param sqlCommandType SqlCommandType
     * @param id String
     * @return boolean
     */
    private boolean exclude(SqlCommandType sqlCommandType, String id)
    {
        if (SqlCommandType.SELECT.equals(sqlCommandType))
        {
            return true;
        }

        for (String namespace : excepted)
        {
            if (id.startsWith(namespace))
            {
                return true;
            }
        }

        return false;
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     * @return PrimaryKey
     */
    private PrimaryKey findPrimaryKey(Map<String, Object> map)
    {
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        Map.Entry<String, Object> entry = null;
        String property = null;
        String propertyWithoutPK = null;
        PrimaryKey primaryKey = null;

        while (iterator.hasNext())
        {
            entry = iterator.next();
            property = entry.getKey();

            if (StringUtils4Aoto.startsWithIgnoreCase(property, PK_PREFIX))
            {
                propertyWithoutPK = StringUtils4Aoto.substringAfter(property, PK_PREFIX);
                primaryKey = new PrimaryKey(propertyWithoutPK, (Integer) entry.getValue());
                break;
            }
        }

        if (null != primaryKey)
        {
            map.remove(property);
            map.put(propertyWithoutPK, primaryKey.getId());
        }

        return primaryKey;
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @version 1.0, 2017年6月1日
     */
    class PrimaryKey
    {
        /**
         * [简要描述]:
         * @author zongwj
         */
        private String column;
        /**
         * [简要描述]:
         * @author zongwj
         */
        private String property;
        /**
         * [简要描述]:
         * @author zongwj
         */
        private int id;

        /**
         * [简要描述]:<br/>
         * [详细描述]:<br/>
         *
         * @author zongwj
         * @param property String
         * @param id int
         */
        PrimaryKey(String property, int id)
        {
            this.property = property;
            this.column = StringUtils4Aoto.camelCaseToSnakeCase(property);
            this.id = id;
        }

        public String getProperty()
        {
            return property;
        }

        public String getColumn()
        {
            return column;
        }

        public int getId()
        {
            return id;
        }
        
        public void setId(int id)
        {
            this.id = id;
        }
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @version 1.0, 2017年6月1日
     */
    class DataLog
    {
        /**
         * [简要描述]:
         * @author zongwj
         */
        private int behaviorId;
        /**
         * [简要描述]:
         * @author zongwj
         */
        private String tableName;
        /**
         * [简要描述]:
         * @author zongwj
         */
        private String columnName;
        /**
         * [简要描述]:
         * @author zongwj
         */
        private int keyValue;
        /**
         * [简要描述]:
         * @author zongwj
         */
        private String oldValue;
        /**
         * [简要描述]:
         * @author zongwj
         */
        private String newValue;
        
        /**
         * [简要描述]:<br/>
         * [详细描述]:<br/>
         *
         * @author zongwj
         * @param behaviorId int
         * @param tableName String
         * @param columnName String
         * @param keyValue int
         * @param oldValue String
         * @param newValue String
         */
        DataLog(int behaviorId, String tableName, String columnName, int keyValue, String oldValue,
                String newValue)
        {
            this.behaviorId = behaviorId;
            this.tableName = tableName;
            this.columnName = columnName;
            this.keyValue = keyValue;
            this.oldValue = oldValue;
            this.newValue = newValue;
        }

        public int getBehaviorId()
        {
            return behaviorId;
        }

        public String getTableName()
        {
            return tableName;
        }

        public String getColumnName()
        {
            return columnName;
        }

        public int getKeyValue()
        {
            return keyValue;
        }

        public String getOldValue()
        {
            return oldValue;
        }

        public String getNewValue()
        {
            return newValue;
        }
    }
}
