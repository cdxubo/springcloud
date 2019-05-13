package com.xu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableFeignClients  // 开启feign client的功能
@EnableHystrixDashboard //开启Hystrix Dashboard的功能
public class HystrixFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixFeignApplication.class, args);
	}

}
