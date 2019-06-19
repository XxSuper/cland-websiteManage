package com.maiyajf.loan.manage.loan.news.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;
import com.maiyajf.loan.manage.loan.news.po.XwNewsInfoBean;

public interface XwNewsInfoDao {

	/**
	 * 保存
	 */
	public void save(XwNewsInfoBean bean);

	/**
	 * 修改
	 */
	public void update(XwNewsInfoBean bean);
	
	/**
	 * 获取最大的排序序号
	 */
	public Integer getMaxSortNum(XwNewsInfoBean bean);

	/**
	 * 查询新闻
	 * 
	 * @author rui23
	 * @param params
	 * @return
	 * @version 创建时间：2016年2月18日 下午4:19:37
	 */
	public List<XwNewsInfoBean> queryNews(QueyNewsParams params);

	public List<XwNewsInfoBean> queryTopNByParam(QueyNewsParams params);
	
	/**
	 * 查询新闻
	 * 
	 * @author rui23
	 * @param params
	 * @return
	 * @version 创建时间：2016年2月18日 下午4:19:37
	 */
	public List<XwNewsInfoBean> queryNewsNoPage(QueyNewsParams params);

	public Integer count(QueyNewsParams params);

	public void deleteNews(@Param("sNewsNo") String sNewsNo);
	
	public XwNewsInfoBean showNewsInfo(String sGuid);
	
	public void deleteAll(@Param("sNewsNos")List<String> sNewsNos);
	
	//查询访问量
	public Integer selectVisitCount(@Param("sNewsNo")String sNewsNo);
	
	public void saveVisit(Map<String,String> param);
	
	public void updateVisit(@Param("sNewsNo")String sNewsNo);
	
	public XwNewsInfoBean queryPreNews(Map<String,Object> param);
	
	public XwNewsInfoBean queryNextNews(Map<String,Object> param);
	
	public Map<String,String> querySeo();
	
	public void updateSeo(Map<String,String> param);

}