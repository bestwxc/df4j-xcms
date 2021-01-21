package com.df4j.xcms.core.filter;

import com.df4j.xcframework.base.exception.ErrorCode;
import com.df4j.xcframework.base.server.Result;
import com.df4j.xcframework.base.util.JsonUtils;
import com.df4j.xcframework.base.util.ResultUtils;
import com.df4j.xcframework.web.util.ResponseUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限校验器，自定义权限校验逻辑
 */
public class XcmsPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {

    private Logger logger = LoggerFactory.getLogger(XcmsPermissionsAuthorizationFilter.class);

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        // 通过request 获取url
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String uri = httpServletRequest.getRequestURI();
        Subject subject = getSubject(request, response);
        return subject.isPermitted(uri);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        Subject subject = getSubject(request, response);
        // If the subject isn't identified, redirect to login URL
        Result result = null;
        if (ObjectUtils.isEmpty(subject.getPrincipal())) {
            result = ResultUtils.error(ErrorCode.UNLOGIN, "未登陆");
        } else {
            result = ResultUtils.error(ErrorCode.UNAUTHORIZED, "未授权");
        }
        ResponseUtils.returnJsonResult((HttpServletResponse) response, result);
        logger.info("未授权访问访问，uri: {}, return:{}",
                ((HttpServletRequest) request).getRequestURI(), JsonUtils.stringify(result));
        return false;
    }
}
