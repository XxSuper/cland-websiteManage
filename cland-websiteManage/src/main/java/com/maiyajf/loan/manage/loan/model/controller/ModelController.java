/**
 * Copyright (C), 2012-2016, 江苏中地集团有限公司
 * Author:   Min Dongxv
 * Date: 2017年10月17日 上午11:08:38
 * Description: 员工活动模块controller      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.maiyajf.loan.manage.loan.model.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.maiyajf.base.utils.base.DateUtils;
import com.maiyajf.base.utils.log.AccessLogger;
import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.loan.model.params.QueryModelParams;
import com.maiyajf.loan.manage.loan.model.po.XwActivityModelBean;
import com.maiyajf.loan.manage.loan.model.service.ModelService;

/**
 * @project BrandController.java
 * @function 员工活动模块controller
 * @author Min Dongxv
 * @date 2017年10月17日 上午11:08:38
 * 
 */
@Controller
@RequestMapping(value = "/model")
public class ModelController {

	@Autowired
	private ModelService modelService;

	/**
	 * 
	 * @project ModelController.java
	 * @function 员工活动模块
	 * @return ModelAndView
	 * @param queryParams
	 * @param pageNumber
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 上午8:55:32
	 *
	 */
	@RequestMapping(value = "/modelQuery.htm")
	public ModelAndView modelQuery(QueryModelParams queryParams,
			@RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
		AccessLogger.info("员工活动模块查询：pageNumber:" + pageNumber, queryParams.toString(), DateUtils.getCurrentTime());
		if (null == pageNumber || pageNumber < 1) {
			pageNumber = 1;
		}
		try {
			Map<String, Object> page = modelService.queryModel(queryParams, pageNumber);
			return new ModelAndView("/model/modelManage", page);
		} catch (Exception e) {
			ExceptionLogger.error("员工活动模块管理", "查询员工活动模块失败", e);
			return new ModelAndView("/model/modelManage", null);
		}
	}

	/**
	 * 
	 * @project ModelController.java
	 * @function 新增员工活动模块
	 * @return ModelAndView
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午3:30:59
	 *
	 */
	@RequestMapping(value = "/addModel.htm")
	public ModelAndView addPage() {
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("operate", "add");
		return new ModelAndView("/model/addModel", params);
	}

	/**
	 * 
	 * @project ModelController.java
	 * @function 保存模块
	 * @return ModelAndView
	 * @param request
	 * @param response
	 * @param params
	 * @param operate
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月23日 下午2:29:43
	 *
	 */
	@RequestMapping(value = "saveModel.htm", method = RequestMethod.POST)
	public ModelAndView saveMercy(HttpServletRequest request, HttpServletResponse response, XwActivityModelBean params,
			@RequestParam(value = "operate", required = false) String operate) {
		AccessLogger.info("员工活动模块保存：operate:" + operate, params.toString(), DateUtils.getCurrentTime());
		try {
			if ("add".equals(operate)) {
				modelService.saveModel(params);
			}
			if ("edit".equals(operate)) {
				modelService.updateModel(params);
			}
			return new ModelAndView("redirect:modelQuery.htm");
		} catch (Exception e) {
			ExceptionLogger.error("员工活动模块保存异常", e.getMessage(), e);
			return new ModelAndView("redirect:modelQuery.htm");
		}
	}

	/**
	 * 
	 * @project ModelController.java
	 * @function 编辑员工活动模块
	 * @return ModelAndView
	 * @param sNewsNo
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午3:34:06
	 *
	 */
	@RequestMapping(value = "/editModel.htm")
	public ModelAndView editPage(String id) {
		Map<String, Object> model = modelService.showModelInfo(id);
		model.put("operate", "edit");
		return new ModelAndView("/model/addModel", model);
	}

	/**
	 * 
	 * @project ModelController.java
	 * @function 删除员工活动模块
	 * @return String
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午3:36:32
	 *
	 */
	@RequestMapping(value = "delModel.htm", method = RequestMethod.POST)
	@ResponseBody
	public String delModel(HttpServletRequest request, HttpServletResponse response, String id) {
		try {
			modelService.deleteModel(id);
			return "删除成功！";
		} catch (Exception e) {
			ExceptionLogger.error(e);
			return "删除失败！";
		}
	}

	/**
	 * 
	 * @project ModelController.java
	 * @function 删除选中的员工活动模块
	 * @return String
	 * @param request
	 * @param response
	 * @param ids
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午3:38:25
	 *
	 */
	@RequestMapping(value = "delAllModels.htm", method = RequestMethod.POST)
	@ResponseBody
	public String delAllMercys(HttpServletRequest request, HttpServletResponse response, String ids) {
		try {
			if (!StringUtils.isEmpty(ids)) {
				String[] modelIds = ids.split(",");
				modelService.deleteAllModel(modelIds);
			}
			return "删除成功！";
		} catch (Exception e) {
			ExceptionLogger.error(e);
			return "删除失败！";
		}
	}
}
