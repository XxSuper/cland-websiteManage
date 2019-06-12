package com.maiyajf.loan.manage.loan.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.maiyajf.loan.manage.loan.sys.po.User;

public interface UserDao {

  void insert(User user);

  void update(User user);

  void delete(String id);

  User getUserByNameAndPassword(Map<String, String> params);

  User getByUsername(String username);

  List<User> getByUsersRoleIds(List<String> roleIds);

  void save(User user);

  List<User> getByUsersByName(@Param("suserName") String suserName,
      @Param("sMobile") String sMobile, @Param("pageStart") Integer pageStart,
      @Param("pageEnd") Integer pageEnd);

  int getUserCountByIdAndPassword(@Param("userId") String userId,
      @Param("oldPassWord") String oldPassWord);

  void updatePassword(@Param("userId") String userId, @Param("passWord") String passWord);

  int checkUniqueMobile(String mobile);

  User getUserById(String guid);

  void updateFreeze(@Param("id") String id, @Param("type") int type);

  int getUserCount();

  int checkUniqueUserName(String userName);

  String getPhoneByUserName(String name);

  int getUserCountForAudit();

  List<User> getUsersForAudit(@Param("suserName") String suserName,
      @Param("sMobile") String sMobile, @Param("pageStart") Integer pageStart,
      @Param("pageEnd") Integer pageEnd);

  void saveUserApply(User user);

  void updateUsing(@Param("sGuid") String sGuid, @Param("sStatus") int sStatus,
      @Param("sCheckPerson") String sCheckPerson, @Param("idelFlag") Integer idelFlag);

  void updateUserAudit(@Param("sGuid") String sGuid, @Param("iCheckResult") Integer iCheckResult,
      @Param("sCheckPerson") String sCheckPerson, @Param("idelFlag") Integer idelFlag);

  void deleteUserApply(String id);

  List<Map<String, String>> getUserNamebyRoleIds(List<String> ids);

}
