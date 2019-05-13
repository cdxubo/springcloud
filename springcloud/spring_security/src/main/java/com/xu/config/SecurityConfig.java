package com.xu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


// @EnableWebSecurity //开启WebSecurity的功能
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true) // 开启方法级别的安全配置
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	/**
	 * spring security的基本配置
	 * 通过AuthenticationManagerBuilder在内存中创建了一个认证用户的信息,用户名为xu,
	 * 密码为123456,具有USER的角色
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("xu")
					.password("123456")
						.roles("USER");
	}
	
	/**
	 * 定义登录行为和授权行为
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/css/**","/index").permitAll()   // 以"/css/**"开头的资源和"/index"资源不需要验证,外界请求可以直接访问这些资源
				.antMatchers("/user/**").hasRole("USER")
					.antMatchers("/blogs/**").hasRole("USER") // 以"/user/**"和"/blogs/**"开头的资源需要验证,并且需要用户的角色是"USER"
						.and()
							.formLogin().loginPage("/login").failureUrl("/login-error") // 表单登录的地址是"/login",登录失败的地址是"/login-error"
								.and()
									.exceptionHandling().accessDeniedPage("/401"); // 异常处理会重定向到"/401"界面
		http.logout().logoutSuccessUrl("/"); // 注销登录成功,重定向到首页
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}
	
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("xu").password("123456").roles("USER").build());
		manager.createUser(User.withUsername("admin").password("123456").roles("ADMIN").build());
		return manager;
	}
	
	

	
}
