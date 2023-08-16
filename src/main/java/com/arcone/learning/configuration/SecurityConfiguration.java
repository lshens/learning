package com.arcone.learning.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.http.HttpMethod.OPTIONS;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final DataSource dataSource;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder encoder)
            throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select email, secret, case when status = 'ACTIVE' then true else false end as is_active" +
                        " from users where email = ?")
                .authoritiesByUsernameQuery("select u.email, r.name from users u, roles r, user_roles ur" +
                        " where u.id = ur.user_id and r.id = ur.role_id and u.email = ?")
                .passwordEncoder(encoder)
                .and()
                .build();
    }

    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {
        return http.cors().disable()
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers(OPTIONS, "/v1/**").permitAll()
                .antMatchers("/v1/users/sig-in").permitAll()
                .antMatchers("/v1/users/levels").hasAnyAuthority("ADMIN", "STUDENT")
                .antMatchers("/v1/courses/**").hasAuthority("ADMIN")
                .antMatchers("/v1/users/**").hasAuthority("STUDENT")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
