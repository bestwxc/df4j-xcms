package com.df4j.xcms.core.shiro;

import com.df4j.xcframework.base.util.JsonUtils;
import com.df4j.xcframework.web.pojo.LoginUser;
import com.df4j.xcframework.web.util.SessionUtils;
import com.df4j.xcms.core.pojo.entity.PositionEntity;
import com.df4j.xcms.core.pojo.entity.RoleEntity;
import com.df4j.xcms.core.pojo.entity.UserEntity;
import com.df4j.xcms.core.service.RightsService;
import com.df4j.xcms.core.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class XcmsUserNameLoginRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(XcmsUserNameLoginRealm.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RightsService rightsService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("doGetAuthorizationInfo: {}", JsonUtils.stringify(principals));
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        XcmsUsernamePasswordToken xcmsUsernamePasswordToken = (XcmsUsernamePasswordToken) token;
        String userName = xcmsUsernamePasswordToken.getUsername();
        UserEntity userEntity = userService.findByUserName(userName);
        if (ObjectUtils.isEmpty(userEntity)) {
            logger.info("用户不存在，登陆失败,userName:{}", userName);
            throw new UnknownAccountException("userName:" + userName);
        }
        String salt = userEntity.getSalt();
        String pass = userEntity.getPass();
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, pass, ByteSource.Util.bytes(salt), this.getName());
        userEntity = userService.findByUserName(userName);
        int userState = userEntity.getState();
        if (userState != 1) {
            if (userState == 2) {
                throw new LockedAccountException("userName:" + userName);
            } else {
                throw new DisabledAccountException("userName:" + userName);
            }
        }
        LoginUser loginUser = toLoginUser(userEntity);
        SessionUtils.setLoginUser(loginUser);
        return simpleAuthenticationInfo;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return !ObjectUtils.isEmpty(token) && token instanceof XcmsUsernamePasswordToken;
    }

    private LoginUser toLoginUser(UserEntity userEntity) {
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(String.valueOf(userEntity.getId()));
        loginUser.setUserName(userEntity.getUserName());
        loginUser.setNickName(userEntity.getNickName());
        loginUser.setMobileNo(userEntity.getMobileNo());
        loginUser.setEmail(userEntity.getEmail());
        loginUser.setDeptCode(userEntity.getDeptCode());
        loginUser.setSourceType(userEntity.getSourceType());
        loginUser.setUserType(userEntity.getUserType());
        loginUser.setAvatar(userEntity.getAvatar());
        Set<RoleEntity> roleSet = userEntity.getRoles();
        List<String> roles = new ArrayList<>();
        if (!ObjectUtils.isEmpty(roleSet)) {
            for (RoleEntity roleEntity : roleSet) {
                String role = "role:" + roleEntity.getRoleCode();
                roles.add(role);
            }
        }
        Set<PositionEntity> positionSet = userEntity.getPositions();
        if (!ObjectUtils.isEmpty(positionSet)) {
            for (PositionEntity positionEntity : positionSet) {
                String role = "position:" + positionEntity.getPositionCode();
                roles.add(role);
            }
        }
        loginUser.setRoleCodes(roles);
        return loginUser;
    }
}
