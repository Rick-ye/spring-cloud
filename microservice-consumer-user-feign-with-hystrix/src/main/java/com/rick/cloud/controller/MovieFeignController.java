package com.rick.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rick.cloud.entity.User;
import com.rick.cloud.feign.UserFeignClient;

@RestController
public class MovieFeignController {

	@Autowired
	private UserFeignClient userFeignClient;

	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id) {
		return userFeignClient.findById(id);
	}
}
