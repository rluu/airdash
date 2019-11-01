package io.github.rluu.airdash.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.rluu.airdash.model.User;
import io.github.rluu.airdash.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LogManager.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        logger.info("Attempting to load username: " + username);
        User user = userRepository.findByUsername(username);
        logger.info("Done with query.  User found was: " + user);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
}