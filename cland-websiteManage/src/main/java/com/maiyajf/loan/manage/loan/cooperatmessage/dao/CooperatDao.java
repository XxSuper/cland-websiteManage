package com.maiyajf.loan.manage.loan.cooperatmessage.dao;

import java.util.List;
import java.util.Map;

import com.maiyajf.loan.manage.loan.cooperatmessage.po.CooperatBean;

public interface CooperatDao {
	
	/**
	 * 保存
	 */
	public void save(CooperatBean bean);
	
	public List<CooperatBean> queryPage(Map<String,Object> param);
	
	public Integer count();
}
