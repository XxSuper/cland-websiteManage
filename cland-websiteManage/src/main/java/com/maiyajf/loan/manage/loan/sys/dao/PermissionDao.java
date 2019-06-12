package com.maiyajf.loan.manage.loan.sys.dao;

import java.util.List;
import java.util.Map;

import com.maiyajf.loan.manage.loan.sys.po.Permission;

public interface PermissionDao {

  List<String> getPermissionStringById(String guid);

  List<Permission> getPermissionById(String guid);

  List<String> getMenuIdById(String guid);

  List<Permission> getPermissionByMenuId(String id);

  void delete(String id);

  void add(Permission permission);

  Permission get(String guid);

  void update(Permission permission);

  void deleteByMenuId(String id);

  Permission getPermissonByUrl(String url);

}
