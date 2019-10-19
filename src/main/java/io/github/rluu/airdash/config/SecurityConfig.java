package io.github.rluu.airdash.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        //PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
        return passwordEncoder;
    }

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

}