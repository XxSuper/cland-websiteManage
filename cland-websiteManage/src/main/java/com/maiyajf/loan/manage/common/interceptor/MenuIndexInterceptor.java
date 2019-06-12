/**   
 * @Title: MenuIndexInterceptor.java 
 * @Package: com.maiya.gcs.admin.web.common.interceptor
 * @company: 麦芽数据
 * @Description: TODO
 * @date 2017年5月31日 下午3:45:33 
 * @version V1.0   
 */
package com.maiyajf.loan.manage.common.interceptor;

import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/** 
 * 首页左边菜单选中效果拦截器
 * @ClassName: MenuIndexInterceptor 
 * @Description: TODO
 * @author yang 
 * @date 2016年9月5日 下午6:45:33 
 *  
 */
public class MenuIndexInterceptor implements HandlerInterceptor {
	
	

	/* (非 Javadoc) 
	 * <p>Title: preHandle</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception 
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object) 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String menu_index = request.getParameter("menu_index");
		if(StringUtils.isNotBlank(menu_index)) {
			request.getSession().setAttribute("menu_index", menu_index);
		}
		String child_index = request.getParameter("child_index");
		if(StringUtils.isNotBlank(child_index)) {
			request.getSession().setAttribute("child_index", child_index);
		}
		long head = System.currentTimeMillis() % 86400000;
		long body = Thread.currentThread().getId();
		int foot = ThreadLocalRandom.current().nextInt(1000);
		String token = head + "_" + body + "_" + foot;
		MDC.put("token", token);
		return true;
	}

	/* (非 Javadoc) 
	 * <p>Title: postHandle</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception 
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView) 
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (非 Javadoc) 
	 * <p>Title: afterCompletion</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception 
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception) 
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
