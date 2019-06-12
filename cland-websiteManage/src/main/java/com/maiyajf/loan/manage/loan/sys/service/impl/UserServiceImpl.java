package com.maiyajf.loan.manage.loan.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.maiyajf.base.utils.base.IdGen;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiyajf.base.utils.base.MD5;
import com.maiyajf.base.utils.log.DebugLogger;
import com.maiyajf.loan.manage.common.Constants;
import com.maiyajf.loan.manage.common.persistence.Pager;
import com.maiyajf.loan.manage.loan.sys.dao.SystemDao;
import com.maiyajf.loan.manage.loan.sys.dao.UserDao;
import com.maiyajf.loan.manage.loan.sys.dao.UserRoleDao;
import com.maiyajf.loan.manage.loan.sys.po.User;
import com.maiyajf.loan.manage.loan.sys.po.UserManagerLog;
import com.maiyajf.loan.manage.loan.sys.po.UserRole;
import com.maiyajf.loan.manage.loan.sys.service.IUserService;
import com.maiyajf.loan.manage.loan.sys.service.SystemService;
import com.maiyajf.loan.manage.loan.sys.utils.CommonUtil;

/**
 * 项目名称： myLoan-manage 类名称： UserServiceImpl 描述： 后台系统用户相关处理service
 * 
 * @author zhuzheng 创建时间： 2015年12月7日 下午1:57:19 修改人：zhuzheng 修改日期： 2015年12月7日
 *         修改备注：
 *
 */
@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private SystemDao systemDao;
	@Resource(name = "systemServiceImpl")
	private SystemService systemService;

	/**
	 * 方法名： getUserByNameAndPassword 描述： 根据用户名密码登录
	 * 
	 * @author zhuzheng 创建时间：2015年9月29日 下午1:13:10
	 * @param username
	 * @param password
	 * @return
	 * @see com.maiyajf.loan.manage.loan.sys.service.IUserService#getUserByNameAndPassword(java.lang.String,
	 *      java.lang.String)
	 *
	 */
	@Override
	public User getUserByNameAndPassword(String username, String password) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("password", password);
		return userDao.getUserByNameAndPassword(params);
	}

	/**
	 * 方法名： delete 描述： 删除用户
	 * 
	 * @author zhuzheng 创建时间：2015年10月31日 上午11:48:18
	 * @param id
	 * @see com.maiyajf.loan.manage.loan.sys.service.IUserService#delete(java.lang.String)
	 *
	 */
	@Override
	public void delete(String id) {
		// 删除用户
		DebugLogger.debug("开始删除该用户id=" + id);
		userDao.delete(id);
		DebugLogger.debug("成功更新该用户表IdelFlag字段记录为0");
		// 删除用户申请
		DebugLogger.debug("开始删除该用户申请id=" + id);
		userDao.deleteUserApply(id);
		DebugLogger.debug("成功更新该用户申请表IdelFlag字段记录为0");
		// 删除其角色
		userRoleDao.deleteUserRole(id);
		DebugLogger.debug("成功删除该用户的角色");
		// 记录日志
		UserManagerLog log = new UserManagerLog();
		log.setsGuid(IdGen.uuid());
		log.setsUserID(id);
		log.setiOperatorType(Constants.USERMANAGER_DELETE);
		log.setsOperatorID(CommonUtil.getUserId());
		log.setsSrcRoles(" ");
		log.setsTargetRoles(" ");
		systemDao.saveManageLog(log);
		DebugLogger.debug("删除该用户结束");
	}

	/**
	 * 方法名： getUsersByNames 描述： 根据用户名取用户
	 * 
	 * @author zhuzheng 创建时间：2015年10月31日 上午11:48:50
	 * @param suserName
	 * @return
	 * @see com.maiyajf.loan.manage.loan.sys.service.IUserService#getUsersByNames(java.lang.String)
	 *
	 */
	@Override
	public Map<String, Object> getUsersByNames(String suserName, String sMobile, int pageNumber) {
		Map<String, Object> model = new HashMap<String, Object>();
		int total = userDao.getUserCount();
		Pager<User> page = new Pager<User>(total, pageNumber);
		List<User> userList = new ArrayList<User>();
		userList = userDao.getByUsersByName(suserName, sMobile, (pageNumber - 1) * page.getLimit(),
				page.getLimit() * pageNumber);
		page.setList(userList);
		model.put("page", page);
		model.put("sMobile", sMobile);
		model.put("suserName", suserName);
		return model;
	}

	/**
	 * 方法名： getByUsername 描述： 根据用户名查询该用户
	 * 
	 * @author zhuzheng 创建时间：2015年12月7日 下午2:21:51
	 * @param username
	 * @return
	 * @see com.maiyajf.loan.manage.loan.sys.service.IUserService#getByUsername(java.lang.String)
	 *
	 */
	@Override
	public User getByUsername(String username) {
		return userDao.getByUsername(username);
	}

	@Override
	public void addUserRole(UserRole ur) {
		userRoleDao.insert(ur);
	}

	@Override
	public void deleteUserRoleByIds(String userId, String roleId) {
		userRoleDao.deleteByIds(userId, roleId);
	}

	/**
	 * 方法名： getUserCountByIdAndPassword 描述： 判断密码是否正确
	 * 
	 * @author zhuzheng 创建时间：2015年12月7日 下午2:23:01
	 * @param userId
	 * @param oldPassWord
	 * @return
	 * @see com.maiyajf.loan.manage.loan.sys.service.IUserService#getUserCountByIdAndPassword(java.lang.String,
	 *      java.lang.String)
	 *
	 */
	@Override
	public int getUserCountByIdAndPassword(String userId, String oldPassWord) {
		return userDao.getUserCountByIdAndPassword(userId, oldPassWord);
	}

	/**
	 * 方法名： updatePassword 描述： 修改密码
	 * 
	 * @author zhuzheng 创建时间：2015年12月7日 下午2:23:48
	 * @param userId
	 * @param passWord
	 * @see com.maiyajf.loan.manage.loan.sys.service.IUserService#updatePassword(java.lang.String,
	 *      java.lang.String)
	 *
	 */
	@Override
	public void updatePassword(String userId, String passWord) {
		DebugLogger.debug("开始初始化/修改密码userId=" + userId);
		userDao.updatePassword(userId, passWord);
		DebugLogger.debug("初始化/修改密码结束");
	}

	/**
	 * 方法名： checkUniqueMobile 描述：检测手机号是否唯一
	 * 
	 * @author zhuzheng 创建时间：2015年11月21日 下午1:34:56
	 * @param phone
	 * @return
	 * @see com.maiyajf.loan.manage.loan.sys.service.IUserService#checkUniqueMobile(java.lang.String)
	 *
	 */
	@Override
	public int checkUniqueMobile(String phone) {
		return userDao.checkUniqueMobile(phone);
	}

	/**
	 * 方法名： getUserById 描述：根据 id获取用户
	 * 
	 * @author zhuzheng 创建时间：2015年11月21日 下午1:34:32
	 * @param guid
	 * @return
	 * @see com.maiyajf.loan.manage.loan.sys.service.IUserService#getUserById(java.lang.String)
	 *
	 */
	@Override
	public User getUserById(String guid) {
		return userDao.getUserById(guid);
	}

	/**
	 * 方法名： editUser 描述： 添加/修改用户
	 * 
	 * @author zhuzheng 创建时间：2015年10月31日 下午12:27:12
	 * @param user
	 * @see com.maiyajf.loan.manage.loan.sys.service.IUserService#editUser(com.maiyajf.loan.manage.loan.sys.po.User)
	 *
	 */
	@Override
	public Map<String, Object> editUser(User user) {
		Map<String, Object> model = new HashMap<String, Object>();
		DebugLogger.debug("添加/修改用户开始");
		if (StringUtils.isNotBlank(user.getGuid())) {
			// 修改用户
			DebugLogger.debug(" 修改用户user=" + user);
			user.setsModifyPerson(CommonUtil.getUserName());
			userDao.update(user);
		} else {
			// 添加用户
			user.setGuid(IdGen.uuid());
			// 默认初始密码
			user.setUserNo(systemService.getSequenceNo("sys_user"));
			user.setPassword(MD5.encode(Constants.INIT_PASSWORD));
			user.setsCreatePerson(CommonUtil.getUserName());
			DebugLogger.debug(" 添加用户user=" + user);
			userDao.save(user);
			userDao.saveUserApply(user);
			// 记录日志
			UserManagerLog log = new UserManagerLog();
			log.setsGuid(IdGen.uuid());
			log.setsUserID(user.getGuid());
			log.setiOperatorType(Constants.USERMANAGER_REGIST);
			log.setsOperatorID(CommonUtil.getUserId());
			log.setsSrcRoles(" ");
			log.setsTargetRoles(" ");
			systemDao.saveManageLog(log);

		}
		DebugLogger.debug("添加/修改用户结束");
		return model;
	}

	/**
	 * 方法名： userFreeze 描述： 禁用/启用用户
	 * 
	 * @author zhuzheng 创建时间：2015年11月7日 下午4:54:48
	 * @param id
	 * @param type
	 * @see com.maiyajf.loan.manage.loan.sys.service.IUserService#userFreeze(java.lang.String,
	 *      int)
	 *
	 */
	@Override
	public void setUserFreeze(String id, int type) {
		DebugLogger.debug("开始禁用/启用用户id=" + id + "type=" + type);
		userDao.updateFreeze(id, type);
		// 记录日志
		UserManagerLog log = new UserManagerLog();
		log.setsGuid(IdGen.uuid());
		log.setsUserID(id);

		if (Constants.NO_INT == type) {
			log.setiOperatorType(Constants.USERMANAGER_FORBDDEN);
		} else if (Constants.YES_INT == type) {
			log.setiOperatorType(Constants.USERMANAGER_USING);
		}
		log.setsOperatorID(CommonUtil.getUserId());
		log.setsSrcRoles(" ");
		log.setsTargetRoles(" ");
		systemDao.saveManageLog(log);
		DebugLogger.debug("禁用/启用用户id=" + id + "type=" + type + "结束");
	}

	/**
	 * 方法名： getUserRoleIds 描述： 根据用户id获取角色ids
	 * 
	 * @author zhuzheng 创建时间：2015年11月11日 上午9:56:19
	 * @param userId
	 * @return
	 * @see com.maiyajf.loan.manage.loan.sys.service.IUserService#getUserRoleIds(java.lang.String)
	 *
	 */
	@Override
	public List<String> getUserRoleIds(String userId) {
		List<String> ids = new ArrayList<String>();
		ids = userRoleDao.getRoleIdsByUserId(userId);
		if (null != ids && ids.size() > Constants.NO_INT) {
			return ids;
		} else {
			return new ArrayList<String>();
		}

	}

	/**
	 * 方法名： editUserRole 描述： 为用户 设置角色
	 * 
	 * @author zhuzheng 创建时间：2015年11月11日 上午11:17:25
	 * @param sUserId
	 * @param roleIdList
	 * @param type
	 * @see com.maiyajf.loan.manage.loan.sys.service.IUserService#editUserRole(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 *
	 */
	@Override
	public void editUserRole(String sUserId, String roleIdList, String type) {

		//
		DebugLogger.debug("为用户 设置角色userId=" + sUserId + ";roleIdList=" + roleIdList);
		if (StringUtils.isNotBlank(roleIdList)) {
			List<Map<String, Object>> idList = new ArrayList<Map<String, Object>>();
			String[] ids = roleIdList.split(",");

			for (int a = 0; a < ids.length; a++) {
				if (StringUtils.isNotBlank(ids[a])) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("sGuid", IdGen.uuid());
					map.put("sUserId", sUserId);
					map.put("sRoleId", ids[a]);
					map.put("iDelFlag", 1);
					idList.add(map);
				}
			}
			String srcRoles = "";
			if (idList.size() > 0) {
				srcRoles = userRoleDao.getFormatRoleNameByIds(idList);
				DebugLogger.debug("获取角色名称==idList=" + idList + ";srcRoles=" + srcRoles);
			}
			if (null != type && "edit".equals(type)) {
				// 修改
				// 记录日志
				UserManagerLog log = new UserManagerLog();
				log.setsGuid(IdGen.uuid());
				log.setsUserID(sUserId);
				log.setiOperatorType(Constants.USERMANAGER_CHANGEPERMISSION);
				log.setsOperatorID(CommonUtil.getUserId());
				log.setsSrcRoles(userRoleDao.getFormatRoleName(sUserId));
				log.setsTargetRoles(srcRoles);
				systemDao.saveManageLog(log);
				userRoleDao.deleteUserRole(sUserId);
			}
			if (idList.size() > 0) {
				userRoleDao.add(idList);
			}
			DebugLogger.debug("为用户 设置角色成功");
		}
	}

	/**
	 * 方法名： checkUniqueUserName 描述： 判断用户名是否唯一
	 * 
	 * @author zhuzheng 创建时间：2015年11月20日 上午10:28:30
	 * @param userName
	 * @return
	 * @see com.maiyajf.loan.manage.loan.sys.service.IUserService#checkUniqueUserName(java.lang.String)
	 *
	 */
	@Override
	public int checkUniqueUserName(String userName) {
		return userDao.checkUniqueUserName(userName);
	}

	/**
	 * 方法名： getPhoneByUserName 描述： 根据用户名获取手机号
	 * 
	 * @author zhuzheng 创建时间：2015年11月20日 上午10:38:55
	 * @param name
	 * @return
	 * @see com.maiyajf.loan.manage.loan.sys.service.IUserService#getPhoneByUserName(java.lang.String)
	 *
	 */
	@Override
	public String getPhoneByUserName(String name) {
		return userDao.getPhoneByUserName(name);
	}

	/**
	 * 方法名： getUsersForAudit 描述： 查询待审核用户
	 * 
	 * @author zhuzheng 创建时间：2015年12月18日 下午3:11:26
	 * @param suserName
	 * @param sMobile
	 * @param pageNumber
	 * @return
	 * @see com.maiyajf.loan.manage.loan.sys.service.IUserService#getUsersForAudit(java.lang.String,
	 *      java.lang.String, int)
	 *
	 */
	@Override
	public Map<String, Object> getUsersForAudit(String suserName, String sMobile, int pageNumber) {
		Map<String, Object> model = new HashMap<String, Object>();
		int total = userDao.getUserCountForAudit();
		Pager<User> page = new Pager<User>(total, pageNumber);
		List<User> userList = new ArrayList<User>();
		userList = userDao.getUsersForAudit(suserName, sMobile, (pageNumber - 1) * page.getLimit(),
				page.getLimit() * pageNumber);
		page.setList(userList);
		model.put("page", page);
		return model;
	}

	/**
	 * 方法名： submitAudit 描述： 提交系统用户审核
	 * 
	 * @author zhuzheng 创建时间：2015年12月18日 下午4:49:32
	 * @param sGuid
	 * @param approvel
	 * @return
	 * @see com.maiyajf.loan.manage.loan.sys.service.IUserService#submitAudit(java.lang.String,
	 *      java.lang.Integer)
	 *
	 */
	@Override
	public void submitAudit(String sGuid, Integer approvel) {
		int sStatus = 1;
		int idelFlag = 1;
		String sCheckPerson = CommonUtil.getUserName();
		if (10 == approvel) {
			// 更新用户表
			sStatus = 0;
		} else {
			sStatus = 1;
			idelFlag = 0;
		}
		userDao.updateUsing(sGuid, sStatus, sCheckPerson, idelFlag);
		// 更新用户申请表
		userDao.updateUserAudit(sGuid, approvel, sCheckPerson, idelFlag);
	}

	/**
	 * 方法名： getUserRole 描述： 查看用户的角色
	 * 
	 * @author zhuzheng 创建时间：2016年1月25日 下午6:41:26
	 * @param id
	 * @return
	 * @see com.maiyajf.loan.manage.loan.sys.service.IUserService#getUserRole(java.lang.String)
	 *
	 */
	@Override
	public Map<String, Object> getUserRole(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		String flag = Constants.NO;
		String role = userRoleDao.getFormatRoleName(id);
		if (StringUtils.isNotBlank(role)) {
			flag = Constants.YES;
			map.put("role", role);
		}
		map.put("flag", flag);
		return map;
	}
}
