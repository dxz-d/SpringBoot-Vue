package com.evan.wj.realm;

import com.evan.wj.pojo.User;
import com.evan.wj.service.AdminPermissionService;
import com.evan.wj.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/***
 * @description
 * @author diaoxiuze
 * @date 2021/1/7 15:31
 * @param
 * @return
 */
public class Realm extends AuthorizingRealm {

    /*@Autowired
    private UserService userService;

    AdminPermissionService adminPermissionService;

    *//***
     * @description  简单重写授权信息方法
     * @author diaoxiuze
     * @date 2021/1/7 15:43
     * @param principalCollection
     * @return org.apache.shiro.authz.AuthorizationInfo
     *//*
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取当前用户的所有权限
        String username = principalCollection.getPrimaryPrincipal().toString();
        Set<String> permissions = adminPermissionService.listPermissionURLsByUser(username);

        // 将权限放入权限信息中
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        s.setStringPermissions(permissions);
        return s;
    }

    *//***
     * @description  获取认证信息，即根据token中的用户名从数据库中获取密码，盐等并返回
     * @author diaoxiuze
     * @date 2021/1/7 15:43
     * @param token
     * @return org.apache.shiro.authc.AuthenticationInfo
     *//*
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = token.getPrincipal().toString();
        User user = userService.getByUserName(userName);
        String passwordInDB = user.getPassword();
        String salt = user.getSalt();
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, passwordInDB, ByteSource.Util.bytes(salt), getName());
        return simpleAuthenticationInfo;
    }*/

    @Autowired
    private UserService userService;

    @Autowired
    AdminPermissionService adminPermissionService;

    /***
     * @description  简单重写授权信息方法
     * @author diaoxiuze
     * @date 2021/1/7 15:43
     * @param principalCollection
     * @return org.apache.shiro.authz.AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取当前用户的所有权限
        String username = principalCollection.getPrimaryPrincipal().toString();

        Set<String> permissions = adminPermissionService.listPermissionURLsByUser(username);

        // 将权限放入授权信息中
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        s.setStringPermissions(permissions);
        return s;
    }

    /***
     * @description  获取认证信息，即根据token中的用户名从数据库中获取密码，盐等并返回
     * @author diaoxiuze
     * @date 2021/1/7 15:43
     * @param token
     * @return org.apache.shiro.authc.AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = token.getPrincipal().toString();
        User user = userService.getByUserName(userName);
        String passwordInDB = user.getPassword();
        String salt = user.getSalt();
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, passwordInDB, ByteSource.Util.bytes(salt), getName());
        return simpleAuthenticationInfo;
    }
}























