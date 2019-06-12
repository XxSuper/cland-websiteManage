package com.maiyajf.loan.manage.common.security.shiro;



import org.apache.shiro.authc.AuthenticationException;

/**
 * 
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
public class SmsException extends AuthenticationException {

  private static final long serialVersionUID = 1L;

  public SmsException() {

    super();

  }

  public SmsException(String message, Throwable cause) {

    super(message, cause);

  }

  public SmsException(String message) {

    super(message);

  }

  public SmsException(Throwable cause) {

    super(cause);

  }

}
