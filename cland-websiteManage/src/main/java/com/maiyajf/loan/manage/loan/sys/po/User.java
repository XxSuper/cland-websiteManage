package com.maiyajf.loan.manage.loan.sys.po;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

  /**
   * @Fields serialVersionUID
   */
  private static final long serialVersionUID = -8547446146305027499L;
  private String guid;
  private String userNo;
  private String mobile;
  private String email;
  private String userName;
  private String password;
  private Integer status;
  private String remark;
  private Date createDate;
  private Date modifyDate;
  private String job;
  private String phone;
  private String realName;
  private Integer bisFreeze;
  private Integer bisAdmin;
  private Date lastLoginTime;
  private String departmentId;
  private String sDepartmentName;
  private String sCreatePerson;
  private String sCheckPerson;
  private String sModifyPerson;
  private int iDelFlag;

  public String getsDepartmentName() {
    return sDepartmentName;
  }

  public void setsDepartmentName(String sDepartmentName) {
    this.sDepartmentName = sDepartmentName;
  }

  public String getsCreatePerson() {
    return sCreatePerson;
  }

  public void setsCreatePerson(String sCreatePerson) {
    this.sCreatePerson = sCreatePerson;
  }

  public String getsCheckPerson() {
    return sCheckPerson;
  }

  public void setsCheckPerson(String sCheckPerson) {
    this.sCheckPerson = sCheckPerson;
  }


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

  public String getUserNo() {
    return userNo;
  }

  public void setUserNo(String userNo) {
    this.userNo = userNo;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getBisFreeze() {
    return bisFreeze;
  }

  public void setBisFreeze(Integer bisFreeze) {
    this.bisFreeze = bisFreeze;
  }

  public Integer getBisAdmin() {
    return bisAdmin;
  }

  public void setBisAdmin(Integer bisAdmin) {
    this.bisAdmin = bisAdmin;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(Date modifyDate) {
    this.modifyDate = modifyDate;
  }

  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public String getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(String departmentId) {
    this.departmentId = departmentId;
  }

  public String getsModifyPerson() {
    return sModifyPerson;
  }

  public void setsModifyPerson(String sModifyPerson) {
    this.sModifyPerson = sModifyPerson;
  }

  @Override
  public String toString() {
    return "User [guid=" + guid + ", userNo=" + userNo + ", mobile=" + mobile + ", email=" + email
        + ", userName=" + userName + ", password=" + "" + ", status=" + status + ", remark="
        + remark + ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", job=" + job
        + ", phone=" + phone + ", realName=" + realName + ", bisFreeze=" + bisFreeze + ", bisAdmin="
        + bisAdmin + ", lastLoginTime=" + lastLoginTime + ", departmentId=" + departmentId + "]";
  }

}
