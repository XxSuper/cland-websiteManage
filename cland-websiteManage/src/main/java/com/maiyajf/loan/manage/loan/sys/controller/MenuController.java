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

import com.maiyajf.base.utils.log.AccessLogger;
import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.common.Constants;
import com.maiyajf.loan.manage.common.service.ActionService;
import com.maiyajf.loan.manage.loan.sys.po.Menu;
import com.maiyajf.loan.manage.loan.sys.service.IMenuService;
import com.maiyajf.loan.manage.loan.sys.utils.CommonUtil;

/**
 * 项目名称： myLoan-manage 类名称： MenuController 描述： 菜单相关
 * 
 * @author zhuzheng 创建时间： 2015年10月23日 上午9:33:33 修改人：zhuzheng 修改日期： 2015年10月23日 修改备注：
 *
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {
  @Resource(name = "menuServiceImpl")
  private IMenuService menuService;
  @Resource(name = "actionServiceImpl")
  private ActionService actionService;

  /**
   * 方法名： menu 描述： 菜单列表
   * 
   * @author zhuzheng 创建时间：2015年9月29日 下午5:41:56
   * @return
   *
   */
  @RequestMapping("/menu.htm")
  public String menu(Model model) {
    List<Menu> menu = menuService.getTopMenu();
    if (menu != null && menu.size() > 0) {
      model.addAttribute("menuList", menu);
    }
    model.addAttribute("level", Constants.SYS_MENU_LEVEL_0);
    AccessLogger.info("菜单列表menu.htm", CommonUtil.getUserName(), "", model.asMap().toString(), 0);
    return "/menu/menu";
  }

  /**
   * 方法名： childrenMenu 描述： 获取子菜单
   * 
   * @author zhuzheng 创建时间：2015年10月23日 上午9:33:44
   * @param model
   * @param id
   * @return
   *
   */
  @RequestMapping("/childrenMenu.htm")
  public String childrenMenu(Model model, String id) {
    List<Menu> menu = menuService.getChildrenMenu(id);
    if (menu != null && menu.size() > 0) {
      model.addAttribute("menuList", menu);
    }
    model.addAttribute("level", Constants.SYS_MENU_LEVEL_1);
    model.addAttribute("parentMenuId", id);
    AccessLogger.info("获取子菜单childrenMenu.htm", CommonUtil.getUserName(), "id=" + id,
        model.asMap().toString(), 0);
    return "/menu/menu";
  }

  /**
   * 方法名： editUI 描述： 添加/修改菜单页面
   * 
   * @author zhuzheng 创建时间：2015年10月6日 上午10:45:56
   * @return
   *
   */
  @RequestMapping("/editUI.htm")
  public String edit(Model model, @RequestParam(value = "menuId", required = false) String menuId,
      String parentMenuId) {
    List<Menu> menu = menuService.getAllMenu();
    if (menu != null && menu.size() > 0) {
      model.addAttribute("menuList", menu);
    }
    if (StringUtils.isNotBlank(menuId)) {
      Menu menuMap = menuService.getMenuById(menuId);
      model.addAttribute("menu", menuMap);
    }
    model.addAttribute("parentMenuId", parentMenuId);
    AccessLogger.info("添加/修改菜单页面editUI.htm", CommonUtil.getUserName(),
        "menuId=" + menuId + ";parentMenuId=" + parentMenuId, model.asMap().toString(), 0);
    return "/menu/edit";
  }

  /**
   * 方法名： add 描述：添加/编辑菜单
   * 
   * @author zhuzheng 创建时间：2015年10月6日 下午3:08:20
   * @param role
   * @return
   *
   */
  @RequestMapping("/edit.htm")
  public String add(HttpServletRequest request, Menu menu, String id) {
    try {
      actionService.saveAction(request, "新增/修改菜单:提交", "参数:" + menu.getName() + ";id=" + id);
      menuService.edit(menu);
      if (StringUtils.isNotBlank(id)) {
        return "redirect:childrenMenu.htm?id=" + id;
      } else {
        return "redirect:menu.htm";
      }
    } catch (Exception e) {
      ExceptionLogger.error("sys", "添加/修改菜单出错menu=" + menu, e);
      throw new RuntimeException(e);
    }
  }

  /**
   * 方法名： delete 描述： 菜单删除
   * 
   * @author zhuzheng 创建时间：2015年10月6日 下午3:44:06
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
      actionService.saveAction(request, "菜单中心:删除菜单", "参数:menuId=" + id);
      menuService.delete(id);
      flag = Constants.YES;
    } catch (Exception e) {
      ExceptionLogger.error("sys", "异常菜单删除menuId=" + id, e);
    }
    model.put("flag", flag);
    AccessLogger.info("菜单删除delete.htm", CommonUtil.getUserName(), "menuId=" + id, model.toString(),
        0);
    return model;
  }

}
