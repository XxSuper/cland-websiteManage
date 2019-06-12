package com.maiyajf.loan.manage.loan.sys.po;

public class UserRole {

  private String guid;
  private String userId;
  private String roleId;
  private int iDelFlag;

  public int getiDelFlag() {
    return iDelFlag;
  }

  public void setiDelFlag(int iDelFlag) {
    this.iDelFlag = iDelFlag;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

}
