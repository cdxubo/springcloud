package com.xu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xu.service.HiService;

@RestController
public class HiController {

	@Autowired
	private HiService hiService;
	
	@GetMapping("/hi")
	public String sayHi(@RequestParam(defaultValue="xu",required=false) String name) {
		return hiService.sayHi(name);
	}
	
	@GetMapping("/hello")
	public String sayHelo(@RequestParam(defaultValue="springcloud",required=false) String name) {
		return hiService.sayHello(name);
	}
}
