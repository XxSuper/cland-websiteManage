package com.maiyajf.loan.manage.loan.knowCland.controller;

import com.maiyajf.base.utils.base.DateUtils;
import com.maiyajf.base.utils.log.AccessLogger;
import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.loan.news.params.QueyNewsParams;
import com.maiyajf.loan.manage.loan.news.po.XwNewsInfoBean;
import com.maiyajf.loan.manage.loan.news.service.NewsInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：合作伙伴Controller
 *
 * @Author：xinpei.xu
 * @Date：2017年10月17日 14:57
 */
@Controller
@RequestMapping("/knowCland")
public class PartnerController {

    @Autowired
    private NewsInfoService newsInfoService;

    /**
     * 查询合作伙伴
     * @param pageNumber
     * @return
     */
    @RequestMapping("/partnerQuery.htm")
    public ModelAndView partnerQuery(QueyNewsParams queryParams, @RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
        if (null == pageNumber || pageNumber < 1) {
            pageNumber = 1;
        }
        // 查询合作伙伴
        try {
            queryParams.setiType(10);
            Map<String, Object> map = newsInfoService.queryNews(queryParams, pageNumber);
            return new ModelAndView("/knowCland/partner", map);
        } catch (Exception e) {
            ExceptionLogger.error("查询合作伙伴：", "异常：", e);
            return new ModelAndView("/knowCland/partner", null);
        }
    }

    /**
     * 跳转新增合作伙伴页面
     * @param request
     * @return
     */
    @RequestMapping(value = "/showSavePartner.htm")
    public ModelAndView showSavePartner(HttpServletRequest request) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("operate", "add");
        return new ModelAndView("knowCland/addPartner", model);
    }

    /**
     * 保存/修改合作伙伴
     * @param request
     * @param newsInfoParams
     * @param show
     * @param operate
     * @return
     */
    @RequestMapping(value = "/savePartner.htm")
    public ModelAndView savePartner(HttpServletRequest request, XwNewsInfoBean newsInfoParams,
                                               @RequestParam(value = "show", required = false) Integer show,
                                               @RequestParam(value = "operate", required = false) String operate) {
        AccessLogger.info("保存/修改合作伙伴：show:" + show+ ",operate:" + operate, newsInfoParams.toString(), DateUtils.getCurrentTime());
        if (null == show) {
            return new ModelAndView("knowCland/addPartner", null);
        }
        if (StringUtils.equals(operate, "add")) {
            newsInfoService.saveNews(newsInfoParams);
        } else {
            newsInfoService.updateNews(newsInfoParams);
        }
        return new ModelAndView("redirect:partnerQuery.htm?iType=" + newsInfoParams.getiType());
    }

    /**
     * 跳转修改合作伙伴页面
     * @param newsNo
     * @return
     */
    @RequestMapping(value = "/showEditPartner.htm")
    public ModelAndView showEditPartner(@RequestParam(value = "newsNo") String newsNo) {
        AccessLogger.info("跳转修改荣誉资质页面：", "", DateUtils.getCurrentTime());
        Map<String, Object> model = new HashMap<String, Object>();
        model = newsInfoService.showNewsInfo(newsNo);
        model.put("operate", "edit");
        return new ModelAndView("knowCland/addPartner", model);
    }
}
