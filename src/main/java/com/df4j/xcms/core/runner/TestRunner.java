package com.df4j.xcms.core.runner;

import com.df4j.xcframework.base.util.JsonUtils;
import com.df4j.xcframework.boot.runner.AbstractApplicationRunner;
import com.df4j.xcms.core.dao.CatalogRepository;
import com.df4j.xcms.core.pojo.entity.CatalogEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestRunner extends AbstractApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(TestRunner.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run0() {
        CatalogRepository catalogRepository = applicationContext.getBean(CatalogRepository.class);
        List<CatalogEntity> list = catalogRepository.findAll();
        logger.info("info:{}", JsonUtils.stringify(list));
    }
}
