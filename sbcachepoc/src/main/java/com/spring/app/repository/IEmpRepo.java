package com.spring.app.repository;

import com.spring.app.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpRepo extends JpaRepository<Emp, Long> {

    Emp findEmpByNameAndAddress(String name, String address);
}
