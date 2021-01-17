package com.df4j.xcms.core.runner;

import com.df4j.xcframework.boot.runner.AbstractApplicationRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 检查及初始化系统管理员
 */
@Component
@Order(3000)
public class CheckAdminUserRunner extends AbstractApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(CheckAdminUserRunner.class);

    @Override
    public void run0() {

    }
}
