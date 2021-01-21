package com.df4j.xcms.core.runner;

import com.df4j.xcframework.boot.runner.AbstractApplicationRunner;
import com.df4j.xcms.core.service.FuncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;
import java.util.Set;

@Order(1000)
@Component
public class SyncFuncRunner extends AbstractApplicationRunner implements ApplicationContextAware {

    private Logger logger = LoggerFactory.getLogger(SyncFuncRunner.class);

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run0() {
        Map<String, RequestMappingHandlerMapping> requestMappingHandlerMappingMap = applicationContext.getBeansOfType(RequestMappingHandlerMapping.class);
        String applicationName = applicationContext.getBean(Environment.class).getProperty("spring.application.name");
        FuncService funcService = applicationContext.getBean(FuncService.class);
        for (String key : requestMappingHandlerMappingMap.keySet()) {
            RequestMappingHandlerMapping requestMappingHandlerMapping = requestMappingHandlerMappingMap.get(key);
            Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
            for (RequestMappingInfo requestMappingInfo : handlerMethods.keySet()) {
                HandlerMethod handlerMethod = handlerMethods.get(requestMappingInfo);
                PatternsRequestCondition prc = requestMappingInfo.getPatternsCondition();
                Set<String> patterns = prc.getPatterns();
                String methodName = handlerMethod.getMethod().getName();
                String className = handlerMethod.getMethod().getDeclaringClass().getName();
                for (String url : patterns) {
                    funcService.save(applicationName, className, methodName, url);
                }
            }
        }
    }
}
