/**
 * 
 */
package com.maiyajf.loan.manage.loan.commonpage.controller;

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
@RequestMapping(value = "/commonPage")
public class CommonPageController {

	@Autowired
	private NewsInfoService newsService;

	@RequestMapping(value = "/saveCommonPageInfo.htm")
	public ModelAndView save(HttpServletRequest request, XwNewsInfoBean newsInfoParams,
			@RequestParam(value = "show", required = false) Integer show,
			@RequestParam(value = "operate", required = false) String operate) {
		AccessLogger.info("新闻管理查询：show:" + show+ ",operate:" + operate, newsInfoParams.toString(), DateUtils.getCurrentTime());
		if (null == show) {
			return new ModelAndView("commonpage/addCommonPage", null);
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
	public ModelAndView showSaveNews(HttpServletRequest request,
			@RequestParam(value = "iType", required = true) Integer iType) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("operate", "add");
		if(null == iType){
			iType = 1;
		}
		model.put("iType", iType);
		return new ModelAndView("commonpage/addCommonPage", model);
	}

	@RequestMapping(value = "/showjtjj.htm")
	public ModelAndView showNewsInfo(@RequestParam(value = "newsNo") String newsNo) {
		AccessLogger.info("新闻信息查询：", "", DateUtils.getCurrentTime());
		Map<String, Object> model = new HashMap<String, Object>();
		XwNewsInfoBean bean = newsService.getByNo(newsNo);
		model.put("newsInfo", bean);
		return new ModelAndView("commonpage/address", model);
	}
	
	@RequestMapping(value = "/savejtjj.htm")
	public ModelAndView savejtjj(HttpServletRequest request, XwNewsInfoBean newsInfoParams,
			@RequestParam(value = "saveType", required = false) Integer saveType,
			@RequestParam(value = "operate", required = false) String operate) {
		AccessLogger.info("新闻管理查询：" + "operate:" + operate, newsInfoParams.toString(), DateUtils.getCurrentTime());
		newsService.updateNews(newsInfoParams);
		return new ModelAndView("redirect:showjtjj.htm?newsNo=" + newsInfoParams.getsNewsNo());
	}
}
