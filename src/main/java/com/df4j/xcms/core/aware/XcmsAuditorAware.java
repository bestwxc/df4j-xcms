package com.df4j.xcms.core.aware;

import com.df4j.xcframework.web.pojo.LoginUser;
import com.df4j.xcframework.web.util.SessionUtils;
import com.df4j.xcms.core.constants.Constants;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Component
public class XcmsAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        LoginUser loginUser = SessionUtils.getLoginUser();
        String userName = Constants.SYSTEM_NAME;
        if (!ObjectUtils.isEmpty(loginUser)) {
            userName = loginUser.getUserName();
        }
        return Optional.of(userName);
    }
}
