package com.maiyajf.loan.manage.loan.sys.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maiyajf.loan.manage.loan.sys.dao.MenuDao;
import com.maiyajf.loan.manage.loan.sys.dao.PermissionDao;
import com.maiyajf.loan.manage.loan.sys.po.Menu;

/**
 * 项目名称： myLoan-manage 类名称： MenuUtil 描述： 菜单列表处理工具类
 * 
 * @author zhuzheng 创建时间： 2015年9月29日 下午2:07:42 修改人：zhuzheng 修改日期： 2015年9月29日 修改备注：
 *
 */
@Component
public class MenuUtil {

  @Autowired
  private MenuDao menuDao;
  @Autowired
  private PermissionDao permissionDao;

  /**
   * 方法名： formatMenuList 描述： 系统页面左侧的菜单
   * 
   * @author zhuzheng 创建时间：2015年10月12日 下午4:41:23
   * @param menuTempList
   * @return
   *
   */
  public List<Menu> formatMenuList(List<Menu> menuTempList) {
    List<String> parentIds = new ArrayList<String>();
    // 得到所有的顶级菜单
    for (Menu menu : menuTempList) {
      if (menu.getIsLeaf() == 1 && StringUtils.isNotBlank(menu.getParentId())) {
        if (!parentIds.contains(menu.getParentId())) {
          parentIds.add(menu.getParentId());
        }
      }
    }
    // 得到顶级菜单的子菜单
    List<Menu> level0MenusList = menuDao.getMenuByIds(parentIds);
    for (int a = 0; a < level0MenusList.size(); a++) {
      List<Menu> childen = new ArrayList<Menu>();
      for (Menu menutemp : menuTempList) {
        if (level0MenusList.get(a).getGuid().equals(menutemp.getParentId())) {
          childen.add(menutemp);
        }
      }
      level0MenusList.get(a).setChirdlen(childen);
    }
    return level0MenusList;
  }


  /**
   * 方法名： formatMenuListForShow 描述： 格式化菜单显示，添加菜单叶
   * 
   * @author zhuzheng 创建时间：2015年10月12日 下午4:40:42
   * @param menuList
   * @return
   *
   */
  public List<Menu> formatMenuListForShow(List<Menu> menuList) {

    // 得到子菜单
    for (int a = 0; a < menuList.size(); a++) {
      List<Menu> childen = new ArrayList<Menu>();
      Menu menu = menuList.get(a);
      childen = menuDao.getChildrenMenus(menu.getGuid());
      for (int b = 0; b < childen.size(); b++) {
        childen.get(b).setName("　┠" + childen.get(b).getName());
      }
      menu.setChirdlen(childen);
      menu.setName("┠" + menu.getName());
    }

    return menuList;
  }

  /**
   * 方法名： formatMenuListForTree 描述： 权限树
   * 
   * @author zhuzheng 创建时间：2015年10月12日 下午4:41:11
   * @param menuList
   * @return
   *
   */
  public List<Menu> formatMenuListForTree(List<Menu> menuList) {
    // 得到子菜单
    for (int a = 0; a < menuList.size(); a++) {
      List<Menu> childen = new ArrayList<Menu>();
      Menu menu = menuList.get(a);
      childen = menuDao.getChildrenMenus(menu.getGuid());
      for (int b = 0; b < childen.size(); b++) {
        String id = childen.get(b).getGuid();
        childen.get(b).setPermissions(permissionDao.getPermissionByMenuId(id));
      }
      menu.setChirdlen(childen);
    }

    return menuList;
  }

  public static void main(String[] args) {
    System.out.println(UUID.randomUUID());
  }
}
