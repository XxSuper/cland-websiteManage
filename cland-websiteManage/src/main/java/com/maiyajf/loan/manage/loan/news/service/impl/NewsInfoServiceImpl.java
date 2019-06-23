/**
 * 
 */
package com.maiyajf.loan.manage.loan.news.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiyajf.loan.manage.common.constant.EnumMaxNum;
import com.maiyajf.loan.manage.common.persistence.Pager;
import com.maiyajf.loan.manage.common.po.AjaxResult;
import com.maiyajf.loan.manage.loan.news.dao.XwNewsInfoDao;
import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;
import com.maiyajf.loan.manage.loan.news.po.XwNewsInfoBean;
import com.maiyajf.loan.manage.loan.news.service.NewsInfoService;
import com.maiyajf.loan.manage.loan.sys.service.SystemService;

/**
 * @author chao.xu
 * @version 创建时间：2017年10月11日 下午4:17:49
 */
@Service(value = "NewsInfoServiceImpl")
public class NewsInfoServiceImpl implements NewsInfoService {

	@Autowired
	private XwNewsInfoDao newsInfoDao;
	
	@Resource(name = "systemServiceImpl")
	private SystemService systemService;

	@Override
	public Map<String, Object> queryNews(QueyNewsParams params, Integer pageNumber) {
		Map<String, Object> model = new HashMap<String, Object>();
		Integer total = newsInfoDao.count(params);// 总计录数
		Pager<XwNewsInfoBean> page = new Pager<XwNewsInfoBean>(total, pageNumber);
		params.setRecordStart((pageNumber - 1) * page.getLimit());
		params.setRecordEnd(page.getLimit() * pageNumber);
		List<XwNewsInfoBean> l = newsInfoDao.queryNews(params);
		page.setList(l);
		model.put("page", page); // 对应页面的信息
		model.put("queryParams", params);// 页面查询条件
		return model;
	}

	@Override
	public void deleteNews(String sNewsNo) {
		newsInfoDao.deleteNews(sNewsNo);
	}

	@Override
	public void saveNews(XwNewsInfoBean params) {
		String newsNo = systemService.getSequenceNo("xw_NewsInfo");
		params.setsNewsNo(newsNo);
		// 获取最大的排序序号
		Integer sortNum = newsInfoDao.getMaxSortNum(params);
		if(sortNum == null) {
			sortNum = 1;
		} else {
			sortNum = sortNum + 1;
		}
		params.setiSortNum(sortNum);
		newsInfoDao.save(params);
		
		//设置浏览次数
		if(StringUtils.isNotBlank(params.getVisitCount())){
			try{
				setVisitCount(newsNo, Integer.parseInt(params.getVisitCount()));
			}catch(Exception e){
				//异常的次数
			}
		}
	}

	@Override
	public void updateNews(XwNewsInfoBean params) {
		newsInfoDao.update(params);
		//设置浏览次数
		if(StringUtils.isNotBlank(params.getVisitCount())){
			
			try{
				setVisitCount(params.getsNewsNo(), Integer.parseInt(params.getVisitCount()));
			}catch(Exception e){
				//异常的次数
			}
		}
	}

	@Override
	public Map<String, Object> showNewsInfo(String sNewsNo) {
		Map<String, Object> model = new HashMap<String, Object>();
		XwNewsInfoBean params = newsInfoDao.showNewsInfo(sNewsNo);
		model.put("newsInfo", params);
		return model;
	}
	
	public XwNewsInfoBean getByNo(String sNewsNo) {
		XwNewsInfoBean params = newsInfoDao.showNewsInfo(sNewsNo);
		return params;
	}

	@Override
	public void deleteAllNews(String[] sNewsNos) {
		newsInfoDao.deleteAll(Arrays.asList(sNewsNos));
	}

	@Override
	public AjaxResult setHomeDisplay(XwNewsInfoBean newsInfoParams) {
		if (newsInfoParams.getiHomeDisplay() == null || newsInfoParams.getiHomeDisplay() == 0) {
			// 设置首页展示-查询是否大于4条
			QueyNewsParams params = new QueyNewsParams();
			params.setiType(newsInfoParams.getiType());
			params.setiHomeDisplay(1);
//			List<XwNewsInfoBean> l = newsInfoDao.queryNewsNoPage(params);
//			if (l != null && l.size() >= EnumMaxNum.getNum(newsInfoParams.getiType())) {
//				return AjaxResult.failed("只能选择" + EnumMaxNum.getNum(newsInfoParams.getiType()) + "条作为首页展示", AjaxResult.ERROR_CODE);
//			}
			newsInfoParams.setiHomeDisplay(1);
		} else {
			newsInfoParams.setiHomeDisplay(0);
		}
		// 设置首页展示
		newsInfoDao.update(newsInfoParams);
		return AjaxResult.success();
	}
	
	@Override
	public List<XwNewsInfoBean> queryTopNews(QueyNewsParams params) {
		List<XwNewsInfoBean> list = newsInfoDao.queryTopNByParam(params);
		return list;
	}
	
	public Map<String, Object> queryPageNews(QueyNewsParams params, Integer pageNumber, Integer pageSize) {
		if(pageSize == null || pageSize == 0){
			pageSize = 1;
		}
		Map<String, Object> model = new HashMap<String, Object>();
		Integer total = newsInfoDao.count(params);// 总计录数
		Pager<XwNewsInfoBean> page = new Pager<XwNewsInfoBean>(total, pageNumber);
		params.setRecordStart((pageNumber - 1) * pageSize);
		params.setRecordEnd(pageSize * pageNumber);
		List<XwNewsInfoBean> l = newsInfoDao.queryNews(params);
		page.setList(l);
		model.put("total", total);
		model.put("page", page); // 对应页面的信息
		model.put("queryParams", params);// 页面查询条件
		List<String> showPage = new ArrayList<String>();
		int totalPage = 1;
		if(total % pageSize > 0){
			totalPage = total/pageSize + 1;
		}else{
			totalPage = total/pageSize;
		}
		if(totalPage <= 6) {
			for(int i = 1;i<=totalPage;i++){
				showPage.add(String.valueOf(i));
			}
		}else{
			if(totalPage - pageNumber <= 2){
				showPage = Arrays.asList(new String[]{"1","2","...",String.valueOf(totalPage-2),String.valueOf(totalPage-1),String.valueOf(totalPage)});
			}else if(pageNumber <= 2){
				showPage = Arrays.asList(new String[]{"1","2","3","...",String.valueOf(totalPage-1),String.valueOf(totalPage)});
			}else{
				showPage = Arrays.asList(new String[]{"1","...",String.valueOf(pageNumber-1),String.valueOf(pageNumber),String.valueOf(pageNumber+1),"...",String.valueOf(totalPage)});
			}
		}
		model.put("pNos", showPage);
		int prePage = 1;
		int nextPage = totalPage;
		if(pageNumber <= 1){
			prePage = 1;
		}else{
			prePage = pageNumber -1;
		}
		if(pageNumber < totalPage){
			nextPage = pageNumber + 1;
		}
		model.put("pageNumber", String.valueOf(pageNumber));
		model.put("prePage", prePage);
		model.put("nextPage", nextPage);
		return model;
	}
	
	public int queryVisit(String newsNo){
		Map<String,String> p = new HashMap<String,String>();
		p.put("sNewsNo", newsNo);
		Integer value = newsInfoDao.selectVisitCount(p);
		if(value == null){
			value = 0;
		}
		Integer count = newsInfoDao.selectVisitDataCount(p);
		if(null == count || count == 0){
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("sGuid", UUID.randomUUID().toString());
			param.put("sNewsNo", newsNo);
			newsInfoDao.saveVisit(param);
			param.put("visitCount", 1);
			return 1;
		}else{
			newsInfoDao.updateVisit(newsNo);
			return value+1;
		}
	}
	
	@Override
	public int selectVisitCount(String newsNo){
		Map<String,String> p = new HashMap<String,String>();
		p.put("sNewsNo", newsNo);
		Integer value = newsInfoDao.selectVisitCount(p);
		if(value == null){
			value = 0;
		}
		return value;
	}
	
	public void setVisitCount(String newsNo, int visitCount){
		
		Map<String,String> p = new HashMap<String,String>();
		p.put("sNewsNo", newsNo);
		
		Integer count = newsInfoDao.selectVisitDataCount(p);
		if(null == count || count == 0){
			
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("sGuid", UUID.randomUUID().toString());
			param.put("sNewsNo", newsNo);
			param.put("visitCount", visitCount);
			newsInfoDao.saveVisit(param);
		}else{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("visitCount", visitCount);
			map.put("sNewsNo", newsNo);
			newsInfoDao.setVisitCount(map);
		}
	}
	
	public XwNewsInfoBean queryPreNews(String iType, int iSortNum){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("iType", iType);
		param.put("iSortNum", iSortNum);
		XwNewsInfoBean params = newsInfoDao.queryPreNews(param);
		return params;
	}
	
	public XwNewsInfoBean queryNextNews(String iType, int iSortNum){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("iType", iType);
		param.put("iSortNum", iSortNum);
		XwNewsInfoBean params = newsInfoDao.queryNextNews(param);
		return params;
	}

	@Override
	public Map<String, String> querySeo() {
		return newsInfoDao.querySeo();
	}

	@Override
	public void updateSeo(Map<String, String> param) {
		newsInfoDao.updateSeo(param);
	}
}
