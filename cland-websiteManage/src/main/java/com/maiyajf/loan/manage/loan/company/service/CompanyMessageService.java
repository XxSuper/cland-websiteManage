/**
 * 
 */
package com.maiyajf.loan.manage.loan.company.service;

import com.maiyajf.loan.manage.loan.company.po.CompanyMessageBean;
import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;

import java.util.Map;

/**
 * @author rui23
 * @version 创建时间：2016年2月14日 下午5:03:06
 */
public interface CompanyMessageService {

	Map<String, Object> queryCompany(QueyNewsParams params, Integer pageNumber);

	Map<String, Object> showCompanyInfo(String sGuid);

	void updateCompany(CompanyMessageBean params);
	
	CompanyMessageBean queryById(String sGuid);
}
