/**
 * 
 */
package com.maiyajf.loan.manage.loan.impress.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiyajf.loan.manage.loan.impress.service.ImpressInfoService;
import com.maiyajf.loan.manage.loan.news.dao.XwNewsInfoDao;
import com.maiyajf.loan.manage.loan.news.po.XwNewsInfoBean;

/**
 * @author chao.xu
 * @version 创建时间：2017年10月11日 下午4:17:49
 */
@Service(value = "ImpressInfoServiceImpl")
public class ImpressInfoServiceImpl implements ImpressInfoService {

	@Autowired
	private XwNewsInfoDao newsInfoDao;
	
	public Integer getMaxPeriods(XwNewsInfoBean queryParams) {
		Integer periods = newsInfoDao.getMaxSortNum(queryParams);
		if (periods == null) {
			periods = 1;
		} else {
			periods = periods + 1;
		}
		return periods;// 最大期数;
	}
}
