package com.rick.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rick.cloud.entity.User;

@FeignClient(name = "microservice-provider-user", fallback = HystrixClientFallback.class)
public interface UserFeignClient {

	@GetMapping("/simple/{id}")
	//@RequestMapping(method = RequestMethod.GET, value = "/simple/{id}")
	public User findById(@PathVariable("id") Long id);  //@PathVariable一定要设置value
	
}
@Component
class HystrixClientFallback implements UserFeignClient {

	public User findById(Long id) {
		User user = new User();
		user.setId(0L);
		return user;
	}

}