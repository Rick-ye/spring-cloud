package com.rick.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rick.config.AuthConfiguration;

import feign.Param;
import feign.RequestLine;

@FeignClient(name="xxx", url = "http://localhost:8761", configuration = AuthConfiguration.class)
public interface FeignClientTest {
	
	/*@RequestLine("GET /eureka/apps/{serviceName}")
	public String findServiceByServiceName(@Param("serviceName") String serviceName);*/
	
	@GetMapping(value = "/eureka/apps/{serviceName}")
	public String findServiceByServiceName(@PathVariable("serviceName") String serviceName);
}
