package com.maiyajf.loan.manage.loan.cooperatmessage.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiyajf.loan.manage.common.persistence.Pager;
import com.maiyajf.loan.manage.loan.cooperatmessage.dao.CooperatDao;
import com.maiyajf.loan.manage.loan.cooperatmessage.po.CooperatBean;
import com.maiyajf.loan.manage.loan.cooperatmessage.service.CooperatService;

@Service(value = "cooperatService")
public class CooperatServiceImpl implements CooperatService {

	@Autowired
	private CooperatDao cooperatDao;

	@Override
	public Map<String, Object> getPageData(int pageNumber, int pageSize) {
		Map<String, Object> model = new HashMap<String, Object>();
		Integer total = cooperatDao.count();// 总计录数
		Pager<CooperatBean> page = new Pager<CooperatBean>(total, pageNumber);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("recordStart", (pageNumber - 1) * page.getLimit());
		params.put("recordEnd", page.getLimit() * pageNumber);
		List<CooperatBean> l = cooperatDao.queryPage(params);
		page.setList(l);
		model.put("page", page); // 对应页面的信息
		model.put("queryParams", params);// 页面查询条件
		return model;
	}
	
	public void saveData(CooperatBean bean){
		bean.setsGuid(UUID.randomUUID().toString());
		bean.setStatus("submit");
		cooperatDao.save(bean);
	}
}
