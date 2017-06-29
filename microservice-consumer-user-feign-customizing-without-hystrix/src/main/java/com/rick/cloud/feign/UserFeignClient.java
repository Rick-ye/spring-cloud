package com.rick.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.rick.config.FeignConfiguration;
import com.rick.cloud.entity.User;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class, fallback = HystrixClientFallback.class)
public interface UserFeignClient {

	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Long id);  //@PathVariable一定要设置value
	
}
