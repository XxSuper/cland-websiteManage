package com.maiyajf.base.card.po;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * INFO: info User: zhaokai Date: 2016/10/10 Version: 1.0 History:
 * <p>
 * 如果有修改过程，请记录
 * </P>
 */
public class ServiceLimitBeanPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4880636666758258135L;

	private String sGuid;
	private String serviceName; // '服务名称'
	private String serviceUrl; // '服务URL'
	private String serviceUrlMd5; // 'MD5（URL）定长'
	private Integer limitType; // '限制时间单位 0:秒 1:分 2:小时'
	private Integer limitTime; // '限制时间大小 该值和limittype一起，形成一个有效的时间单位'
	private Integer upperValue; // '上限阀值'
	private Integer state; // '状态 0:初始化 1:启用 2:停用'

	public String getsGuid() {
		return sGuid;
	}

	public void setsGuid(String sGuid) {
		this.sGuid = sGuid;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getServiceUrlMd5() {
		return serviceUrlMd5;
	}

	public void setServiceUrlMd5(String serviceUrlMd5) {
		this.serviceUrlMd5 = serviceUrlMd5;
	}

	public Integer getLimitType() {
		return limitType;
	}

	public void setLimitType(Integer limitType) {
		this.limitType = limitType;
	}

	public Integer getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(Integer limitTime) {
		this.limitTime = limitTime;
	}

	public Integer getUpperValue() {
		return upperValue;
	}

	public void setUpperValue(Integer upperValue) {
		this.upperValue = upperValue;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
