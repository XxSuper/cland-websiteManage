package com.maiyajf.loan.manage.loan.cooperatmessage.service;

import java.util.Map;

import com.maiyajf.loan.manage.loan.cooperatmessage.po.CooperatBean;

public interface CooperatService {

	public Map<String, Object> getPageData(int currentPage, int pageSize);
	
	public void saveData(CooperatBean bean);
}
