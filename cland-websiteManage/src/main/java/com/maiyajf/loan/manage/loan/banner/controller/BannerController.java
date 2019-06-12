package com.maiyajf.loan.manage.loan.banner.controller;

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
 * @project BannerController.java
 * @function bannner管理Controller
 * @author Min Dongxv
 * @date 2017年10月13日 上午9:12:18
 *
 */
@Controller
@RequestMapping(value = "/banner")
public class BannerController {

	@Autowired
	private NewsInfoService newsInfoService;

	/**
	 * @Title: bannerQuery
	 * @Description: 查询banner
	 * @param bannerInfo
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "/bannerQuery.htm")
	public ModelAndView bannerQuery(QueyNewsParams queryParams,
			@RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
		AccessLogger.info("banner管理查询：pageNumber:" + pageNumber, queryParams.toString(),
				DateUtils.getCurrentTime());
		if (null == pageNumber || pageNumber < 1) {
			pageNumber = 1;
		}
		try {
			// banner类型为3
			queryParams.setiType(3);
			Map<String, Object> page = newsInfoService.queryNews(queryParams, pageNumber);
			return new ModelAndView("/banner/bannerManage", page);
		} catch (Exception e) {
			ExceptionLogger.error("banner管理", "查询banner失败", e);
			return new ModelAndView("/banner/bannerManage", null);
		}
	}

	/**
	 * 
	 * @project BannerController.java
	 * @function 新增banner
	 * @return ModelAndView
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月13日 上午9:27:18
	 *
	 */
	@RequestMapping(value = "/addBanner.htm")
	public ModelAndView addPage() {
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("operate", "add");
		return new ModelAndView("/banner/addBanner", params);
	}

	/**
	 * 
	 * @project BannerController.java
	 * @function 保存banner
	 * @return AjaxResult
	 * @param request
	 * @param response
	 * @param params
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月16日 下午3:52:59
	 *
	 */
	@RequestMapping(value = "saveBanner.htm", method = RequestMethod.POST)
	public ModelAndView saveBanner(HttpServletRequest request, HttpServletResponse response, XwNewsInfoBean params,
			@RequestParam(value = "operate", required = false) String operate) {
		AccessLogger.info("banner管理保存banner：operate:" + operate, params.toString(), DateUtils.getCurrentTime());
		try {
			params.setiType(3);
			if ("add".equals(operate)) {
				newsInfoService.saveNews(params);
			}
			if ("edit".equals(operate)) {
				newsInfoService.updateNews(params);
			}
			return new ModelAndView("redirect:bannerQuery.htm");
		} catch (Exception e) {
			ExceptionLogger.error("banner管理保存异常", e.getMessage(), e);
			return new ModelAndView("redirect:bannerQuery.htm");
		}
	}

	/**
	 * 
	 * @project BannerController.java
	 * @function 编辑banner
	 * @return ModelAndView
	 * @param sNewsNo
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月17日 上午10:19:05
	 *
	 */
	@RequestMapping(value = "/editBanner.htm")
	public ModelAndView editPage(String sNewsNo) {
		Map<String, Object> banner = newsInfoService.showNewsInfo(sNewsNo);
		banner.put("operate", "edit");
		return new ModelAndView("/banner/addBanner", banner);
	}
}