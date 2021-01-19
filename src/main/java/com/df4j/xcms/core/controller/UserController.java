package com.df4j.xcms.core.controller;

import com.df4j.xcframework.base.exception.BusinessException;
import com.df4j.xcframework.base.exception.ErrorCode;
import com.df4j.xcframework.base.exception.XcException;
import com.df4j.xcframework.base.server.Result;
import com.df4j.xcframework.base.util.MapUtils;
import com.df4j.xcframework.base.util.PojoUtils;
import com.df4j.xcframework.base.util.ResultUtils;
import com.df4j.xcframework.web.pojo.LoginUser;
import com.df4j.xcframework.web.util.RemoteIpUtils;
import com.df4j.xcframework.web.util.SessionUtils;
import com.df4j.xcms.core.pojo.dto.UserDto;
import com.df4j.xcms.core.pojo.entity.UserEntity;
import com.df4j.xcms.core.service.LoginLogService;
import com.df4j.xcms.core.service.UserService;
import com.df4j.xcms.core.shiro.XcmsUsernamePasswordToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
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
        UserEntity userEntity = null;
        String nickName = "";
        String msg = null;
        Integer success = 0;
        try {
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken authenticationToken = null;
            if("account".equals(type)){
                authFailIfTrue(ObjectUtils.isEmpty(userName) || ObjectUtils.isEmpty(userPass), userName, "校验是否填写用户名、密码、验证码");
                authenticationToken = new XcmsUsernamePasswordToken(userName, userPass);
            } else if("mobile".equals(type)){
                authFailIfTrue(ObjectUtils.isEmpty(mobileNo) || ObjectUtils.isEmpty(captcha), mobileNo, "校验手机号码和验证码是否为空");
                // Todo 支持手机号登录
                throw new XcException("暂不支持手机号登陆");
            } else {
                throw new XcException("未知的登录方式");
            }
            subject.login(authenticationToken);
            userEntity = userService.findByUserName(userName);
            nickName = userEntity.getNickName();
            userName = userEntity.getUserName();
            mobileNo = userEntity.getMobileNo();
            LoginUser loginUser = new LoginUser();
            loginUser.setUserId(String.valueOf(userEntity.getId()));
            loginUser.setUserName(userName);
            loginUser.setNickName(nickName);
            loginUser.setMobileNo(mobileNo);
            SessionUtils.setLoginUser(loginUser);
            msg = "成功";
            success = 1;
            // 组装当前用户信息（应该包括角色、权限等详情）并返回
            return this.packageUserResult(userEntity);
        } catch (Exception e) {
            msg = e.getMessage();
            throw e;
        } finally {
            try {
                String remark = String.format("%s|%s|%s|%s|%s|%s", success, type, userName, mobileNo, captcha, msg);
                loginLogService.insert(userName, nickName, "", deviceInfo, netAddress, remark);
            }catch ( Exception e) {
                logger.error("插入登陆日志异常", e);
            }
        }
    }

    @RequestMapping("/info")
    public Result info(@RequestBody Map<String, ?> data) {
        // 通过token或者会话来获取当前用户
        // Todo 通过token或者会话来获取当前用户
        Long userId = 1000L;
        // 查询当前用户
        UserEntity userEntity = userService.findByUserId(userId);
        // 组装当前用户信息（应该包括角色、权限等详情）并返回
        return this.packageUserResult(userEntity);
    }

    @RequestMapping("/logout")
    public Result logout(@RequestBody Map<String, ?> data) {
        // 登出前清理登陆信息
        Subject subject = SecurityUtils.getSubject();
        if(!ObjectUtils.isEmpty(subject)) {
            subject.logout();
        }
        SessionUtils.removeLoginUser();
        return ResultUtils.success(null);
    }

    private Result packageUserResult(UserEntity userEntity) {
        UserDto userDto = PojoUtils.from(UserDto.class, userEntity);
        // 包装角色、权限等详情信息
        // Todo 包装角色、权限等详情信息
        return ResultUtils.success(userDto);
    }

    private void authFailIfTrue(boolean auth, String id, String msg) {
        if (auth) {
            logger.info("用户登陆校验不通过,id:{}, msg:{}", id, msg);
            throw new BusinessException(BASE_ERROR_GROUP, ErrorCode.INCORRECT_CREDENTIALS, "用户名或密码不正确");
        } else {
            logger.debug("用户登陆校验通过,id:{}, msg:{}", id, msg);
        }
    }
}
