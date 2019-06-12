package com.maiyajf.loan.manage.loan.sys.dao;

import java.util.List;
import java.util.Map;

public interface RolePermissionDao {

  void deleteByRoleId(String roleId);

  void add(List<Map<String, Object>> idList);

  List<Map<String, String>> getPermissionByRole(String roleId);

}
