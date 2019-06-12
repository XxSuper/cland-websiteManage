package com.maiyajf.loan.manage.loan.sys.dao;

import java.util.Date;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.maiyajf.loan.manage.loan.sys.po.UserManagerLog;

public interface SystemDao {
  /**
   * 方法名： saveLoginLog 描述： 记录登录日志
   * 
   * @author zhuzheng 创建时间：2015年11月27日 下午3:23:54
   * @param sGuid
   * @param sUserNo
   * @param sUserName
   * @param sLoginDate
   * @param sLogoutDate
   * @param sIp
   * @param sCity
   * @param sCreateDate
   *
   */
  void saveLoginLog(@Param(value = "sGuid") String sGuid, @Param(value = "sUserNo") String sUserNo,
      @Param(value = "sUserName") String sUserName, @Param(value = "sLoginDate") Date sLoginDate,
      @Param(value = "sLogoutDate") Date sLogoutDate, @Param(value = "sIp") String sIp,
      @Param(value = "sCity") String sCity, @Param(value = "sCreateDate") Date sCreateDate);

  /**
   * 方法名： updateLoginLogForLogout 描述： 更新退出时间
   * 
   * @author zhuzheng 创建时间：2015年11月27日 下午3:24:20
   * @param sGuid
   * @param sLogoutDate
   *
   */
  void updateLoginLogForLogout(@Param(value = "sGuid") String sGuid,
      @Param(value = "sLogoutDate") Date sLogoutDate);

  /**
   * 方法名： saveAccessLog 描述： 记录访问日志
   * 
   * @author zhuzheng 创建时间：2015年11月27日 下午3:24:46
   * @param sGuid
   * @param sUserName
   * @param sUrlAddress
   * @param sPermissionNo
   * @param sPermissionName
   * @param sIp
   * @param sCity
   * @param dVisitTime
   * @param sCreateDate
   *
   */
  void saveAccessLog(@Param(value = "sGuid") String sGuid,
      @Param(value = "sUserName") String sUserName,
      @Param(value = "sUrlAddress") String sUrlAddress,
      @Param(value = "sPermissionNo") String sPermissionNo,
      @Param(value = "sPermissionName") String sPermissionName, @Param(value = "sIp") String sIp,
      @Param(value = "sCity") String sCity, @Param(value = "dVisitTime") Date dVisitTime,
      @Param(value = "sCreateDate") Date sCreateDate);

  void saveManageLog(UserManagerLog log);

  void updateLoginTime(@Param(value = "date") Date date, @Param(value = "userId") String userId);

  String getCityByIp(long ip);

  int judgeFirstLogin(String sUserNo);

  /**
   * 
   * @param params
   */
  public String querySequenceNo(Map<String, String> params);
}
