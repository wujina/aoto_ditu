/*
 * Nanjing Aoto 2017, All rights reserved.
 * 文件名  :CacheFactory.java
 * 创建人  :zongwj
 * 创建时间:2017年5月22日
*/

package com.aoto.framework.ignite;

import java.util.concurrent.TimeUnit;

import javax.cache.expiry.AccessedExpiryPolicy;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.expiry.ModifiedExpiryPolicy;
import javax.cache.expiry.TouchedExpiryPolicy;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.configuration.CacheConfiguration;

import com.aoto.framework.commons.constant.ExpiryPolicyEnum;
import com.aoto.framework.spring.SpringContextHolder;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年5月22日
 */
public class CacheFactory {
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static Ignite ignite = (Ignite)SpringContextHolder.getBean("igniteSpringBean");    
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param cacheType String
     */
    public static void destoryCache(String cacheType) {
        ignite.destroyCache(cacheType);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param cacheType String
     * @return IgniteCache<String, Object>
     */
    public static IgniteCache<String, Object> getCache(String cacheType) {
        return ignite.getOrCreateCache(cacheType);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param cacheType String
     * @param timeUnit TimeUnit
     * @param timeValue long
     * @param expiryPolicy ExpiryPolicyEnum
     * @return IgniteCache<String, Object>
     */
    public static IgniteCache<String, Object> getCacheWithExpiry(String cacheType, TimeUnit timeUnit,
            long timeValue, ExpiryPolicyEnum expiryPolicy) {
        CacheConfiguration<String, Object> cfg = new CacheConfiguration<String, Object>();
        cfg.setName(cacheType);
        if (ExpiryPolicyEnum.ACCESSED.equals(expiryPolicy)) {
            cfg.setExpiryPolicyFactory(AccessedExpiryPolicy.factoryOf(new Duration(timeUnit, timeValue)));
        }
        else if (ExpiryPolicyEnum.CREATED.equals(expiryPolicy)) {
            cfg.setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(timeUnit, timeValue)));
        }
        else if (ExpiryPolicyEnum.MODIFIED.equals(expiryPolicy)) {
            cfg.setExpiryPolicyFactory(ModifiedExpiryPolicy.factoryOf(new Duration(timeUnit, timeValue)));
        }
        else {
            cfg.setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(timeUnit, timeValue)));
        }
        
        return ignite.getOrCreateCache(cfg);
    }
}
