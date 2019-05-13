package com.xu.config;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Retryer;



/**
 *  重写FeignClientsConfiguration中的bean,覆盖掉默认的Retryer的bean
 *  feign默认的配置在请求失败后重试次数为0,即不重试(Retryer.NEVER_RETRY)
 *  @Bean
	@ConditionalOnMissingBean
	public Retryer feignRetryer() {
		return Retryer.NEVER_RETRY;
	}
	
 * @author Administrator
 *
 */
@Configuration
public class FeignConfig {

	@Bean
	public Retryer feignRetryer() {
		return new Retryer.Default(100, SECONDS.toMillis(1), 5);
	}

}
