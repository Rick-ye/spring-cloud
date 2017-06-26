package com.rick.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rick.cloud.entity.User;

@RestController
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/ribben/{id}")
	@HystrixCommand(fallbackMethod = "findByIdFallback")
	public User findById(@PathVariable Long id) {
		return restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}
	
	public User findByIdFallback(Long id){
		User user = new User();
		user.setId(0L);
		return user;
	}
	
}
