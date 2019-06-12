package com.maiyajf.loan.manage.loan.borong;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;
import com.maiyajf.loan.manage.loan.news.po.XwNewsInfoBean;
import com.maiyajf.loan.manage.loan.news.service.NewsInfoService;

@Controller
@RequestMapping(value = "/gw")
public class controller {
	
	@Autowired
	private NewsInfoService newsInfoService;
	
	@RequestMapping(value = "/index.htm")
	public ModelAndView showNewsInfo() {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/index");
		QueyNewsParams params = new QueyNewsParams();
		params.setiType(3);
		params.setTopN(10); //最多显示10条在首页
		List<XwNewsInfoBean> bannerList = newsInfoService.queryTopNews(params);
		model.addObject("bannerList", bannerList);
		
		params.setiType(1);//核心行业
		params.setTopN(null);
		List<XwNewsInfoBean> coreList = newsInfoService.queryTopNews(params);
		model.addObject("coreList", coreList);
		
		params.setiType(7);//服务案例
		params.setTopN(3);
		List<XwNewsInfoBean> serviceList = newsInfoService.queryTopNews(params);
		model.addObject("serviceList", serviceList);
		
		params.setiType(4);
		params.setTopN(4);
		List<XwNewsInfoBean> empList = newsInfoService.queryTopNews(params);
		model.addObject("empList", empList);
		
		params.setiType(6);
		params.setTopN(4);
		List<XwNewsInfoBean> ryList = newsInfoService.queryTopNews(params);
		model.addObject("ryList", ryList);
		
		if(ryList != null && ryList.size() > 0){
			model.addObject("ryshow", ryList.get(0));
		}
		
		params.setiType(15);
		params.setTopN(null);
		List<XwNewsInfoBean> linkList = newsInfoService.queryTopNews(params);
		model.addObject("linkList", linkList);
		return model;
	}
	
}
