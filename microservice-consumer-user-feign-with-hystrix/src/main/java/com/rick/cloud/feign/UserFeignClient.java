package com.rick.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
<<<<<<< HEAD

import com.rick.cloud.entity.User;
import com.rick.cloud.feign.UserFeignClient.HystrixClientFallback;
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rick.cloud.entity.User;

@FeignClient(name = "microservice-provider-user", fallback = HystrixClientFallback.class)
public interface UserFeignClient {

	@GetMapping("/simple/{id}")
	public User findById(@PathVariable("id") Long id);  //@PathVariable一定要设置value
	
	@Component
	static class HystrixClientFallback implements UserFeignClient {
	    @Override
	    public User findById(Long id) {
	    	User user = new User();
	    	user.setId(0L);
	    	user.setName("rick");
	        return user;
	    }
	}
}
