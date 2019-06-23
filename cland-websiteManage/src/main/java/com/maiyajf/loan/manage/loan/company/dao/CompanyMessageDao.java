package com.maiyajf.loan.manage.loan.company.dao;

import com.maiyajf.loan.manage.loan.company.po.CompanyMessageBean;
import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;

import java.util.List;

public interface CompanyMessageDao {

	/**
	 * 查询新闻
	 *
	 * @author rui23
	 * @param params
	 * @return
	 * @version 创建时间：2016年2月18日 下午4:19:37
	 */
	List<CompanyMessageBean> queryCompanyMessage(QueyNewsParams params);

	Integer count(QueyNewsParams params);

	CompanyMessageBean showCompanyInfo(String sGuid);
	/**
	 * 保存
	 */
	void save(CompanyMessageBean bean);

	/**
	 * 修改
	 */
	void update(CompanyMessageBean bean);

}