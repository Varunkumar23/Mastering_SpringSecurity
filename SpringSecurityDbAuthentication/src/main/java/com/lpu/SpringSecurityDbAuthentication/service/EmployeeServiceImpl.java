package com.lpu.SpringSecurityDbAuthentication.service;

import com.lpu.SpringSecurityDbAuthentication.entity.Employee;
import com.lpu.SpringSecurityDbAuthentication.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    private final EmployeeRepository repo;

    private final AuthenticationManager authenticationManager;

    private final JWTService jwtService;

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setPassword(encoder.encode(employee.getPassword()));
        return repo.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {

        return repo.findAll();
    }

    @Override
    public String deleteEmployee(int id) {
        repo.deleteById(id);
        return "Employee Deleted Successfully!";
    }

    @Override
    public String verifyLogInUser(Employee employee) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(employee.getName(), employee.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateJwtToken(employee);
        } else {
            return "Login Failed";
        }
    }


}
