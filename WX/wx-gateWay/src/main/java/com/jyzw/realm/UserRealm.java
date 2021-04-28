package com.jyzw.realm;

import com.jyzw.dao.UserClient;
import com.jyzw.entity.Result;
import com.jyzw.entity.TMenu;
import com.jyzw.entity.TRole;
import com.jyzw.entity.Tuser;
import com.netflix.discovery.converters.Auto;
import net.bytebuddy.build.Plugin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserRealm /*extends AuthorizingRealm*/ {
   /* @Autowired
    private UserClient userClient;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        Subject subject= SecurityUtils.getSubject();
        Tuser user=(Tuser)subject.getPrincipal();
        List<TRole> list=new ArrayList<>();
         Result result =userClient.getUR(user.getUserId());
         list=(List<TRole>)result.data;
         for(TRole role:list){
             simpleAuthorizationInfo.addRole(role.getRoleName());
             List<TMenu> list1=new ArrayList<>();
             Set<TMenu> res=userClient.getRM(role.getRoleId());
             for(TMenu tMenu:res){
                 simpleAuthorizationInfo.addStringPermission(tMenu.getMenuName());
             }
         }
         return  simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName=(String)token.getPrincipal();
        if(userName==null|userName.length()==0){
            return null;
        }
        Tuser tuser=userClient.getUByName(userName);
        SimpleAuthenticationInfo simpleAuthenticationInfo=
                new SimpleAuthenticationInfo(tuser,tuser.getLoginPwd(),ByteSource.Util.bytes(tuser.getLoginName()),getName());
        return simpleAuthenticationInfo;
    }*/
}
