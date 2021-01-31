package com.spring.app.util;

import com.spring.app.config.CacheConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CacheServiceUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheServiceUtil.class);

    @Autowired
    private CacheManager cacheManager;

    public void evictAll() {
        LOGGER.info("Inside evictAll");
        LOGGER.info("Inside CacheManager available cacheNames {} ", cacheManager.getCacheNames());
        cacheManager.getCacheNames().forEach(cacheName -> Objects.requireNonNull(cacheManager.getCache(cacheName)).clear());
        LOGGER.info("Inside CacheManager cleared all cacheNames, now cacheNames are {}", cacheManager.getCacheNames());
    }

    public void evictCacheByName(String cacheName) {
        LOGGER.info("Inside evictAll");
        LOGGER.info("Inside CacheManager available cacheNames {} ", cacheManager.getCacheNames());
        LOGGER.info("removed cache name is {}", cacheName);
        Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
        LOGGER.info("{} cache removed from cache manager", cacheName);
    }
}
