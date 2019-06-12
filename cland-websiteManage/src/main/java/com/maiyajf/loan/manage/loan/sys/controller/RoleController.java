package com.maiyajf.loan.manage.loan.sys.controller;

import java.util.ArrayList;
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

import com.maiyajf.base.utils.log.AccessLogger;
import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.common.Constants;
import com.maiyajf.loan.manage.common.service.ActionService;
import com.maiyajf.loan.manage.loan.sys.po.Role;
import com.maiyajf.loan.manage.loan.sys.service.RoleService;
import com.maiyajf.loan.manage.loan.sys.utils.CommonUtil;

/**
 * 项目名称： myLoan-manage 类名称： RoleController 描述：
 * 
 * @author zhuzheng 创建时间： 2015年10月6日 上午10:45:52 修改人：zhuzheng 修改日期： 2015年10月6日 修改备注：
 *
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController {
  @Resource(name = "roleServiceImpl")
  private RoleService roleService;

  @Resource(name = "actionServiceImpl")
  private ActionService actionService;

  /**
   * 方法名： role 描述：
   * 
   * @author zhuzheng 创建时间：2015年10月6日 上午10:46:03
   * @param request
   * @return
   *
   */
  @RequestMapping("/role.htm")
  public ModelAndView role(@RequestParam(value = "sroleName", required = false) String sroleName) {
    Map<String, Object> model = new HashMap<String, Object>();
    List<Role> roleList = new ArrayList<Role>();
    if (sroleName != null) {
      roleList = roleService.getRolesByName(sroleName);
    } else {
      roleList = roleService.getAllRoles();
    }

    if (roleList != null && roleList.size() > 0) {
      model.put("roleList", roleList);
    }
    AccessLogger.info("角色列表role.htm", CommonUtil.getUserName(), "sroleName=" + sroleName,
        model.toString(), 0);
    return new ModelAndView("/role/role", model);
  }

  /**
   * 方法名： addUI 描述：
   * 
   * @author zhuzheng 创建时间：2015年10月6日 上午10:45:56
   * @return
   *
   */
  @RequestMapping("/editUI.htm")
  public ModelAndView addUI(@RequestParam(value = "roleId", required = false) String roleId) {
    Map<String, Object> model = new HashMap<String, Object>();
    if (StringUtils.isNotBlank(roleId)) {
      Role role = roleService.get(roleId);
      model.put("role", role);
    }
    AccessLogger.info("角色编辑editUI.htm", CommonUtil.getUserName(), "roleId=" + roleId,
        model.toString(), 0);
    return new ModelAndView("/role/edit", model);
  }

  /**
   * 方法名： 描述：添加编辑角色
   * 
   * @author zhuzheng 创建时间：2015年10月6日 上午10:45:58
   * @param role
   * @return
   *
   */
  @RequestMapping("/edit.htm")
  public String edit(HttpServletRequest request, Role role) {
    actionService.saveAction(request, "新增/修改角色：提交", "参数:" + role.getSroleName());
    String flag = Constants.FALSE;
    try {
      roleService.edit(role);
      flag = Constants.TRUE;
    } catch (Exception e) {
      ExceptionLogger.error("sys", "添加编辑角色role=" + role, e);
    } finally {
      AccessLogger.info("角色编辑editUI.htm", CommonUtil.getUserName(), "Role=" + role, flag, 0);
    }
    return "redirect:role.htm";
  }

  /**
   * 方法名： delete 描述： 删除某个角色
   * 
   * @author zhuzheng 创建时间：2015年10月23日 上午9:36:11
   * @param id
   * @return
   *
   */
  @RequestMapping("/deleteRole.htm")
  @ResponseBody
  public Map<String, Object> delete(HttpServletRequest request, String id) {
    actionService.saveAction(request, "角色管理:删除角色", "参数:roleId=" + id);
    Map<String, Object> model = new HashMap<String, Object>();
    String flag = Constants.NO;

    try {
      roleService.delete(id);
      flag = Constants.YES;
    } catch (Exception e) {
      ExceptionLogger.error("sys", "删除角色异常roleId=" + id, e);
    } finally {
      model.put("flag", flag);
      AccessLogger.info("删除某个角色deleteRole.htm", CommonUtil.getUserName(), "id=" + id,
          model.toString(), 0);
    }
    return model;
  }
}
