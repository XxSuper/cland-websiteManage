/**
 * 
 */
package com.maiyajf.loan.manage.loan.news.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
	}

	@Override
	public void updateNews(XwNewsInfoBean params) {
		newsInfoDao.update(params);
	}

	@Override
	public Map<String, Object> showNewsInfo(String sNewsNo) {
		Map<String, Object> model = new HashMap<String, Object>();
		XwNewsInfoBean params = newsInfoDao.showNewsInfo(sNewsNo);
		model.put("newsInfo", params);
		return model;
	}

	@Override
	public void deleteAllNews(String[] sNewsNos) {
		newsInfoDao.deleteAll(Arrays.asList(sNewsNos));
	}

	@Override
	public AjaxResult setHomeDisplay(XwNewsInfoBean newsInfoParams) {
		if (newsInfoParams.getiHomeDisplay() == 0) {
			// 设置首页展示-查询是否大于4条
			QueyNewsParams params = new QueyNewsParams();
			params.setiType(newsInfoParams.getiType());
			params.setiHomeDisplay(1);
			List<XwNewsInfoBean> l = newsInfoDao.queryNewsNoPage(params);
			if (l != null && l.size() >= EnumMaxNum.getNum(newsInfoParams.getiType())) {
				return AjaxResult.failed("只能选择" + EnumMaxNum.getNum(newsInfoParams.getiType()) + "条作为首页展示", AjaxResult.ERROR_CODE);
			}
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
}
