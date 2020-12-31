package com.df4j.xcms.core.service;

import com.df4j.xcms.core.dao.UserRepository;
import com.df4j.xcms.core.pojo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity findByUserName(String userName) {
       return userRepository.findByUserName(userName);
    }

    public UserEntity findByMobileNo(String mobileNo) {
        return userRepository.findByMobileNo(mobileNo);
    }

    public UserEntity findByUserId(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
