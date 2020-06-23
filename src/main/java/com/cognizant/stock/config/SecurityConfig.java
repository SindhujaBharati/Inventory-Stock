package com.cognizant.stock.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").authorities("ADMIN");
		
	}
				
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		 http.httpBasic().and().authorizeRequests()
			.antMatchers("/cognizant/sales/**").hasAuthority("ADMIN")
			 .and().csrf().disable();
	}
}
