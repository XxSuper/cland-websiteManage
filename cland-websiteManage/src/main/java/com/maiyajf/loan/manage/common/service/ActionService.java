package com.maiyajf.loan.manage.common.service;

import javax.servlet.http.HttpServletRequest;

public interface ActionService {
  /**
   * 方法名： saveAction 描述：
   * 
   * @author zhuzheng 创建时间：2016年1月11日 下午6:45:20
   * @param request
   * @param actionName 动作名称 （页面：按钮）
   * @param remark 参数
   *
   */
  public void saveAction(HttpServletRequest request, String actionName, Object remark);
}
