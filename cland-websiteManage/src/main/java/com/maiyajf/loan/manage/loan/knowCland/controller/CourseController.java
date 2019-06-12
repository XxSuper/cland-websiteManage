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
 * 功能描述：中地历程Controller
 *
 * @Author：xinpei.xu
 * @Date：2017年10月17日 15:53
 */
@Controller
@RequestMapping("/knowCland")
public class CourseController {

    @Autowired
    private NewsInfoService newsInfoService;

    /**
     * 查询中地历程
     * @param pageNumber
     * @return
     */
    @RequestMapping("/courseQuery.htm")
    public ModelAndView courseQuery(QueyNewsParams queryParams, @RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
        if (null == pageNumber || pageNumber < 1) {
            pageNumber = 1;
        }
        // 查询中地历程
        try {
            queryParams.setiType(5);
            Map<String, Object> map = newsInfoService.queryNews(queryParams, pageNumber);
            return new ModelAndView("/knowCland/course", map);
        } catch (Exception e) {
            ExceptionLogger.error("查询中地历程：", "异常：", e);
            return new ModelAndView("/knowCland/course", null);
        }
    }

    /**
     * 跳转新增中地历程页面
     * @param request
     * @return
     */
    @RequestMapping(value = "/showSaveCourse.htm")
    public ModelAndView showSaveCourse(HttpServletRequest request) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("operate", "add");
        return new ModelAndView("knowCland/addCourse", model);
    }

    /**
     * 保存/修改中地历程
     * @param request
     * @param newsInfoParams
     * @param show
     * @param operate
     * @return
     */
    @RequestMapping(value = "/saveCourse.htm")
    public ModelAndView saveCourse(HttpServletRequest request, XwNewsInfoBean newsInfoParams,
                                    @RequestParam(value = "show", required = false) Integer show,
                                    @RequestParam(value = "operate", required = false) String operate) {
        AccessLogger.info("保存/修改中地历程：show:" + show+ ",operate:" + operate, newsInfoParams.toString(), DateUtils.getCurrentTime());
        if (null == show) {
            return new ModelAndView("knowCland/addCourse", null);
        }
        if (StringUtils.equals(operate, "add")) {
            newsInfoService.saveNews(newsInfoParams);
        } else {
            newsInfoService.updateNews(newsInfoParams);
        }
        return new ModelAndView("redirect:courseQuery.htm?iType=" + newsInfoParams.getiType());
    }

    /**
     * 跳转修改中地历程页面
     * @param newsNo
     * @return
     */
    @RequestMapping(value = "/showEditCourse.htm")
    public ModelAndView showEditCourse(@RequestParam(value = "newsNo") String newsNo) {
        AccessLogger.info("跳转修改中地历程页面：", "", DateUtils.getCurrentTime());
        Map<String, Object> model = new HashMap<String, Object>();
        model = newsInfoService.showNewsInfo(newsNo);
        model.put("operate", "edit");
        return new ModelAndView("knowCland/addCourse", model);
    }
}
