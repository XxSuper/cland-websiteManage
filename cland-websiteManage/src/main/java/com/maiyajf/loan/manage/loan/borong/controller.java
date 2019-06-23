package com.maiyajf.loan.manage.loan.borong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

import com.maiyajf.loan.manage.loan.column.po.SysColumnBean;
import com.maiyajf.loan.manage.loan.column.service.ColumnService;
import com.maiyajf.loan.manage.loan.company.po.CompanyMessageBean;
import com.maiyajf.loan.manage.loan.company.service.CompanyMessageService;
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
	
	@Autowired
	private ColumnService columnService;
	
	@Autowired
	private CompanyMessageService companyMessageService;
	
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
		
		params.setiType(24);//核心行业推荐
		params.setTopN(2);
		List<XwNewsInfoBean> coreNl = newsInfoService.queryTopNews(params);
		model.addObject("coreNl", coreNl);
		
		params.setiType(23);//核心行业
		params.setTopN(null);
		List<XwNewsInfoBean> coreList = newsInfoService.queryTopNews(params);
		model.addObject("coreList", coreList);
		
		params.setiType(7);//服务案例
		params.setTopN(3);
		params.setiHomeDisplay(1);
		params.setTimeShow(1); //需要添加发布时间过滤
		List<XwNewsInfoBean> serviceList = newsInfoService.queryTopNews(params);
		model.addObject("serviceList", serviceList);
		params.setTimeShow(null); //需要添加发布时间过滤
		
		
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
		params.setiHomeDisplay(null);
		
		//加载heard 和 foot数据
		initLinkList(model, 1);
		return model;
	}
	
	//友情链接
	private void initLinkList(ModelAndView mv, int columIndex){
		QueyNewsParams params = new QueyNewsParams();
		params.setiType(3);
		params.setTopN(10); //最多显示10条在首页
		List<XwNewsInfoBean> bannerList = newsInfoService.queryTopNews(params);
		mv.addObject("bannerList", bannerList);
		
		mv.addObject("columIndex", columIndex);
		
		params.setiType(15);
		params.setTopN(null);
		List<XwNewsInfoBean> linkList = newsInfoService.queryTopNews(params);
		mv.addObject("linkList", linkList);
		
		//菜单的显示
		Map<String,Object> tm = new HashMap<String, Object>();
		tm.put("iLevel", 0);
//		tm.put("sFatherNo", 0);
		List<SysColumnBean> clist = columnService.selectColumn(tm);
		
		for(SysColumnBean b : clist){
			tm.put("iLevel", null);
			tm.put("sFatherNo", b.getsGuid());
			List<SysColumnBean> list = columnService.selectColumn(tm);
			b.setClist(list);
			b.setChildSize(list == null?0:list.size());
		}
		mv.addObject("clumns", clist);
		mv.addObject("clumnsSize", clist == null?0:clist.size());
		
		CompanyMessageBean cp = companyMessageService.queryById("S0001");
		mv.addObject("cp", cp);
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
		initLinkList(model, 6);
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
		initLinkList(model, 3);
		return model;
	}
	
	//核心行业详情
	@RequestMapping(value = "/hexinDetail.htm")
	public ModelAndView hexinDetail(@RequestParam(value = "sNewsNo", required = false) String sNewsNo) {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/detail_hexinhangye");
		Map<String, Object> info = newsInfoService.showNewsInfo(sNewsNo);
		model.addObject("info", info);
		
		int visitCount = newsInfoService.queryVisit(sNewsNo);
		model.addObject("visitCount", visitCount);
		
		XwNewsInfoBean cur = (XwNewsInfoBean)info.get("newsInfo");
		
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
		initLinkList(model, 3);
		return model;
	}
	
	//核心行业详情
	@RequestMapping(value = "/teamDetial.htm")
	public ModelAndView teamDetial(@RequestParam(value = "sNewsNo", required = false) String sNewsNo) {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/detail_borongtuandui");
		Map<String, Object> info = newsInfoService.showNewsInfo(sNewsNo);
		model.addObject("info", info);
		
		int visitCount = newsInfoService.queryVisit(sNewsNo);
		model.addObject("visitCount", visitCount);
		
		XwNewsInfoBean cur = (XwNewsInfoBean)info.get("newsInfo");
		
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
		initLinkList(model, 3);
		return model;
	}

	//服务案例
	@RequestMapping(value = "/serviceList.htm")
	public ModelAndView serviceList(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
			@RequestParam(value = "queryType", required = false) Integer queryType) {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/fuwuanli");
		
//		//1为农业7  2位建筑业12
//		if(queryType == null || 2 != queryType){
//			queryType = 1;
//		}
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		QueyNewsParams params = new QueyNewsParams();
		params.setiType(12);
		params.setTimeShow(1); //需要添加发布时间过滤
		
		model.addObject("queryType", queryType);
		Map<String, Object> pageInfo = newsInfoService.queryPageNews(params, pageNumber, 8);
		model.addObject("pageInfo", pageInfo);
		
		//经典案例
		params.setiType(7);
		List<XwNewsInfoBean> list = newsInfoService.queryTopNews(params);
		model.addObject("jList", list);
		
		//加载heard 和 foot数据
		initLinkList(model, 3);
		
		return model;
	}
	
	//集团简介
	@RequestMapping(value = "/companyInfo.htm")
	public ModelAndView companyInfo() {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/jituanjianjie");
		//集团简介类容
		XwNewsInfoBean bean = newsInfoService.getByNo("XTCD100000000001");
		model.addObject("info", bean);
		
		//查询简介图文
		QueyNewsParams params = new QueyNewsParams();
		params.setiType(22);//服务案例
		List<XwNewsInfoBean> listInfo = newsInfoService.queryTopNews(params);
		model.addObject("listInfo", listInfo);
		
		//加载heard 和 foot数据
		initLinkList(model, 6);
		return model;
	}
	
	//联系博融
	@RequestMapping(value = "/lianxiborong.htm")
	public ModelAndView lianxiborong() {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/lianxiborong");
		
		initLinkList(model, 7);
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
		
		initLinkList(model, 6);
		return model;
	}
	
	
	//博融生活详情
	@RequestMapping(value = "/lifeDetail.htm")
	public ModelAndView lifeDetail(@RequestParam(value = "sNewsNo", required = false) String sNewsNo,
			@RequestParam(value = "iType", required = false) Integer iType) {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/detail_sh");
		
		Map<String, Object> info = newsInfoService.showNewsInfo(sNewsNo);
		model.addObject("info", info);
		XwNewsInfoBean cur = (XwNewsInfoBean)info.get("newsInfo");
		
		int visitCount = newsInfoService.queryVisit(sNewsNo);
		model.addObject("visitCount", visitCount);
		
		
		if( cur != null){
			if(null == iType){
				iType = cur.getiType();
			}
			model.addObject("iType", iType);
			
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
		params.setiHomeDisplay(1);
		List<XwNewsInfoBean> tjlist = newsInfoService.queryTopNews(params);
		model.addObject("tjList", tjlist);
		
		//加载heard 和 foot数据
		initLinkList(model, 6);
		return model;
	}
	
	//招贤纳士
	@RequestMapping(value = "/zhaoxian.htm")
	public ModelAndView zhaoxian(@RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
		ModelAndView model = new ModelAndView();
		model.setViewName("borong/zhaoxiannashi");
		
		QueyNewsParams params = new QueyNewsParams();
		
		params.setiType(25);//选择博融
		params.setTopN(1);
		List<XwNewsInfoBean> chooseBr = newsInfoService.queryTopNews(params);
		if(chooseBr != null && chooseBr.size() > 0){
			model.addObject("chooseBr", chooseBr.get(0));
		}
		
		
		
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
		params.setTimeShow(1); //需要添加发布时间过滤
		
		Map<String, Object> pageInfo = newsInfoService.queryPageNews(params, pageNumber, 3);
		model.addObject("pageInfo", pageInfo);
		
		List<XwNewsInfoBean> showlist = newsInfoService.queryTopNews(params);
		if(showlist != null && showlist.size() > 0){
			model.addObject("showOne", showlist.get(0));
		}
		
		initLinkList(model, 6);
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
		params.setTimeShow(1); //需要添加发布时间过滤
		
		params.setSearchKey(searchKey);
		model.addObject("queryType", queryType);
		Map<String, Object> pageInfo = newsInfoService.queryPageNews(params, pageNumber, 8);
		model.addObject("pageInfo", pageInfo);
		
		initLinkList(model, 4);
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
		params.setTimeShow(1); //需要添加发布时间过滤
		params.setSearchIType("12,16,17,14,2");
		Map<String, Object> pageInfo = newsInfoService.queryPageNews(params, pageNumber, 10);
		model.addObject("pageInfo", pageInfo);
		
		initLinkList(model, 1);
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
		
		params.setiType(1);//应用领域 就是核心行业的下面
		params.setTopN(4);
		List<XwNewsInfoBean> areaList = newsInfoService.queryTopNews(params);
		model.addObject("areaList", areaList);
		
		params.setiType(9);//主要模块
		params.setTopN(20);
		params.setsModularId(queryType);
		List<XwNewsInfoBean> mainModel = newsInfoService.queryTopNews(params);
		model.addObject("mainModel", mainModel);
		
		params.setiType(8);//服务概述
		params.setTopN(1);
		List<XwNewsInfoBean> gs = newsInfoService.queryTopNews(params);
		if(gs != null && gs.size() > 0){
			model.addObject("gs", gs.get(0));
		}
		
		
		initLinkList(model, 2);
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
		
		initLinkList(model, 2);
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
		params.setTimeShow(1);  //需要过滤发布时间
		Map<String, Object> pageInfo = newsInfoService.queryPageNews(params, pageNumber, 8);
		model.addObject("pageInfo", pageInfo);
		
		initLinkList(model, 6);
		return model;
	}
	
}
