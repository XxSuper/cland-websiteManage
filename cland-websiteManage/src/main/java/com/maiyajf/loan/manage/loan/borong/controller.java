package com.maiyajf.loan.manage.loan.borong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.maiyajf.loan.manage.loan.cooperatmessage.po.CooperatBean;
import com.maiyajf.loan.manage.loan.cooperatmessage.service.CooperatService;
import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;
import com.maiyajf.loan.manage.loan.news.po.XwNewsInfoBean;
import com.maiyajf.loan.manage.loan.news.service.NewsInfoService;

@Controller
@RequestMapping(value = "/gw")
public class controller {
	
	
	@Autowired
	private NewsInfoService newsInfoService;
	
	@Autowired
	private CooperatService cooperatService;
	
	@RequestMapping(value = "/submitCooperat.htm")
	@ResponseBody
	public String submitCooperat(CooperatBean coop){
		try{
			cooperatService.saveData(coop);
			return "200";
		}catch(Exception e){
			e.printStackTrace();
			return "0";
		}
	}
	
	@RequestMapping(value = "/index.htm")
	public ModelAndView showNewsInfo(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/index");
		QueyNewsParams params = new QueyNewsParams();
		
		params.setiType(11);//核心行业
		params.setTopN(2);
		List<XwNewsInfoBean> coreNl = newsInfoService.queryTopNews(params);
		model.addObject("coreNl", coreNl);
		
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
		
		//加载heard 和 foot数据
		initLinkList(model);
		return model;
	}
	
	//友情链接
	private void initLinkList(ModelAndView mv){
		QueyNewsParams params = new QueyNewsParams();
		params.setiType(3);
		params.setTopN(10); //最多显示10条在首页
		List<XwNewsInfoBean> bannerList = newsInfoService.queryTopNews(params);
		mv.addObject("bannerList", bannerList);
		
		
		params.setiType(15);
		params.setTopN(null);
		List<XwNewsInfoBean> linkList = newsInfoService.queryTopNews(params);
		mv.addObject("linkList", linkList);
		
		Map<String,String> res = newsInfoService.querySeo();
		mv.addObject("seo", res);
	}
	
	//博融团队
	@RequestMapping(value = "/borongTeam.htm")
	public ModelAndView borongTeam(@RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/borongtuandui");
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		QueyNewsParams params = new QueyNewsParams();
		params.setiType(4);
		Map<String, Object> pageInfo = newsInfoService.queryPageNews(params, pageNumber, 8);
		model.addObject("pageInfo", pageInfo);
		//加载heard 和 foot数据
		initLinkList(model);
		return model;
	}
	
	//服务案例详情
	@RequestMapping(value = "/fuwuDetail.htm")
	public ModelAndView newsDetail(@RequestParam(value = "sNewsNo", required = false) String sNewsNo) {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/detail_fuwuanli");
		Map<String, Object> info = newsInfoService.showNewsInfo(sNewsNo);
		model.addObject("info", info);
		
		int visitCount = newsInfoService.queryVisit(sNewsNo);
		model.addObject("visitCount", visitCount);
		
		XwNewsInfoBean cur = (XwNewsInfoBean)info.get("newsInfo");
		if(cur.getiType() == 11){
			model.addObject("showType", "核心能力");
		}else if(cur.getiType() == 12){
			model.addObject("showType", "服务案例(建筑业)");
		}else{
			model.addObject("showType", "服务案例(农业)");
		}
		if( cur != null){
			if(StringUtils.isNotBlank(cur.getRemark())){
				List<String> bqs = Arrays.asList(cur.getRemark().trim().split(","));
				model.addObject("bqs", bqs);
			}
			XwNewsInfoBean pre = newsInfoService.queryPreNews(cur.getiType().toString(), cur.getiSortNum());
			model.addObject("pre", pre);
			
			XwNewsInfoBean next = newsInfoService.queryNextNews(cur.getiType().toString(), cur.getiSortNum());
			model.addObject("next", next);
		}
		
		
		//加载heard 和 foot数据
		initLinkList(model);
		return model;
	}
	
	//服务案例
	@RequestMapping(value = "/serviceList.htm")
	public ModelAndView serviceList(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
			@RequestParam(value = "queryType", required = false) Integer queryType) {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/fuwuanli");
		
		//1为农业7  2位建筑业12
		if(queryType == null || 2 != queryType){
			queryType = 1;
		}
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		QueyNewsParams params = new QueyNewsParams();
		if(queryType == 1){
			params.setiType(7);
		}else{
			params.setiType(12);
		}
		model.addObject("queryType", queryType);
		Map<String, Object> pageInfo = newsInfoService.queryPageNews(params, pageNumber, 8);
		model.addObject("pageInfo", pageInfo);
		
		params.setTopN(1);
		List<XwNewsInfoBean> list = newsInfoService.queryTopNews(params);
		if(list != null && list.size() > 0){
			model.addObject("showOne", list.get(0));
		}
		//加载heard 和 foot数据
		initLinkList(model);
		
		return model;
	}
	
	//集团简介
	@RequestMapping(value = "/companyInfo.htm")
	public ModelAndView companyInfo() {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/jituanjianjie");
		
		//加载heard 和 foot数据
		initLinkList(model);
		return model;
	}
	
	//联系博融
	@RequestMapping(value = "/lianxiborong.htm")
	public ModelAndView lianxiborong() {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/lianxiborong");
		
		initLinkList(model);
		return model;
	}
	
	//荣誉证书
	@RequestMapping(value = "/rongyuzhengshu.htm")
	public ModelAndView rongyuzhengshu(@RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/rongyuzhengshu");
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		QueyNewsParams params = new QueyNewsParams();
		params.setiType(6);
		Map<String, Object> pageInfo = newsInfoService.queryPageNews(params, pageNumber, 8);
		model.addObject("pageInfo", pageInfo);
		
		initLinkList(model);
		return model;
	}
	
	
	//博融生活详情
	@RequestMapping(value = "/lifeDetail.htm")
	public ModelAndView lifeDetail(@RequestParam(value = "sNewsNo", required = false) String sNewsNo,
			@RequestParam(value = "iType", required = false) Integer iType) {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/detail_sh");
		if(null == iType){
			iType = 14;
		}
		model.addObject("iType", iType);
		
		Map<String, Object> info = newsInfoService.showNewsInfo(sNewsNo);
		model.addObject("info", info);
		XwNewsInfoBean cur = (XwNewsInfoBean)info.get("newsInfo");
		
		int visitCount = newsInfoService.queryVisit(sNewsNo);
		model.addObject("visitCount", visitCount);
		
		
		if( cur != null){
			if(StringUtils.isNotBlank(cur.getRemark())){
				List<String> bqs = Arrays.asList(cur.getRemark().trim().split(","));
				model.addObject("bqs", bqs);
			}
			
			XwNewsInfoBean pre = newsInfoService.queryPreNews(cur.getiType().toString(), cur.getiSortNum());
			model.addObject("pre", pre);
			
			XwNewsInfoBean next = newsInfoService.queryNextNews(cur.getiType().toString(), cur.getiSortNum());
			model.addObject("next", next);
		}
		
		//推荐阅读
		QueyNewsParams params = new QueyNewsParams();
		params.setiType(iType);
		params.setTopN(2);
		List<XwNewsInfoBean> tjlist = newsInfoService.queryTopNews(params);
		model.addObject("tjList", tjlist);
		
		//加载heard 和 foot数据
		initLinkList(model);
		return model;
	}
	
	//招贤纳士
	@RequestMapping(value = "/zhaoxian.htm")
	public ModelAndView zhaoxian(@RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/zhaoxiannashi");
		
		QueyNewsParams params = new QueyNewsParams();
		params.setiType(13);
		params.setTopN(20);
		List<XwNewsInfoBean> list = newsInfoService.queryTopNews(params);
		//社招
		List<XwNewsInfoBean> szList = new ArrayList<XwNewsInfoBean>();
		//校招
		List<XwNewsInfoBean> xzList = new ArrayList<XwNewsInfoBean>();
		for(XwNewsInfoBean bean : list){
			if(StringUtils.isNotBlank(bean.getRemark()) && bean.getRemark().indexOf("校园") > -1){
				xzList.add(bean);
			}else{
				szList.add(bean);
			}
		}
		model.addObject("szList", szList);
		model.addObject("xzList", xzList);
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		params.setiType(14);
		params.setTopN(null);
		Map<String, Object> pageInfo = newsInfoService.queryPageNews(params, pageNumber, 3);
		model.addObject("pageInfo", pageInfo);
		
		List<XwNewsInfoBean> showlist = newsInfoService.queryTopNews(params);
		if(showlist != null && showlist.size() > 0){
			model.addObject("showOne", showlist.get(0));
		}
		
		initLinkList(model);
		return model;
	}
	
	//博融智库
	@RequestMapping(value = "/zhiku.htm")
	public ModelAndView zhiku(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
			@RequestParam(value = "queryType", required = false) Integer queryType,
			@RequestParam(value = "searchKey", required = false) String searchKey) {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/zhiku");
		model.addObject("searchKey", searchKey);
		//1为博融观点16  2位理论本土化17
		if(queryType == null || 2 != queryType){
			queryType = 1;
		}
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		QueyNewsParams params = new QueyNewsParams();
		if(queryType == 1){
			params.setiType(16);
		}else{
			params.setiType(17);
		}
		params.setSearchKey(searchKey);
		model.addObject("queryType", queryType);
		Map<String, Object> pageInfo = newsInfoService.queryPageNews(params, pageNumber, 8);
		model.addObject("pageInfo", pageInfo);
		
		initLinkList(model);
		return model;
	}
	
	//搜索页面
	@RequestMapping(value = "/searchPage.htm")
	public ModelAndView searchPage(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
			@RequestParam(value = "queryType", required = false) Integer queryType,
			@RequestParam(value = "value", required = false) String value) {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/sousuo");
		model.addObject("searchKey", value);
		QueyNewsParams params = new QueyNewsParams();
		if(null == pageNumber){
			pageNumber = 1;
		}
		params.setSearchKey(value);
		params.setOrderByStr("dModifyDate desc");
		params.setSearchIType("7,12,16,17,14,2,11");
		Map<String, Object> pageInfo = newsInfoService.queryPageNews(params, pageNumber, 10);
		model.addObject("pageInfo", pageInfo);
		
		initLinkList(model);
		return model;
	}
	
	@RequestMapping(value = "/searchDetail.htm")
	public ModelAndView searchDeatil(@RequestParam(value = "sNewsNo", required = false) String sNewsNo){
		ModelAndView mv = new ModelAndView();
		XwNewsInfoBean value = newsInfoService.getByNo(sNewsNo);
		if(value.getiType() == 7 || value.getiType() == 12){
			mv.setViewName("redirect:fuwuDetail.htm?sNewsNo="+sNewsNo);
			//服务案例_农业
		}else if(value.getiType() == 14){
			//博融生活
			mv.setViewName("redirect:lifeDetail.htm?sNewsNo="+sNewsNo);
		}else if(value.getiType() == 11){
			//核心能力
		}else if(value.getiType() == 2){
			//新闻（博融生活）
			mv.setViewName("redirect:lifeDetail.htm?sNewsNo="+sNewsNo);
		}else if(value.getiType() == 16){
			//智库-博融观点
			mv.setViewName("redirect:lifeDetail.htm?iType=16&sNewsNo="+sNewsNo);
		}else if(value.getiType() == 17){
			mv.setViewName("redirect:lifeDetail.htm?iType=17&sNewsNo="+sNewsNo);
			
		}
		return mv;
	}
	
	//咨询服务-产品详情
	@RequestMapping(value = "/detailCP.htm")
	public ModelAndView detailCP(@RequestParam(value = "queryType", required = false) Integer queryType) {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/zixun_chanpinxiangqing");
		if(queryType == null){
			queryType = 1;
		}
		model.addObject("queryType",queryType);
		
		//主要模块
		QueyNewsParams params = new QueyNewsParams();
		params.setiType(9);//主要模块
		params.setTopN(20);
		List<XwNewsInfoBean> mainModel = newsInfoService.queryTopNews(params);
		model.addObject("mainModel", mainModel);
		
		params.setiType(1);//应用领域 就是核心行业的下面
		params.setTopN(4);
		List<XwNewsInfoBean> areaList = newsInfoService.queryTopNews(params);
		model.addObject("areaList", areaList);
		
		params.setiType(8);//服务概述
		params.setTopN(1);
		List<XwNewsInfoBean> gs = newsInfoService.queryTopNews(params);
		if(gs != null && gs.size() > 0){
			model.addObject("gs", gs.get(0));
		}
		
		
		initLinkList(model);
		return model;
	}
	
	//咨询服务-核心能力
	@RequestMapping(value = "/coreNls.htm")
	public ModelAndView coreNls() {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/zixun_hexingnengli");
		
		QueyNewsParams params = new QueyNewsParams();
		
		params.setiType(11);//核心能力
		params.setTopN(10);
		List<XwNewsInfoBean> coreNl = newsInfoService.queryTopNews(params);
		model.addObject("coreNl", coreNl);
		
		initLinkList(model);
		return model;
	}
	
	//博融智库
	@RequestMapping(value = "/xinwen.htm")
	public ModelAndView xinwen(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
			@RequestParam(value = "searchKey", required = false) String searchKey) {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/xinwen");
		model.addObject("searchKey", searchKey);
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		QueyNewsParams params = new QueyNewsParams();
		params.setiType(2);
		params.setSearchKey(searchKey);
		Map<String, Object> pageInfo = newsInfoService.queryPageNews(params, pageNumber, 8);
		model.addObject("pageInfo", pageInfo);
		
		initLinkList(model);
		return model;
	}
	
}
