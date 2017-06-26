package com.rick.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rick.cloud.entity.User;

@FeignClient("microservice-provider-user")
public interface UserFeignClient {

	@GetMapping("/simple/{id}")
	public User findById(@PathVariable("id") Long id);  //@PathVariable一定要设置value
	
	//@RequestMapping(value="/user", method = RequestMethod.POST)
	@PostMapping("/user")
	public User postUser(@RequestBody User user);
	
	//该请求不会成功，只要参数是复杂对象，即使制定了是get方法，feign依然会以post方法进行发送请求
	@GetMapping("/getuser")
	public User getUser(User user);
}
