package com.maiyajf.loan.manage.common.dao;

import java.util.Map;

public interface UtilDao {
  
  /**
   * @Title: getLastLoginInfo
   * @Description: 最后登录信息获取
   * @param userId
   * @return
   * @return: Map<String,Object>
   */
  Map<String, Object> getLastLoginInfo(String userId);

  String getCityByIp(long ipInt);
}
