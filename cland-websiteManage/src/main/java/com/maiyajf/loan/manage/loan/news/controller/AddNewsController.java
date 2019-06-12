/**
 * 
 */
package com.maiyajf.loan.manage.loan.news.controller;

import com.maiyajf.base.po.BaseResponse;
import com.maiyajf.base.utils.base.DateUtils;
import com.maiyajf.base.utils.log.AccessLogger;
import com.maiyajf.loan.manage.loan.news.po.XwNewsInfoBean;
import com.maiyajf.loan.manage.loan.news.service.NewsInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rui23
 * @version 创建时间：2016年2月5日 上午9:52:08
 */
@Controller
@RequestMapping(value = "/news")
public class AddNewsController {

	@Autowired
	private NewsInfoService newsService;

	@RequestMapping(value = "/saveNewsInfo.htm")
	public ModelAndView save(HttpServletRequest request, XwNewsInfoBean newsInfoParams,
			@RequestParam(value = "show", required = false) Integer show,
			@RequestParam(value = "operate", required = false) String operate) {
		AccessLogger.info("新闻管理查询：show:" + show+ ",operate:" + operate, newsInfoParams.toString(), DateUtils.getCurrentTime());
		if (null == show) {
			return new ModelAndView("news/addNews", null);
		}
		if (StringUtils.equals(operate, "add")) {
			newsService.saveNews(newsInfoParams);
		} else {
			newsService.updateNews(newsInfoParams);
		}
		return new ModelAndView("redirect:query.htm?show=" + 1 + "&iType=" + newsInfoParams.getiType());
	}

	@RequestMapping(value = "/saveNewsInfoJson.htm")
	@ResponseBody
	public BaseResponse saveNewsInfoJson(HttpServletRequest request, XwNewsInfoBean newsInfoParams,
										 @RequestParam(value = "show", required = false) Integer show,
										 @RequestParam(value = "operate", required = false) String operate) {
		AccessLogger.info("更新序号：saveNewsInfoJson:" + show+ ",operate:" + operate, newsInfoParams.toString(), DateUtils.getCurrentTime());
		BaseResponse resp = BaseResponse.SUCCESS("");
		newsService.updateNews(newsInfoParams);
		return resp;
	}

	@RequestMapping(value = "/showSaveNews.htm")
	public ModelAndView showSaveNews(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("operate", "add");
		return new ModelAndView("news/addNews", model);
	}

	@RequestMapping(value = "/showNewsInfo.htm")
	public ModelAndView showNewsInfo(@RequestParam(value = "newsId") String newsId) {
		AccessLogger.info("新闻信息查询：", "", DateUtils.getCurrentTime());
		Map<String, Object> model = new HashMap<String, Object>();
		model = newsService.showNewsInfo(newsId);
		return new ModelAndView("news/showNews", model);
	}
}
