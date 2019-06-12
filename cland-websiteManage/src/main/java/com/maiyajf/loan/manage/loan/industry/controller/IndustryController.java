/**
 * Copyright (C), 2012-2016, 江苏中地集团有限公司
 * Author:   Min Dongxv
 * Date: 2017年10月17日 上午11:08:38
 * Description: 中地产业controller      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.maiyajf.loan.manage.loan.industry.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.maiyajf.base.utils.base.DateUtils;
import com.maiyajf.base.utils.log.AccessLogger;
import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;
import com.maiyajf.loan.manage.loan.news.po.XwNewsInfoBean;
import com.maiyajf.loan.manage.loan.news.service.NewsInfoService;

/**
 * @project BrandController.java
 * @function 旗下品牌controller
 * @author Min Dongxv
 * @date 2017年10月17日 上午11:08:38
 * 
 */
@Controller
@RequestMapping(value = "/industry")
public class IndustryController {

	@Autowired
	private NewsInfoService newsInfoService;

	/**
	 * 
	 * @project IndustryController.java
	 * @function 查询中地产业
	 * @return ModelAndView
	 * @param queryParams
	 * @param pageNumber
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月17日 下午3:48:54
	 *
	 */
	@RequestMapping(value = "/industryQuery.htm")
	public ModelAndView industryQuery(QueyNewsParams queryParams,
			@RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
		AccessLogger.info("中地产业管理查询：pageNumber:" + pageNumber, queryParams.toString(), DateUtils.getCurrentTime());
		if (null == pageNumber || pageNumber < 1) {
			pageNumber = 1;
		}
		try {
			// banner类型为9
			queryParams.setiType(11);
			Map<String, Object> page = newsInfoService.queryNews(queryParams, pageNumber);
			return new ModelAndView("/industry/industryManage", page);
		} catch (Exception e) {
			ExceptionLogger.error("中地产业管理", "查询中地产业失败", e);
			return new ModelAndView("/industry/industryManage", null);
		}
	}

	/**
	 * 
	 * @project IndustryController.java
	 * @function 新增中地产业
	 * @return ModelAndView
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月17日 下午3:49:08
	 *
	 */
	@RequestMapping(value = "/addIndustry.htm")
	public ModelAndView addPage() {
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("operate", "add");
		return new ModelAndView("/industry/addIndustry", params);
	}

	/**
	 * 
	 * @project IndustryController.java
	 * @function 保存中地产业
	 * @return AjaxResult
	 * @param request
	 * @param response
	 * @param params
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月17日 下午3:49:20
	 *
	 */
	@RequestMapping(value = "saveIndustry.htm", method = RequestMethod.POST)
	public ModelAndView saveIndustry(HttpServletRequest request, HttpServletResponse response, XwNewsInfoBean params,
			@RequestParam(value = "operate", required = false) String operate) {
		AccessLogger.info("中地产业保存：operate:" + operate, params.toString(), DateUtils.getCurrentTime());
		try {
			params.setiType(11);
			if ("add".equals(operate)) {
				newsInfoService.saveNews(params);
			}
			if ("edit".equals(operate)) {
				newsInfoService.updateNews(params);
			}
			return new ModelAndView("redirect:industryQuery.htm");
		} catch (Exception e) {
			ExceptionLogger.error("中地产业保存异常", e.getMessage(), e);
			return new ModelAndView("redirect:industryQuery.htm");
		}
	}

	/**
	 * 
	 * @project IndustryController.java
	 * @function 编辑中地产业
	 * @return ModelAndView
	 * @param sNewsNo
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月17日 下午3:49:34
	 *
	 */
	@RequestMapping(value = "/editIndustry.htm")
	public ModelAndView editPage(String sNewsNo) {
		Map<String, Object> indestry = newsInfoService.showNewsInfo(sNewsNo);
		indestry.put("operate", "edit");
		return new ModelAndView("/industry/addIndustry", indestry);
	}
}
