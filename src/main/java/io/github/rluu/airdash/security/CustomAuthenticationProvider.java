package io.github.rluu.airdash.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.github.rluu.airdash.model.User;
import io.github.rluu.airdash.service.CustomUserDetailsService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static final Logger logger = LogManager.getLogger(CustomAuthenticationProvider.class);
    
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        logger.info("Inside authenticate()");
        
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        logger.info("username: " + username);
        logger.info("password: " + password);

        logger.info("customUserDetailsService: " + customUserDetailsService);

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
        logger.info("userDetails: " + userDetails);
        
        if (userDetails instanceof User) {
            User user = (User)userDetails;
            logger.info("user: " + user);
        }

        if (username.equals(userDetails.getUsername()) && 
            password.equals(userDetails.getPassword())) {
            
            logger.info("Login success");
            return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
        }
        else {
            logger.info("Login failure");
            throw new BadCredentialsException("Authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        logger.info("Inside supports()");
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    public CustomUserDetailsService getCustomUserDetailsService() {
        return customUserDetailsService;
    }

    public void setCustomUserDetailsService(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    
}
