package com.todo.todoBackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
// @EnableWebSecurity provides with the default auto-configuration for enabling WebSecurity in the Config class of our Spring Boot project
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");

		http
			.csrf().disable()
			.authorizeRequests()
			// Since authorization header is passed with the HTTP request from the front end. That is handled by permitting the pre-flight Options req
			.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
				.anyRequest().authenticated()
				.and()
			//.formLogin().and()
			.httpBasic();
	}

}
