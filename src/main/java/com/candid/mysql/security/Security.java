package com.candid.mysql.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.candid.mysql.service.Usermysqlservice;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class Security extends WebSecurityConfigurerAdapter {

	@Autowired
	Usermysqlservice service;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
	 
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.cors().disable().csrf().disable();
		 http.authorizeRequests().antMatchers("/resources/**", "/webjars/**","/assets/**").permitAll()
		 .antMatchers(HttpMethod.GET,"/hi").permitAll()
		 .antMatchers(HttpMethod.POST,"/add").hasAnyRole("STUDENT").anyRequest().permitAll()
		 .antMatchers(HttpMethod.GET,"/all").hasAnyRole("STUDENT").anyRequest().authenticated();
		 
	}
	
	
	

}
