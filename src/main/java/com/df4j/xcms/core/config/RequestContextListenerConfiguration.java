package com.df4j.xcms.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

@Configuration
public class RequestContextListenerConfiguration {

    /**
     * 用户实现在filter逻辑中通过RequestContextHolder获取当前的请求对象
     *
     * @return
     */
    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}
