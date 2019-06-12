package com.maiyajf.loan.manage.common.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maiyajf.loan.manage.common.dao.SMSMsgDao;
import com.maiyajf.loan.manage.common.service.SMSMsgService;

@Service("sMSMsgServiceImpl")
public class SMSMsgServiceImpl implements SMSMsgService {
  @Autowired
  private SMSMsgDao dao;

  @Override
  public String selectById(String SMSMsgNo) {
    return dao.selectById(SMSMsgNo);
  }

  @Override
  public List<Map<String, Object>> selectAllTemplage() {
    return dao.selectAllTemplage();
  }

}
