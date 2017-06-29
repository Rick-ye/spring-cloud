package com.rick.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class AuthConfiguration {

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
		return new BasicAuthRequestInterceptor("user", "password");
	}
	
	@Bean
	@Scope("prototype")
	public Feign.Builder feignBuilder() {
		return Feign.builder();
	}
	
}
