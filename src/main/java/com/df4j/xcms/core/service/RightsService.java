package com.df4j.xcms.core.service;

import com.df4j.xcms.core.dao.RightsRepository;
import com.df4j.xcms.core.pojo.entity.RightsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightsService {
    @Autowired
    private RightsRepository rightsRepository;


    public List<RightsEntity> findRightsByGrantTypeAndGrantTo(Integer grantType, String grantTo) {
        return rightsRepository.findRightsByTargetTypeAndTargetCode(grantType, grantTo);
    }
}
