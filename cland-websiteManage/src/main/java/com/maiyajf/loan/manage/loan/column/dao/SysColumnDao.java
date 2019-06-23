package com.maiyajf.loan.manage.loan.column.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.maiyajf.loan.manage.loan.column.po.SysColumnBean;
import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;

public interface SysColumnDao {

	/**
	 * 查询新闻
	 *
	 * @author rui23
	 * @param params
	 * @return
	 * @version 创建时间：2016年2月18日 下午4:19:37
	 */
	public List<SysColumnBean> queryColumns(QueyNewsParams params);

	public Integer count(QueyNewsParams params);

	SysColumnBean showColumnInfo(String sGuid);

	void deleteAll(@Param("columnNos")List<String> columnNos);

	void deleteColumn(@Param("columnNo") String columnNo);

	List<SysColumnBean> getTopColumn();
	
	List<SysColumnBean> selectColumn(Map<String,Object> map);

	/**
	 * 保存
	 */
	void save(SysColumnBean bean);

	/**
	 * 修改
	 */
	void update(SysColumnBean bean);

}