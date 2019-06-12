/**
 * 
 */
package com.maiyajf.loan.manage.loan.model.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiyajf.loan.manage.common.persistence.Pager;
import com.maiyajf.loan.manage.loan.model.dao.XwActivityModelDao;
import com.maiyajf.loan.manage.loan.model.params.QueryModelParams;
import com.maiyajf.loan.manage.loan.model.po.XwActivityModelBean;
import com.maiyajf.loan.manage.loan.model.service.ModelService;

/**
 * @author chao.xu
 * @version 创建时间：2017年10月11日 下午4:17:49
 */
@Service(value = "ModelServiceImpl")
public class ModelServiceImpl implements ModelService {

	@Autowired
	private XwActivityModelDao modelDao;

	/**
	 * 
	 * @project ModelServiceImpl.java
	 * @function 分页查询员工活动模块
	 * @return Map<String,Object>
	 * @param params
	 * @param pageNumber
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午3:23:17
	 *
	 */
	@Override
	public Map<String, Object> queryModel(QueryModelParams params, Integer pageNumber) {
		Map<String, Object> model = new HashMap<String, Object>();
		Integer total = modelDao.count(params);// 总计录数
		Pager<XwActivityModelBean> page = new Pager<XwActivityModelBean>(total, pageNumber);
		params.setRecordStart((pageNumber - 1) * page.getLimit());
		params.setRecordEnd(page.getLimit() * pageNumber);
		List<XwActivityModelBean> l = modelDao.queryModels(params);
		page.setList(l);
		model.put("page", page); // 对应页面的信息
		model.put("queryParams", params);// 页面查询条件
		return model;
	}

	/**
	 * 
	 * @project ModelServiceImpl.java
	 * @function 删除模块
	 * @return void
	 * @param id
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午3:24:06
	 *
	 */
	@Override
	public void deleteModel(String id) {
		modelDao.deleteModel(id);
	}

	/**
	 * 
	 * @project ModelServiceImpl.java
	 * @function 保存模块
	 * @return void
	 * @param params
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午3:24:45
	 *
	 */
	@Override
	public void saveModel(XwActivityModelBean params) {
		modelDao.save(params);
	}

	/**
	 * 
	 * @project ModelServiceImpl.java
	 * @function 更新模块
	 * @return void
	 * @param params
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午3:25:14
	 *
	 */
	@Override
	public void updateModel(XwActivityModelBean params) {
		modelDao.update(params);
	}

	/**
	 * 
	 * @project ModelServiceImpl.java
	 * @function 查询模块详情
	 * @return Map<String,Object>
	 * @param id
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午3:25:49
	 *
	 */
	@Override
	public Map<String, Object> showModelInfo(String id) {
		Map<String, Object> model = new HashMap<String, Object>();
		XwActivityModelBean params = modelDao.showModelInfo(id);
		model.put("modelInfo", params);
		return model;
	}

	/**
	 * 
	 * @project ModelServiceImpl.java
	 * @function 删除选中模块
	 * @return void
	 * @param ids
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午3:26:19
	 *
	 */
	@Override
	public void deleteAllModel(String[] ids) {
		modelDao.deleteAll(Arrays.asList(ids));
	}
}
