/**
 * 
 */
package com.maiyajf.loan.manage.loan.model.params;

/**
 * @author chao.xu
 * @version 创建时间：2017年10月11日 下午5:26:37
 */
public class QueryModelParams {
	
	private Integer recordStart;// 开始记录
	
	private Integer recordEnd;// 结束记录

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

	@Override
	public String toString() {
		return "QueyNewsParams [recordStart=" + recordStart + ", recordEnd=" + recordEnd + "]";
	}
}