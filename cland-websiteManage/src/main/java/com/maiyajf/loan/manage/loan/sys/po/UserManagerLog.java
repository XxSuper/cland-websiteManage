package com.maiyajf.loan.manage.loan.sys.po;

import java.util.Date;

public class UserManagerLog {
  private String sGuid;// 否 主键
  private String sUserID;// 否 目标用户ID
  private Integer iOperatorType;// 是 操作类型 10：注册，11：禁用，12：删除，13：启用20：权限变更
  private String sSrcRoles;// 是 原有角色：角色名称，用||分隔
  private String sTargetRoles;// 是 现有角色：角色名称，用||分隔
  private String sOperatorID;// 否 操作人ID
  private Date dOperatorDate;// Date 是 操作日期

  public String getsGuid() {
    return sGuid;
  }

  public void setsGuid(String sGuid) {
    this.sGuid = sGuid;
  }

  public String getsUserID() {
    return sUserID;
  }

  public void setsUserID(String sUserID) {
    this.sUserID = sUserID;
  }

  public Integer getiOperatorType() {
    return iOperatorType;
  }

  public void setiOperatorType(Integer iOperatorType) {
    this.iOperatorType = iOperatorType;
  }

  public String getsSrcRoles() {
    return sSrcRoles;
  }

  public void setsSrcRoles(String sSrcRoles) {
    this.sSrcRoles = sSrcRoles;
  }

  public String getsTargetRoles() {
    return sTargetRoles;
  }

  public void setsTargetRoles(String sTargetRoles) {
    this.sTargetRoles = sTargetRoles;
  }

  public String getsOperatorID() {
    return sOperatorID;
  }

  public void setsOperatorID(String sOperatorID) {
    this.sOperatorID = sOperatorID;
  }

  public Date getdOperatorDate() {
    return dOperatorDate;
  }

  public void setdOperatorDate(Date dOperatorDate) {
    this.dOperatorDate = dOperatorDate;
  }


}
