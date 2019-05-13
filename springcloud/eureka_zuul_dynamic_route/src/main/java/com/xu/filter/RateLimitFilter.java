package com.xu.filter;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * 使用zuul实现限流的过滤器
 * @author Administrator
 *
 */
@Component
public class RateLimitFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 若一个用户(ip)在5s内访问同一个微服务超过10次,则限流
	 * 使用Map集合存储用户访问微服务的数据:Map<ip+微服务的名称,访问次数>
	 */
	@Override
	public Object run() throws ZuulException {
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return -1;
	}

}
