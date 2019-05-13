package com.xu.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xu.config.FeignConfig;


/**
 *   @author Administrator
 *  	 在接口上加@FeignClient注解来声明一个Feign Client
 *  	value为远程调用其他服务的服务名
 *  	FeignConfig.class为Feign Client的配置类,可以覆盖默认配置
 *
 */
@FeignClient(value="eureka-client",configuration=FeignConfig.class)
public interface EurekaClientFeign {
	@GetMapping(value="/hi")
	String sayHiFromClientEureka(@RequestParam(value="name") String name);

}
