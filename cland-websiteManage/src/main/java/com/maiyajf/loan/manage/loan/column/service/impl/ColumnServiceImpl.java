/**
 * 
 */
package com.maiyajf.loan.manage.loan.column.service.impl;

import com.maiyajf.loan.manage.common.persistence.Pager;
import com.maiyajf.loan.manage.loan.column.dao.SysColumnDao;
import com.maiyajf.loan.manage.loan.column.po.SysColumnBean;
import com.maiyajf.loan.manage.loan.column.service.ColumnService;
import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;
import com.maiyajf.loan.manage.loan.sys.service.SystemService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author chao.xu
 * @version 创建时间：2017年10月11日 下午4:17:49
 */
@Service(value = "ColumnServiceImpl")
public class ColumnServiceImpl implements ColumnService {

	@Autowired
	private SysColumnDao columnDao;

	@Resource(name = "systemServiceImpl")
	private SystemService systemService;

	@Override
	public Map<String, Object> queryColumns(QueyNewsParams params, Integer pageNumber) {
		Map<String, Object> model = new HashMap<String, Object>();
		Integer total = columnDao.count(params);// 总计录数
		Pager<SysColumnBean> page = new Pager<SysColumnBean>(total, pageNumber);
		params.setRecordStart((pageNumber - 1) * page.getLimit());
		params.setRecordEnd(page.getLimit() * pageNumber);
		List<SysColumnBean> l = columnDao.queryColumns(params);
		page.setList(l);
		model.put("page", page); // 对应页面的信息
		model.put("queryParams", params);// 页面查询条件
		return model;
	}

	@Override
	public void deleteAllColumns(String[] columnNos) {
		columnDao.deleteAll(Arrays.asList(columnNos));
	}

	@Override
	public void deleteColumn(String columnNo) {
		columnDao.deleteColumn(columnNo);
	}

	@Override
	public Map<String, Object> showColumnInfo(String columnNo) {
		Map<String, Object> model = new HashMap<String, Object>();
		SysColumnBean params = columnDao.showColumnInfo(columnNo);
		model.put("columnInfo", params);
		return model;
	}

	@Override
	public List<SysColumnBean> getAllColumn() {
		List<SysColumnBean> columnList = new ArrayList<SysColumnBean>();
		columnList = columnDao.getTopColumn();
		return columnList;
	}

	@Override
	public void saveColumn(SysColumnBean params) {
		String columnNo = systemService.getSequenceNo("xw_NewsInfo");
		params.setsColumnNo(columnNo);
		String sGuid = systemService.getSequenceNo("xw_NewsInfo");
		params.setsGuid(sGuid);
		if(StringUtils.isEmpty(params.getsFatherNo())){
			params.setiLevel(0);
		} else {
			params.setiLevel(1);
		}
		columnDao.save(params);
	}

	@Override
	public void updateColumn(SysColumnBean params) {
		if(StringUtils.isNotBlank(params.getsFatherNo())){
			params.setiLevel(1);
		}
		columnDao.update(params);
	}
	
	public List<SysColumnBean> selectColumn(Map<String,Object> map){
		return columnDao.selectColumn(map);
	}
}
