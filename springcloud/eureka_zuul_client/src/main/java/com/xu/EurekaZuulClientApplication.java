package com.xu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient // 开启EurekaClient的功能
@EnableZuulProxy	// 开启Zuul的功能
public class EurekaZuulClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaZuulClientApplication.class, args);
	}

}
