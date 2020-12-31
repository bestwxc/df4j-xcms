package com.df4j.xcms.core.service;

import com.df4j.xcms.core.dao.LoginLogRepository;
import com.df4j.xcms.core.pojo.entity.LoginLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginLogService {

    @Autowired
    private LoginLogRepository loginLogRepository;

    public List<LoginLogEntity> list() {
        return loginLogRepository.findAll();
    }

}
