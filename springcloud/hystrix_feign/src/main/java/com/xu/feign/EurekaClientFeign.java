package com.xu.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xu.config.FeignConfig;
import com.xu.fallback.HiHystrix;


// 在接口上加@FeignClient注解来声明一个Feign Client
// value 为远程调用其他服务的服务名
@FeignClient(value="eureka-client",configuration=FeignConfig.class,fallback=HiHystrix.class)
public interface EurekaClientFeign {

	// 请求路径必须与eureka-client服务中的请求路径一致(否则会报404错误)
	@GetMapping("/hi")
	String sayHiFromClientEureka(@RequestParam(value="name") String name);
	
	
	// 请求路径必须与eureka-client服务中的请求路径一致
	@GetMapping("/hello")
	String sayHello(@RequestParam(value="name") String name);
}
