package com.xu.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

@SuppressWarnings("deprecation")
public class MyFallbackProvider implements ZuulFallbackProvider{

	/**
	 * 指定熔断功能应用于哪些路由的服务
	 */
	@Override
	public String getRoute() {
		return "eureka-client";
	}

	/**
	 * 进入熔断功能时执行的逻辑
	 */
	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
			 @Override
	            public HttpStatus getStatusCode() throws IOException {
	                return HttpStatus.OK;
	            }

	            @Override
	            public int getRawStatusCode() throws IOException {
	                return 200;
	            }

	            @Override
	            public String getStatusText() throws IOException {
	                return "OK";
	            }

	            @Override
	            public void close() {

	            }

	            @Override
	            public InputStream getBody() throws IOException {
	                return new ByteArrayInputStream("oooops!error, i'm the fallback.".getBytes());
	            }

	            @Override
	            public HttpHeaders getHeaders() {
	                HttpHeaders headers = new HttpHeaders();
	                headers.setContentType(MediaType.APPLICATION_JSON);
	                return headers;
	            }
		};
	}

}
