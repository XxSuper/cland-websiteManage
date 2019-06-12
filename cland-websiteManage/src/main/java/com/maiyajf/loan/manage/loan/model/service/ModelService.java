/**
 * 
 */
package com.maiyajf.loan.manage.loan.model.service;

import java.util.Map;

import com.maiyajf.loan.manage.loan.model.params.QueryModelParams;
import com.maiyajf.loan.manage.loan.model.po.XwActivityModelBean;

/**
 * @author rui23
 * @version 创建时间：2016年2月14日 下午5:03:06
 */
public interface ModelService {

	/**
	 * 
	 * @project ModelService.java
	 * @function 分页查询员工活动模块
	 * @return Map<String,Object>
	 * @param params
	 * @param pageNumber
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午3:23:56
	 *
	 */
	Map<String, Object> queryModel(QueryModelParams params, Integer pageNumber);

	/**
	 * 
	 * @project ModelService.java
	 * @function 删除模块
	 * @return void
	 * @param id
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午3:24:27
	 *
	 */
	void deleteModel(String id);

	/**
	 * 
	 * @project ModelService.java
	 * @function 保存模块
	 * @return void
	 * @param params
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午3:25:00
	 *
	 */
	void saveModel(XwActivityModelBean params);

	/**
	 * 
	 * @project ModelService.java
	 * @function 更新模块
	 * @return void
	 * @param params
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午3:25:34
	 *
	 */
	void updateModel(XwActivityModelBean params);

	/**
	 * 
	 * @project ModelService.java
	 * @function 查询模块详情
	 * @return Map<String,Object>
	 * @param id
	 * @return
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午3:26:11
	 *
	 */
	Map<String, Object> showModelInfo(String id);

	/**
	 * 
	 * @project ModelService.java
	 * @function 删除选中模块
	 * @return void
	 * @param ids
	 * @author Min Dongxv
	 * @date 2017年10月18日 下午3:26:39
	 *
	 */
	void deleteAllModel(String[] ids);

}
