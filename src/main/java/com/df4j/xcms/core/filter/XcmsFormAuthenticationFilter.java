package com.df4j.xcms.core.filter;

import com.df4j.xcframework.base.exception.ErrorCode;
import com.df4j.xcframework.base.server.Result;
import com.df4j.xcframework.base.util.ResultUtils;
import com.df4j.xcframework.web.util.ResponseUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class XcmsFormAuthenticationFilter extends FormAuthenticationFilter {

    private Logger logger = LoggerFactory.getLogger(XcmsFormAuthenticationFilter.class);

    /**
     * 验证失败 返回json 区分未登陆和未授权
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        logger.info("校验未通过");
        Subject subject = SecurityUtils.getSubject();
        Result result = ObjectUtils.isEmpty(subject) ? ResultUtils.error(ErrorCode.UNLOGIN, "未登陆") : ResultUtils.error(ErrorCode.UNAUTHORIZED, "未授权");
        ResponseUtils.returnJsonResult((HttpServletResponse) response, result);
    }
}
