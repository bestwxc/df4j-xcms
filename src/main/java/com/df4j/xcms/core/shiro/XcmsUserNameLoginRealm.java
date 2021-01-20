package com.df4j.xcms.core.shiro;

import com.df4j.xcframework.base.exception.BusinessErrorManager;
import com.df4j.xcframework.base.exception.BusinessException;
import com.df4j.xcframework.base.exception.ErrorCode;
import com.df4j.xcframework.base.util.JsonUtils;
import com.df4j.xcframework.web.pojo.LoginUser;
import com.df4j.xcframework.web.util.SessionUtils;
import com.df4j.xcms.core.constants.Constants;
import com.df4j.xcms.core.pojo.entity.UserEntity;
import com.df4j.xcms.core.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

public class XcmsUserNameLoginRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(XcmsUserNameLoginRealm.class);

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("doGetAuthorizationInfo: {}", JsonUtils.stringify(principals));
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        try {
            Subject subject = SecurityUtils.getSubject();
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
            String nickName = userEntity.getNickName();
            userName = userEntity.getUserName();
            String mobileNo = userEntity.getMobileNo();
            LoginUser loginUser = new LoginUser();
            loginUser.setUserId(String.valueOf(userEntity.getId()));
            loginUser.setUserName(userName);
            loginUser.setNickName(nickName);
            loginUser.setMobileNo(mobileNo);
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
}
