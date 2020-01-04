package com.p2p.shiro;

import com.p2p.model.Users;
import com.p2p.service.IUsersService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUsersService usersService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = token.getPrincipal().toString();
        Users users = usersService.UsersByPrimaryName(userName);
        if(users == null){
            throw new RuntimeException();
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                users.getUsername(),users.getPassword(), ByteSource.Util.bytes(users.getSalt()),this.getName()
        );

        return simpleAuthenticationInfo;
    }
}
