package com.xu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;


/**
 * zuul的动态路由:使用PatternServiceRouteMapper和正则表达式来实现动态路由
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class EurekaZuulDynamicRouteApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaZuulDynamicRouteApplication.class, args);
	}
	
	
	@Bean
	public PatternServiceRouteMapper patternServiceRouteMapper() {
		return new PatternServiceRouteMapper("(?<name>.*)", "${name}");
	}

}
