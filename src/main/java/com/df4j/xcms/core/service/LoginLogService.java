package com.df4j.xcms.core.service;

import com.df4j.xcframework.base.id.IdentityGenerator;
import com.df4j.xcms.core.dao.LoginLogRepository;
import com.df4j.xcms.core.pojo.entity.LoginLogEntity;
import com.df4j.xcms.core.utils.IdentityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.df4j.xcms.core.constants.Constants.SYSTEM_NAME;

@Service
public class LoginLogService {

    @Autowired
    private LoginLogRepository loginLogRepository;

    @Autowired
    private IdentityGenerator<Long> identityGenerator;

    public List<LoginLogEntity> list() {
        return loginLogRepository.findAll();
    }

    public LoginLogEntity insert(String userName,
                                 String nickName,
                                 String regionCode,
                                 String deviceInfo,
                                 String netAddress,
                                 String remark) {

        Long id = identityGenerator.generate(SYSTEM_NAME, IdentityUtils.getName(LoginLogEntity.class));
        String uniqueStr = String.format("%010d", id);

        LoginLogEntity loginLogEntity = new LoginLogEntity();

        loginLogEntity.setId(id);
        loginLogEntity.setUniqueStr(uniqueStr);
        loginLogEntity.setSysCode(SYSTEM_NAME.toLowerCase());

        loginLogEntity.setUserName(userName);
        loginLogEntity.setNickName(nickName);
        loginLogEntity.setRegionCode(regionCode);
        loginLogEntity.setNetAddress(netAddress);
        loginLogEntity.setDeviceInfo(deviceInfo);
        loginLogEntity.setRemark(remark);

        loginLogEntity.setOrderNum(0);
        loginLogEntity.setState(1);
        loginLogEntity.setCreatedBy(userName);
        loginLogEntity.setLastModifiedBy(userName);

        LocalDateTime datetime = LocalDateTime.now();
        loginLogEntity.setCreatedDate(datetime);
        loginLogEntity.setLastModifiedDate(datetime);

        return loginLogRepository.saveAndFlush(loginLogEntity);
    }
}
