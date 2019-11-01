package io.github.rluu.airdash.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import io.github.rluu.airdash.service.CustomUserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1  = User.builder()
//                                 .username("ryanadmin")
//                                 .password("password")
//                                 .roles("ADMIN", "USER")
//                                 .build();
//
//        UserDetails user2  = User.builder()
//                                 .username("ryanuser")
//                                 .password("password")
//                                 .roles("USER")
//                                 .build();
//
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        userDetailsManager.createUser(user1);
//        userDetailsManager.createUser(user2);
//
//        return userDetailsManager;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
        return passwordEncoder;
    }
    

//
//    @Bean
//    public UserDetailsService userDetailsService(CustomUserDetailsService userService) {
//        return userService;
//    }
// 
}