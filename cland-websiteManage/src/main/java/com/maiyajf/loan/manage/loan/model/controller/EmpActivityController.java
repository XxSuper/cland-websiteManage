/**
 * Copyright (C), 2012-2016, 江苏中地集团有限公司
 * Author:   Min Dongxv
 * Date: 2017年10月17日 上午11:08:38
 * Description: 员工活动controller 
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.maiyajf.loan.manage.loan.model.controller;

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
 * 
 * @project EmpActivityController.java
 * @function 员工活动controller
 * @author Min Dongxv
 * @date 2017年10月18日 上午8:55:59
 *
 */
@Controller
@RequestMapping(value = "/activity")
public class EmpActivityController {

	@Autowired
	private NewsInfoService newsInfoService;

	/**
	 * 
	 * @project EmpActivityController.java
	 * @function 员工活动
	 * @return ModelAndView
	 * @param queryParams
	 * @param pageNumber
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午4:28:10
	 *
	 */
	@RequestMapping(value = "/activityQuery.htm")
	public ModelAndView activityQuery(QueyNewsParams queryParams,
			@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
			@RequestParam(value = "sModularId", required = false) Integer sModularId) {
		AccessLogger.info("员工活动管理查询：pageNumber:" + pageNumber, queryParams.toString(), DateUtils.getCurrentTime());
		if (null == pageNumber || pageNumber < 1) {
			pageNumber = 1;
		}
		try {
			// banner类型为7
			queryParams.setiType(7);
			queryParams.setsModularId(sModularId);
			Map<String, Object> page = newsInfoService.queryNews(queryParams, pageNumber);
			return new ModelAndView("/model/activityManage", page);
		} catch (Exception e) {
			ExceptionLogger.error("员工活动管理", "查询员工活动失败", e);
			return new ModelAndView("/model/activityManage", null);
		}
	}

	/**
	 * 
	 * @project EmpActivityController.java
	 * @function 新增员工活动
	 * @return ModelAndView
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午4:28:58
	 *
	 */
	@RequestMapping(value = "/addActivity.htm")
	public ModelAndView addPage(Integer sModularId) {
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("operate", "add");
		params.put("sModularId", sModularId);
		return new ModelAndView("/model/addActivity", params);
	}

	/**
	 * 
	 * @project EmpActivityController.java
	 * @function 保存员工活动
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param params
	 * @param operate
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午4:29:55
	 *
	 */
	@RequestMapping(value = "saveActivity.htm", method = RequestMethod.POST)
	public ModelAndView saveActivity(HttpServletRequest request, HttpServletResponse response, XwNewsInfoBean params,
			@RequestParam(value = "operate", required = false) String operate) {
		AccessLogger.info("员工活动保存：operate:" + operate, params.toString(), DateUtils.getCurrentTime());
		try {
			params.setiType(7);
			if ("add".equals(operate)) {
				newsInfoService.saveNews(params);
			}
			if ("edit".equals(operate)) {
				newsInfoService.updateNews(params);
			}
		} catch (Exception e) {
			ExceptionLogger.error("公益慈善保存异常", e.getMessage(), e);
			return new ModelAndView("redirect:/activity/activityQuery.htm?sModularId=" + params.getsModularId());
		}
		return new ModelAndView("redirect:/activity/activityQuery.htm?sModularId=" + params.getsModularId());
	}

	/**
	 * 
	 * @project EmpActivityController.java
	 * @function 编辑员工活动
	 * @return ModelAndView
	 * @param sNewsNo
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午4:30:47
	 *
	 */
	@RequestMapping(value = "/editActivity.htm")
	public ModelAndView editPage(String sNewsNo, String sModularId) {
		Map<String, Object> activity = newsInfoService.showNewsInfo(sNewsNo);
		activity.put("operate", "edit");
		activity.put("sModularId", sModularId);
		return new ModelAndView("/model/addActivity", activity);
	}
}