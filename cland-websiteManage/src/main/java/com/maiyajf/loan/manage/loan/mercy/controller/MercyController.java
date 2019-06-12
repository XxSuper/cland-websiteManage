/**
 * Copyright (C), 2012-2016, 江苏中地集团有限公司
 * Author:   Min Dongxv
 * Date: 2017年10月17日 上午11:08:38
 * Description: 公益慈善controller      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.maiyajf.loan.manage.loan.mercy.controller;

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
 * @project MercyController.java
 * @function 公益慈善controller
 * @author Min Dongxv
 * @date 2017年10月18日 上午8:55:59
 *
 */
@Controller
@RequestMapping(value = "/mercy")
public class MercyController {

	@Autowired
	private NewsInfoService newsInfoService;

	/**
	 * 
	 * @project MercyController.java
	 * @function 公益慈善
	 * @return ModelAndView
	 * @param queryParams
	 * @param pageNumber
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 上午8:56:12
	 *
	 */
	@RequestMapping(value = "/mercyQuery.htm")
	public ModelAndView mercyQuery(QueyNewsParams queryParams,
			@RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
		AccessLogger.info("公益慈善管理查询：pageNumber:" + pageNumber, queryParams.toString(), DateUtils.getCurrentTime());
		if (null == pageNumber || pageNumber < 1) {
			pageNumber = 1;
		}
		try {
			// banner类型为1
			queryParams.setiType(1);
			Map<String, Object> page = newsInfoService.queryNews(queryParams, pageNumber);
			return new ModelAndView("/mercy/mercyManage", page);
		} catch (Exception e) {
			ExceptionLogger.error("公益慈善管理", "查询公益慈善失败", e);
			return new ModelAndView("/mercy/mercyManage", null);
		}
	}

	/**
	 * 
	 * @project MercyController.java
	 * @function 新增公益慈善
	 * @return ModelAndView
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 上午8:56:21
	 *
	 */
	@RequestMapping(value = "/addMercy.htm")
	public ModelAndView addPage() {
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("operate", "add");
		return new ModelAndView("/mercy/addMercy", params);
	}

	/**
	 * 
	 * @project MercyController.java
	 * @function 保存公益慈善
	 * @return AjaxResult
	 * @param request
	 * @param response
	 * @param params
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 上午8:56:30
	 *
	 */
	@RequestMapping(value = "saveMercy.htm", method = RequestMethod.POST)
	public ModelAndView saveMercy(HttpServletRequest request, HttpServletResponse response, XwNewsInfoBean params,
			@RequestParam(value = "operate", required = false) String operate) {
		AccessLogger.info("公益慈善保存：operate:" + operate, params.toString(), DateUtils.getCurrentTime());
		try {
			params.setiType(1);
			if ("add".equals(operate)) {
				newsInfoService.saveNews(params);
			}
			if ("edit".equals(operate)) {
				newsInfoService.updateNews(params);
			}
		} catch (Exception e) {
			ExceptionLogger.error("公益慈善保存异常", e.getMessage(), e);
			return new ModelAndView("redirect:mercyQuery.htm");
		}
		return new ModelAndView("redirect:mercyQuery.htm");
	}

	/**
	 * 
	 * @project MercyController.java
	 * @function 编辑公益慈善
	 * @return ModelAndView
	 * @param sNewsNo
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 上午8:56:51
	 *
	 */
	@RequestMapping(value = "/editMercy.htm")
	public ModelAndView editPage(String sNewsNo) {
		Map<String, Object> mercy = newsInfoService.showNewsInfo(sNewsNo);
		mercy.put("operate", "edit");
		return new ModelAndView("/mercy/addMercy", mercy);
	}
}