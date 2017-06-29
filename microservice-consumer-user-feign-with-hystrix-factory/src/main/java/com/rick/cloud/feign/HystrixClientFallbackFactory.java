package com.rick.cloud.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rick.cloud.entity.User;

import feign.hystrix.FallbackFactory;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<UserFeignClient> {

	private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);
	
	@Override
	public UserFeignClient create(Throwable error) {
		
		HystrixClientFallbackFactory.LOGGER.info("fallback reason was:" + error.getMessage());
		
		return new UserFeignClientWithFactory() {
			public User findById(Long id) {
				User user = new User();
				user.setId(-1L);
				user.setUsername("rick");
				return user;
			}
		};
	}

}
