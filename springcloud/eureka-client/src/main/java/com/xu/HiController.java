package com.xu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
	//从配置文件读取port,用于标识哪个服务提供者响应的请求
	@Value("${server.port}")
	String port;
	
	@GetMapping("/hi")
	public String home(@RequestParam String name) {
		return "hi "+name+", i am from port:"+port;
	}
	
	@GetMapping("/hello")
	public String cloud(@RequestParam String name) {
		return "hello "+name+", i am from port:"+port;
	}

}
