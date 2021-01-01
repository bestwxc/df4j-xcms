package com.df4j.xcms.core.config;

import com.df4j.xcframework.base.id.LongRedisIdentityGenerator;
import com.df4j.xcframework.base.lock.DistributedLock;
import com.df4j.xcframework.base.lock.RedisDistributedLock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class IdentityGeneratorConfiguration {

    @Bean
    LongRedisIdentityGenerator longRedisIdentityGenerator(
            DistributedLock distributedLock,
            StringRedisTemplate stringRedisTemplate,
            JdbcTemplate jdbcTemplate) {
        return new LongRedisIdentityGenerator(stringRedisTemplate, (RedisDistributedLock) distributedLock, jdbcTemplate);
    }
}
