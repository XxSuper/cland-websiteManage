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
 * 功能描述：董事长致辞Controller
 *
 * @Author：xinpei.xu
 * @Date：2017年10月17日 16:30
 */
@Controller
@RequestMapping("/knowCland")
public class ChairmanSpeechController {

    @Autowired
    private NewsInfoService newsInfoService;

    /**
     * 查询董事长致辞
     * @param pageNumber
     * @return
     */
    @RequestMapping("/chairmanSpeechQuery.htm")
    public ModelAndView chairmanSpeechQuery(QueyNewsParams queryParams, @RequestParam(value = "pageNumber", required = false) Integer pageNumber) {
        if (null == pageNumber || pageNumber < 1) {
            pageNumber = 1;
        }
        // 查询董事长致辞
        try {
            queryParams.setiType(12);
            Map<String, Object> map = newsInfoService.queryNews(queryParams, pageNumber);
            return new ModelAndView("/knowCland/chairmanSpeech", map);
        } catch (Exception e) {
            ExceptionLogger.error("查询董事长致辞：", "异常：", e);
            return new ModelAndView("/knowCland/chairmanSpeech", null);
        }
    }

    /**
     * 跳转新增董事长致辞页面
     * @param request
     * @return
     */
    @RequestMapping(value = "/showSaveChairmanSpeech.htm")
    public ModelAndView showSaveCourse(HttpServletRequest request) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("operate", "add");
        return new ModelAndView("knowCland/addChairmanSpeech", model);
    }

    /**
     * 保存/修改董事长致辞
     * @param request
     * @param newsInfoParams
     * @param show
     * @param operate
     * @return
     */
    @RequestMapping(value = "/saveChairmanSpeech.htm")
    public ModelAndView saveChairmanSpeech(HttpServletRequest request, XwNewsInfoBean newsInfoParams,
                                   @RequestParam(value = "show", required = false) Integer show,
                                   @RequestParam(value = "operate", required = false) String operate) {
        AccessLogger.info("保存/修改董事长致辞：show:" + show+ ",operate:" + operate, newsInfoParams.toString(), DateUtils.getCurrentTime());
        if (null == show) {
            return new ModelAndView("knowCland/addChairmanSpeech", null);
        }
        if (StringUtils.equals(operate, "add")) {
            newsInfoService.saveNews(newsInfoParams);
        } else {
            newsInfoService.updateNews(newsInfoParams);
        }
        return new ModelAndView("redirect:chairmanSpeechQuery.htm?iType=" + newsInfoParams.getiType());
    }

    /**
     * 跳转修改董事长致辞页面
     * @param newsNo
     * @return
     */
    @RequestMapping(value = "/showEditChairmanSpeech.htm")
    public ModelAndView showEditChairmanSpeech(@RequestParam(value = "newsNo") String newsNo) {
        AccessLogger.info("跳转修改董事长致辞页面：", "", DateUtils.getCurrentTime());
        Map<String, Object> model = new HashMap<String, Object>();
        model = newsInfoService.showNewsInfo(newsNo);
        model.put("operate", "edit");
        return new ModelAndView("knowCland/addChairmanSpeech", model);
    }
}
