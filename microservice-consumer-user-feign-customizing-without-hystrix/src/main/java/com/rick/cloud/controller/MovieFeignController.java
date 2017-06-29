package com.rick.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rick.cloud.feign.FeignClientTest;
import com.rick.cloud.feign.UserFeignClient;
import com.rick.cloud.entity.User;

@RestController
public class MovieFeignController {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired 
	private FeignClientTest feignClientTest;
	
	@GetMapping("/simple/{id}")
	public User findById(@PathVariable Long id) {
		return userFeignClient.findById(id);
	}
	
	/*
	 * 有坑，Tomcat8.5的高版本不支持，，，服务端接收请求不会对符号进行转义
	 * 解决办法：1.使用低版本的Tomcat
	 * 		 2.在conf/catalina.properties中最后添加一行：
	 *		   org.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH=true
	 */
	@GetMapping("/{serviceName}")
	public String findServiceByServiceName(@PathVariable String serviceName){
		return feignClientTest.findServiceByServiceName(serviceName);
	}
	
	/*@GetMapping("/serviceName")
	public String findServiceByServiceName(){
		return feignClientTest.findServiceByServiceName("microservice-provider-user");
	}*/
}
