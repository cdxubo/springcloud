package com.xu.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


/**
 * 在zuul中使用自定义过滤器,继承ZuulFilter
 * @author Administrator
 *
 */
@Component
public class TokenFilter extends ZuulFilter{

	private static Logger log=LoggerFactory.getLogger(TokenFilter.class);
	/**
	 * 是否启用该过滤器,若为true,则执行run方法
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 具体的过滤逻辑:检查请求的参数中是否有token这个参数,如果没有传,则请求不会路由到具体的服务实例,直接返回响应,状态码为401
	 */
	@Override
	public Object run() throws ZuulException {
		// zuul将所有请求数据放在RequestContext(容器)里面
		// ConcurrentHashMap里面有16个子HashMap
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		// 从请求参数里面获取token
		String token = request.getParameter("token");
		if (null==token) {
			log.warn("token is empty");
			ctx.setSendZuulResponse(false); // 拦截
			ctx.setResponseStatusCode(401); 
			try {
				ctx.getResponse().getWriter().write("token is empty");
			} catch (IOException e) {
				return null;
			}
		}
		
		ctx.setSendZuulResponse(true); //验证通过
		log.info("ok");
		return null;
	}

	/**
	 * 过滤器的类型,包括pre,post,route,error
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤顺序,值越小,越早执行该过滤器
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

}
