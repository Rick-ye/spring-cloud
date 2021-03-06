package com.rick.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rick.cloud.entity.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	/*
	 * @Value("${user.userServicePath}") private String userServicePath;
	 */

	@GetMapping("/ribbon/{id}")
	public User findById(@PathVariable Long id) {
		return restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}

	@GetMapping("/test")
	public String test() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
		System.out.println(
				serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

		ServiceInstance serviceInstance2 = loadBalancerClient.choose("microservice-provider-user2");
		System.out.println(
				serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());

		return "1";
	}

	@GetMapping("/sidecar")
	public String findById() {
		return restTemplate.getForObject("http://microservice-sidecar/", String.class);
	}

}
