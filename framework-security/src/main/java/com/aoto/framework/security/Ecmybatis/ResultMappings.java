package com.aoto.framework.security.Ecmybatis;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author ecmybatis
 */
public final class ResultMappings {
  
  private static final Logger LOG = LoggerFactory.getLogger(ResultMappings.class);
  
  // This class is thread safe
  
  private ResultMappings() { }

  private static Configuration config;
  
  // All properties mapping include id
  private static Map<Class<?>, List<ResultMapping>> mappings = new HashMap<>();
  
  // Just id properties exclude other properties
  private static Map<Class<?>, List<ResultMapping>> idMappings = new HashMap<>();
  
  static {
    
    LOG.info("Initialize result mappings for domain models");
    
    SqlSessionFactory factory = SpringBeansLocator.getBean(SqlSessionFactory.class);

    config = factory.getConfiguration();

    Collection<ResultMap> resultMaps = config.getResultMaps();
    
    Iterator<ResultMap> iter = resultMaps.iterator();
    while (iter.hasNext()) {
    	Object obj = iter.next();
    	if (!(obj instanceof ResultMap))
    		iter.remove();
    }

    resultMaps.forEach(rm -> {
      LOG.info("Type: {}", rm.getType().getName());
      mappings.put(rm.getType(), rm.getResultMappings());
      idMappings.put(rm.getType(), rm.getIdResultMappings());
    });

  }
  
  /**
   * 获取标识符的列名称
   * 
   * @param type 实体类型
   * @return 列名称
   */
  public static String getIdColumn(Class<?> type) {
    return getIdMapping(type).getColumn();
  }
  
  /**
   * 获取标识符的属性名称
   * 
   * @param type 实体类型
   * @return 属性名称
   */
  public static String getIdProperty(Class<?> type) {
    return getIdMapping(type).getProperty();
  }
  
  /**
   * 获取列名称
   * 
   * @param type 实体类型
   * @param property 属性名称
   * @return 列名称
   */
  public static String getColumn(Class<?> type, String property) {
    return getMapping(type, property).getColumn();
  }
  
  /**
   * 获取属性名称
   * 
   * @param type 实体类型
   * @param column 列名称
   * @return 属性名称
   */
  public static String getProperty(Class<?> type, String column) {
    List<ResultMapping> mappings = getMappings(type);
    for (ResultMapping mapping : mappings) {
      if (mapping.getColumn().equals(column)) {
        return mapping.getProperty();
      }
    }
    throw new IllegalStateException("No such mapping of type " + type.getName() + " map column " + column);
  }
  
  public static ResultMapping getIdMapping(Class<?> type) {
    List<ResultMapping> mappings = idMappings.get(type);
    if (mappings != null) {
      if (mappings.size() != 1) {
        throw new IllegalStateException("Too many id mapping of type " + type.getName());
      }
      return mappings.get(0);
    }
    throw new IllegalStateException("No id mapping of type " + type.getName());
  }
  
  public static ResultMapping getMapping(Class<?> type, String property) {
    List<ResultMapping> mappings = getMappings(type);
    for (ResultMapping mapping : mappings) {
      if (mapping.getProperty().equals(property)) {
        return mapping;
      }
    }
    throw new IllegalStateException("No such mapping of type " + type.getName() + " map property " + property);
  }
  
  public static List<ResultMapping> getMappings(Class<?> type) {
    List<ResultMapping> mappings1 = mappings.get(type);
    if (mappings1 == null)
    	return Collections.emptyList();
    return Collections.unmodifiableList(mappings1);
  }
  
  public static Map<Class<?>, List<ResultMapping>> getMappings() {
    return Collections.unmodifiableMap(mappings);
  }
}
