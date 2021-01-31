package com.spring.app.service;


import com.spring.app.entity.Emp;

import java.util.List;

public interface IEmpService {

    List<Emp> getEmployees();

    Emp getEmpById(Long id);

    void saveOrUpdateEmp(Emp e);

    void deleteEmp(Long id);
}
