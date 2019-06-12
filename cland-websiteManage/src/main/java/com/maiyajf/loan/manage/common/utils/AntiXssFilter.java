package com.maiyajf.loan.manage.common.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *    
 * 类名称：AntiXssFilter   
 * @version
 * 类描述：基于黑名单的xss过滤器
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
public class AntiXssFilter implements Filter {

	public void destroy() {

	}

	/* (non Javadoc)
	 * @Title: doFilter
	 * @Description: 
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 * @throws UnsupportedEncodingException
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException, UnsupportedEncodingException {
		HttpServletRequest req = (HttpServletRequest) request;
		Map<String, String[]> parameterMap = req.getParameterMap();
		 String method = req.getMethod();
		for (Object key : parameterMap.keySet()) {
			String[] val = (String[]) parameterMap.get(key);
			for (String v : val) {
				 if(method.equalsIgnoreCase("get")){//处理get请求时的编码问题
				v = URLDecoder.decode(URLDecoder.decode(v, "utf-8"), "utf-8");
				 }
				if (existsXssElement(v)) {
					HttpServletResponse res = (HttpServletResponse) response;
					res.sendError(404);
					return;
				}
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

	/**
	 * 黑名单
	 * existsXssElement  
	 * @param    
	 * @return  
	 * @throws 
	 * @author zhuzheng
	 * @date   2015年11月2日 下午1:12:16
	 */
	private boolean existsXssElement(String s) throws UnsupportedEncodingException {
		boolean res = false;
		if (s.indexOf("\n\r") != -1 || s.indexOf("\r\n") != -1 || s.indexOf("\\x") != -1 || s.indexOf("&#") != -1) {
			res = true;
		} else {
			s = s.toLowerCase();
			res = getIncludeSqlSpecialCharsFlag(s);
			if (!res) {
				res = getIncludeHtmlSpecialCharsFlag(s);
			}
		}
		return res;
	}

	/**
	 * 替换一些特殊字符
	 * replaceSpecialChars  
	 * @param    
	 * @return  
	 * @throws 
	 * @author zhuzheng
	 * @date   2015年11月2日 下午1:12:16
	 */
	private String replaceSpecialChars(String s) throws UnsupportedEncodingException {
//		String specialChar = "";
//		s = s.replaceAll("(\r|\n|\t|\f|'|\")", "");
//		s = s.replaceAll("(\r|\n|\t|\f|'|\")", "");
//		int specialCharsLen = specailCharArray.length;
//		for (int i = 0; i < specialCharsLen; i++) {
//			specialChar = specailCharArray[i];
//			specialChar = URLDecoder.decode(URLDecoder.decode(specialChar, "utf-8"), "utf-8");
//			s = s.replaceAll(specialChar, "");
//		}
//		return s;
	   return s.replaceAll("(^|\\&)|(\\|)|(\\;)|(\\$)|(\\%)|(\\@)|(\\')|(\\\")|(\\>)|(\\<)|(\\))|(\\()|(\\+)|(\\,)|(\\\\)|(\\#|$)","");
	}

	/**
	 * 判断是否包含html特殊字符 
	 * getIncludeHtmlSpecialCharsFlag  
	 * @param    
	 * @return  
	 * @throws UnsupportedEncodingException 
	 * @throws 
	 * @author zhuzheng
	 * @date   2015年11月2日 下午1:12:16
	 */
	private boolean getIncludeHtmlSpecialCharsFlag(String s) throws UnsupportedEncodingException {
		boolean res = false;
		s = replaceSpecialChars(s);
		if ( // XSS黑名单
		s.indexOf("javascript:") != -1 || s.indexOf("document.cookie") != -1 || s.indexOf("<script") != -1
				|| s.indexOf("<iframe") != -1 || s.indexOf("\"><script>") != -1 || s.indexOf("\"<script>") != -1
				|| s.indexOf("<img") != -1 || s.indexOf("onclick=") != -1 || s.indexOf("<style") != -1
				|| s.indexOf(")//") != -1 || s.indexOf("\">") != -1 || s.indexOf("<body") != -1
				|| s.indexOf("/xss/") != -1 || s.indexOf("onfocus") != -1
				|| s.indexOf("alert") != -1 // || s.indexOf(";") != -1
				|| s.indexOf("fromcharcode") != -1 || s.indexOf("eval") != -1 || s.indexOf("<a") != -1
				|| s.indexOf("cookie") != -1 || s.indexOf("document.write") != -1) {
			res = true;
		}
		return res;
	}

	/**
	 * 判断是否包含sql特殊字符 
	 * getIncludeSqlSpecialCharsFlag  
	 * @param    
	 * @return  
	 * @throws 
	 * @author zhuzheng
	 * @date   2015年11月2日 下午1:12:16
	 */
	private boolean getIncludeSqlSpecialCharsFlag(String str) {
		// 过滤掉的sql关键字，可以手动添加
		String badStr = "'|and |exec |execute |insert |select |delete |update |count|*|"
				+ "char|declare|sitename|net user|xp_cmdshell|like |create |drop |"
				+ "table|from |grant |use |group_concat|column_name|"
				+ "information_schema.columns|table_schema|union |where |order |by |"
				+ "chr|mid|master|truncate |or ";
		String[] badStrs = badStr.split("\\|");
		for (int i = 0; i < badStrs.length; i++) {
			if (str.indexOf(badStrs[i]) >= 0) {
				return true;
			}
		}
		return false;
	}

	private String[] specailCharArray = { "%00", "%2B", "%25E3%2580%2580" };

}
