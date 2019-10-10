/*
 * Nanjing Aoto 2017, All rights reserved.
 * 文件名  :CacheFacade.java
 * 创建人  :zongwj
 * 创建时间:2017年5月22日
*/

package com.aoto.framework.ignite;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ignite.IgniteCache;
import org.apache.poi.ss.formula.functions.T;

import com.aoto.framework.commons.constant.FrameworkCacheType;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年5月22日
 */
public class CacheFacade {
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static Interner<String> interner = Interners.newWeakInterner();
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param cacheType String
     */
    private static synchronized void updateCacheMeta(String cacheType) {
        if (null == cacheType) {
            return;
        }
        
        IgniteCache<String, Object> igMem = CacheFactory.getCache(FrameworkCacheType.CACHE_META_INFO.getName());
        if (null == igMem) {
            return;
        }
        igMem.put(cacheType, new Date());
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param cacheType String
     * @return Date
     */
    public static Date getCacheMetaData(String cacheType) {
        if (StringUtils.isEmpty(cacheType)) {
            return null;
        }
        
        IgniteCache<String, Object> igMem = CacheFactory.getCache(FrameworkCacheType.CACHE_META_INFO.getName());
        if (null == igMem) {
            return null;
        }
        return (Date)igMem.get(cacheType);
    }
    
    /**
     * [简要描述]:判断single缓存是否为空
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param cacheType String
     * @return boolean
     */
    public static boolean isSingleCacheEmpty(String cacheType) {
        IgniteCache<String, Object> igMem = CacheFactory.getCache(cacheType);
        if (null == igMem) {
            return true;
        }
        return false;
    }

    /**
     * [简要描述]:判断all缓存是否为空
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param cacheType String
     * @return boolean
     */
    public static boolean isAllCacheEmpty(String cacheType) {
        IgniteCache<String, Object> igMem = CacheFactory.getCache(cacheType);
        if (null == igMem) {
            return true;
        }
        if (null == igMem.get(cacheType)) {
            return true;
        }        
        return false;
    }
    
    /**
     * [简要描述]:从all缓存中获取list
     * [详细描述]:get:all:key-->list
     * 
     * @author zongwj
     * @param cacheType String
     * @return List<T>
     */
    @SuppressWarnings("unchecked")
    public static List<T> getList(String cacheType) {
        Object value = null;
        IgniteCache<String, Object> igMem = CacheFactory.getCache(cacheType);
        if (null == igMem) {
            return null;
        }
        value = igMem.get(cacheType);
        return (null == value ? null : (List<T>)value);
    }
    
    /**
     * [简要描述]:从single缓存中获取list
     * [详细描述]:get:single:key1-->list
     * 
     * @author zongwj
     * @param cacheType String
     * @param id String
     * @return List<T>
     */
    @SuppressWarnings("unchecked")
    public static List<T> getList(String cacheType, String id) {
        Object value = null;
        IgniteCache<String, Object> igMem = CacheFactory.getCache(cacheType);
        if (null == igMem) {
            return null;
        }
        value = igMem.get(id);
        return (null == value ? null : (List<T>)value);
    }
    
    /**
     * [简要描述]:从all缓存中获取map
     * [详细描述]:get:all:key-->map
     * 
     * @author zongwj
     * @param cacheType String
     * @return Map<String, List<T>>
     */
    @SuppressWarnings("unchecked")
    public static Map<String, List<T>> getMap(String cacheType) {
        Object value = null;
        IgniteCache<String, Object> igMem = CacheFactory.getCache(cacheType);
        if (null == igMem) {
            return null;
        }
        value = igMem.get(cacheType);
        return (null == value ? null : (Map<String, List<T>>)value);
    }
    
    /**
     * [简要描述]:从single缓存中获取map
     * [详细描述]:get:single:key1-->map
     * 
     * @author zongwj
     * @param cacheType String
     * @param id String
     * @return Map<String, List<T>>
     */
    @SuppressWarnings("unchecked")
    public static Map<String, List<T>> getMap(String cacheType, String id) {
        Object value = null;
        IgniteCache<String, Object> igMem = CacheFactory.getCache(cacheType);
        if (null == igMem) {
            return null;
        }
        value = igMem.get(id);
        return (null == value ? null : (Map<String, List<T>>)value);
    }
    
    /**
     * [简要描述]:从single缓存中的map中根据key获取list
     * [详细描述]:get:single:key1-->map:key2-->list
     * 
     * @author zongwj
     * @param cacheType String
     * @param id String
     * @param id2 String
     * @return List<T>
     */
    public static List<T> getList(String cacheType, String id, String id2) {
        Map<String, List<T>> map = getMap(cacheType, id);
        if (null == map) {
            return null;
        }
        else {
            return map.get(id2);
        }
    }
    
    /**
     * [简要描述]:将list数据放入all缓存
     * [详细描述]:put:all:key-->list
     * 
     * @author zongwj
     * @param cacheType String
     * @param list List<T>
     */
    public static void putList(String cacheType, List<T> list) {
        synchronized (interner.intern(cacheType)) {
            IgniteCache<String, Object> igMem = CacheFactory.getCache(cacheType);
            if (null == igMem) {
                return;
            }
            igMem.remove(cacheType);
            igMem.put(cacheType, list);
            updateCacheMeta(cacheType);
        }
    }
    
    /**
     * [简要描述]:将map数据放入all缓存
     * [详细描述]:put:all:key-->map
     * 
     * @author zongwj
     * @param cacheType String
     * @param map Map<String, List<T>>
     */
    public static void putMap(String cacheType, Map<String, List<T>> map) {
        synchronized (interner.intern(cacheType)) {
            IgniteCache<String, Object> igMem = CacheFactory.getCache(cacheType);
            if (null == igMem) {
                return;
            }
            igMem.remove(cacheType);
            igMem.put(cacheType, map);
            updateCacheMeta(cacheType);
        }
    }
    
    /**
     * [简要描述]:将list数据放入single缓存
     * [详细描述]:put:single:key1-->list
     * 
     * @author zongwj
     * @param cacheType String
     * @param entityId String
     * @param list List<T>
     */
    public static void putList(String cacheType, String entityId, List<T> list) {
        synchronized (interner.intern(cacheType)) {
            IgniteCache<String, Object> igMem = CacheFactory.getCache(cacheType);
            if (null == igMem) {
                return;
            }
            igMem.remove(entityId);
            igMem.put(entityId, list);
            updateCacheMeta(cacheType);
        }
    }
    
    /**
     * [简要描述]:将map数据放入single缓存（全覆盖原map）
     * [详细描述]:put:single:key1-->map
     * 
     * @author zongwj
     * @param cacheType String
     * @param entityId String
     * @param map Map<String, List<T>>
     */
    public static void putMap(String cacheType, String entityId, Map<String, List<T>> map) {
        synchronized (interner.intern(cacheType)) {
            IgniteCache<String, Object> igMem = CacheFactory.getCache(cacheType);
            if (null == igMem) {
                return;
            }
            igMem.remove(entityId);
            igMem.put(entityId, map);
            updateCacheMeta(cacheType);
        }
    }
    
    /**
     * [简要描述]:将map数据放入single缓存（新map在原map的基础上做新增和替换，不删除新map中不存在原map中存在的键值对）
     * [详细描述]:put:single:key1-->map
     * 
     * @author zongwj
     * @param cacheType String
     * @param entityId String
     * @param map Map<String, List<T>>
     */
    @SuppressWarnings("unchecked")
    public static void putMapToMap(String cacheType, String entityId, Map<String, List<T>> map) {
        synchronized (interner.intern(cacheType)) {
            if (null == map || map.size() == 0) {
                return;
            }
            IgniteCache<String, Object> igMem = CacheFactory.getCache(cacheType);
            Map<String, List<T>> cacheMap = (Map<String, List<T>>)igMem.get(entityId);
            if (null != cacheMap) {
                List<T> list;
                for (Map.Entry<String, List<T>> entry : map.entrySet()) {
                    list = cacheMap.get(entry.getKey());
                    if (null == list) {
                        cacheMap.put(entry.getKey(), entry.getValue());
                    }
                    else {
                        list.addAll(entry.getValue());
                    }
                }
                igMem.remove(entityId);
            }
            else {
                cacheMap = map;
            }
            
            igMem.put(entityId, cacheMap);
            updateCacheMeta(cacheType);
        }
    }
    
    /**
     * [简要描述]:将map数据放入single缓存（新map在原map的基础上做新增和替换，不删除新map中不存在原map中存在的键值对）
     * [详细描述]:put:single:key1-->map(根据传入键值对封装，size为1,适用插入或修改一个键值对)
     * 
     * @author zongwj
     * @param cacheType String
     * @param entityId String
     * @param id2 String
     * @param t T
     */
    public static void putEntity(String cacheType, String entityId, String id2, T t) {
        synchronized (interner.intern(cacheType)) {
            List<T> list = new ArrayList<T>();
            list.add(t);
            Map<String, List<T>> map = new HashMap<String, List<T>>();
            map.put(id2, list);
            putMapToMap(cacheType, entityId, map);
        }
    }
    
    /**
     * [简要描述]:从single缓存中根据key1获取entity
     * [详细描述]:get:single:key1-->entity
     * 
     * @author zongwj
     * @param cacheType String
     * @param entityId String
     * @return T
     */
    public static T getEntity(String cacheType, String entityId) {
        if (null == entityId) {
            return null;
        }
        IgniteCache<String, Object> igMem = CacheFactory.getCache(cacheType);
        if (null == igMem) {
            return null;
        }
        return (T)(igMem.get(entityId));
    }
    
    /**
     * [简要描述]:从all缓存中的list中新增或更新entity
     * [详细描述]:put:all:key:entity-->list
     * 
     * @author zongwj
     * @param cacheType String
     * @param t T
     */
    public static void putEntityToList(String cacheType, T t) {
        synchronized (interner.intern(cacheType)) {
            if (null == t) {
                return;
            }
            List<T> list = getList(cacheType);
            if (null == list) {
                list = new ArrayList<T>();
            }
            if (list.contains(t)) {
                list.remove(t);
            }
            list.add(t);
            putList(cacheType, list);
            updateCacheMeta(cacheType);
        }
    }
    
    /**
     * [简要描述]:从single缓存中根据key1删除数据
     * [详细描述]:remove:single:key1-->entity
     * 
     * @author zongwj
     * @param cacheType String
     * @param entityId String
     */
    public static void removeEntity(String cacheType, String entityId) {
        synchronized (interner.intern(cacheType)) {
            IgniteCache<String, Object> igMem = CacheFactory.getCache(cacheType);
            if (null == igMem) {
                return;
            }
            igMem.remove(entityId);
            updateCacheMeta(cacheType);
        }
    }
    
    /**
     * [简要描述]:从single缓存中的map(key2-->list)的list中删除entity
     * [详细描述]:remove:single:key1-->map:key2:entity-->list
     * 
     * @author zongwj
     * @param cacheType String
     * @param entityId String
     * @param id2 String
     * @param t T
     */
    public static void removeEntity(String cacheType, String entityId, String id2, T t) {
        synchronized (interner.intern(cacheType)) {
            if (null == t) {
                return;
            }
            Map<String, List<T>> map = getMap(cacheType, entityId);
            if (null != map) {
                List<T> list = map.get(id2);
                if (null != list) {
                    list.remove(t);
                }
            }
            putMap(cacheType, entityId, map);
            updateCacheMeta(cacheType);
        }
    }
    
    /**
     * [简要描述]:从single缓存中的map根据key2删除键值对
     * [详细描述]:remove:single:key1-->map:key2-->entity
     * 
     * @author zongwj
     * @param cacheType String
     * @param entityId String
     * @param id2 String
     */
    public static void removeList(String cacheType, String entityId, String id2) {
        synchronized (interner.intern(cacheType)) {
            Map<String, List<T>> map = getMap(cacheType, entityId);
            if (null != map) {
                map.remove(id2);
            }
            putMap(cacheType, entityId, map);
            updateCacheMeta(cacheType);
        }
    }
    
    /**
     * [简要描述]:从all缓存中的list中删除entity
     * [详细描述]:remove:all:key-->list-->entity
     * 
     * @author zongwj
     * @param cacheType String
     * @param t T
     */
    public static void removeEntityFromList(String cacheType, T t) {
        synchronized (interner.intern(cacheType)) {
            if (null == t) {
                return;
            }
            List<T> list = getList(cacheType);
            if (null == list) {
                list = new ArrayList<T>();
            }
            if (list.contains(t)) {
                list.remove(t);
            }
            putList(cacheType, list);
            updateCacheMeta(cacheType);
        }
    }
    
    /**
     * [简要描述]:从single缓存中的list中删除entity
     * [详细描述]:remove:single:key1-->list--->entity
     * 
     * @author zongwj
     * @param cacheType String
     * @param entityId String
     * @param t T
     */
    public static void removeEntityFromList(String cacheType, String entityId, T t) {
        synchronized (interner.intern(cacheType)) {
            if (null == t) {
                return;
            }
            List<T> list = getList(cacheType, entityId);
            if (null == list) {
                list = new ArrayList<T>();
            }
            if (list.contains(t)) {
                list.remove(t);
            }
            putList(cacheType, entityId, list);
            updateCacheMeta(cacheType);
        }
    }
    
    /**
     * [简要描述]:将entity插入或更新到single缓存中的list中
     * [详细描述]:put:single:key1:entity-->list
     * 
     * @author zongwj
     * @param cacheType String
     * @param entityId String
     * @param t T
     */
    @SuppressWarnings("unchecked")
    public static void putEntityToList(String cacheType, String entityId, T t) {
        synchronized (interner.intern(cacheType)) {
            if (null == t) {
                return;
            }
            IgniteCache<String, Object> igMem = CacheFactory.getCache(cacheType);
            if (null == igMem) {
                return;
            }
            
            List<T> list = (List<T>)igMem.get(entityId);
            if (null == list) {
                list = new ArrayList<T>();
            }
            list.remove(t);
            list.add(t);
            putList(cacheType, entityId, list);
            updateCacheMeta(cacheType);
        }
    }
}
