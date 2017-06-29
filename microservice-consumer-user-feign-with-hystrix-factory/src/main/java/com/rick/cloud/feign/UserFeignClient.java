package com.rick.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rick.cloud.entity.User;

@FeignClient(name = "microservice-provider-user", /*
													 * fallback =
													 * HystrixClientFallback.
													 * class,
													 */ fallbackFactory = HystrixClientFallbackFactory.class)
public interface UserFeignClient {

	@GetMapping("/simple/{id}")
	public User findById(@PathVariable("id") Long id); // @PathVariable一定要设置value

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
