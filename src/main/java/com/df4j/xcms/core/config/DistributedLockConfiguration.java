package com.df4j.xcms.core.config;

import com.df4j.xcframework.base.lock.DistributedLock;
import com.df4j.xcframework.base.lock.RedisDistributedLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.ObjectUtils;

@Configuration
public class DistributedLockConfiguration {

    private Logger logger = LoggerFactory.getLogger(DistributedLockConfiguration.class);

    @Bean(name = "distributedLock")
    DistributedLock distributedLock(ObjectProvider<StringRedisTemplate> stringRedisTemplateObjectProvider) {
        StringRedisTemplate stringRedisTemplate = stringRedisTemplateObjectProvider.getIfAvailable();
        if(!ObjectUtils.isEmpty(stringRedisTemplate)){
            return new RedisDistributedLock(stringRedisTemplate);
        } else {
            logger.error("未找到对应的stringRedisTemplate,未正确注入distributedLock");
            return null;
        }
    }
}
