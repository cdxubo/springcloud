package com.xu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Retryer;
import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class FeignConfig {
	
	@Bean
	public Retryer feignRetryer() {
		return new Retryer.Default(100, SECONDS.toMillis(1), 5);
	}

}
