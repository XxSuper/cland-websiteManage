package com.maiyajf.loan.manage.loan.column.controller;

import com.maiyajf.base.utils.base.DateUtils;
import com.maiyajf.base.utils.log.AccessLogger;
import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.loan.column.po.SysColumnBean;
import com.maiyajf.loan.manage.loan.column.service.ColumnService;
import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/column")
public class ColumnController {

	@Autowired
	private ColumnService columnService;

	/**
	 * 查询栏目
	 * @param queryParams
	 * @param pageNumber
	 * @param show
	 * @return
	 */
	@RequestMapping(value = "query.htm")
	public ModelAndView query(QueyNewsParams queryParams,
							  @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
							  @RequestParam(value = "show", required = false) Integer show) {
		ModelAndView model;
		AccessLogger.info("栏目管理查询：show:" + show + ",pageNumber:" + pageNumber, queryParams.toString(),
				DateUtils.getCurrentTime());
		if (null == pageNumber || pageNumber < 1) {
			pageNumber = 1;
		}
		// 根据查询参数，查询数据
		try {
			Map<String, Object> map = columnService.queryColumns(queryParams, pageNumber);
			model = new ModelAndView("column/columnPageManage", map);
		} catch (Exception e) {
			ExceptionLogger.error("新闻管理后台：", "栏目管理查询异常：", e);
			model = new ModelAndView("column/columnPageManage", null);
		}
		return model;
	}

	@RequestMapping(value = "deleteAllColumns.htm")
	@ResponseBody
	public String deleteAllColumns(@RequestParam(value = "columnNos") String columnNos) {
		AccessLogger.info("", "栏目批量删除：columnNos:" + columnNos.toString(), DateUtils.getCurrentTime());
		try {
			String[] str = columnNos.split(",");
			if (str.length == 0) {
				return null;
			}
			columnService.deleteAllColumns(str);
			return "操作成功！";
		} catch (Exception e) {
			ExceptionLogger.error("栏目管理后台：", "栏目批量删除异常：", e);
			return "操作失败！";
		}
	}

	@RequestMapping(value = "deleteColumn.htm")
	@ResponseBody
	public String deleteColumns(@RequestParam(value = "columnNo") String columnNo) {
		AccessLogger.info("", "栏目删除：columnNo:" + columnNo, DateUtils.getCurrentTime());
		try {
			columnService.deleteColumn(columnNo);
			return "操作成功！";
		} catch (Exception e) {
			ExceptionLogger.error("栏目管理后台：", "栏目删除异常：", e);
			return "操作失败！";
		}
	}

	@RequestMapping(value = "/showSaveColumn.htm")
	public ModelAndView showSaveColumns(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("operate", "add");
		List<SysColumnBean> columnList = columnService.getAllColumn();
		if (columnList != null && columnList.size() > 0) {
			model.put("columnList", columnList);
		}
		return new ModelAndView("column/addColumnPage", model);
	}

	@RequestMapping(value = "/showEditColumn.htm")
	public ModelAndView showEditColumn(@RequestParam(value = "columnNo") String columnNo,
      	String sFatherNo) {
		AccessLogger.info("栏目信息查询：", "", DateUtils.getCurrentTime());
		Map<String, Object> model = columnService.showColumnInfo(columnNo);
		model.put("operate", "edit");
		model.put("sFatherNo", sFatherNo);
		List<SysColumnBean> columnList = columnService.getAllColumn();
		if (columnList != null && columnList.size() > 0) {
			model.put("columnList", columnList);
		}
		return new ModelAndView("column/addColumnPage", model);
	}

	@RequestMapping(value = "/saveColumnInfo.htm")
	public ModelAndView save(HttpServletRequest request, SysColumnBean columnInfoParams,
							 @RequestParam(value = "show", required = false) Integer show,
							 @RequestParam(value = "operate", required = false) String operate) {
		AccessLogger.info("新闻管理查询：show:" + show+ ",operate:" + operate, columnInfoParams.toString(), DateUtils.getCurrentTime());
		if (null == show) {
			return new ModelAndView("column/addColumnPage", null);
		}
		if (StringUtils.equals(operate, "add")) {
			columnService.saveColumn(columnInfoParams);
		} else {
			columnService.updateColumn(columnInfoParams);
		}
		return new ModelAndView("redirect:query.htm?show=" + 1);
	}
}
