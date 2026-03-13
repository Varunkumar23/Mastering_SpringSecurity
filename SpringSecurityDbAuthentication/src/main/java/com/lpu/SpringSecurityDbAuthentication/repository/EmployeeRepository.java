package com.lpu.SpringSecurityDbAuthentication.repository;

import com.lpu.SpringSecurityDbAuthentication.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByName(String username);
}
