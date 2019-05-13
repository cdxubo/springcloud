package com.xu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestRestTemplate {

	@GetMapping("/testRestTemplate")
	public String testRestTemplate() {
		RestTemplate template = new RestTemplate();		
		return template.getForObject("https://www.baidu.com", String.class);
	}
}
