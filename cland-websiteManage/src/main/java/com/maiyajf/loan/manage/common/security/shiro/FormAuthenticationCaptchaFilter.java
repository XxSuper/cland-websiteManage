package com.maiyajf.loan.manage.common.security.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 * 
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class FormAuthenticationCaptchaFilter extends FormAuthenticationFilter {

  public static final String DEFAULT_CAPTCHA_PARAM = "j_captcha";

  private String captchaParam = DEFAULT_CAPTCHA_PARAM;

  /**
   * @Title: getCaptchaParam
   * @Description: 获取参数
   * @return
   * @return: String
   */
  public String getCaptchaParam() {

    return captchaParam;

  }

  protected String getCaptcha(ServletRequest request) {

    return WebUtils.getCleanParam(request, getCaptchaParam());

  }


  @Override
  protected AuthenticationToken createToken(

      ServletRequest request, ServletResponse response) {

    String username = getUsername(request);

    String password = getPassword(request);

    String captcha = getCaptcha(request);

    boolean rememberMe = isRememberMe(request);

    String host = getHost(request);

    return new UsernamePasswordCaptchaToken(username, password, rememberMe, host, captcha);

  }

  @Override
  protected boolean executeLogin(ServletRequest request, ServletResponse response)
      throws Exception {
    // TODO Auto-generated method stub
    UsernamePasswordCaptchaToken token =
        (UsernamePasswordCaptchaToken) createToken(request, response);
    try {
      /* 图形验证码验证 */
      doCaptchaValidate((HttpServletRequest) request, token);
      Subject subject = getSubject(request, response);
      subject.login(token);// 正常验证

      return onLoginSuccess(token, subject, request, response);
    } catch (AuthenticationException e) {

      return onLoginFailure(token, e, request, response);
    }
  }

  // 验证码校验
  protected void doCaptchaValidate(HttpServletRequest request, UsernamePasswordCaptchaToken token) {
    // session中的图形码字符串
    String captcha = (String) request.getSession().getAttribute(captchaParam);
    // 比对
    if (captcha != null && !captcha.equalsIgnoreCase(token.getCaptcha())) {
      throw new CaptchaException("验证码错误！");
    }
  }

  @Override
  protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
    // TODO Auto-generated method stub
    request.setAttribute(getFailureKeyAttribute(), ae);
  }
}
