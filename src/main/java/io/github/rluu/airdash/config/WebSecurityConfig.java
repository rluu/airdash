package io.github.rluu.airdash.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.github.rluu.airdash.security.CustomAuthenticationProvider;
import io.github.rluu.airdash.service.CustomUserDetailsService;

//import de.codecentric.boot.admin.server.config.AdminServerProperties;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	private final AdminServerProperties adminServer;
//	 
//    public WebSecurityConfig(AdminServerProperties adminServer) {
//        this.adminServer = adminServer;
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

//
//        SavedRequestAwareAuthenticationSuccessHandler successHandler = 
//            new SavedRequestAwareAuthenticationSuccessHandler();
//        successHandler.setTargetUrlParameter("redirectTo");
//        successHandler.setDefaultTargetUrl(this.adminServer.getContextPath() + "/");
// 
//        http
//            .authorizeRequests()
//                .antMatchers(this.adminServer.getContextPath() + "/assets/**").permitAll()
//                .antMatchers(this.adminServer.getContextPath() + "/login").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .loginPage(this.adminServer.getContextPath() + "/login")
//                .successHandler(successHandler)
//                .and()
//            .logout()
//                .logoutUrl(this.adminServer.getContextPath() + "/logout")
//                .and()
//            .httpBasic()
//                .and()
//            .csrf()
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .ignoringRequestMatchers(
//                  new AntPathRequestMatcher(this.adminServer.getContextPath() + 
//                    "/instances", HttpMethod.POST.toString()), 
//                  new AntPathRequestMatcher(this.adminServer.getContextPath() + 
//                    "/instances/*", HttpMethod.DELETE.toString()),
//                  new AntPathRequestMatcher(this.adminServer.getContextPath() + 
//                	"/actuator/**"))
//                .and()
//            .rememberMe()
//                .key(UUID.randomUUID().toString())
//                .tokenValiditySeconds(1209600);
        

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/v1/dataPoint/test").permitAll()
                .antMatchers("/api/v1/dataPoint/testPost").permitAll()
                .antMatchers("/api/v1/dataPoint/create").permitAll()
                .antMatchers("/login").permitAll()
                //.antMatchers("/test/**").permitAll()
                .antMatchers(
                        "/",
                        "/assets/**",
                        "/js/**",
                        "/css/**",
                        "/img/**",
                        "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
             .formLogin()
//                 .loginPage("/login")   // When this is commented out, it will use the default Spring login page.
                 .and()
             .httpBasic();
    }

//    
//
//    @Bean
//    public CustomAuthenticationProvider customAuthenticationProvider() {
//        return new CustomAuthenticationProvider();
//    }
//    @Override
//    public void configure(AuthenticationManagerBuilder builder) throws Exception {
//        builder.authenticationProvider(new CustomAuthenticationProvider());
//    }
    
    
    
}