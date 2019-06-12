package com.maiyajf.loan.manage.loan.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.maiyajf.loan.manage.loan.model.params.QueryModelParams;
import com.maiyajf.loan.manage.loan.model.po.XwActivityModelBean;

public interface XwActivityModelDao {

	/**
	 * 保存
	 */
	public void save(XwActivityModelBean bean);

	/**
	 * 修改
	 */
	public void update(XwActivityModelBean bean);
	
	/**
	 * 
	 * @project XwActivityModelDao.java
	 * @function 查询
	 * @return List<XwActivityModelBean>
	 * @param params
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午2:57:51
	 *
	 */
	public List<XwActivityModelBean> queryModels(QueryModelParams params);

	public Integer count(QueryModelParams params);

	public void deleteModel(@Param("id") String id);
	
	public XwActivityModelBean showModelInfo(String id);
	
	public void deleteAll(@Param("ids") List<String> ids);

}