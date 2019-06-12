package com.maiyajf.loan.manage.common.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.maiyajf.base.utils.log.SystemLogger;

@SuppressWarnings("serial")
public class SpringBeanContainer extends HttpServlet {

	private static WebApplicationContext context;
	
	public void init() throws ServletException {
		SpringBeanContainer.context = WebApplicationContextUtils
				.getWebApplicationContext(this.getServletContext());
		SystemLogger.info("注入ApplicationContext到SpringContextHolder:" + context);
	}

	// 通过bean名字获取
	public static Object getBean(String beanName) {
		Object bean = context.getBean(beanName);
		return bean;
	}

	@Override
	public void destroy() {
		SystemLogger.info("清除SpringContextHolder中的ApplicationContext:" + context);
		context = null;
	}

	// 通过bean类型获取
	public static Object getBean(Class clz) {
		Object bean = context.getBean(clz);
		return bean;
	}
	
	// 通过类泛型获取
	public static <T> T getBeanG(Class<T> clz) {
		T bean = (T)context.getBean(clz);
		return bean;
	}
}