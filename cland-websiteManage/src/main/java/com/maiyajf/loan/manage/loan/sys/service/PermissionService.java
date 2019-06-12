package com.maiyajf.loan.manage.loan.sys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.maiyajf.loan.manage.loan.sys.po.Menu;
import com.maiyajf.loan.manage.loan.sys.po.Permission;

public interface PermissionService {

  List<String> getPermissionStringById(String guid);

  List<Permission> getPermissionById(String guid);

  List<String> getMenuIdById(String guid);

  List<Permission> getPermissionByMenuId(String id);

  @Transactional("transactionManager-myLoan")
  void delete(String id);

  List<Menu> getAllPermission();

  @Transactional("transactionManager-myLoan")
  void setPermission(String roleId, String resourceIdList);

  Permission get(String guid);

  @Transactional("transactionManager-myLoan")
  void edit(Permission permission);

  Permission getPermissonByUrl(String url);
}
