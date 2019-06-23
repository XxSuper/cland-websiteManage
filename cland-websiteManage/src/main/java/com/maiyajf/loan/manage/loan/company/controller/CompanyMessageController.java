package com.maiyajf.loan.manage.loan.company.controller;

import com.maiyajf.base.utils.base.DateUtils;
import com.maiyajf.base.utils.log.AccessLogger;
import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.loan.company.po.CompanyMessageBean;
import com.maiyajf.loan.manage.loan.company.service.CompanyMessageService;
import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/company")
public class CompanyMessageController {

	@Autowired
	private CompanyMessageService companyMessageService;

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
							  @RequestParam(value = "show", required = false) Integer show,
							  @RequestParam(value = "isAbout", required = false) Integer isAbout) {
		ModelAndView model;
		AccessLogger.info("栏目管理查询：show:" + show + ",pageNumber:" + pageNumber, queryParams.toString(),
				DateUtils.getCurrentTime());
		if (null == pageNumber || pageNumber < 1) {
			pageNumber = 1;
		}
		// 根据查询参数，查询数据
		try {
			Map<String, Object> map = companyMessageService.queryCompany(queryParams, pageNumber);
			map.put("isAbout", isAbout);
			model = new ModelAndView("company/companyPageManage", map);
		} catch (Exception e) {
			ExceptionLogger.error("新闻管理后台：", "栏目管理查询异常：", e);
			model = new ModelAndView("company/companyPageManage", null);
		}
		return model;
	}

	@RequestMapping(value = "/showEditCompany.htm")
	public ModelAndView showEditCompany(@RequestParam(value = "sGuid") String sGuid,
										@RequestParam(value = "isAbout") String isAbout) {
		AccessLogger.info("栏目信息查询：", "", DateUtils.getCurrentTime());
		Map<String, Object> model = companyMessageService.showCompanyInfo(sGuid);
		model.put("isAbout", isAbout);
		model.put("operate", "edit");
		return new ModelAndView("company/addCompanyPage", model);
	}

	@RequestMapping(value = "/saveCompanyInfo.htm")
	public ModelAndView save(HttpServletRequest request, CompanyMessageBean companyInfoParams,
							 @RequestParam(value = "show", required = false) Integer show,
							 @RequestParam(value = "operate", required = false) String operate,
							 @RequestParam(value = "isAbout", required = false) String isAbout) {
		AccessLogger.info("新闻管理查询：show:" + show+ ",operate:" + operate, companyInfoParams.toString(), DateUtils.getCurrentTime());
		if (null == show) {
			return new ModelAndView("company/addCompanyPage", null);
		}
		if (StringUtils.equals(operate, "add")) {
		} else {
			companyMessageService.updateCompany(companyInfoParams);
		}
		return new ModelAndView("redirect:query.htm?show=" + 1 + "&isAbout=" + isAbout);
	}
}
