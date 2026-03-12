package com.lpu.SpringSecurityBasic.service;

import com.lpu.SpringSecurityBasic.entity.Cricketer;
import com.lpu.SpringSecurityBasic.repository.CricketerRepository;
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
public class DataBaseUserDetailsService implements UserDetailsService {

    private final CricketerRepository cricketerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cricketer cricketer = cricketerRepository.findByName(username);
        if(cricketer==null){
            System.out.println("Cricketer Not Found");
        }

        return new User(cricketer.getName(),
                cricketer.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + cricketer.getRole()))
        );
    }
}
