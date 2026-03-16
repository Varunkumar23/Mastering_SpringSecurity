package com.lpu.SpringSecurityDbAuthentication.controller;

import com.lpu.SpringSecurityDbAuthentication.entity.Employee;
import com.lpu.SpringSecurityDbAuthentication.service.EmployeeService;
import jakarta.servlet.ServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

//    @GetMapping("/register")
//    public String hello(){
//        return "Working!";
//    }

    @PostMapping("/register")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Employee employee) {
        return employeeService.verifyLogInUser(employee);
    }


    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {

        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {

        return employeeService.deleteEmployee(id);
    }
}
