package com.example.demo.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(WebSecurity web){
            web.ignoring().antMatchers("/**");
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.csrf()
                    .disable()
                    .authorizeRequests()
                    .anyRequest()
                    .permitAll();
        }

}
