package com.maiyajf.loan.manage.loan.commonpage.controller;

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
@RequestMapping(value = "/commonPage")
public class CommomPageManageController {

	@Autowired
	private NewsInfoService newsInfoService;

	/**
	 * 查询新闻
	 * @param queryParams
	 * @param pageNumber
	 * @param show
	 * @param iType 1:核心行业  2:新闻中心  3:banner 4:团队介绍 5: 6:荣誉资质,
	 * @return
	 */
	@RequestMapping(value = "query.htm")
	public ModelAndView query(QueyNewsParams queryParams,
			@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
			@RequestParam(value = "show", required = false) Integer show,
			@RequestParam(value = "iType", required = false) Integer iType) {
		ModelAndView model;
		if(null == queryParams.getiType()){
			if(null == iType){
				queryParams.setiType(1);
			}else{
				queryParams.setiType(iType);
			}
		}
		AccessLogger.info("新闻管理查询：show:" + show + ",pageNumber:" + pageNumber, queryParams.toString(),
				DateUtils.getCurrentTime());
//		if (null == show) {
//			model = new ModelAndView("commonpage/commonPageManage", null);
//			model.addObject("iType", queryParams.getiType());
//			return model;
//		}
		if (null == pageNumber || pageNumber < 1) {
			pageNumber = 1;
		}
		// 根据查询参数，查询数据
		try {
			Map<String, Object> map = newsInfoService.queryNews(queryParams, pageNumber);
			model = new ModelAndView("commonpage/commonPageManage", map);
		} catch (Exception e) {
			ExceptionLogger.error("新闻管理后台：", "新闻查询异常：", e);
			model = new ModelAndView("commonpage/commonPageManage", null);
		}
		model.addObject("iType", queryParams.getiType());
		return model;
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
		model.put("iType",((XwNewsInfoBean)model.get("newsInfo")).getiType());
		return new ModelAndView("commonpage/addCommonPage", model);
	}

	@RequestMapping(value = "/setHomeDisplay.htm")
	@ResponseBody
	public AjaxResult setHomeDisplay(XwNewsInfoBean newsInfoParams) {
		AccessLogger.info("置为首页展示：", "newsInfoParams:" + newsInfoParams.toString(), DateUtils.getCurrentTime());
		return newsInfoService.setHomeDisplay(newsInfoParams);
	}
	
	@RequestMapping(value = "showSeo.htm")
	public ModelAndView showSeo(){
		Map<String,String> res = newsInfoService.querySeo();
		
		ModelAndView model = new ModelAndView();
		model.addObject("seo", res);
		model.setViewName("commonpage/showSeo");
		return model;
	}
	
	@RequestMapping(value = "updateSeo.htm")
	public ModelAndView updateSeo(String keywords, String description){
		
		Map<String,String> param = new HashMap<String,String>();
		param.put("keywords", keywords);
		param.put("description", description);
		newsInfoService.updateSeo(param);
		
		Map<String,String> res = newsInfoService.querySeo();
		
		ModelAndView model = new ModelAndView();
		model.addObject("seo", res);
		model.setViewName("commonpage/showSeo");
		return model;
	}
}
