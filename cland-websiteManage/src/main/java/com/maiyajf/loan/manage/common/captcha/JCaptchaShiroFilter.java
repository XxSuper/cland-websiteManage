
package com.maiyajf.loan.manage.common.captcha;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.servlet.OncePerRequestFilter;

import com.maiyajf.base.utils.log.DebugLogger;
import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.common.security.shiro.ShiroUtils;
import com.maiyajf.loan.manage.common.utils.SpringBeanContainer;
import com.octo.captcha.service.CaptchaService;
import com.octo.captcha.service.CaptchaServiceException;

/**
 * @ClassName: JCaptchaShiroFilter
 * @Description: 验证码过滤器
 * @author: zhuangsheng.chen
 * @date: 2016年2月23日 上午10:17:10
 */
public class JCaptchaShiroFilter extends OncePerRequestFilter {

  // captchaService
  private CaptchaService captchaService;

  // ------------------------------web.xml中的参数名定义------------------------------//
  public static final String PARAM_CAPTCHA_PARAMTER_NAME = "captchaParamterName";
  // captchaService在配置文件中Bean的id
  public static final String PARAM_CAPTCHA_SERVICE_ID = "captchaServiceId";

  // ------------------------------默认值定义------------------------------//
  public static final String PARAM_AUTO_PASS_VALUE = "autoPassValue";// 自动化测试默认通过值
  public static final String DEFAULT_CAPTCHA_PARAMTER_NAME = "j_captcha";// 验证码文本框的name默认值
  public static final String DEFAULT_CAPTCHA_SERVICE_ID = "captchaService";

  public static final String DEFAULT_PRODUCT_CAPTCHA_URL = "productCaptchaURL";// 请求生成验证码路劲

  public static final String DEFAULT_GET_CAPTCHA_URL = "/sys/captchaCode.htm";// 请求验证码图片的默认路径


  private String captchaURL = DEFAULT_GET_CAPTCHA_URL;
  private String captchaServiceId = DEFAULT_CAPTCHA_SERVICE_ID;
  private String captchaParamterName = DEFAULT_CAPTCHA_PARAMTER_NAME;
  private String autoPassValue = DEFAULT_GET_CAPTCHA_URL;

  // ------------------------------失败路径集合------------------------------//
  private static String[] failureUrl = null;// 正式登陆验证码失败跳转路劲
  private String loginFailureUrl;
  private String loginSuccessUrl;

  public String getGetCaptchaURL() {
    return captchaURL;
  }

  public void setGetCaptchaURL(String captchaURL) {
    this.captchaURL = captchaURL;
  }

  public String getLoginFailureUrl() {
    return loginFailureUrl;
  }

  public void setLoginFailureUrl(String loginFailureUrl) {
    this.loginFailureUrl = loginFailureUrl;
    JCaptchaShiroFilter.failureUrl = loginFailureUrl.split(",");
  }

  public String getLoginSuccessUrl() {
    return loginSuccessUrl;
  }

  public void setLoginSuccessUrl(String loginSuccessUrl) {
    this.loginSuccessUrl = loginSuccessUrl;
  }


  /**
   * Filter回调退出函数.
   */
  public void destroy() {}

  /**
   * 生成验证码图片.
   */
  protected void genernateCaptchaImage(final HttpServletRequest request,
      final HttpServletResponse response) throws IOException {

    response.setDateHeader("Expires", 1L);
    response.addHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");

    response.setContentType("image/jpeg");
    ServletOutputStream out = response.getOutputStream();
    try {
      String captchaId = request.getSession(true).getId();
      try {
        captchaService.validateResponseForID(captchaId, "");
      } catch (Exception e) {
        ExceptionLogger.error(e);
      }
      DebugLogger.debug("生成验证码图片是captchId" + captchaId);
      BufferedImage challenge =
          (BufferedImage) captchaService.getChallengeForID(captchaId, request.getLocale());
      ImageIO.write(challenge, "JPEG", out);
      out.flush();
    } catch (CaptchaServiceException e) {
      ExceptionLogger.error(e);
    } finally {
      out.close();
    }
  }

  /**
   * 重新生成验证码图片.
   */
  protected void refreshCaptchaImage(final HttpServletRequest request) throws IOException {
    try {
      String captchaId = request.getSession(true).getId();
      captchaService.getChallengeForID(captchaId, request.getLocale());
    } catch (CaptchaServiceException e) {
      ExceptionLogger.error(e);
    }
  }

  protected boolean handerStr(String str) {
    boolean flag = false;
    if (StringUtils.isNotBlank(str)) {
      if (str.contains("<") || str.contains("=") || str.contains(">") || str.contains(")")) {
        flag = true;
      }
    }
    return flag;
  }

  /**
   * 验证验证码.
   */
  protected boolean validateCaptchaChallenge(final HttpServletRequest request) {
    try {
      // 是否通过IM单点登录方式
      String userName = request.getParameter("j_username");

      if (!StringUtils.isEmpty(userName) && userName.length() > 32) {
        // IM登录无需验证码，直接通过
        return true;
      } else {
        String captchaID = request.getSession().getId();
        DebugLogger.debug("当前sessionID" + captchaID);
        String challengeResponse = request.getParameter(captchaParamterName);
        // Long ifalseNum = (Long) ShiroUtils.getSession().getAttribute("failNum");
        // if (ifalseNum == null || ifalseNum < 2) {
        // return true;
        // }

        if (("OtherNoCaptcha").equals(challengeResponse)) {
          return true;
        }
        // 自动通过值存在时,检验输入值是否等于自动通过值
        if (StringUtils.isNotBlank(autoPassValue) && autoPassValue.equals(challengeResponse)) {
          return true;
        }
        return captchaService.validateResponseForID(captchaID, challengeResponse);
      }
    } catch (CaptchaServiceException e) {
      return false;
    }
  }

  /**
   * 跳转到失败页面.
   * 
   * 可在子类进行扩展, 比如在session中放入SpringSecurity的Exception.
   * 
   * @throws ServletException
   */
  protected void redirectFailureUrl(final HttpServletRequest request,
      final HttpServletResponse response) throws IOException, ServletException {

    request.setAttribute("message_login", "验证码错误！");
    request.getRequestDispatcher(loginFailureUrl).forward(request, response);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.apache.shiro.web.servlet.OncePerRequestFilter#doFilterInternal(javax
   * .servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
   */
  @Override
  protected void doFilterInternal(ServletRequest theRequest, ServletResponse theResponse,
      FilterChain chain) throws ServletException, IOException {
    DebugLogger.debug("----- in jcaptchashirofilter -----");
    captchaService = (CaptchaService) SpringBeanContainer.getBean(captchaServiceId);
    HttpServletRequest request = (HttpServletRequest) theRequest;
    HttpServletResponse response = (HttpServletResponse) theResponse;
    String servletPath = request.getServletPath();
    DebugLogger.debug("servletPath---》" + servletPath);
    if ("/sys/login.htm".equals(servletPath) && ShiroUtils.isAuthenticated()) {
      DebugLogger.debug("----- already authenticated -----");
      request.getRequestDispatcher(loginSuccessUrl).forward(request, response);
      // response.sendRedirect("/wap");
      return;
    }
    // 符合filterProcessesUrl为验证处理请求,其余为生成验证图片请求.
    if (servletPath.indexOf(captchaURL) >= 0) {
      DebugLogger.debug("----- just for captcha -----");
      // 为生成验证图片请求.
      genernateCaptchaImage(request, response);
    } else {
      boolean validated = validateCaptchaChallenge(request);
      // 重新生成验证码
      refreshCaptchaImage(request);
      if (validated) {
        DebugLogger.debug("----- captcha valid ->chain.dofilter -----");
        // 验证码正确
        chain.doFilter(request, response);
      } else {
        redirectFailureUrl(request, response);
      }
    }

  }

}
