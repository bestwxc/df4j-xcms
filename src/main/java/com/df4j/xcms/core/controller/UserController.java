package com.df4j.xcms.core.controller;

import com.df4j.xcframework.base.constant.Constants;
import com.df4j.xcframework.base.exception.BusinessException;
import com.df4j.xcframework.base.exception.ErrorCode;
import com.df4j.xcframework.base.exception.XcException;
import com.df4j.xcframework.base.server.Result;
import com.df4j.xcframework.base.util.MapUtils;
import com.df4j.xcframework.base.util.PojoUtils;
import com.df4j.xcframework.base.util.ResultUtils;
import com.df4j.xcframework.web.util.RemoteIpUtils;
import com.df4j.xcframework.web.util.SessionUtils;
import com.df4j.xcms.core.pojo.dto.UserDto;
import com.df4j.xcms.core.pojo.entity.UserEntity;
import com.df4j.xcms.core.service.LoginLogService;
import com.df4j.xcms.core.service.UserService;
import com.df4j.xcms.core.shiro.XcmsUsernamePasswordToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.df4j.xcframework.base.constant.Constants.BASE_ERROR_GROUP;

@RestController
@RequestMapping("/api/xcms/core/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private LoginLogService loginLogService;

    @RequestMapping("/captcha")
    public Result captcha(@RequestBody Map<String, ?> data) {
        return ResultUtils.success(null);
    }

    @RequestMapping("/sms")
    public Result sms(@RequestBody Map<String, ?> data) {
        return ResultUtils.success(null);
    }

    @RequestMapping("/login")
    public Result login(@RequestBody Map<String, ?> data, HttpServletRequest request) {
        String type = MapUtils.getString(data, "type", "account");
        String userName = MapUtils.getString(data, "userName", "");
        String userPass = MapUtils.getString(data, "userPass", "");
        String captcha = MapUtils.getString(data, "captcha", "");
        String mobileNo = MapUtils.getString(data, "mobileNo", "");
        String deviceInfo = MapUtils.getString(data, "devideInfo", "");
        String netAddress = RemoteIpUtils.getRemoteIp(request);
        String nickName = "";
        String msg = null;
        Integer success = 0;
        try {
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken authenticationToken = null;
            if ("account".equals(type)) {
                authFailIfTrue(ObjectUtils.isEmpty(userName) || ObjectUtils.isEmpty(userPass), userName, "????????????????????????????????????????????????");
                authenticationToken = new XcmsUsernamePasswordToken(userName, userPass);
            } else if ("mobile".equals(type)) {
                authFailIfTrue(ObjectUtils.isEmpty(mobileNo) || ObjectUtils.isEmpty(captcha), mobileNo, "??????????????????????????????????????????");
                // Todo ?????????????????????
                throw new XcException("???????????????????????????");
            } else {
                throw new XcException("?????????????????????");
            }
            try {
                subject.login(authenticationToken);
            } catch (AuthenticationException e) {
                if(e instanceof DisabledAccountException) {
                    throw new BusinessException(Constants.BASE_ERROR_GROUP, ErrorCode.DISABLED_ACCOUNT, "???????????????", e);
                } else if(e instanceof LockedAccountException){
                    throw new BusinessException(Constants.BASE_ERROR_GROUP, ErrorCode.LOCKED_ACCOUNT, "???????????????", e);
                } else {
                    throw new BusinessException(Constants.BASE_ERROR_GROUP, ErrorCode.INCORRECT_CREDENTIALS, "???????????????????????????", e);
                }
            }
            msg = "??????";
            success = 1;
            // ???????????????????????????????????????????????????????????????????????????
            return ResultUtils.success(SessionUtils.getLoginUser());
        } catch (Exception e) {
            msg = e.getMessage();
            throw e;
        } finally {
            try {
                String remark = String.format("%s|%s|%s|%s|%s|%s", success, type, userName, mobileNo, captcha, msg);
                loginLogService.insert(userName, nickName, "", deviceInfo, netAddress, remark);
            } catch (Exception e) {
                logger.error("????????????????????????", e);
            }
        }
    }

    @RequestMapping("/info")
    public Result info(@RequestBody Map<String, ?> data) {
        // ??????token?????????????????????????????????
        return ResultUtils.success(SessionUtils.getLoginUser());
    }

    @RequestMapping("/logout")
    public Result logout(@RequestBody Map<String, ?> data) {
        // ???????????????????????????
        Subject subject = SecurityUtils.getSubject();
        if (!ObjectUtils.isEmpty(subject)) {
            subject.logout();
        }
        SessionUtils.removeLoginUser();
        return ResultUtils.success(null);
    }

    private Result packageUserResult(UserEntity userEntity) {
        UserDto userDto = PojoUtils.from(UserDto.class, userEntity);
        // ????????????????????????????????????
        // Todo ????????????????????????????????????
        return ResultUtils.success(userDto);
    }

    private void authFailIfTrue(boolean auth, String id, String msg) {
        if (auth) {
            logger.info("???????????????????????????,id:{}, msg:{}", id, msg);
            throw new BusinessException(BASE_ERROR_GROUP, ErrorCode.INCORRECT_CREDENTIALS, "???????????????????????????");
        } else {
            logger.debug("????????????????????????,id:{}, msg:{}", id, msg);
        }
    }
}
