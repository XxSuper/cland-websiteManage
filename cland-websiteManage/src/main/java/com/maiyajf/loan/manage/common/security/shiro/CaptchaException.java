package com.maiyajf.loan.manage.common.security.shiro;



import org.apache.shiro.authc.AuthenticationException;

/**
 * 
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class CaptchaException extends AuthenticationException {

  private static final long serialVersionUID = 1L;

  /**
   * @Title: CaptchaException
   * @Description: 
   */
  public CaptchaException() {

    super();

  }

  /**
   * @Title: CaptchaException
   * @Description: 
   * @param message
   * @param cause
   */
  public CaptchaException(String message, Throwable cause) {

    super(message, cause);

  }

  /**
   * @Title: CaptchaException
   * @Description: 
   * @param message
   */
  public CaptchaException(String message) {

    super(message);

  }

  /**
   * @Title: CaptchaException
   * @Description: 
   * @param cause
   */
  public CaptchaException(Throwable cause) {

    super(cause);

  }

}
