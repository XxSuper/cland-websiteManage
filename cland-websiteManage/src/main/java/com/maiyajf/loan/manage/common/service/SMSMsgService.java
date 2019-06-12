package com.maiyajf.loan.manage.common.service;

import java.util.List;
import java.util.Map;

public interface SMSMsgService {
  public String selectById(String SMSMsgNo);

  public List<Map<String, Object>> selectAllTemplage();

}
