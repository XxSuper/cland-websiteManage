package com.maiyajf.loan.manage.loan.model.po;

public class XwActivityModelBean {

	private Long id;
	/**
	 * 标题
	 */
	private String sTitle;
	/**
	 * 活动标题图片
	 */
	private String sMediaImage;
	/**
	 * 发布时间
	 */
	private String dPublishDate;
	/**
	 * 修改时间
	 */
	private String dModifyDate;
	/**
	 * 记录状态0：无效1：有效（默认）
	 */
	private Integer iDelFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getsTitle() {
		return sTitle;
	}

	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}

	public String getsMediaImage() {
		return sMediaImage;
	}

	public void setsMediaImage(String sMediaImage) {
		this.sMediaImage = sMediaImage;
	}

	public String getdPublishDate() {
		return dPublishDate;
	}

	public void setdPublishDate(String dPublishDate) {
		this.dPublishDate = dPublishDate;
	}

	public String getdModifyDate() {
		return dModifyDate;
	}

	public void setdModifyDate(String dModifyDate) {
		this.dModifyDate = dModifyDate;
	}

	public Integer getiDelFlag() {
		return iDelFlag;
	}

	public void setiDelFlag(Integer iDelFlag) {
		this.iDelFlag = iDelFlag;
	}

	@Override
	public String toString() {
		return "XwActivityModelBean[id=" + id + ",sTitle=" + sTitle + ",sMediaImage=" + sMediaImage + ",dPublishDate="
				+ dPublishDate + ",dModifyDate=" + dModifyDate + ",iDelFlag=" + iDelFlag + "]";
	}
}