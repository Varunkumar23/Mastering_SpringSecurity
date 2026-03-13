package com.lpu.SpringSecurityDbAuthentication.service;

import com.lpu.SpringSecurityDbAuthentication.entity.Employee;
import com.lpu.SpringSecurityDbAuthentication.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeUserDetailService implements UserDetailsService {

    private final EmployeeRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = repo.findByName(username);

        if (employee == null) {
            System.out.println("User Not Found!");
            throw new UsernameNotFoundException("User Not Found!");
        }

        return new User(employee.getName(), employee.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_" + employee.getRole())));
    }
}
