package com.maiyajf.loan.manage.loan.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.maiyajf.loan.manage.loan.sys.po.UserRole;

public interface UserRoleDao {
  void insert(UserRole userRole);

  int deleteByIds(@Param("userId") String userId, @Param("roleId") String roleId);

  int deleteUserRole(String userId);

  List<String> getRoleIdsByUserId(String userId);

  void add(List<Map<String, Object>> idList);

  String getFormatRoleName(String sUserId);

  String getFormatRoleNameByIds(List<Map<String, Object>> idList);
}
