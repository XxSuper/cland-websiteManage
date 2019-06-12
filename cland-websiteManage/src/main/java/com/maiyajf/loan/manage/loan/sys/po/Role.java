package com.maiyajf.loan.manage.loan.sys.po;

public class Role {

  private String sguid;
  private String sroleNo;
  private String sroleName;
  private String sroleDesc;
  private int iDelFlag;

  public int getiDelFlag() {
    return iDelFlag;
  }

  public void setiDelFlag(int iDelFlag) {
    this.iDelFlag = iDelFlag;
  }

  public String getSguid() {
    return sguid;
  }

  public void setSguid(String sguid) {
    this.sguid = sguid;
  }

  public String getSroleNo() {
    return sroleNo;
  }

  public void setSroleNo(String sroleNo) {
    this.sroleNo = sroleNo;
  }

  public String getSroleName() {
    return sroleName;
  }

  public void setSroleName(String sroleName) {
    this.sroleName = sroleName;
  }

  public String getSroleDesc() {
    return sroleDesc;
  }

  public void setSroleDesc(String sroleDesc) {
    this.sroleDesc = sroleDesc;
  }

  @Override
  public String toString() {
    return "Role [sguid=" + sguid + ", sroleNo=" + sroleNo + ", sroleName=" + sroleName
        + ", sroleDesc=" + sroleDesc + "]";
  }

}
