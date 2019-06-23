/**
 * 
 */
package com.maiyajf.loan.manage.loan.news.params;

import java.util.Date;

/**
 * @author chao.xu
 * @version 创建时间：2017年10月11日 下午5:26:37
 */
public class QueyNewsParams {
	
	private Integer iType;// 新闻类型
	
	/**
	 * 首页展示（1 展示 0 不展示）
	 */
	private Integer iHomeDisplay;
	
	private Integer recordStart;// 开始记录
	
	private Integer recordEnd;// 结束记录

	private Integer sModularId;// 员工活动模块id
	
	private Integer topN;
	
	private String searchKey;
	
	private String searchIType;
	
	private String orderByStr;
	
	private Integer timeShow;  //是否需要添加时间过滤

	public Integer getTimeShow() {
		return timeShow;
	}

	public void setTimeShow(Integer timeShow) {
		this.timeShow = timeShow;
	}

	public String getOrderByStr() {
		return orderByStr;
	}

	public void setOrderByStr(String orderByStr) {
		this.orderByStr = orderByStr;
	}

	public String getSearchIType() {
		return searchIType;
	}

	public void setSearchIType(String searchIType) {
		this.searchIType = searchIType;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public Integer getTopN() {
		return topN;
	}

	public void setTopN(Integer topN) {
		this.topN = topN;
	}

	public Integer getiType() {
		return iType;
	}

	public void setiType(Integer iType) {
		this.iType = iType;
	}
	
	public Integer getRecordStart() {
		return recordStart;
	}

	public void setRecordStart(Integer recordStart) {
		this.recordStart = recordStart;
	}

	public Integer getRecordEnd() {
		return recordEnd;
	}

	public void setRecordEnd(Integer recordEnd) {
		this.recordEnd = recordEnd;
	}
	
	public Integer getiHomeDisplay() {
		return iHomeDisplay;
	}

	public void setiHomeDisplay(Integer iHomeDisplay) {
		this.iHomeDisplay = iHomeDisplay;
	}

	public Integer getsModularId() {
		return sModularId;
	}

	public void setsModularId(Integer sModularId) {
		this.sModularId = sModularId;
	}

	@Override
	public String toString() {
		return "QueyNewsParams [iType=" + iType + ", iHomeDisplay=" + iHomeDisplay + ", recordStart=" + recordStart
				+ ", recordEnd=" + recordEnd + "]";
	}
}