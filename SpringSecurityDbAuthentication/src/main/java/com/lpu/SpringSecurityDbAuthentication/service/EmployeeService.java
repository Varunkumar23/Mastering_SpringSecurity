package com.lpu.SpringSecurityDbAuthentication.service;

import com.lpu.SpringSecurityDbAuthentication.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployees();

    String deleteEmployee(int id);

    String verifyLogInUser(Employee employee);
}
