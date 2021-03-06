package com.security;

import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter implements ApplicationContextAware{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.headers().httpStrictTransportSecurity()
			.maxAgeInSeconds(0)
			.includeSubDomains(true);
			http.csrf().disable();
		 http.authorizeRequests().antMatchers("/").permitAll();
	}
	 @Override
	    public void configure(WebSecurity web) throws Exception {
	        web
	            .ignoring()
	            .antMatchers("/h2-contatos/**");
	    }
}
