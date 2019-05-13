package com.xu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xu.feign.EurekaClientFeign;

@Service
public class HiService {
	@Autowired
	private EurekaClientFeign eurekaClientFeign;
	
	public String sayHi(String name) {
		return eurekaClientFeign.sayHiFromClientEureka(name);
	}

}
