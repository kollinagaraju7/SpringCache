package com.spring.app.jobs;

import com.spring.app.entity.Emp;
import com.spring.app.repository.IEmpRepo;
import com.spring.app.util.CacheServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author dell
 */
@Component
@CacheConfig(cacheNames = {"emps"})
public class ScheduledJobsExecution {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledJobsExecution.class);

    @Autowired
    private IEmpRepo repo;

    @Autowired
    private CacheServiceUtil cacheServiceUtil;


    @Caching(put = {@CachePut(condition = "#result != null")})
    @Scheduled(fixedRate = 30 * 60 * 1000)
    public List<Emp> reloadEmployees() {
        LOGGER.info("Inside emps put ... Clearing emps cache data");
        cacheServiceUtil.evictCacheByName("emps");
        LOGGER.info("Cleared cacheto load fresh data");
        return repo.findAll();
    }
}
