package com.df4j.xcms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan({
        "com.df4j.xcms.core.mapper"
})
public class XcmsApplication {

    private static Logger logger = LoggerFactory.getLogger(XcmsApplication.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(XcmsApplication.class, args);
        } catch (Throwable t) {
            logger.error("启动失败", t);
        }
    }
}
