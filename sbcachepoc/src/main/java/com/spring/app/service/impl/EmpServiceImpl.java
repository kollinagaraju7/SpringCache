package com.spring.app.service.impl;

import com.spring.app.entity.Emp;
import com.spring.app.repository.IEmpRepo;
import com.spring.app.service.IEmpService;
import com.spring.app.util.CacheServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = {"emps"})
public class EmpServiceImpl implements IEmpService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmpServiceImpl.class);

    @Autowired
    private IEmpRepo repo;

    @Autowired
    private CacheServiceUtil cacheServiceUtil;

    @Override
    @Cacheable(sync = true)
    public List<Emp> getEmployees() {
        return repo.findAll();
    }


    @Override
    @Cacheable(value = "emps", key = "#id")
    public Emp getEmpById(Long id) {
        Optional<Emp> employee = repo.findById(id);
        if (employee.isPresent())
            return employee.get();
        return null;
    }

    @Override
    @CacheEvict(value="emps", allEntries = true)
    public void saveOrUpdateEmp(Emp e) {
        if (null != e) {
            repo.save(e);
        }
    }

    @Override
    @CacheEvict(value="emps", allEntries = true)
    public void deleteEmp(Long id) {
        Optional<Emp> employee = repo.findById(id);
        if (employee.isPresent())
            repo.delete(employee.get());
    }

}
