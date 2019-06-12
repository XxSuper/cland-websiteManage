package com.maiyajf.base.card.po;

import java.io.Serializable;

public class ZdBankNoConfigPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String sGuid;

	private String bankNo;

	private String bankName;

	private String iDelFlag;

	private String icon;

	private String sBankCode;

	private String sSimpleCode;
	
	private int iQuickPass;// 快捷支付
	
	private int iCollection;// 代扣
	
	private int iPay;// 代付
	
	private int iCertification;// 实名认证

	public String getsGuid() {
		return sGuid;
	}

	public void setsGuid(String sGuid) {
		this.sGuid = sGuid;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getiDelFlag() {
		return iDelFlag;
	}

	public void setiDelFlag(String iDelFlag) {
		this.iDelFlag = iDelFlag;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getsBankCode() {
		return sBankCode;
	}

	public void setsBankCode(String sBankCode) {
		this.sBankCode = sBankCode;
	}

	public String getsSimpleCode() {
		return sSimpleCode;
	}

	public void setsSimpleCode(String sSimpleCode) {
		this.sSimpleCode = sSimpleCode;
	}

	public int getiQuickPass() {
		return iQuickPass;
	}

	public void setiQuickPass(int iQuickPass) {
		this.iQuickPass = iQuickPass;
	}

	public int getiCollection() {
		return iCollection;
	}

	public void setiCollection(int iCollection) {
		this.iCollection = iCollection;
	}

	public int getiPay() {
		return iPay;
	}

	public void setiPay(int iPay) {
		this.iPay = iPay;
	}

	public int getiCertification() {
		return iCertification;
	}

	public void setiCertification(int iCertification) {
		this.iCertification = iCertification;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ZdBankNoConfigPO [sGuid=");
		builder.append(sGuid);
		builder.append(", bankNo=");
		builder.append(bankNo);
		builder.append(", bankName=");
		builder.append(bankName);
		builder.append(", iDelFlag=");
		builder.append(iDelFlag);
		builder.append(", icon=");
		builder.append(icon);
		builder.append(", sBankCode=");
		builder.append(sBankCode);
		builder.append(", sSimpleCode=");
		builder.append(sSimpleCode);
		builder.append(", iQuickPass=");
		builder.append(iQuickPass);
		builder.append(", iCollection=");
		builder.append(iCollection);
		builder.append(", iPay=");
		builder.append(iPay);
		builder.append(", iCertification=");
		builder.append(iCertification);
		builder.append("]");
		return builder.toString();
	}
}
