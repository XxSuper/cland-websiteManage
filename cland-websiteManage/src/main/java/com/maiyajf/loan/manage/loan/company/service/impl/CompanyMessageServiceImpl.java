/**
 * 
 */
package com.maiyajf.loan.manage.loan.company.service.impl;

import com.maiyajf.loan.manage.common.persistence.Pager;
import com.maiyajf.loan.manage.loan.company.dao.CompanyMessageDao;
import com.maiyajf.loan.manage.loan.company.po.CompanyMessageBean;
import com.maiyajf.loan.manage.loan.company.service.CompanyMessageService;
import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;
import com.maiyajf.loan.manage.loan.sys.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chao.xu
 * @version 创建时间：2017年10月11日 下午4:17:49
 */
@Service(value = "CompanyMessageServiceImpl")
public class CompanyMessageServiceImpl implements CompanyMessageService {

	@Autowired
	private CompanyMessageDao companyMessageDao;

	@Resource(name = "systemServiceImpl")
	private SystemService systemService;

	@Override
	public Map<String, Object> queryCompany(QueyNewsParams params, Integer pageNumber) {
		Map<String, Object> model = new HashMap<String, Object>();
		Integer total = companyMessageDao.count(params);// 总计录数
		Pager<CompanyMessageBean> page = new Pager<CompanyMessageBean>(total, pageNumber);
		params.setRecordStart((pageNumber - 1) * page.getLimit());
		params.setRecordEnd(page.getLimit() * pageNumber);
		List<CompanyMessageBean> l = companyMessageDao.queryCompanyMessage(params);
		page.setList(l);
		model.put("page", page); // 对应页面的信息
		model.put("queryParams", params);// 页面查询条件
		return model;
	}

	@Override
	public Map<String, Object> showCompanyInfo(String sGuid) {
		Map<String, Object> model = new HashMap<String, Object>();
		CompanyMessageBean params = companyMessageDao.showCompanyInfo(sGuid);
		model.put("companyInfo", params);
		return model;
	}
	public CompanyMessageBean queryById(String sGuid){
		return companyMessageDao.showCompanyInfo(sGuid);
	}
	

	@Override
	public void updateCompany(CompanyMessageBean params) {
		companyMessageDao.update(params);
	}
}
