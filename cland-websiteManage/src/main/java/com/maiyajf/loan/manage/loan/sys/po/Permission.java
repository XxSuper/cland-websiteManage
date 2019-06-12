package com.maiyajf.loan.manage.loan.sys.po;

import java.util.Date;

public class Permission {

  private String guid;
  private String permissionNo;
  private String parentId;
  private String permissionUrl;
  private String permissionName;
  private String permissionCode;
  private Date addDate;
  private int iDelFlag;

  public int getiDelFlag() {
    return iDelFlag;
  }

  public void setiDelFlag(int iDelFlag) {
    this.iDelFlag = iDelFlag;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  public String getPermissionNo() {
    return permissionNo;
  }

  public void setPermissionNo(String permissionNo) {
    this.permissionNo = permissionNo;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getPermissionUrl() {
    return permissionUrl;
  }

  public void setPermissionUrl(String permissionUrl) {
    this.permissionUrl = permissionUrl;
  }

  public String getPermissionName() {
    return permissionName;
  }

  public void setPermissionName(String permissionName) {
    this.permissionName = permissionName;
  }

  public String getPermissionCode() {
    return permissionCode;
  }

  public void setPermissionCode(String permissionCode) {
    this.permissionCode = permissionCode;
  }

  public Date getAddDate() {
    return addDate;
  }

  public void setAddDate(Date addDate) {
    this.addDate = addDate;
  }

  @Override
  public String toString() {
    return "Permission [guid=" + guid + ", permissionNo=" + permissionNo + ", parentId=" + parentId
        + ", permissionUrl=" + permissionUrl + ", permissionName=" + permissionName
        + ", permissionCode=" + permissionCode + ", addDate=" + addDate + "]";
  }

}
