package com.shadowSpringSecurity.SpringSecurityMySQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider(){
        // DAO(Data Access Object). We're accessing data from the DB
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
        // password encoder
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll() // "/" can be accessed by anyone, don't need login
                .antMatchers("/home").hasAuthority("USER") // "/home" can be accessed by anyone with "USER" authority(use hasAnyAuthority for multiple authority)
                .antMatchers("/admin").hasAuthority("ADMIN") // "/admin" can be accessed by anyone with "ADMIN" authority
                .anyRequest().authenticated() // any request that comes to "/home" or "/admin" should be authenticated
                .and().httpBasic();
    }
}

// Spring's Security DaoAuthenticationProvider is a simple authentication provider that uses a Data Access Object (DAO) to retrieve user information from a relational database. It leverages a UserDetailsService (as a DAO) in order to lookup the username, password and GrantedAuthority s.

// The UserDetailsService interface is used to retrieve user-related data. It has one method named loadUserByUsername() which can be overridden to customize the process of finding the user. It is used by the DaoAuthenticationProvider to load details about the user during authentication.

// UserDetailsService interface is used in order to lookup the username, password and GrantedAuthorities for any given user.

// Here UserDetails is container for core user information. According to docs, its implementations are not used directly by Spring Security for security purposes. They simply store user information which is later encapsulated into Authentication objects. This allows non-security related user information (such as email addresses, telephone numbers etc) to be stored in a convenient location.