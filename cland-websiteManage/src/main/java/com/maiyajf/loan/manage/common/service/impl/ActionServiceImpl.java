package com.maiyajf.loan.manage.common.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.common.dao.ActionRecordDao;
import com.maiyajf.loan.manage.common.po.ActionRecord;
import com.maiyajf.loan.manage.common.security.shiro.ShiroUtils;
import com.maiyajf.loan.manage.common.service.ActionService;
import com.maiyajf.base.utils.base.IdGen;
import com.maiyajf.loan.manage.common.utils.IpUtil;
import com.maiyajf.loan.manage.loan.sys.po.User;
import com.maiyajf.loan.manage.loan.sys.utils.CommonUtil;

/**
 * 项目名称： myLoan-manage 类名称： ActionServiceImpl 描述： 用于记录后台用户的操作动作
 * 
 * @author zhuzheng 创建时间： 2016年1月11日 上午10:00:03 修改人：zhuzheng 修改日期： 2016年1月11日 修改备注：
 *
 */
@Service("actionServiceImpl")
public class ActionServiceImpl implements ActionService {

  @Autowired
  private ActionRecordDao actionRecordDao;

  /**
   * 方法名： saveAction 描述： 保存操作记录
   * 
   * @author zhuzheng 创建时间：2016年1月11日 下午5:38:34
   * @param request
   * @param sActionName not null
   * @param sRemark not null
   * @see com.maiyajf.loan.manage.common.service.ActionService#saveAction(javax.servlet.http.HttpServletRequest,
   *      java.lang.String, java.lang.Object)
   *
   */
  public void saveAction(HttpServletRequest request, String actionName, Object remark) {
    HttpServletRequest req = (HttpServletRequest) request;
    try {
      // 请求url
      StringBuffer url = req.getRequestURL();
      // 获取客户ip
      String ip = CommonUtil.getClientIP(req);
      String city = IpUtil.getCityByIp(ip);
      User user = ShiroUtils.getCurrentUser();
      String userNo = user.getUserNo() == null ? "" : user.getUserNo();
      String userName = user.getUserNo() == null ? "" : user.getUserName();
      String remarkTemp = remark.toString();
      if (remarkTemp.getBytes().length > 1000) {
        remarkTemp = remarkTemp.substring(0, 300) + "...";
      }
      ActionRecord record = new ActionRecord(IdGen.uuid(), userNo, userName, url.toString(),
        actionName, new Date(), ip, city, remarkTemp);
      actionRecordDao.saveAction(record);
    } catch (Exception e) {
      ExceptionLogger.error("ActionServiceImpl", "参数:" + remark.toString(), e);
    }

  }
}
