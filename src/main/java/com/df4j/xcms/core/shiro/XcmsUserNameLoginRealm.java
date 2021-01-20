package com.df4j.xcms.core.shiro;

import com.df4j.xcframework.base.exception.BusinessException;
import com.df4j.xcframework.base.exception.ErrorCode;
import com.df4j.xcframework.base.util.JsonUtils;
import com.df4j.xcframework.web.pojo.LoginUser;
import com.df4j.xcframework.web.util.SessionUtils;
import com.df4j.xcms.core.constants.Constants;
import com.df4j.xcms.core.pojo.entity.UserEntity;
import com.df4j.xcms.core.pojo.entity.UserPositionEntity;
import com.df4j.xcms.core.pojo.entity.UserRoleEntity;
import com.df4j.xcms.core.service.RightsService;
import com.df4j.xcms.core.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
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
        try {
            XcmsUsernamePasswordToken xcmsUsernamePasswordToken = (XcmsUsernamePasswordToken) token;
            String userName = xcmsUsernamePasswordToken.getUsername();
            UserEntity userEntity = userService.findByUserName(userName);
            if (ObjectUtils.isEmpty(userEntity)) {
                logger.info("用户不存在，登陆失败,userName:{}", userName);
                throw new BusinessException(Constants.SYSTEM_NAME, ErrorCode.LOGIN_FAIL, "用户名或密码错误");
            }
            String salt = userEntity.getSalt();
            String pass = userEntity.getPass();
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, pass, ByteSource.Util.bytes(salt), this.getName());
            userEntity = userService.findByUserName(userName);

            LoginUser loginUser = toLoginUser(userEntity);
            SessionUtils.setLoginUser(loginUser);
            return simpleAuthenticationInfo;
        } catch (BusinessException be) {
            throw be;
        } catch (Exception e) {
            throw new BusinessException(Constants.SYSTEM_NAME, ErrorCode.LOGIN_FAIL, "用户名或密码错误", e);
        }
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
        List<UserRoleEntity> userRoleEntities = rightsService.findUserRoleByUserName(userEntity.getUserName());
        List<UserPositionEntity> userPositionEntities = rightsService.findUserPositionsByUserName(userEntity.getUserName());
        List<String> roles = new ArrayList<>();
        if (!ObjectUtils.isEmpty(userRoleEntities)) {
            for (int i = 0; i < userRoleEntities.size(); i++) {
                UserRoleEntity userRoleEntity = userRoleEntities.get(i);
                String role = "role:" + userRoleEntity.getRoleCode();
                roles.add(role);
            }
        }
        if (!ObjectUtils.isEmpty(userPositionEntities)) {
            for (int i = 0; i < userPositionEntities.size(); i++) {
                UserPositionEntity userPositionEntity = userPositionEntities.get(i);
                String role = "position:" + userPositionEntity.getDeptCode() + ":" + userPositionEntity.getPositionCode();
                roles.add(role);
            }
        }
        loginUser.setRoleCodes(roles);
        return loginUser;
    }
}
