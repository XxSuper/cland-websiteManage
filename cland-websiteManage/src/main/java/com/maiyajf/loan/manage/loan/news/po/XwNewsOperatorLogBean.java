package com.maiyajf.loan.manage.loan.news.po;

public class XwNewsOperatorLogBean {

	private String sGuid;

	/**
	 * 新闻编号
	 */
	private String sNewsId;

	/**
	 * 新闻编号
	 */
	private String sNewsNo;

	/**
	 * 操作类型1：审核通过2：审核拒绝3: 删除
	 */
	private Integer sOperatorResult;

	/**
	 * 备注
	 */
	private String sRemark;

	/**
	 * 操作人
	 */
	private String sOperatorPerson;

	/**
	 * 修改时间
	 */
	private String dCreateDate;

	public String getsGuid() {
		return sGuid;
	}

	public void setsGuid(String sGuid) {
		this.sGuid = sGuid;
	}

	public String getsNewsId() {
		return sNewsId;
	}

	public void setsNewsId(String sNewsId) {
		this.sNewsId = sNewsId;
	}

	public String getsNewsNo() {
		return sNewsNo;
	}

	public void setsNewsNo(String sNewsNo) {
		this.sNewsNo = sNewsNo;
	}

	public Integer getsOperatorResult() {
		return sOperatorResult;
	}

	public void setsOperatorResult(Integer sOperatorResult) {
		this.sOperatorResult = sOperatorResult;
	}

	public String getsRemark() {
		return sRemark;
	}

	public void setsRemark(String sRemark) {
		this.sRemark = sRemark;
	}

	public String getsOperatorPerson() {
		return sOperatorPerson;
	}

	public void setsOperatorPerson(String sOperatorPerson) {
		this.sOperatorPerson = sOperatorPerson;
	}

	public String getdCreateDate() {
		return dCreateDate;
	}

	public void setdCreateDate(String dCreateDate) {
		this.dCreateDate = dCreateDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("XwNewsOperatorLogBean [sGuid=").append(sGuid).append(", sNewsId=").append(sNewsId)
				.append(", sNewsNo=").append(sNewsNo).append(", sOperatorResult=").append(sOperatorResult)
				.append(", sRemark=").append(sRemark).append(", sOperatorPerson=").append(sOperatorPerson)
				.append(", dCreateDate=").append(dCreateDate).append("]");
		return builder.toString();
	}

}