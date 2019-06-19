package com.maiyajf.loan.manage.loan.news.po;

public class XwNewsInfoBean {

	private Long id;

	/**
	 * 新闻编号
	 */
	private String sNewsNo;

	/**
	 * 新闻类型 1:公益慈善 2:新闻中心 3:banner 4:印象中地 3:中地历程 4:荣誉资质 5:员工活动 6:旗下品牌 7:文化理念
	 * 8:合作伙伴 9:中地产业 10:董事长致辞
	 */
	private Integer iType;

	/**
	 * 新闻标题
	 */
	private String sTitle;

	/**
	 * 新闻介绍
	 */
	private String sIntroduce;

	/**
	 * 媒体图片（多张|分割）
	 */
	private String sMediaImage;

	/**
	 * 首页banner图
	 */
	private String sBannerImage;

	/**
	 * 超链接
	 */
	private String sLinkUrl;
	/**
	 * 新闻内容
	 */
	private String sNewContent;

	/**
	 * 首页展示（1 展示 0 不展示）
	 */
	private Integer iHomeDisplay;

	/**
	 * 排序序号
	 */
	private Integer iSortNum;

	/**
	 * 发布时间
	 */
	private String dPublishDate;

	/**
	 * 修改时间
	 */
	private String dModifyDate;

	/**
	 * 员工活动模块id
	 */
	private Long sModularId;

	/**
	 * 记录状态0：无效1：有效（默认）
	 */
	private Integer iDelFlag;
	
	private String remark;
	
	private String sWriter;

	public String getsWriter() {
		return sWriter;
	}

	public void setsWriter(String sWriter) {
		this.sWriter = sWriter;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getsNewsNo() {
		return sNewsNo;
	}

	public void setsNewsNo(String sNewsNo) {
		this.sNewsNo = sNewsNo;
	}

	public Integer getiType() {
		return iType;
	}

	public void setiType(Integer iType) {
		this.iType = iType;
	}

	public String getsTitle() {
		return sTitle;
	}

	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}

	public String getsIntroduce() {
		return sIntroduce;
	}

	public void setsIntroduce(String sIntroduce) {
		this.sIntroduce = sIntroduce;
	}

	public String getsMediaImage() {
		return sMediaImage;
	}

	public void setsMediaImage(String sMediaImage) {
		this.sMediaImage = sMediaImage;
	}

	public String getsBannerImage() {
		return sBannerImage;
	}

	public void setsBannerImage(String sBannerImage) {
		this.sBannerImage = sBannerImage;
	}

	public String getsLinkUrl() {
		return sLinkUrl;
	}

	public void setsLinkUrl(String sLinkUrl) {
		this.sLinkUrl = sLinkUrl;
	}

	public String getsNewContent() {
		return sNewContent;
	}

	public void setsNewContent(String sNewContent) {
		this.sNewContent = sNewContent;
	}

	public Integer getiHomeDisplay() {
		return iHomeDisplay;
	}

	public void setiHomeDisplay(Integer iHomeDisplay) {
		this.iHomeDisplay = iHomeDisplay;
	}

	public Integer getiSortNum() {
		return iSortNum;
	}

	public void setiSortNum(Integer iSortNum) {
		this.iSortNum = iSortNum;
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

	public Long getsModularId() {
		return sModularId;
	}

	public void setsModularId(Long sModularId) {
		this.sModularId = sModularId;
	}

	public Integer getiDelFlag() {
		return iDelFlag;
	}

	public void setiDelFlag(Integer iDelFlag) {
		this.iDelFlag = iDelFlag;
	}

	@Override
	public String toString() {
		return "XwNewsInfoBean [id=" + id + ", sNewsNo=" + sNewsNo + ", iType=" + iType + ", sTitle=" + sTitle
				+ ", sIntroduce=" + sIntroduce + ", sMediaImage=" + sMediaImage + ", sBannerImage=" + sBannerImage
				+ ", sLinkUrl=" + sLinkUrl + ", sNewContent=" + sNewContent + ", iHomeDisplay=" + iHomeDisplay
				+ ", iSortNum=" + iSortNum + ", dPublishDate=" + dPublishDate + ", dModifyDate=" + dModifyDate
				+ ", sModularId=" + sModularId + ", iDelFlag=" + iDelFlag + ", remark=" + remark + "]";
	}
}