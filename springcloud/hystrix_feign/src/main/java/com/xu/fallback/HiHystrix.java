package com.xu.fallback;

import org.springframework.stereotype.Component;

import com.xu.feign.EurekaClientFeign;

@Component
public class HiHystrix implements EurekaClientFeign{

	@Override
	public String sayHiFromClientEureka(String name) {
		return "sorry,"+name+" error";
	}

	@Override
	public String sayHello(String name) {
		return "oh ,shit,"+name+" wrong";
	}
	
	

}
