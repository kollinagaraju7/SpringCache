package com.spring.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author dell
 */
@Configuration
@EnableCaching
public class CacheConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheConfig.class);

    @Value("${cacheNames}")
    private String cacheNames;

    @Bean
    public CacheManager cacheManager() {
        LOGGER.info("Inside cacheManager.. ");
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        LOGGER.info("cacheNames {}", cacheNames);
        cacheManager.setCacheNames(Arrays.asList(cacheNames));
        LOGGER.info("cacheManager {}", cacheManager);
        return cacheManager;
    }
}
