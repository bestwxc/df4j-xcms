package com.df4j.xcms.core.service;

import com.df4j.xcframework.base.id.IdentityGenerator;
import com.df4j.xcms.core.dao.UserRepository;
import com.df4j.xcms.core.pojo.entity.UserEntity;
import com.df4j.xcms.core.utils.IdentityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

import static com.df4j.xcms.core.constants.Constants.SYSTEM_NAME;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IdentityGenerator<Long> identityGenerator;

    public UserEntity findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public UserEntity findByMobileNo(String mobileNo) {
        return userRepository.findByMobileNo(mobileNo);
    }

    public UserEntity findByUserId(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public UserEntity saveByUserName(String userName, UserEntity userEntity) {
        UserEntity user = this.findByUserName(userName);
        if (!ObjectUtils.isEmpty(user)) {
            return user;
        } else {
            Long id = identityGenerator.generate(SYSTEM_NAME, IdentityUtils.getName(UserEntity.class));
            String uniqueStr = String.format("%010d", id);
            LocalDateTime now = LocalDateTime.now();
            userEntity.setId(id);
            userEntity.setUniqueStr(uniqueStr);
            userEntity.setCreatedDate(now);
            userEntity.setLastModifiedDate(now);
            userEntity.setCreatedBy("XCMS");
            userEntity.setLastModifiedBy("XCNS");
            userRepository.save(userEntity);
            return userEntity;
        }
    }
}
