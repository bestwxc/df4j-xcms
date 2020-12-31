package com.df4j.xcms.core.service;

import com.df4j.xcms.core.dao.OperLogRepository;
import com.df4j.xcms.core.pojo.entity.OperLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperLogService {

    @Autowired
    private OperLogRepository operLogRepository;

    public List<OperLogEntity> list() {
        return operLogRepository.findAll();
    }

}
