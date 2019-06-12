package com.maiyajf.loan.manage.common.utils;

import com.maiyajf.base.utils.base.DateUtils;
import com.maiyajf.base.utils.base.IdGen;
import com.maiyajf.base.utils.log.AccessLogger;
import com.maiyajf.loan.manage.common.security.shiro.ShiroUtils;
import com.maiyajf.loan.manage.loan.sys.po.Permission;
import com.maiyajf.loan.manage.loan.sys.service.PermissionService;
import com.maiyajf.loan.manage.loan.sys.service.SystemService;
import com.maiyajf.loan.manage.loan.sys.utils.CommonUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * 
 *    
 * 类名称：AntiXssFilter   
 * @version
 * 类描述：记录访问日志过滤器
 * @version   
 * 创建人：zhuzheng
 * @version
 * 创建时间：2015年11月3日 下午1:00:11 
 * @version  
 * 修改人：zhuzheng     修改时间：2015年11月3日 下午1:00:11 
 * @version
 * 修改备注：   
 *
 */
public class LogFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException, UnsupportedEncodingException {
		HttpServletRequest req = (HttpServletRequest) request;
		//请求url
		StringBuffer url = req.getRequestURL();
		String parms = req.getQueryString();
		if (null != parms) {
			url.append("?");
			url.append(parms);
		}
		//获取客户ip
		String ip = CommonUtil.getClientIP(req);
//		String city = IpUtil.getCityByIp(ip);
		String city = "南京";
		//用户的权限
		Permission permission = getUrlPermission(req.getServletPath());
		String permissionCode = "";
		String permissionName = "";
		if(permission!=null){
			permissionCode = permission.getPermissionNo();
			permissionName = permission.getPermissionName();
		}
		String userName = CommonUtil.getUserName();
		//记录日志
		SystemService service = (SystemService) SpringBeanContainer.getBean("systemServiceImpl");
		service.saveAccessLog(IdGen.uuid(), userName, url.toString(),permissionCode,permissionName, ip, city, new Date(),
				new Date());
		AccessLogger.info(userName, ShiroUtils.getSession().getId().toString(), url.toString(), "WEB", ip, "", DateUtils.getCurrentTime(), parms, "", "", "", 0);
		chain.doFilter(request, response);
	}

	/** 
	 * 方法名：  getUrlPermission 
	 * 描述：  根据url获取权限 
	 * @author  zhuzheng   
	 * 创建时间：2015年11月23日 下午4:06:42
	 * @param url
	 * @return
	 *
	 */
	private Permission getUrlPermission(String url) {
		PermissionService permissionService = 	(PermissionService) SpringBeanContainer.getBean("permissionServiceImpl");
		Permission permission = permissionService.getPermissonByUrl(url);
		return permission;
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
