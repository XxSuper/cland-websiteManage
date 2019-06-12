package com.maiyajf.loan.manage.loan.sys.dao;

import java.util.List;

import com.maiyajf.loan.manage.loan.sys.po.Menu;

public interface MenuDao {

  List<Menu> getAll(String string, boolean b);

  boolean isNameSame(String sname, String sparentid, String id);

  List<Menu> getMenuByParentId(String parentId, String sort);

  Menu get(String id);

  void save(Menu menu);

  List<Menu> getMenuByIds(List<String> menuListString);

  List<Menu> getTopMenu();

  List<Menu> getChildrenMenus(String id);

  void add(Menu menu);

  void delete(String id);

  void update(Menu menu);

}
