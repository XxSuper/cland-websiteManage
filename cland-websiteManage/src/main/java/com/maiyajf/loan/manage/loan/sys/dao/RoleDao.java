package com.maiyajf.loan.manage.loan.sys.dao;

import java.util.List;

import com.maiyajf.loan.manage.loan.sys.po.Role;
import com.maiyajf.loan.manage.loan.sys.vo.UserRoleVo;

public interface RoleDao {

  Role get(String id);

  Role getByName(Role r);

  List<Role> findList(Role role);

  List<Role> getAllMemberRoleById(String guid);

  List<String> getRoleByUserId(String guid);

  void add(Role role);

  List<Role> getALl();

  List<Role> getRolesByName(String roleName);

  int delete(String id);

  void update(Role role);

}
