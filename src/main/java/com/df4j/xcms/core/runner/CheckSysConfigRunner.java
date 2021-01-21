package com.df4j.xcms.core.runner;

import com.df4j.xcframework.boot.runner.AbstractApplicationRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 检查及初始化系统的配置
 */
@Order(2000)
@Component
public class CheckSysConfigRunner extends AbstractApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(CheckSysConfigRunner.class);

    @Override
    public void run0() {

    }
}
