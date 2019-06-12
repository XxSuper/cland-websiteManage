package com.maiyajf.loan.manage.loan.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.maiyajf.loan.manage.loan.sys.po.Role;

/**
 * @author zz 实现基本的创建/删除权限。
 */
public interface RoleService {

  List<Role> getAllMemberRoleById(String guid);

  List<String> getRolesById(String guid);

  List<Role> getAllRoles();

  List<Role> getRolesByName(String sroleName);

  @Transactional("transactionManager-myLoan")
  void delete(String id);

  Role get(String roleId);

  @Transactional("transactionManager-myLoan")
  void edit(Role role);

  List<Map<String, String>> getPermissionByRoleId(String roleId);

}
