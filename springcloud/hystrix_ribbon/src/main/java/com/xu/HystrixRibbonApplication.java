package com.xu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix  // 开启hystrix的熔断器功能 
@EnableHystrixDashboard // 开启Hystrix Dashbord的功能,监控熔断器的状态
public class HystrixRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixRibbonApplication.class, args);
	}

}
