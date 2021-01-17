package com.df4j.xcms.core.runner;

import com.df4j.xcframework.boot.runner.AbstractApplicationRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 检查及初始化系统功能bundle
 */
@Component
@Order(4000)
public class CheckSysBundleRunner extends AbstractApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(CheckSysBundleRunner.class);

    @Override
    public void run0() {

    }
}
