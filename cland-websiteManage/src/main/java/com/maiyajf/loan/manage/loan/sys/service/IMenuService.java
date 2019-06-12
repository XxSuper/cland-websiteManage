package com.maiyajf.loan.manage.loan.sys.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.maiyajf.loan.manage.loan.sys.po.Menu;

public interface IMenuService {

  public Menu getMenuById(String menuId);

  public List<Menu> getUserAllMeans(String guid);

  public List<Menu> getTopMenu();

  public List<Menu> getChildrenMenu(String id);

  public List<Menu> getAllMenu();
  @Transactional("transactionManager-myLoangwmanage")
  public void delete(String id);

  @Transactional("transactionManager-myLoangwmanage")
  public void edit(Menu menu);
}
