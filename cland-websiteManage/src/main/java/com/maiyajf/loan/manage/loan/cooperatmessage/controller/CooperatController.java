package com.maiyajf.loan.manage.loan.cooperatmessage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.loan.cooperatmessage.service.CooperatService;
import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;

@Controller
@RequestMapping(value = "/cooperat")
public class CooperatController {

	@Autowired
	private CooperatService cooperatService;
	
	@RequestMapping(value = "query.htm")
	public ModelAndView query(QueyNewsParams queryParams,
			@RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
		if (null == pageNumber || pageNumber < 1) {
			pageNumber = 1;
		}
		// 根据查询参数，查询数据
		try {
			//默认查询20条
			Map<String, Object> map = cooperatService.getPageData(pageNumber, 20);
			return new ModelAndView("cooperat/cooperatPage", map);
		} catch (Exception e) {
			ExceptionLogger.error("合作意向管理后台：", "合作意向查询异常：", e);
			return new ModelAndView("cooperat/cooperatPage", null);
		}
	}
}
