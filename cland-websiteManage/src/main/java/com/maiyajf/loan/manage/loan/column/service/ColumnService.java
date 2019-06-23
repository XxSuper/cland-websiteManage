/**
 * 
 */
package com.maiyajf.loan.manage.loan.column.service;

import com.maiyajf.loan.manage.loan.column.po.SysColumnBean;
import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;

import java.util.List;
import java.util.Map;

/**
 * @author rui23
 * @version 创建时间：2016年2月14日 下午5:03:06
 */
public interface ColumnService {

	Map<String, Object> queryColumns(QueyNewsParams params, Integer pageNumber);

	void deleteAllColumns(String[] columnNos);

	void deleteColumn(String columnNo);

	List<SysColumnBean> getAllColumn();

	Map<String, Object> showColumnInfo(String columnNo);

	void saveColumn(SysColumnBean params);

	void updateColumn(SysColumnBean params);
	
	List<SysColumnBean> selectColumn(Map<String,Object> map);
}
