package com.rick.cloud.feign;

import org.springframework.stereotype.Component;

@Component
public class FeignClientTestFallback implements FeignClientTest {

	@Override
	public String findServiceByServiceName(String serviceName) {
		return "FeignClientTestFallback";
	}

}
