package com.xu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 熔断器:实际为一个切面
 * 	注解@HystrixCommmand:开启熔断器的功能,使用在方法上    fallbackMethod:处理回退逻辑的方法
 * @author Administrator
 *
 */
@Service
public class HiService {

	@Autowired
	private RestTemplate restTemplate;
	
	// 使用RestTemplate远程调用eureka-client服务
	// 使用@HystrixCommand注解,sayHi()方法就开启了熔断器的功能,其中fallbackMethod为处理回退逻辑的方法
	@HystrixCommand(fallbackMethod="hiError")
	public String sayHi(String name) {
		return restTemplate.getForObject("http://eureka-client/hi?name="+name, String.class);
	}
	
	
	public String hiError(String name) {
		return "hi,"+name+",sorry,error";
	}
}
