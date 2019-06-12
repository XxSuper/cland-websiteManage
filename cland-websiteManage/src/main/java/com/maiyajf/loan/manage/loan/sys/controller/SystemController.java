package com.maiyajf.loan.manage.loan.sys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.maiyajf.base.security.patchca.PatchcaImageCode;
import com.maiyajf.base.utils.log.AccessLogger;
import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.common.Constants;
import com.maiyajf.loan.manage.common.security.shiro.ShiroUtils;
import com.maiyajf.loan.manage.loan.sys.po.Menu;
import com.maiyajf.loan.manage.loan.sys.service.IMenuService;
import com.maiyajf.loan.manage.loan.sys.service.IUserService;
import com.maiyajf.loan.manage.loan.sys.service.SystemService;
import com.maiyajf.loan.manage.loan.sys.utils.CommonUtil;

@Controller
@RequestMapping(value = "/sys")
public class SystemController {

	@Resource(name = "menuServiceImpl")
	private IMenuService menuService;

	@Resource(name = "systemServiceImpl")
	private SystemService systemService;
	@Resource(name = "userServiceImpl")
	private IUserService userService;

	/**
	 * 方法名： login 描述： 处理登录的post请求
	 * 
	 * @author zhuzheng 创建时间：2015年9月29日 下午1:11:19
	 * @param request
	 * @param j_username
	 * @param j_password
	 * @return
	 *
	 */
	@RequestMapping(value = "/dologin.htm")
	public ModelAndView login(HttpServletRequest request, String j_username, String j_password) {
		// 登录操作
		String result = systemService.login(request, j_username, j_password);
		AccessLogger.info("处理登录的post请求dologin.htm", j_username, "j_username=" + j_username, result, 0);
		if (Constants.YES.equals(result)) {
			return new ModelAndView("redirect:index.htm");
		} else {
			return new ModelAndView("/login/login", null);
		}
	}

	/**
	 * 方法名： loginPage 描述： 登录页面
	 * 
	 * @author zhuzheng 创建时间：2015年9月29日 下午1:11:46
	 * @return
	 *
	 */
	@RequestMapping(value = "/login.htm")
	public ModelAndView loginPage() {
		return new ModelAndView("/login/login");
	}

	/**
	 * 方法名： logout 描述： 注销登录
	 * 
	 * @author zhuzheng 创建时间：2015年9月29日 下午1:11:53
	 *
	 */
	@RequestMapping(value = "/logout.htm")
	public String logout(HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			// 记录退出日志
			String logId = ShiroUtils.getSessionAttribute("logId").toString();
			// 更新此次登录的退出时间
			ShiroUtils.removeSessionAttribute("logId");
			systemService.updateLoginLogForLogout(logId, new Date());
			AccessLogger.info("注销登录logout.htm", CommonUtil.getUserName(), "", "", 0);
			subject.logout();

		}
		return "redirect:login.htm";
	}

	/**
	 * 方法名： index 描述： 首页
	 * 
	 * @author zhuzheng 创建时间：2015年9月29日 下午1:12:07
	 * @param request
	 * @return
	 *
	 */
	@RequestMapping("/index.htm")
	public ModelAndView index(HttpServletRequest request) {
		List<Menu> menus = menuService.getUserAllMeans(CommonUtil.getUserId());
		if (menus != null && menus.size() > 0) {
			// 把菜单数据存入session
			ShiroUtils.getSession().setAttribute("menus", menus);
		}
		return new ModelAndView("/index/index");
	}

	/**
	 * 方法名： left 描述： 左部分页面
	 * 
	 * @author zhuzheng 创建时间：2015年9月29日 下午1:12:16
	 * @param request
	 * @return
	 *
	 */
	@RequestMapping("/left.htm")
	public ModelAndView left(HttpServletRequest request) {
		return new ModelAndView("/index/left");
	}

	/**
	 * 方法名： top 描述： 顶部页面
	 * 
	 * @author zhuzheng 创建时间：2015年9月29日 下午1:12:29
	 * @param request
	 * @return
	 *
	 */
	@RequestMapping("/top.htm")
	public ModelAndView top(HttpServletRequest request) {
		return new ModelAndView("/index/top");
	}

	/**
	 * 方法名： center 描述： 中心页面
	 * 
	 * @author zhuzheng 创建时间：2015年9月29日 下午1:12:38
	 * @param request
	 * @return
	 *
	 */
	@RequestMapping("/center.htm")
	public ModelAndView center(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		int count = systemService.judgeFirstLogin(ShiroUtils.getCurrentUser().getUserNo());
		model.put("count", count);
		AccessLogger.info("首页中心页面center.htm", CommonUtil.getUserName(), "", model.toString(), 0);
		return new ModelAndView("/index/center", model);
	}

	/**
	 * 方法名： getLoginStatus 描述：获取登录状态，判断session是否过期
	 * 
	 * @author zhuzheng 创建时间：2015年10月23日 上午10:43:18
	 * @param request
	 * @return
	 *
	 */
	@RequestMapping("/getLoginStatus.htm")
	@ResponseBody
	public Map<String, Object> getLoginStatus(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		if (CommonUtil.getUser() != null) {
			model.put("flag", Constants.YES);
		} else {
			model.put("flag", Constants.NO);
		}
		AccessLogger.info("获取登录状态，判断session是否过期  getLoginStatus.htm", CommonUtil.getUserName(), "", model.toString(),
				0);
		return model;
	}

	/**
	 * 打印login需要用到的验证码
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/captchaCode.htm")
	public void captchaRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String imgCode = PatchcaImageCode.getImgCode(request, response, "");
		// 将验证码存入SESSION
		ShiroUtils.putToSession("captchalogin", imgCode);

	}

	/**
	 * 方法名： sendLoginSmsCode 描述： 校验图片验证码,发送登录短信
	 * 
	 * @author zhuzheng 创建时间：2015年11月20日 下午1:48:30
	 * @param name
	 * @param j_captcha
	 * @param request
	 * @return
	 *
	 */
	@RequestMapping(value = "/sendLoginSmsCode.htm", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> sendLoginSmsCode(String name, String j_captcha, HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			model = systemService.sendLoginSmsCode(name, j_captcha, request);
			return model;
		} catch (Exception e) {
			ExceptionLogger.error("sys", "重新发送登录短信异常", e);
			throw new RuntimeException(e);
		} finally {
			AccessLogger.info("校验图片验证码,发送登录短信 sendLoginSmsCode.htm", CommonUtil.getUserName(),
					"name=" + name + ";j_captcha=" + j_captcha, model.toString(), 0);
		}
	}

}
