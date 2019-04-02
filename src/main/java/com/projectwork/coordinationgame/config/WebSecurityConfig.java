/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectwork.coordinationgame.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 *
 * @author Antti Manninen <antti.e.manninen@tuni.fi>
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        // define filter rules for security
        // form login currently disabled, will be added later
        http.httpBasic().and()
        .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/games").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/api/games").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/api/games").hasRole("USER")
                .anyRequest().permitAll().and()
                //.formLogin().permitAll().and()
                //.logout().permitAll()
                //.and()
                .csrf().disable();
        
        
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                // hard coded admin password
                .withUser("admin").password(passwordEncoder().encode("2019coordAdmin")).roles("USER");
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}