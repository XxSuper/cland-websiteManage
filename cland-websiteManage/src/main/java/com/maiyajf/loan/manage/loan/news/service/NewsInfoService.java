/**
 * 
 */
package com.maiyajf.loan.manage.loan.news.service;

import java.util.List;
import java.util.Map;

import com.maiyajf.loan.manage.common.po.AjaxResult;
import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;
import com.maiyajf.loan.manage.loan.news.po.XwNewsInfoBean;

/**
 * @author rui23
 * @version 创建时间：2016年2月14日 下午5:03:06
 */
public interface NewsInfoService {

	public Map<String, Object> queryNews(QueyNewsParams params, Integer pageNumber);

	public void deleteNews(String sNewsNo);

	public void saveNews(XwNewsInfoBean params);

	public void updateNews(XwNewsInfoBean params);

	public Map<String, Object> showNewsInfo(String sNewsNo);
	
	public void deleteAllNews(String[] sNewsNos);

	public AjaxResult setHomeDisplay(XwNewsInfoBean newsInfoParams);
	
	public List<XwNewsInfoBean> queryTopNews(QueyNewsParams params);
}
