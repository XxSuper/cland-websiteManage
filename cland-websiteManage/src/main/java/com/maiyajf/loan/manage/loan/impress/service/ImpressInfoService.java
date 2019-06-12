/**
 * 
 */
package com.maiyajf.loan.manage.loan.impress.service;

import com.maiyajf.loan.manage.loan.news.po.XwNewsInfoBean;

/**
 * @author chao.xu
 * @version 创建时间：2017年10月17日 下午5:03:06
 */
public interface ImpressInfoService {

	Integer getMaxPeriods(XwNewsInfoBean queryParams);
	
}
