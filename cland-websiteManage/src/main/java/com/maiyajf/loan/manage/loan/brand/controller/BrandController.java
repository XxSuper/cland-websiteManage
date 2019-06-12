/**
 * Copyright (C), 2012-2016, 江苏中地集团有限公司
 * Author:   Min Dongxv
 * Date: 2017年10月17日 上午11:08:38
 * Description: 旗下品牌controller      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.maiyajf.loan.manage.loan.brand.controller;

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
@RequestMapping(value = "/brand")
public class BrandController {

	@Autowired
	private NewsInfoService newsInfoService;

	/**
	 * 
	 * @project BrandController.java
	 * @function 查询旗下品牌
	 * @return ModelAndView
	 * @param queryParams
	 * @param pageNumber
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月17日 上午11:09:56
	 *
	 */
	@RequestMapping(value = "/brandQuery.htm")
	public ModelAndView brandQuery(QueyNewsParams queryParams,
			@RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
		AccessLogger.info("旗下品牌管理查询：pageNumber:" + pageNumber, queryParams.toString(), DateUtils.getCurrentTime());
		if (null == pageNumber || pageNumber < 1) {
			pageNumber = 1;
		}
		try {
			// banner类型为8
			queryParams.setiType(8);
			Map<String, Object> page = newsInfoService.queryNews(queryParams, pageNumber);
			return new ModelAndView("/brand/brandManage", page);
		} catch (Exception e) {
			ExceptionLogger.error("旗下品牌管理", "查询品牌失败", e);
			return new ModelAndView("/brand/brandManage", null);
		}
	}

	/**
	 * 
	 * @project BrandController.java
	 * @function 新增品牌
	 * @return ModelAndView
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月17日 上午11:10:01
	 *
	 */
	@RequestMapping(value = "/addBrand.htm")
	public ModelAndView addPage() {
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("operate", "add");
		return new ModelAndView("/brand/addBrand", params);
	}

	/**
	 * 
	 * @project BrandController.java
	 * @function 保存品牌
	 * @return AjaxResult
	 * @param request
	 * @param response
	 * @param params
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月17日 上午11:10:07
	 *
	 */
	@RequestMapping(value = "saveBrand.htm", method = RequestMethod.POST)
	public ModelAndView saveBrand(HttpServletRequest request, HttpServletResponse response, XwNewsInfoBean params,
			@RequestParam(value = "operate", required = false) String operate) {
		AccessLogger.info("旗下品牌保存：operate:" + operate, params.toString(), DateUtils.getCurrentTime());
		try {
			params.setiType(8);
			if ("add".equals(operate)) {
				newsInfoService.saveNews(params);
			}
			if ("edit".equals(operate)) {
				newsInfoService.updateNews(params);
			}
			return new ModelAndView("redirect:brandQuery.htm");
		} catch (Exception e) {
			ExceptionLogger.error("旗下品牌保存异常", e.getMessage(), e);
			return new ModelAndView("redirect:brandQuery.htm");
		}
	}

	/**
	 * 
	 * @project BrandController.java
	 * @function 编辑品牌
	 * @return ModelAndView
	 * @param sNewsNo
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月17日 上午11:10:16
	 *
	 */
	@RequestMapping(value = "/editBrand.htm")
	public ModelAndView editPage(String sNewsNo) {
		Map<String, Object> brand = newsInfoService.showNewsInfo(sNewsNo);
		brand.put("operate", "edit");
		return new ModelAndView("/brand/addBrand", brand);
	}
}
