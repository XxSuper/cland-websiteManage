package com.maiyajf.loan.manage.common.security.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.maiyajf.base.utils.log.DebugLogger;
import com.maiyajf.loan.manage.loan.sys.po.User;
import com.maiyajf.loan.manage.loan.sys.service.IUserService;
import com.maiyajf.loan.manage.loan.sys.service.PermissionService;
import com.maiyajf.loan.manage.loan.sys.service.RoleService;

 
/**
 * @ClassName: MaiyaRealm
 * @Description: 重写安全数据源的实现
 * @author: zhuangsheng.chen
 * @date: 2016年2月23日 上午10:27:19
 */
public class MaiyaRealm extends AuthorizingRealm {

  @Resource(name = "userServiceImpl")
  private IUserService userService;

  @Resource(name = "roleServiceImpl")
  private RoleService roleService;

  @Resource(name = "permissionServiceImpl")
  private PermissionService permissionService;

  /**
   * 为当前登录的Subject授予角色和权限
   * 
   * @see 经测试:本例中该方法的调用时机为需授权资源被访问时
   * @see 经测试:并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
   * @see 个人感觉若使用了Spring3 .1开始提供的ConcurrentMapCache支持,则可灵活决定是否启用AuthorizationCache
   * @see 比如说这里从数据库获取权限信息时,先去访问Spring3.1提供的缓存,而不使用Shior提供的AuthorizationCache
   */
  /*
   * (non-Javadoc)
   * 
   * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache
   * .shiro.subject.PrincipalCollection)
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    String username = (String) principals.getPrimaryPrincipal();
    if (StringUtils.isNotBlank(username)) {
      // 获取用户
      User operator = userService.getByUsername(username);
      // // 得到该用户的所有角色的权限集合------应放在redis里面
      List<String> roleList = new ArrayList<String>();
      List<String> permissionList = new ArrayList<String>();
      // 获取用户所有的角色id
      roleList = roleService.getRolesById(operator.getGuid());
      // 获取用户角色的权限码
      permissionList = permissionService.getPermissionStringById(operator.getGuid());
      // 为当前用户设置角色和权限
      SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
      simpleAuthorInfo.addRoles(roleList);
      simpleAuthorInfo.addStringPermissions(permissionList);
      return simpleAuthorInfo;
    }
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org
   * .apache.shiro.authc.AuthenticationToken)
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
      throws AuthenticationException {

    // 获取基于用户名和密码的令牌
    // 实际上这个authcToken是从Controller里面login(token)传过来的
    UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

    User user =
        userService.getUserByNameAndPassword(token.getUsername(), new String(token.getPassword()));
    if (null != user) {
      AuthenticationInfo authcInfo =
          new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), user.getRealName());
      this.setSession("currentUser", user);
      return authcInfo;
    } else {
      return null;
    }

  }

  /**
   * 将一些数据放到ShiroSession中,以便于其它地方使用
   * 
   * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
   */
  private void setSession(Object key, Object value) {
    Subject currentUser = SecurityUtils.getSubject();
    if (null != currentUser) {
      Session session = currentUser.getSession();
      DebugLogger.debug("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
      if (null != session) {
        session.setAttribute(key, value);
      }
    }
  }
}
