package com.df4j.xcms.core.config;

import com.df4j.xcms.core.filter.XcmsPermissionsAuthorizationFilter;
import com.df4j.xcms.core.shiro.XcmsUserNameLoginRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.*;

@Configuration
public class ShiroConfiguration {

    /**
     * Bean生命周期前置处理器
     * shiro自定义了自己的生命周期回调接口，而不是Spring的。
     * {@link org.apache.shiro.util.Initializable}
     * {@link org.apache.shiro.util.Destroyable}
     *
     * @return
     */
    @Bean
    LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    CacheManager shiroCacheManager() {
        return new MemoryConstrainedCacheManager();
    }

    @Bean
    SessionManager shiroSessionManager() {
        return new DefaultWebSessionManager();
    }

    @Bean
    HashedCredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("SHA1");
        credentialsMatcher.setHashIterations(3);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    @Bean
    XcmsUserNameLoginRealm xcmsUserNameLoginRealm() {
        XcmsUserNameLoginRealm xcmsUserNameLoginRealm = new XcmsUserNameLoginRealm();
        xcmsUserNameLoginRealm.setCredentialsMatcher(credentialsMatcher());
        return xcmsUserNameLoginRealm;
    }

    @Bean
    SecurityManager securityManager() {

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        // 设置realm
        // realm为shiro提供给开发者用来提供权限信息的接口
        // 该部分网上教程较多

        // 设置单个realm
        // Realm realm = null;
        // securityManager.setRealm(realm);

        // 设置多个realm
        // List<Realm> realms = new ArrayList<>();
        // securityManager.setRealms(realms);

        // 配置加密算法验证器

        securityManager.setRealm(xcmsUserNameLoginRealm());
        // 配置缓存管理
        securityManager.setCacheManager(shiroCacheManager());
        // 配置会话管理器 默认为ServletContainerSessionManager
        securityManager.setSessionManager(shiroSessionManager());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置权限管理器SecurityManager 这里通过SpringBean方式注入
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 设置登陆页面URL，当未登陆的用户访问需要登陆的页面，会跳转至该页面，默认是 /login.jsp
        // String loginUrl = "/login.jsp";
        // shiroFilterFactoryBean.setLoginUrl(loginUrl);

        // 设置登陆成功页面URL，登陆成功后跳转的页面，默认是 /
        // String successUrl = "/";
        // shiroFilterFactoryBean.setSuccessUrl(successUrl);

        // 设置登陆失败页面URL，可以与登陆页面相同，也可以先展示登陆错误页，错误页上带有返回登陆页的链接，默认应该是loginUrl
        // String unauthorizedUrl = "/login.jsp";
        // shiroFilterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);

        // 配置shiro的init文件路径，可以将配置文件配置拦截规则，取urls定义部分
        // 即 setFilterChainDefinitions和setFilterChainDefinitionMap两个方式选一个
        // String filterChainDefinitions = "shiro.ini";
        // shiroFilterFactoryBean.setFilterChainDefinitions(filterChainDefinitions);

        /**
         * 自定义的基于shiro filter 在这里注册
         * 在Spring与Shiro集成的项目中，会存在两种类型的filter
         *     1. 归Spring管理的filter,可以通过标注@Component的方式注册为Bean即可
         *          SpringShiroFilter本身归spring管理
         *     2. 归shiro管理的filter, 在此处进行注册，该部分实际由SpringShiroFilter管理
         *          除了在这里注册的Bean外，shiro还管理其默认的过滤器 {@link org.apache.shiro.web.filter.mgt.DefaultFilter}
         * 请勿将filter注册为Bean并在此交给shiro管理
         */
        Map<String, Filter> filters = new HashMap<>();
        filters.put("perms", new XcmsPermissionsAuthorizationFilter());
        shiroFilterFactoryBean.setFilters(filters);

        // 注册全局filters的名称
        List<String> globalFilters = new ArrayList<>();
        shiroFilterFactoryBean.setGlobalFilters(globalFilters);

        // 注册拦截规则map
        // 下面的anao, authc 均为默认的拦截器，在DefaultFilter中定义
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 允许静态资源及登陆地址 无需校验
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/login.jsp", "anon");
        // 设置其他地址需要登陆 anao
        filterChainDefinitionMap.put("/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }
}
