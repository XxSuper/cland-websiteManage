package com.maiyajf.loan.manage.loan.sys.service.impl;

import com.maiyajf.base.utils.base.IdGen;
import com.maiyajf.base.utils.log.DebugLogger;
import com.maiyajf.loan.manage.loan.sys.dao.MenuDao;
import com.maiyajf.loan.manage.loan.sys.dao.PermissionDao;
import com.maiyajf.loan.manage.loan.sys.dao.RolePermissionDao;
import com.maiyajf.loan.manage.loan.sys.po.Menu;
import com.maiyajf.loan.manage.loan.sys.po.Permission;
import com.maiyajf.loan.manage.loan.sys.service.PermissionService;
import com.maiyajf.loan.manage.loan.sys.service.SystemService;
import com.maiyajf.loan.manage.loan.sys.utils.MenuUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目名称： myLoan-manage 类名称： PermissionServiceImpl 描述： 后台系统用户角色权限相关处理service
 * 
 * @author zhuzheng 创建时间： 2015年12月7日 下午1:57:10 修改人：zhuzheng 修改日期： 2015年12月7日 修改备注：
 *
 */
@Service("permissionServiceImpl")
public class PermissionServiceImpl implements PermissionService {
  @Resource(name = "systemServiceImpl")
  private SystemService systemService;
  @Autowired
  private MenuDao menuDao;

  @Autowired
  private PermissionDao permissionDao;

  @Autowired
  private RolePermissionDao rolePermissionDao;
  @Autowired
  private MenuUtil menuUtil;

  /**
   * 方法名： getPermissionStringById 描述： ： 根据用户id查询权限码
   * 
   * @author zhuzheng 创建时间：2015年9月29日 下午1:09:52
   * @param guid
   * @return
   * @see com.maiyajf.loan.manage.loan.sys.service.PermissionService#getPermissionStringById(java.lang.String)
   *
   */
  @Override
  public List<String> getPermissionStringById(String guid) {
    return permissionDao.getPermissionStringById(guid);
  }

  /**
   * 方法名： getPermissionById 描述： 根据用户id查询权限列表
   * 
   * @author zhuzheng 创建时间：2015年9月29日 下午1:09:56
   * @param guid
   * @return
   * @see com.maiyajf.loan.manage.loan.sys.service.PermissionService#getPermissionById(java.lang.String)
   *
   */
  @Override
  public List<Permission> getPermissionById(String guid) {
    return permissionDao.getPermissionById(guid);
  }

  /**
   * 方法名： getMenuIdById 描述： 根据用户id查询权限所属的菜单列表
   * 
   * @author zhuzheng 创建时间：2015年9月29日 下午1:26:10
   * @param guid
   * @return
   * @see com.maiyajf.loan.manage.loan.sys.service.PermissionService#getMenuIdById(java.lang.String)
   *
   */
  @Override
  public List<String> getMenuIdById(String guid) {
    return permissionDao.getMenuIdById(guid);
  }

  /**
   * 方法名： getPermissionByMenuId 描述： 获取菜单拥有的权限
   * 
   * @author zhuzheng 创建时间：2015年10月12日 下午4:37:48
   * @param id
   * @return
   * @see com.maiyajf.loan.manage.loan.sys.service.PermissionService#getPermissionByMenuId(java.lang.String)
   *
   */
  @Override
  public List<Permission> getPermissionByMenuId(String id) {
    return permissionDao.getPermissionByMenuId(id);
  }

  /**
   * 方法名： delete 描述： 删除权限
   * 
   * @author zhuzheng 创建时间：2015年10月12日 下午4:38:09
   * @param id
   * @see com.maiyajf.loan.manage.loan.sys.service.PermissionService#delete(java.lang.String)
   *
   */
  @Override
  public void delete(String id) {
    DebugLogger.debug("开始删除权限id=" + id);
    permissionDao.delete(id);
    DebugLogger.debug("删除权限结束");
  }

  /**
   * 方法名： getAllPermission 描述： 获取所有的权限
   * 
   * @author zhuzheng 创建时间：2015年10月12日 下午4:38:23
   * @return
   * @see com.maiyajf.loan.manage.loan.sys.service.PermissionService#getAllPermission()
   *
   */
  @Override
  public List<Menu> getAllPermission() {
    List<Menu> menuList = new ArrayList<Menu>();
    menuList = menuDao.getTopMenu();
    menuList = menuUtil.formatMenuListForTree(menuList);
    return menuList;
  }

  /**
   * 方法名： setPermission 描述： 为角色设置权限
   * 
   * @author zhuzheng 创建时间：2015年10月12日 下午4:38:31
   * @param roleId
   * @param resourceIdList
   * @see com.maiyajf.loan.manage.loan.sys.service.PermissionService#setPermission(java.lang.String,
   *      java.lang.String)
   *
   */
  @Override
  public void setPermission(String roleId, String resourceIdList) {
    DebugLogger.debug("开始为角色设置权限roleId=" + roleId + "");
    if (StringUtils.isNotBlank(resourceIdList)) {
      String[] ids = resourceIdList.split(",");
      List<Map<String, Object>> idList = new ArrayList<Map<String, Object>>();
      for (int a = 0; a < ids.length; a++) {
        if (StringUtils.isNotBlank(ids[a])) {
          Map<String, Object> map = new HashMap<String, Object>();
          map.put("sGuid", IdGen.uuid());
          map.put("sRoleId", roleId);
          map.put("sPermissionId", ids[a]);
          map.put("iDelFlag", 1);
          idList.add(map);
        }
      }
      rolePermissionDao.deleteByRoleId(roleId);
      rolePermissionDao.add(idList);
    }
    DebugLogger.debug("为角色设置权限结束");
  }

  /**
   * 方法名： get 描述： 根据权限id获取权限
   * 
   * @author zhuzheng 创建时间：2015年11月2日 下午2:42:19
   * @param guid
   * @return
   * @see com.maiyajf.loan.manage.loan.sys.service.PermissionService#get(java.lang.String)
   *
   */
  @Override
  public Permission get(String guid) {
    return permissionDao.get(guid);
  }

  /**
   * 方法名： edit 描述： 添加修改权限
   * 
   * @author zhuzheng 创建时间：2015年11月2日 下午2:47:49
   * @param permission
   * @see com.maiyajf.loan.manage.loan.sys.service.PermissionService#edit(com.maiyajf.loan.manage.loan.sys.po.Permission)
   *
   */
  @Override
  public void edit(Permission permission) {
    DebugLogger.debug("添加/修改权限开始");
    if (StringUtils.isNotBlank(permission.getGuid())) {
      // id存在就修改
      DebugLogger.debug("修改权限permission=" + permission);
      permissionDao.update(permission);
    } else {
      // id不存在添加
      permission.setGuid(IdGen.uuid());
      permission.setPermissionNo(systemService.getSequenceNo("sys_permission"));
      DebugLogger.debug("添加权限permission=" + permission);
      permissionDao.add(permission);
    }
    DebugLogger.debug("添加/修改权限结束");
  }

  /**
   * 方法名： getPermissonByUrl 描述： 根据url获取权限
   * 
   * @author zhuzheng 创建时间：2015年11月23日 下午4:04:28
   * @param url
   * @return
   * @see com.maiyajf.loan.manage.loan.sys.service.PermissionService#getPermissonByUrl(java.lang.String)
   *
   */
  @Override
  public Permission getPermissonByUrl(String url) {
    return permissionDao.getPermissonByUrl(url);
  }

}
