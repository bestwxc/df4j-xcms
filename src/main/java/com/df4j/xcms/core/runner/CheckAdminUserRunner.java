package com.df4j.xcms.core.runner;

import com.df4j.xcframework.boot.runner.AbstractApplicationRunner;
import com.df4j.xcms.core.constants.TargetType;
import com.df4j.xcms.core.pojo.entity.UserEntity;
import com.df4j.xcms.core.service.UserService;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * 检查及初始化系统管理员
 */
@Component
@Order(2000)
public class CheckAdminUserRunner extends AbstractApplicationRunner implements ApplicationContextAware {

    private Logger logger = LoggerFactory.getLogger(CheckAdminUserRunner.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run0() {
        UserService userService = applicationContext.getBean(UserService.class);
        UserEntity user = userService.findByUserName("admin");
        if(!ObjectUtils.isEmpty(user)){
            logger.info("admin用户已经存在，跳过初始化");
            return;
        }
        String salt = "123456";
        user = new UserEntity();
        user.setUserName("admin");
        user.setNickName("超级管理员");
        user.setMobileNo("13012345678");
        user.setUserType(1);
        user.setSourceType(1);
        user.setSex(1);
        user.setState(1);
        user.setOrderNum(0);
        user.setSysCode("XCMS");
        user.setAvatar("123");
        user.setSelfIntroduction("自我介绍");
        user.setEncType(1);
        user.setSalt(salt);
        user.setTargetType(TargetType.User.getTargetType());
        Sha1Hash sha1Hash = new Sha1Hash("admin123", "123456", 3);
        user.setPass(sha1Hash.toHex());
        user.setTargetType(TargetType.User.getTargetType());
        userService.saveByUserName(user.getUserName(), user);
    }
}
