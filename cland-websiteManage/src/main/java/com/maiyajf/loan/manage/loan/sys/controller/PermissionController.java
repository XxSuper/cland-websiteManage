package com.maiyajf.loan.manage.loan.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maiyajf.base.utils.base.JsonUtil;
import com.maiyajf.base.utils.log.AccessLogger;
import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.common.Constants;
import com.maiyajf.loan.manage.common.service.ActionService;
import com.maiyajf.loan.manage.loan.sys.po.Menu;
import com.maiyajf.loan.manage.loan.sys.po.Permission;
import com.maiyajf.loan.manage.loan.sys.po.Role;
import com.maiyajf.loan.manage.loan.sys.service.IMenuService;
import com.maiyajf.loan.manage.loan.sys.service.PermissionService;
import com.maiyajf.loan.manage.loan.sys.service.RoleService;
import com.maiyajf.loan.manage.loan.sys.utils.CommonUtil;

/**
 * 项目名称： myLoan-manage 类名称： PermissionController 描述： 后台权限相关
 * 
 * @author zhuzheng 创建时间： 2015年10月23日 上午9:34:30 修改人：zhuzheng 修改日期： 2015年10月23日 修改备注：
 *
 */
@Controller
@RequestMapping(value = "/permission")
public class PermissionController {

  @Resource(name = "permissionServiceImpl")
  private PermissionService permissionService;
  @Resource(name = "menuServiceImpl")
  private IMenuService menuService;

  @Resource(name = "roleServiceImpl")
  private RoleService roleService;
  @Resource(name = "actionServiceImpl")
  private ActionService actionService;

  /**
   * 方法名： menu 描述：获取该菜单的权限列表
   * 
   * @author zhuzheng 创建时间：2015年10月6日 下午4:57:08
   * @param model
   * @param id
   * @return
   *
   */
  @RequestMapping("/menuPermission.htm")
  public String menu(Model model, String id, String parentMenuId) {
    List<Permission> permissionList = permissionService.getPermissionByMenuId(id);
    if (permissionList != null && permissionList.size() > 0) {
      model.addAttribute("permissionList", permissionList);
    }
    model.addAttribute("menuId", id);
    model.addAttribute("parentMenuId", parentMenuId);
    AccessLogger.info("获取该菜单的权限列表  menuPermission.htm", CommonUtil.getUserName(),
        "id=" + id + ";parentMenuId=" + parentMenuId, model.asMap().toString(), 0);
    return "/permission/permission";
  }

  /**
   * 方法名： addUI 描述： 添加/修改权限页面
   * 
   * @author zhuzheng 创建时间：2015年10月6日 下午4:57:05
   * @param model
   * @param menuId
   * @return
   *
   */
  @RequestMapping("/editUI.htm")
  public String addUI(Model model, String menuId,
      @RequestParam(value = "guid", required = false) String guid) {
    Menu menu = menuService.getMenuById(menuId);
    model.addAttribute("menu", menu);
    if (StringUtils.isNotBlank(guid)) {
      Permission permission = permissionService.get(guid);
      model.addAttribute("permission", permission);
    }
    AccessLogger.info("添加/修改权限页面 editUI.htm", CommonUtil.getUserName(),
        "menuId=" + menuId + ";guid=" + guid, model.asMap().toString(), 0);
    return "/permission/edit";
  }

  /**
   * 方法名： delete 描述： 删除权限
   * 
   * @author zhuzheng 创建时间：2015年10月6日 下午4:57:03
   * @param id
   * @return
   *
   */
  @RequestMapping("/delete.htm")
  @ResponseBody
  public Map<String, Object> delete(HttpServletRequest request, String id) {
    Map<String, Object> model = new HashMap<String, Object>();
    String flag = Constants.NO;
    try {
      actionService.saveAction(request, "页面管理:删除权限", "参数:id=" + id);
      permissionService.delete(id);
      flag = Constants.YES;
    } catch (Exception e) {
      ExceptionLogger.error("sys", "删除权限异常permissionId=" + id, e);
    } finally {
      model.put("flag", flag);
      AccessLogger.info("删除权限 delete.htm", CommonUtil.getUserName(), "permissionId=" + id,
          model.toString(), 0);
    }
    return model;
  }

  /**
   * 方法名： edit 描述： 添加/修改权限
   * 
   * @author zhuzheng 创建时间：2015年10月6日 下午4:57:14
   * @param menu
   * @return
   *
   */
  @RequestMapping("/edit.htm")
  public String edit(HttpServletRequest request, Permission permission) {
    String flag = Constants.FALSE;
    try {
      actionService.saveAction(request, "添加/修改权限:提交",
          "参数:permission=" + permission.getPermissionName());
      permissionService.edit(permission);
      Menu menu = menuService.getMenuById(permission.getParentId());
      flag = Constants.TRUE;
      return "redirect:menuPermission.htm?id=" + permission.getParentId() + "&parentMenuId="
          + menu.getParentId();
    } catch (Exception e) {
      ExceptionLogger.error("sys", "添加/修改权限异常permission=" + permission, e);
      throw new RuntimeException(e);
    } finally {
      AccessLogger.info("删除权限 delete.htm", CommonUtil.getUserName(),
          "Permission=" + permission.toString(), "flag=" + flag, 0);
    }
  }

  /**
   * 方法名： setPermissionUi 描述： 为角色分配权限
   * 
   * @author zhuzheng 创建时间：2015年10月7日 上午10:52:22
   * @param roleId
   * @return
   *
   */
  @RequestMapping("/setPermissionUI.htm")
  public String setPermissionUi(Model model, String roleId) {
    // 构建菜单及权限树
    List<Menu> menu = permissionService.getAllPermission();
    if (menu != null && menu.size() > 0) {
      model.addAttribute("menuList", menu);
    }
    Role role = roleService.get(roleId);
    model.addAttribute("role", role);
    List<Map<String, String>> permissionIdsList = roleService.getPermissionByRoleId(roleId);
    model.addAttribute("rolePermissionsIdsList", JsonUtil.objectToJson(permissionIdsList));
    AccessLogger.info("为角色分配权限页面 setPermissionUI.htm", CommonUtil.getUserName(), "roleId=" + roleId,
        "flag=" + 1, 0);
    return "/permission/setPermissionUI";
  }

  /**
   * 方法名： setPermissionUi 描述： 设置权限
   * 
   * @author zhuzheng 创建时间：2015年10月23日 上午9:35:43
   * @param model
   * @param roleId
   * @param resourceIdList
   * @return
   *
   */
  @RequestMapping("/setPermission.htm")
  public String setPermissionUi(HttpServletRequest request, Model model, String roleId,
      String resourceIdList) {
    //
    String flag = Constants.FALSE;
    try {
      actionService.saveAction(request, "设置权限:提交", "参数:roleId=" + roleId);
      permissionService.setPermission(roleId, resourceIdList);
      flag = Constants.TRUE;
    } catch (Exception e) {
      ExceptionLogger.error("sys",
          "为角色设置权限异常roleId=" + roleId + ";resourceIdList=" + resourceIdList, e);
    } finally {
      AccessLogger.info(" 设置权限 setPermission.htm", CommonUtil.getUserName(),
          "roleId=" + roleId + ";resourceIdList=" + resourceIdList, "flag=" + flag, 0);
    }

    return "redirect:/role/role.htm";
  }
}
