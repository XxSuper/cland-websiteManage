package com.maiyajf.loan.manage.loan.impress.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.maiyajf.base.utils.base.DateUtils;
import com.maiyajf.base.utils.log.AccessLogger;
import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.loan.impress.service.ImpressInfoService;
import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;
import com.maiyajf.loan.manage.loan.news.po.XwNewsInfoBean;
import com.maiyajf.loan.manage.loan.news.service.NewsInfoService;

/**
 * @author chao.xu
 * @version 创建时间：2017年10月17日 上午9:5:32
 */
@Controller
@RequestMapping(value = "/impress")
public class ImpressController {

	@Autowired
	private NewsInfoService newsInfoService;

	@Autowired
	private ImpressInfoService impressInfoService;

	@RequestMapping(value = "query.htm")
	public ModelAndView query(QueyNewsParams queryParams,
			@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
			@RequestParam(value = "show", required = false) Integer show) {
		AccessLogger.info("印象中地管理查询：show:" + show + ",pageNumber:" + pageNumber, queryParams.toString(),
				DateUtils.getCurrentTime());
		if (null == show) {
			return new ModelAndView("impress/impressManage", null);
		}
		if (null == pageNumber || pageNumber < 1) {
			pageNumber = 1;
		}
		// 根据查询参数，查询数据
		try {
			Map<String, Object> map = newsInfoService.queryNews(queryParams, pageNumber);
			return new ModelAndView("impress/impressManage", map);
		} catch (Exception e) {
			ExceptionLogger.error("印象中地管理后台：", "印象中地查询异常：", e);
			return new ModelAndView("impress/impressManage", null);
		}
	}
	
	@RequestMapping(value = "/saveImpressInfo.htm")
	public ModelAndView save(HttpServletRequest request, XwNewsInfoBean newsInfoParams,
			@RequestParam(value = "show", required = false) Integer show,
			@RequestParam(value = "operate", required = false) String operate) {
		AccessLogger.info("印象中地管理查询：show:" + show+ ",operate:" + operate, newsInfoParams.toString(), DateUtils.getCurrentTime());
		if (null == show) {
			return new ModelAndView("impress/addImpress", null);
		}
		if (StringUtils.equals(operate, "add")) {
			newsInfoService.saveNews(newsInfoParams);
		} else {
			newsInfoService.updateNews(newsInfoParams);
		}
		return new ModelAndView("redirect:query.htm?show=" + 1 + "&iType=" + newsInfoParams.getiType());
	}
	
	@RequestMapping(value = "/showSaveImpress.htm")
	public ModelAndView showSaveNews(XwNewsInfoBean queryParams) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("operate", "add");
		model.put("periods", impressInfoService.getMaxPeriods(queryParams));
		return new ModelAndView("impress/addImpress", model);
	}
	
	@RequestMapping(value = "/showEditImpress.htm")
	public ModelAndView showEditNews(@RequestParam(value = "newsNo") String newsNo) {
		AccessLogger.info("印象中地信息查询：", "", DateUtils.getCurrentTime());
		Map<String, Object> model = new HashMap<String, Object>();
		model = newsInfoService.showNewsInfo(newsNo);
		model.put("operate", "edit");
		return new ModelAndView("impress/addImpress", model);
	}
	
}
