package com.maiyajf.loan.manage.loan.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.maiyajf.base.utils.base.MD5;
import com.maiyajf.base.utils.log.AccessLogger;
import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.common.Constants;
import com.maiyajf.loan.manage.common.service.ActionService;
import com.maiyajf.loan.manage.common.utils.StringUtil;
import com.maiyajf.loan.manage.loan.sys.po.Role;
import com.maiyajf.loan.manage.loan.sys.po.User;
import com.maiyajf.loan.manage.loan.sys.service.IUserService;
import com.maiyajf.loan.manage.loan.sys.service.RoleService;
import com.maiyajf.loan.manage.loan.sys.utils.CommonUtil;

/**
 * @ClassName: UserController
 * @Description: usercontroller
 * @author: zhuangsheng.chen
 * @date: 2015年10月15日 下午1:20:55
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Resource(name = "userServiceImpl")
	private IUserService userService;
	@Resource(name = "roleServiceImpl")
	private RoleService roleService;
	@Resource(name = "actionServiceImpl")
	private ActionService actionService;

	/**
	 * @Title: role
	 * @Description: 查询用户
	 * @param suserName
	 * @return
	 * @return: ModelAndView
	 */
	@RequestMapping("/userQuery.htm")
	public ModelAndView userQuery(@RequestParam(value = "suserName", required = false) String suserName,
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			@RequestParam(value = "sMobile", required = false) String sMobile) {
		Map<String, Object> model = new HashMap<String, Object>();
		int page = 1;
		if (StringUtils.isBlank(pageNumber)) {
			page = 1;
		} else {
			page = Integer.parseInt(pageNumber);
		}
		model = userService.getUsersByNames(suserName, sMobile, page);
		AccessLogger.info("查询用户 userQuery.htm", CommonUtil.getUserName(),
				"suserName" + suserName + ";pageNumber=" + pageNumber + ";sMobile=" + sMobile, model.toString(), 0);
		return new ModelAndView("/user/user", model);
	}

	/**
	 * @Title: role
	 * @Description: 查询待审核用户
	 * @param suserName
	 * @return
	 * @return: ModelAndView
	 */
	@RequestMapping("/operatorAudit.htm")
	public ModelAndView operatorAudit(@RequestParam(value = "suserName", required = false) String suserName,
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			@RequestParam(value = "sMobile", required = false) String sMobile) {
		Map<String, Object> model = new HashMap<String, Object>();
		int page = 1;
		if (StringUtils.isBlank(pageNumber)) {
			page = 1;
		} else {
			page = Integer.parseInt(pageNumber);
		}
		model = userService.getUsersForAudit(suserName, sMobile, page);
		AccessLogger.info("查询待审核用户 operatorAudit.htm", CommonUtil.getUserName(),
				"suserName" + suserName + ";pageNumber=" + pageNumber + ";sMobile=" + sMobile, model.toString(), 0);
		return new ModelAndView("/user/operatorAudit", model);
	}

	/**
	 * 方法名： add/edit 描述：
	 * 
	 * @author zhuzheng 创建时间：2015年10月6日 上午10:45:58
	 * @param role
	 * @return
	 *
	 */
	@RequestMapping("/editUser.htm")
	@ResponseBody
	public Map<String, Object> editUser(HttpServletRequest request, User user) {
		Map<String, Object> model = new HashMap<String, Object>();
		String flag = Constants.NO;
		actionService.saveAction(request, "用户管理:添加/修改用户:提交", "参数:user=" + user.getRealName());
		try {
			if (StringUtils.isNotBlank(user.getUserName()) && StringUtils.isNotBlank(user.getRealName())
					&& StringUtil.isMobileNO(user.getMobile())) {

				model = userService.editUser(user);
				flag = Constants.YES;
			}
			model.put("flag", flag);
		} catch (Exception e) {
			ExceptionLogger.error("sys", "添加/修改用户异常user=" + user.toString(), e);
		} finally {
			AccessLogger.info("编辑用户 editUser.htm", CommonUtil.getUserName(), "User" + user.toString(), model.toString(),
					0);
		}
		return model;
	}

	/**
	 * 方法名： submitAudit 描述： 管理员审核
	 * 
	 * @author zhuzheng 创建时间：2016年1月11日 下午5:15:40
	 * @param request
	 * @param sGuid
	 * @param approvel
	 * @return
	 *
	 */
	@RequestMapping("/submitAudit.htm")
	@ResponseBody
	public Map<String, Object> submitAudit(HttpServletRequest request, String sGuid, Integer approvel) {
		Map<String, Object> model = new HashMap<String, Object>();
		String flag = Constants.NO;
		actionService.saveAction(request, "待审核用户:提交审核", "参数:sGuid=" + sGuid + ";approvel=" + approvel);
		try {
			userService.submitAudit(sGuid, approvel);
			flag = Constants.YES;
			model.put("flag", flag);
		} catch (Exception e) {
			ExceptionLogger.error("sys", "审核用户异常sGuid=" + sGuid + ";approvel=" + approvel, e);
		} finally {
			AccessLogger.info("审核系统用户 submitAudit.htm", CommonUtil.getUserName(),
					"sGuid=" + sGuid + ";approvel=" + approvel, model.toString(), 0);
		}
		return model;
	}

	/**
	 * 方法名： setRole 描述： 分配角色页面
	 * 
	 * @author zhuzheng 创建时间：2015年11月11日 上午11:32:22
	 * @param userId
	 * @return
	 *
	 */
	@RequestMapping("/assignRole.htm")
	public ModelAndView setRole(@RequestParam(value = "userId", required = false) String userId) {
		Map<String, Object> model = new HashMap<String, Object>();
		User user = userService.getUserById(userId);
		List<Role> roleList = roleService.getAllRoles();
		List<String> userRoleIds = userService.getUserRoleIds(userId);
		if (roleList != null && roleList.size() > 0) {
			model.put("allRoleList", roleList);
		}
		if (roleList != null && roleList.size() > 0) {
			model.put("userRoleIds", userRoleIds);
		}
		model.put("user", user);
		AccessLogger.info("分配角色页面 assignRole.htm", CommonUtil.getUserName(), "userId" + userId, model.toString(), 0);
		return new ModelAndView("/user/setRole", model);
	}

	/**
	 * 方法名： setRole 描述： 为用户 设置角色
	 * 
	 * @author zhuzheng 创建时间：2015年11月11日 上午11:16:54
	 * @param type
	 * @param sUserId
	 * @param roleIdList
	 * @return
	 *
	 */
	@RequestMapping("/editUserRole.htm")
	public String setRole(HttpServletRequest request, @RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "sUserId", required = true) String userId,
			@RequestParam(value = "roleIdList", required = true) String roleIdList) {
		String flag = Constants.FALSE;
		try {
			actionService.saveAction(request, "分配角色页面:提交", "参数:type=" + type + ";sUserId=" + userId);
			userService.editUserRole(userId, roleIdList, type);
			flag = Constants.TRUE;
		} catch (Exception e) {
			StringBuffer buf = new StringBuffer("为用户设置角色异常sUserId=");
			buf.append(userId);
			buf.append(";操作类别：");
			buf.append(type);
			buf.append("角色id列表:");
			buf.append(roleIdList);
			ExceptionLogger.error("sys", buf.toString(), e);
		} finally {
			AccessLogger.info("为用户 设置角色 editUserRole.htm", CommonUtil.getUserName(),
					"type" + type + ";sUserId=" + userId + ";roleIdList" + roleIdList, flag, 0);
		}

		return "redirect:userQuery.htm";
	}

	/**
	 * 方法名： delete 描述： 删除用户
	 * 
	 * @author zhuzheng 创建时间：2015年10月21日 下午7:57:53
	 * @param id
	 * @return
	 *
	 */
	@RequestMapping("/deleteUser.htm")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request, String id) {
		Map<String, Object> model = new HashMap<String, Object>();
		String flag = Constants.NO;
		actionService.saveAction(request, "用户管理:删除用户", "参数:id=" + id);
		try {
			userService.delete(id);
			flag = Constants.YES;
			model.put("flag", flag);
		} catch (Exception e) {
			ExceptionLogger.error("sys", "删除用户异常:userId=" + id, e);
		} finally {
			AccessLogger.info("删除用户 deleteUser.htm", CommonUtil.getUserName(), "sUserId=" + id, flag, 0);
		}
		return model;
	}

	/**
	 * 方法名： initPassword 描述： 初始化密码
	 * 
	 * @author zhuzheng 创建时间：2015年10月27日 下午5:29:18
	 * @param id
	 * @return
	 *
	 */
	@RequestMapping("/initPassword.htm")
	@ResponseBody
	public Map<String, Object> initPassword(HttpServletRequest request, String id) {
		Map<String, Object> model = new HashMap<String, Object>();
		String flag = Constants.NO;
		try {
			actionService.saveAction(request, "用户管理:初始化密码提交", "参数:userId=" + id);
			userService.updatePassword(id, MD5.encode(Constants.INIT_PASSWORD));
			flag = Constants.YES;
			model.put("flag", flag);
		} catch (Exception e) {
			ExceptionLogger.error("sys", "初始化密码异常:userId=" + id, e);
		} finally {
			AccessLogger.info("初始化密码initPassword.htm", CommonUtil.getUserName(), "sUserId=" + id, flag, 0);
		}
		return model;
	}

	/**
	 * 方法名： initPassword 描述： 禁用/启用用户
	 * 
	 * @author zhuzheng 创建时间：2015年11月7日 下午4:53:12
	 * @param id
	 * @return
	 *
	 */
	@RequestMapping("/userFreeze.htm")
	@ResponseBody
	public Map<String, Object> userFreeze(HttpServletRequest request, String id, int type) {
		Map<String, Object> model = new HashMap<String, Object>();
		String flag = Constants.NO;
		try {
			actionService.saveAction(request, "用户管理:禁用/启用提交", "参数:userId=" + id + ";type=" + type);
			userService.setUserFreeze(id, type);
			flag = Constants.YES;
			model.put("flag", flag);
		} catch (Exception e) {
			ExceptionLogger.error("sys", " 禁用/启用用户异常:userId=" + id, e);
		} finally {
			AccessLogger.info(" 禁用/启用用户userFreeze.htm", CommonUtil.getUserName(), "sUserId=" + id + ";type=" + type,
					flag, 0);
		}
		return model;
	}

	/**
	 * 方法名： checkUniqueMobile 描述： 判断手机号是否唯一
	 * 
	 * @author zhuzheng 创建时间：2015年10月28日 上午10:41:54
	 * @param id
	 * @return
	 *
	 */
	@RequestMapping("/checkUniqueMobile.htm")
	@ResponseBody
	public Map<String, Object> checkUniqueMobile(String mobile) {
		Map<String, Object> model = new HashMap<String, Object>();
		String flag = Constants.NO;
		try {
			if (StringUtil.isMobileNO(mobile)) {

				int count = userService.checkUniqueMobile(mobile);
				flag = Constants.YES;
				model.put("count", count);
			}
			model.put("flag", flag);
		} catch (Exception e) {
			ExceptionLogger.error("sys", "判断手机号是否唯一异常mobile=" + mobile);
		} finally {
			AccessLogger.info("  判断手机号是否唯一", CommonUtil.getUserName(), "mobile=" + mobile, flag, 0);
		}

		return model;
	}

	/**
	 * 方法名： checkUniqueUserName 描述： 判断用户名是否唯一
	 * 
	 * @author zhuzheng 创建时间：2015年11月20日 上午10:26:45
	 * @param userName
	 * @return
	 *
	 */
	@RequestMapping("/checkUniqueUserName.htm")
	@ResponseBody
	public Map<String, Object> checkUniqueUserName(String userName) {
		Map<String, Object> model = new HashMap<String, Object>();
		String flag = Constants.NO;
		try {
			if (StringUtils.isNotBlank(userName)) {

				int count = userService.checkUniqueUserName(userName);
				flag = Constants.YES;
				model.put("count", count);
			}
			model.put("flag", flag);
		} catch (Exception e) {
			ExceptionLogger.error("sys", "判断用户名是否唯一异常userName=" + userName);
		} finally {
			AccessLogger.info("判断用户名是否唯一", CommonUtil.getUserName(), "userName=" + userName, flag, 0);
		}
		return model;
	}

	/**
	 * 方法名： getUser 描述： 根据用户id获取用户
	 * 
	 * @author zhuzheng 创建时间：2015年10月31日 上午11:46:31
	 * @param phone
	 * @return
	 *
	 */
	@RequestMapping("/getUser.htm")
	@ResponseBody
	public Map<String, Object> getUser(String guid) {
		Map<String, Object> model = new HashMap<String, Object>();
		String flag = Constants.NO;
		try {
			User user = userService.getUserById(guid);
			flag = Constants.YES;
			model.put("user", user);
			model.put("flag", flag);
		} catch (Exception e) {
			ExceptionLogger.error("sys", "根据用户id获取用户 异常sUserId=" + guid, e);
		} finally {
			AccessLogger.info("根据用户id获取用户", CommonUtil.getUserName(), "sguid=" + guid, model.toString(), 0);
		}
		return model;
	}

	/**
	 * 方法名： updatePassword 描述： 修改密码页面
	 * 
	 * @author zhuzheng 创建时间：2015年9月29日 下午1:11:46
	 * @return
	 *
	 */
	@RequestMapping(value = "/updatePassword.htm")
	public ModelAndView updatePassword() {
		return new ModelAndView("/user/updatePassword");
	}

	/**
	 * 方法名： updatePassWordSubmit 描述：修改密码
	 * 
	 * @author zhuzheng 创建时间：2015年10月21日 下午8:12:02
	 * @param id
	 * @return
	 *
	 */
	@RequestMapping(value = "/updatePassWordSubmit.htm")
	@ResponseBody
	public Map<String, Object> updatePassWordSubmit(String oldPassWord, String passWord, String repassWord) {
		Map<String, Object> model = new HashMap<String, Object>();
		String flag = Constants.FALSE;
		String userId = CommonUtil.getUserId();
		try {
			int count = userService.getUserCountByIdAndPassword(userId, oldPassWord);
			if (count == 1) {
				userService.updatePassword(userId, passWord);
				flag = Constants.TRUE;
			} else {
				flag = Constants.NO;
			}
			model.put("flag", flag);
		} catch (Exception e) {
			ExceptionLogger.error("sys", "修改密码异常", e);
		} finally {
			AccessLogger.info("修改密码  ", CommonUtil.getUserName(), "userId=" + userId, model.toString(), 0);
		}
		return model;
	}

	/**
	 * 方法名： getUserRole 描述： 查看用户的角色
	 * 
	 * @author zhuzheng 创建时间：2016年1月25日 下午6:39:58
	 * @param id
	 * @return
	 *
	 */
	@RequestMapping("/getUserRole.htm")
	@ResponseBody
	public Map<String, Object> getUserRole(String id) {
		return userService.getUserRole(id);
	}

}
