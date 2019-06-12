package com.maiyajf.loan.manage.loan.sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiyajf.base.utils.log.DebugLogger;
import com.maiyajf.base.utils.base.IdGen;
import com.maiyajf.loan.manage.loan.sys.dao.RoleDao;
import com.maiyajf.loan.manage.loan.sys.dao.RolePermissionDao;
import com.maiyajf.loan.manage.loan.sys.po.Role;
import com.maiyajf.loan.manage.loan.sys.service.RoleService;
import com.maiyajf.loan.manage.loan.sys.service.SystemService;

/**
 * 项目名称： myLoan-manage 类名称： RoleServiceImpl 描述： 后台系统用户角色相关处理service
 * 
 * @author zhuzheng 创建时间： 2015年12月7日 下午1:57:14 修改人：zhuzheng 修改日期： 2015年12月7日 修改备注：
 *
 */
@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService {
  @Resource(name = "systemServiceImpl")
  private SystemService systemService;
  @Autowired
  private RoleDao roleDao;
  @Autowired
  private RolePermissionDao rolePermissionDao;

  /**
   * 方法名： getAllMemberRoleById 描述： 根据用户id查询用户的角色
   * 
   * @author zhuzheng 创建时间：2015年9月29日 下午1:14:07
   * @param guid
   * @return
   * @see com.maiyajf.loan.manage.loan.sys.service.RoleService#getAllMemberRoleById(java.lang.String)
   *
   */
  @Override
  public List<Role> getAllMemberRoleById(String guid) {

    return roleDao.getAllMemberRoleById(guid);
  }

  /**
   * 方法名： getRolesById 描述： 根据用户id查询用户的角色
   * 
   * @author zhuzheng 创建时间：2015年9月29日 下午1:14:33
   * @param guid
   * @return
   * @see com.maiyajf.loan.manage.loan.sys.service.RoleService#getRolesById(java.lang.String)
   *
   */
  @Override
  public List<String> getRolesById(String guid) {
    List<String> roles = roleDao.getRoleByUserId(guid);
    return roles;
  }

  /**
   * 方法名： getAllRoles 描述： 获取所有的角色
   * 
   * @author zhuzheng 创建时间：2015年10月12日 下午4:38:57
   * @return
   * @see com.maiyajf.loan.manage.loan.sys.service.RoleService#getAllRoles()
   *
   */
  @Override
  public List<Role> getAllRoles() {
    return roleDao.getALl();
  }

  /**
   * 方法名： getRolesByName 描述：获取角色根据角色名
   * 
   * @author zhuzheng 创建时间：2015年10月12日 下午4:39:07
   * @param sroleName
   * @return
   * @see com.maiyajf.loan.manage.loan.sys.service.RoleService#getRolesByName(java.lang.String)
   *
   */
  @Override
  public List<Role> getRolesByName(String sroleName) {
    return roleDao.getRolesByName(sroleName);
  }

  /**
   * 方法名： delete 描述： 删除角色及其权限
   * 
   * @author zhuzheng 创建时间：2015年10月12日 下午4:39:25
   * @param id
   * @see com.maiyajf.loan.manage.loan.sys.service.RoleService#delete(java.lang.String)
   *
   */
  @Override
  public void delete(String id) {
    DebugLogger.debug("开始 删除某角色及其权限，角色id:" + id);
    roleDao.delete(id);
    rolePermissionDao.deleteByRoleId(id);
    DebugLogger.debug("删除某角色及其权限成功");
  }

  /**
   * 方法名： get 描述： 获取角色
   * 
   * @author zhuzheng 创建时间：2015年10月12日 下午4:39:34
   * @param id
   * @return
   * @see com.maiyajf.loan.manage.loan.sys.service.RoleService#get(java.lang.String)
   *
   */
  @Override
  public Role get(String id) {
    return roleDao.get(id);
  }

  /**
   * 方法名： edit 描述：新增/编辑角色
   * 
   * @author zhuzheng 创建时间：2015年10月31日 上午11:06:10
   * @param role
   * @see com.maiyajf.loan.manage.loan.sys.service.RoleService#edit(com.maiyajf.loan.manage.loan.sys.po.Role)
   *
   */
  @Override
  public void edit(Role role) {
    DebugLogger.debug("新增/编辑角色  开始");
    if (StringUtils.isNotBlank(role.getSguid())) {
      // id存在就修改
      DebugLogger.debug("编辑角色role=" + role);
      roleDao.update(role);
    } else {
      // id不存在就添加
      role.setSguid(IdGen.uuid());
      role.setSroleNo(systemService.getSequenceNo("sys_role"));
      DebugLogger.debug("新增角色role=" + role);
      roleDao.add(role);
    }
    DebugLogger.debug("新增/编辑角色结束");
  }

  /**
   * 方法名： getPermissionByRoleId 描述：
   * 
   * @author zhuzheng 创建时间：2015年11月2日 下午7:24:12
   * @param roleId
   * @return
   * @see com.maiyajf.loan.manage.loan.sys.service.RoleService#getPermissionByRoleId(java.lang.String)
   *
   */
  @Override
  public List<Map<String, String>> getPermissionByRoleId(String roleId) {
    return rolePermissionDao.getPermissionByRole(roleId);
  }

}
