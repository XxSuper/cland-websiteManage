package com.maiyajf.loan.manage.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maiyajf.loan.manage.common.dao.QueryOperatorsDao;

/**
 * @author rui23
 * @version 创建时间：2016年3月14日  下午3:12:26
 */
@Controller
@RequestMapping(value = "/Operators")
public class QueryOperatorsController {

	@Autowired
	private QueryOperatorsDao queryOperatorsDao;
	
	@RequestMapping(value = "/queryAddNewsOperators.htm")
	@ResponseBody
	public Object queryAddNewsOperators(){
		return queryOperatorsDao.queryAddNewsOperators();
	}
	
	@RequestMapping(value = "/queryApprovalNewsOperators.htm")
	@ResponseBody
	public Object queryApprovalNewsOperators(){
		return queryOperatorsDao.queryApprovalNewsOperators();
	}
}
