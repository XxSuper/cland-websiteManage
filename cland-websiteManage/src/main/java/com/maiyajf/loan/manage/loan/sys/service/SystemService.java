package com.maiyajf.loan.manage.loan.sys.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;

public interface SystemService {
  void saveLoginLog(String sGuid, String sUserNo, String sUserName, Date sLoginDate,
      Date sLogoutDate, String sIp, String sCity, Date sCreateDate);

  void updateLoginLogForLogout(String sGuid, Date sLogoutDate);

  void saveAccessLog(String sGuid, String sUserName, String sUrlAddress, String sPsermisiionNo,
      String sPermissionName, String sIp, String sCity, Date dVisitTime, Date sCreateDate);

  void updateLoginTime(Date date, String userId);

  Map<String, Object> sendLoginSmsCode(String name, String j_captcha, HttpServletRequest request);

  String getCityByIp(long ipInt);

  @Transactional("transactionManager-myLoan")
  String login(HttpServletRequest request, String j_username, String j_password);

  int judgeFirstLogin(String guid);

  public String getSequenceNo(String tableName);
}
