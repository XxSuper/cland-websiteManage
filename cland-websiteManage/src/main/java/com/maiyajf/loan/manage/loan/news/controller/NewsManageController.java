package com.maiyajf.loan.manage.loan.news.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.maiyajf.base.utils.base.DateUtils;
import com.maiyajf.base.utils.log.AccessLogger;
import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.common.po.AjaxResult;
import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;
import com.maiyajf.loan.manage.loan.news.po.XwNewsInfoBean;
import com.maiyajf.loan.manage.loan.news.service.NewsInfoService;

/**
 * @author rui23
 * @version 创建时间：2016年2月5日 上午9:5:32
 */
@Controller
@RequestMapping(value = "/news")
public class NewsManageController {

	@Autowired
	private NewsInfoService newsInfoService;

	@RequestMapping(value = "query.htm")
	public ModelAndView query(QueyNewsParams queryParams,
			@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
			@RequestParam(value = "show", required = false) Integer show) {
		AccessLogger.info("新闻管理查询：show:" + show + ",pageNumber:" + pageNumber, queryParams.toString(),
				DateUtils.getCurrentTime());
		if (null == show) {
			return new ModelAndView("news/newsManage", null);
		}
		if (null == pageNumber || pageNumber < 1) {
			pageNumber = 1;
		}
		// 根据查询参数，查询数据
		try {
			Map<String, Object> map = newsInfoService.queryNews(queryParams, pageNumber);
			return new ModelAndView("news/newsManage", map);
		} catch (Exception e) {
			ExceptionLogger.error("新闻管理后台：", "新闻查询异常：", e);
			return new ModelAndView("news/newsManage", null);
		}
	}

	@RequestMapping(value = "deleteNews.htm")
	@ResponseBody
	public String deleteNews(@RequestParam(value = "newsNo") String newsNo) {
		AccessLogger.info("", "新闻删除：newsNo:" + newsNo, DateUtils.getCurrentTime());
		try {
			newsInfoService.deleteNews(newsNo);
			return "操作成功！";
		} catch (Exception e) {
			ExceptionLogger.error("新闻管理后台：", "新闻删除异常：", e);
			return "操作失败！";
		}
	}

	@RequestMapping(value = "deleteAllNews.htm")
	@ResponseBody
	public String deleteAllNews(@RequestParam(value = "newsNos") String newsNos) {
		AccessLogger.info("", "新闻批量删除：newsNos:" + newsNos.toString(), DateUtils.getCurrentTime());
		try {
			String[] str = newsNos.split(",");
			if (str.length == 0) {
				return null;
			}
			newsInfoService.deleteAllNews(str);
			return "操作成功！";
		} catch (Exception e) {
			ExceptionLogger.error("新闻管理后台：", "新闻批量删除异常：", e);
			return "操作失败！";
		}
	}

	@RequestMapping(value = "/showEditNews.htm")
	public ModelAndView showEditNews(@RequestParam(value = "newsNo") String newsNo) {
		AccessLogger.info("新闻信息查询：", "", DateUtils.getCurrentTime());
		Map<String, Object> model = new HashMap<String, Object>();
		model = newsInfoService.showNewsInfo(newsNo);
		model.put("operate", "edit");
		return new ModelAndView("news/addNews", model);
	}

	@RequestMapping(value = "/setHomeDisplay.htm")
	@ResponseBody
	public AjaxResult setHomeDisplay(XwNewsInfoBean newsInfoParams) {
		AccessLogger.info("置为首页展示：", "newsInfoParams:" + newsInfoParams.toString(), DateUtils.getCurrentTime());
		return newsInfoService.setHomeDisplay(newsInfoParams);
	}
}
