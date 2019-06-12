package com.maiyajf.loan.manage.common.dao;

import java.util.List;
import java.util.Map;

public interface SMSMsgDao {
  public String selectById(String SMSMsgNo);

  public List<Map<String, Object>> selectAllTemplage();
}
