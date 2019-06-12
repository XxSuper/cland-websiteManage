package com.maiyajf.loan.manage.loan.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.maiyajf.loan.manage.loan.sys.po.User;
import com.maiyajf.loan.manage.loan.sys.po.UserRole;

public interface IUserService {

  User getUserByNameAndPassword(String username, String password);

  User getByUsername(String username);

  @Transactional("transactionManager-myLoan")
  void delete(String id);

  Map<String, Object> getUsersByNames(String suserName, String sMobile, int i);

  @Transactional("transactionManager-myLoan")
  void addUserRole(UserRole ur);

  @Transactional("transactionManager-myLoan")
  void deleteUserRoleByIds(String userId, String roleId);

  int getUserCountByIdAndPassword(String userId, String oldPassWord);

  @Transactional("transactionManager-myLoan")
  void updatePassword(String userId, String passWord);

  int checkUniqueMobile(String phone);

  User getUserById(String guid);

  @Transactional("transactionManager-myLoan")
  Map<String, Object> editUser(User user);

  @Transactional("transactionManager-myLoan")
  void setUserFreeze(String id, int type);

  List<String> getUserRoleIds(String userId);

  @Transactional("transactionManager-myLoan")
  void editUserRole(String sUserId, String roleIdList, String type);

  int checkUniqueUserName(String userName);

  String getPhoneByUserName(String name);

  Map<String, Object> getUsersForAudit(String suserName, String sMobile, int page);

  @Transactional("transactionManager-myLoan")
  void submitAudit(String sGuid, Integer approvel);


  Map<String, Object> getUserRole(String id);

}
