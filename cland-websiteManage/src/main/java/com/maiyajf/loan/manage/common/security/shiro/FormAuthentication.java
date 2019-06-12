package com.maiyajf.loan.manage.common.security.shiro;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.common.security.shiro.vo.Authorization;

 
/**
 * @ClassName: FormAuthentication
 * @Description: 表单认证
 * @author: zhuangsheng.chen
 * @date: 2016年2月23日 上午10:25:58
 */
public class FormAuthentication extends FormAuthenticationFilter {

  public static final String FAIL_URL = "/sys/loginFail";

  @Override
  protected String getUsername(ServletRequest request) {
    String username = super.getUsername(request);
    // 将初始带符号的用户名保存起来
    ShiroUtils.putToSession(ShiroUtils.ORIGIN_NAME_KEY, username);
    if (username != null) {
      username = ShiroUtils.getRealUserName(username);
    }
    return username;
  }

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response,
      Object mappedValue) throws Exception {
    if (request.getAttribute(getFailureKeyAttribute()) != null) {
      return true;
    }
    return super.onAccessDenied(request, response, mappedValue);
  }

  @Override
  protected String getPassword(ServletRequest request) {
    String password = super.getPassword(request);  
    return password;
  }

  @Override
  protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e,
      ServletRequest request, ServletResponse response) {
    if ((String) ShiroUtils.getSessionAttribute(ShiroUtils.AUTHORIZATION_EXCEPTION_KEY) != null)
      ShiroUtils.putToSession(ShiroUtils.AUTHORIZATION_EXCEPTION_KEY,
          Authorization.AUTHORIZATION_USERNAME_FAIL);
    try {
      ShiroUtils.removeSessionAttribute(ShiroUtils.AUTHORIZATION_KEY);
      WebUtils.redirectToSavedRequest(request, response, FAIL_URL);
    } catch (IOException e1) {
      ExceptionLogger.error(e1);
    }

    return false;
  }

  @Override
  protected boolean onLoginSuccess(AuthenticationToken token, Subject subject,
      ServletRequest request, ServletResponse response) throws Exception {

    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    String url = this.getSuccessUrl();
    httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + url);
    return false;
  }

}
