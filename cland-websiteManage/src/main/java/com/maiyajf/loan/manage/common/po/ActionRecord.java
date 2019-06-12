package com.maiyajf.loan.manage.common.po;

import java.util.Date;

public class ActionRecord {

  private String sGuid;
  private String sUserNo;
  private String sUserName;
  private String sUrl;
  private String sActionName;
  private Date dCreateDate;
  private String sIp;
  private String sCity;
  private String sRemark;

  public String getsGuid() {
    return sGuid;
  }

  public void setsGuid(String sGuid) {
    this.sGuid = sGuid;
  }

  public String getsUserNo() {
    return sUserNo;
  }

  public void setsUserNo(String sUserNo) {
    this.sUserNo = sUserNo;
  }

  public String getsUserName() {
    return sUserName;
  }

  public void setsUserName(String sUserName) {
    this.sUserName = sUserName;
  }

  public String getsUrl() {
    return sUrl;
  }

  public void setsUrl(String sUrl) {
    this.sUrl = sUrl;
  }

  public String getsActionName() {
    return sActionName;
  }

  public void setsActionName(String sActionName) {
    this.sActionName = sActionName;
  }

  public Date getdCreateDate() {
    return dCreateDate;
  }

  public void setdCreateDate(Date dCreateDate) {
    this.dCreateDate = dCreateDate;
  }

  public String getsIp() {
    return sIp;
  }

  public void setsIp(String sIp) {
    this.sIp = sIp;
  }

  public String getsCity() {
    return sCity;
  }

  public void setsCity(String sCity) {
    this.sCity = sCity;
  }

  public String getsRemark() {
    return sRemark;
  }

  public void setsRemark(String sRemark) {
    this.sRemark = sRemark;
  }

  public ActionRecord(String sGuid, String sUserNo, String sUserName, String sUrl,
      String sActionName, Date dCreateDate, String sIp, String sCity, String sRemark) {
    super();
    this.sGuid = sGuid;
    this.sUserNo = sUserNo;
    this.sUserName = sUserName;
    this.sUrl = sUrl;
    this.sActionName = sActionName;
    this.dCreateDate = dCreateDate;
    this.sIp = sIp;
    this.sCity = sCity;
    this.sRemark = sRemark;
  }



}
