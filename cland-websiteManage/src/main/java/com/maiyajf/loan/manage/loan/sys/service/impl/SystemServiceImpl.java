package com.maiyajf.loan.manage.loan.sys.service.impl;

import com.maiyajf.base.constants.IAppIDType;
import com.maiyajf.base.po.BaseResponse;
import com.maiyajf.base.utils.base.IdGen;
import com.maiyajf.base.utils.log.DebugLogger;
import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.base.utils.log.OutInterfaceLogger;
import com.maiyajf.loan.manage.common.Constants;
import com.maiyajf.loan.manage.common.dao.UtilDao;
import com.maiyajf.loan.manage.common.security.shiro.CaptchaException;
import com.maiyajf.loan.manage.common.security.shiro.ShiroUtils;
import com.maiyajf.loan.manage.common.security.shiro.SmsException;
import com.maiyajf.loan.manage.common.utils.IpUtil;
import com.maiyajf.loan.manage.common.utils.JedisBisUtil;
import com.maiyajf.loan.manage.common.utils.StringUtil;
import com.maiyajf.loan.manage.config.Global;
import com.maiyajf.loan.manage.loan.sys.dao.SystemDao;
import com.maiyajf.loan.manage.loan.sys.dao.UserDao;
import com.maiyajf.loan.manage.loan.sys.po.User;
import com.maiyajf.loan.manage.loan.sys.service.SystemService;
import com.maiyajf.loan.manage.loan.sys.utils.CommonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 项目名称： myLoan-manage 类名称： SystemServiceImpl 描述： 系统service
 * 
 * @author zhuzheng 创建时间： 2015年11月17日 下午6:36:56 修改人：zhuzheng 修改日期： 2015年11月17日
 *         修改备注：
 *
 */
@Service("systemServiceImpl")
public class SystemServiceImpl implements SystemService {

	@Autowired
	private SystemDao systemDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private UtilDao utilDao;
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 方法名： saveLoginLog 描述： 记录登录日志
	 * 
	 * @author zhuzheng 创建时间：2015年11月17日 下午6:37:48
	 * @param sGuid
	 * @param sUserNo
	 * @param sUserName
	 * @param sLoginDate
	 * @param sLogoutDate
	 * @param sIp
	 * @param sCity
	 * @param sCreateDate
	 * @see com.maiyajf.loan.manage.loan.sys.service.SystemService#saveLoginLog(java.lang.String,
	 *      java.lang.String, java.lang.String, java.util.Date, java.util.Date,
	 *      java.lang.String, java.lang.String, java.util.Date)
	 *
	 */
	@Override
	public void saveLoginLog(String sGuid, String sUserNo, String sUserName, Date sLoginDate, Date sLogoutDate,
			String sIp, String sCity, Date sCreateDate) {
		systemDao.saveLoginLog(sGuid, sUserNo, sUserName, sLoginDate, sLogoutDate, sIp, sCity, sCreateDate);
	}

	/**
	 * 方法名： updateLoginLogForLogout 描述： 更新退出时间
	 * 
	 * @author zhuzheng 创建时间：2015年11月17日 下午6:38:02
	 * @param sGuid
	 * @param sLogoutDate
	 * @see com.maiyajf.loan.manage.loan.sys.service.SystemService#updateLoginLogForLogout(java.lang.String,
	 *      java.util.Date)
	 *
	 */
	@Override
	public void updateLoginLogForLogout(String sGuid, Date sLogoutDate) {
		systemDao.updateLoginLogForLogout(sGuid, sLogoutDate);
	}

	/**
	 * 方法名： saveAccessLog 描述： 记录访问日志
	 * 
	 * @author zhuzheng 创建时间：2015年11月17日 下午6:37:25
	 * @param sGuid
	 * @param sUserName
	 * @param sUrlAddress
	 * @param sPsermisiionNo
	 * @param sPermissionName
	 * @param sIp
	 * @param sCity
	 * @param dVisitTime
	 * @param sCreateDate
	 * @see com.maiyajf.loan.manage.loan.sys.service.SystemService#saveAccessLog(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.util.Date, java.util.Date)
	 *
	 */
	@Override
	public void saveAccessLog(String sGuid, String sUserName, String sUrlAddress, String sPsermisiionNo,
			String sPermissionName, String sIp, String sCity, Date dVisitTime, Date sCreateDate) {
		systemDao.saveAccessLog(sGuid, sUserName, sUrlAddress, sPsermisiionNo, sPermissionName, sIp, sCity, dVisitTime,
				sCreateDate);
	}

	/**
	 * 方法名： updateLoginTime 描述： 更新登录时间
	 * 
	 * @author zhuzheng 创建时间：2015年11月17日 下午6:37:09
	 * @param date
	 * @param userId
	 * @see com.maiyajf.loan.manage.loan.sys.service.SystemService#updateLoginTime(java.util.Date,
	 *      java.lang.String)
	 *
	 */
	@Override
	public void updateLoginTime(Date date, String userId) {
		systemDao.updateLoginTime(date, userId);
	}

	/**
	 * 方法名： sendLoginSmsCode 描述： 发送登录短信
	 * 
	 * @author zhuzheng 创建时间：2015年11月20日 下午1:57:23
	 * @param name
	 * @param request
	 * @return
	 * @see com.maiyajf.loan.manage.loan.sys.service.SystemService#sendLoginSmsCode(java.lang.String,
	 *      javax.servlet.http.HttpServletRequest)
	 *
	 */
	@Override
	public Map<String, Object> sendLoginSmsCode(String name, String j_captcha, HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		String flag = Constants.NO;
		// session里面的验证码
		String sessionCaptcha = ShiroUtils.getSessionAttribute("captchalogin") == null ? ""
				: ShiroUtils.getSessionAttribute("captchalogin").toString();
		// 移除session缓存里面的验证码
		ShiroUtils.removeSessionAttribute("captchalogin");

		if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(j_captcha) && StringUtils.isNotBlank(sessionCaptcha)
				&& j_captcha.toLowerCase().equals(sessionCaptcha.toLowerCase())) {
			// 发送短信部分
			// 获取登录用户的手机号
			DebugLogger.debug("登录------开始发送短信部分");
			String phone = userDao.getPhoneByUserName(name);
			DebugLogger.debug("登录---获取该登录用户的手机号phone=" + phone);
			// 判断发送短信时间间隔
			if (JedisBisUtil.ttl("sys_login_smsCode_count_down:" + phone) > 0) {
				// 还在倒计时时间内，不能继续发送
				flag = Constants.FALSE;
			} else {
				if (StringUtils.isNotBlank(phone)) {
					sendSms(name, phone);
					model.put("time", Constants.COUNT_DOWN_EXPIRE);
					model.put("mobile", StringUtil.getDealMobile(phone));
					flag = Constants.YES;
				} else {
					model.put("errorMessage", "用户名不正确");
				}
			}
		}
		model.put("flag", flag);
		return model;
	}

	/**
	 * 方法名： sendSms 描述： 发送短信的方法
	 * 
	 * @author zhuzheng 创建时间：2015年11月20日 下午2:09:32
	 * @param name
	 * @param phone
	 *
	 */
	public void sendSms(String name, String phone) {
		DebugLogger.debug("登录---获取数据库里面该登录用户的手机号phone=" + phone);
		Random random = new Random();
		StringBuilder code = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			code.append(random.nextInt(10));
		}
		DebugLogger.debug("登录--发送短信部分---短信验证码=" + code.toString());
		// 正式发送短信
		BaseResponse baseResponse = null;
		Map<String, Object> reqParams = new HashMap<String, Object>();
		String url = Global.getConfig("sendShortMsg_Url") + "sendMsg4BackManageLogin";
		try {
			reqParams.put("appId", IAppIDType.MYLOAN_MANAGER);
			reqParams.put("sSecurityCode", code.toString());
			reqParams.put("sMobile", phone);
			baseResponse = restTemplate.postForObject(url, reqParams, BaseResponse.class);
			// Map<String, Object> result = SendMegUtil.sendMessage(phone,
			// "后台登录短信验证码：" +
			// code.toString());
			// 设置短信有效时间
			JedisBisUtil.putExpire("sys_login_smsCode:" + phone, Constants.EXPIRE, code.toString());
			// 设置短信发送间隔时间
			JedisBisUtil.putExpire("sys_login_smsCode_count_down:" + phone, Constants.COUNT_DOWN_EXPIRE,
					code.toString());
			DebugLogger.debug("登录---发送短信部分结束");
		} catch (Exception e) {
			ExceptionLogger.error("sys", "后台系统调用短信中心发送短信异常reqParams=" + reqParams, e);
		} finally {
			OutInterfaceLogger.info("调用短信中心发送短信", url, new Date(), reqParams.toString(), new Date(), baseResponse + "");
		}
	}

	/**
	 * 方法名： getCityByIp 描述： 根据ip地址查所在城市
	 * 
	 * @author zhuzheng 创建时间：2015年11月26日 上午11:22:54
	 * @param ipInt
	 * @return
	 * @see com.maiyajf.loan.manage.loan.sys.service.SystemService#getCityByIp(int)
	 *
	 */
	@Override
	public String getCityByIp(long ipInt) {
		return utilDao.getCityByIp(ipInt);
	}

	/**
	 * 方法名： login 描述： 登录操作
	 * 
	 * @author zhuzheng 创建时间：2015年12月2日 下午5:46:11
	 * @param request
	 * @param j_username
	 * @param j_password
	 * @param j_smsCode
	 * @return
	 * @see com.maiyajf.loan.manage.loan.sys.service.SystemService#login(javax.servlet.http.HttpServletRequest,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String)
	 *
	 */
	@Override
	public String login(HttpServletRequest request, String j_username, String j_password) {

		// 让旧session失效
		SecurityUtils.getSubject().logout();
		String flag = Constants.NO;
		// 禁用标记
		boolean bisFreeze = false;
		DebugLogger.debug("开始登录后台;参数userName=" + j_username);
		try {
			// 用户名
			if (StringUtils.isBlank(j_username)) {
				throw new CaptchaException("登录名不能为空");
			}
			// 密码
			if (StringUtils.isBlank(j_password)) {
				throw new CaptchaException("登录口令不能为空");
			}
			DebugLogger.debug("登录后台，获取缓存里面的短信验证码");

			// 短信验证码正确
			DebugLogger.debug("登录后台，短信验证码有效------正式开始登录处理");
			Subject subject = SecurityUtils.getSubject();
			subject.login(new UsernamePasswordToken(j_username, j_password));

			if (subject.isAuthenticated()) {
				// 记录登录日志
				User user = CommonUtil.getUser();
				DebugLogger.debug("登录后台成功" + user);
				if (1 == user.getBisFreeze()) {
					// 更新最后登录时间
					DebugLogger.debug("登录后台成功--------更新最后登录时间，记录登录日志");
					updateLoginTime(new Date(), user.getGuid());
					String logId = IdGen.uuid();
					String ip = CommonUtil.getClientIP(request);
					String city = null;//IpUtil.getCityByIp(ip);
					saveLoginLog(logId, user.getUserNo(), user.getUserName(), new Date(), null, ip, city, new Date());
					ShiroUtils.putToSession("logId", logId);
					flag = Constants.YES;
				} else {
					bisFreeze = true;
				}
			} else {
				throw new SmsException("短信验证码不正确，请重新发送后填写新验证码");
			}
		} catch (CaptchaException ae) {
			// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			request.setAttribute("message_login", ae.getMessage());
		} catch (SmsException ae) {
			// 短信验证码异常
			request.setAttribute("message_login", ae.getMessage());
		} catch (UnknownAccountException uae) {
			request.setAttribute("message_login", "用户名或密码不正确");
		} catch (IncorrectCredentialsException ice) {
			request.setAttribute("message_login", "用户名或密码不正确");
		} catch (LockedAccountException lae) {
			request.setAttribute("message_login", "账户已锁定");
		} catch (ExcessiveAttemptsException eae) {
			request.setAttribute("message_login", "用户名或密码错误次数过多");
		} catch (AuthenticationException ae) {
			// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			request.setAttribute("message_login", "用户名或密码不正确");
		} catch (Exception e) {
			request.setAttribute("message_login", "后台管理系统异常!!!!!!");
			ExceptionLogger.error("sys", "登录后台管理系统异常", e);
		}
		if (bisFreeze) {
			request.setAttribute("message_login", "该用户已被禁用");
		}
		request.setAttribute("j_username", j_username);
		request.setAttribute("j_password", j_password);
		return flag;
	}

	@Override
	public int judgeFirstLogin(String sUserNo) {
		return systemDao.judgeFirstLogin(sUserNo);
	}

	public String getSequenceNo(String tableName) {
		Map<String, String> params = new HashMap<>();
		params.put("tableName", tableName);
		return systemDao.querySequenceNo(params);

	}
}
