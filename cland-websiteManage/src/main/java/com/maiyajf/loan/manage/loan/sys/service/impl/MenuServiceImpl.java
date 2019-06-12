package com.maiyajf.loan.manage.loan.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.maiyajf.base.utils.base.IdGen;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiyajf.base.utils.log.DebugLogger;
import com.maiyajf.loan.manage.common.Constants;
import com.maiyajf.loan.manage.loan.sys.dao.MenuDao;
import com.maiyajf.loan.manage.loan.sys.dao.PermissionDao;
import com.maiyajf.loan.manage.loan.sys.po.Menu;
import com.maiyajf.loan.manage.loan.sys.service.IMenuService;
import com.maiyajf.loan.manage.loan.sys.service.SystemService;
import com.maiyajf.loan.manage.loan.sys.utils.MenuUtil;

/**
 * 项目名称： myLoan-manage 类名称： MenuServiceImpl 描述： 后台系统菜单处理service
 * 
 * @author zhuzheng 创建时间： 2015年12月7日 下午1:57:06 修改人：zhuzheng 修改日期： 2015年12月7日 修改备注：
 *
 */
@Service("menuServiceImpl")
public class MenuServiceImpl implements IMenuService {
  @Resource(name = "systemServiceImpl")
  private SystemService systemService;
  @Autowired
  private MenuDao menuDao;

  @Autowired
  private PermissionDao permissionDao;

  @Autowired
  private MenuUtil menuUtil;

  public Menu getMenuById(String menuId) {
    return menuDao.get(menuId);
  }

  /**
   * 方法名： getUserAllMeans 描述： 根据系统用户id 获取应显示的菜单
   * 
   * @author zhuzheng 创建时间：2015年9月29日 下午1:21:24
   * @param guid
   * @return
   * @see com.maiyajf.loan.manage.loan.sys.service.IMenuService#getUserAllMeans(java.lang.String)
   *
   */
  @Override
  public List<Menu> getUserAllMeans(String guid) {
    List<Menu> menuList = new ArrayList<Menu>();
    List<String> menuListString = permissionDao.getMenuIdById(guid);
    if (null != menuListString && menuListString.size() > 0) {
      List<Menu> menuTempList = menuDao.getMenuByIds(menuListString);
      menuList = menuUtil.formatMenuList(menuTempList);
    }
    return menuList;
  }

  /**
   * 方法名： getTopMenu 描述： 获取顶级菜单
   * 
   * @author zhuzheng 创建时间：2015年9月29日 下午5:50:59
   * @return
   * @see com.maiyajf.loan.manage.loan.sys.service.IMenuService#getTopMenu()
   *
   */
  @Override
  public List<Menu> getTopMenu() {
    List<Menu> menuList = new ArrayList<Menu>();
    menuList = menuDao.getTopMenu();
    return menuList;
  }

  /**
   * 方法名： getChildrenMenu 描述： 获取菜单的子菜单
   * 
   * @author zhuzheng 创建时间：2015年10月12日 下午4:36:55
   * @param id
   * @return
   * @see com.maiyajf.loan.manage.loan.sys.service.IMenuService#getChildrenMenu(java.lang.String)
   *
   */
  @Override
  public List<Menu> getChildrenMenu(String id) {
    List<Menu> menuList = new ArrayList<Menu>();
    menuList = menuDao.getChildrenMenus(id);
    return menuList;
  }

  /**
   * 方法名： getAllMenu 描述： 获取所有的菜单
   * 
   * @author zhuzheng 创建时间：2015年10月12日 下午4:37:07
   * @return
   * @see com.maiyajf.loan.manage.loan.sys.service.IMenuService#getAllMenu()
   *
   */
  @Override
  public List<Menu> getAllMenu() {
    List<Menu> menuList = new ArrayList<Menu>();
    menuList = menuDao.getTopMenu();
    menuList = menuUtil.formatMenuListForShow(menuList);
    return menuList;
  }

  /**
   * 方法名： delete 描述： 删除菜单及其权限
   * 
   * @author zhuzheng 创建时间：2015年10月12日 下午4:37:23
   * @param id
   * @see com.maiyajf.loan.manage.loan.sys.service.IMenuService#delete(java.lang.String)
   *
   */
  @Override
  public void delete(String id) {
    DebugLogger.debug("删除菜单开始");
    menuDao.delete(id);
    permissionDao.deleteByMenuId(id);
    DebugLogger.debug("删除菜单结束");
  }

  /**
   * 方法名： edit 描述：添加编辑菜单
   * 
   * @author zhuzheng 创建时间：2015年11月2日 下午4:26:39
   * @param menu
   * @see com.maiyajf.loan.manage.loan.sys.service.IMenuService#edit(com.maiyajf.loan.manage.loan.sys.po.Menu)
   *
   */
  @Override
  public void edit(Menu menu) {
    DebugLogger.debug("添加/修改菜单开始");
    String parentId = menu.getParentId();
    if (StringUtils.isNotBlank(parentId) && !Constants.NO.equals(parentId)) {
      menu.setIsRoot(Constants.NO_INT);
      menu.setIsLeaf(Constants.YES_INT);
      menu.setLevel(Constants.YES_INT);
    } else {
      menu.setIsRoot(Constants.YES_INT);
      menu.setIsLeaf(Constants.NO_INT);
      menu.setLevel(Constants.NO_INT);
    }
    if (StringUtils.isNotBlank(menu.getGuid())) {
      // 编辑菜单
      DebugLogger.debug("修改菜单menu=" + menu);
      menuDao.update(menu);
    } else {
      // 添加菜单
      DebugLogger.debug("添加菜单menu=" + menu);
      menu.setGuid(IdGen.uuid());
      menu.setMenuNo(systemService.getSequenceNo("sys_menu"));
      menuDao.add(menu);
    }
    DebugLogger.debug("添加/修改菜单结束");
  }
}
