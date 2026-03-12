package com.lpu.SpringSecurityBasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@Configuration //This is used for testing purpose where the security component will load the details from the application only.
public class InMemoryUserDetailsService {

   //@Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.withDefaultPasswordEncoder().username("varun").password("varun123").roles("ADMIN").build();
        UserDetails user2 = User.withDefaultPasswordEncoder().username("tharun").password("tharun123").roles("USER").build();

        return new InMemoryUserDetailsManager(user1, user2);

    }

}
