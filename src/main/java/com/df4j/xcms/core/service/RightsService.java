package com.df4j.xcms.core.service;

import com.df4j.xcms.core.dao.RightsRepository;
import com.df4j.xcms.core.dao.UserPositionRepository;
import com.df4j.xcms.core.dao.UserRoleRepository;
import com.df4j.xcms.core.pojo.entity.RightsEntity;
import com.df4j.xcms.core.pojo.entity.UserPositionEntity;
import com.df4j.xcms.core.pojo.entity.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightsService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserPositionRepository userPositionRepository;
    @Autowired
    private RightsRepository rightsRepository;

    public List<UserPositionEntity> findUserPositionsByUserName(String userName){
        return userPositionRepository.findByUserName(userName);
    }

    public List<UserRoleEntity> findUserRoleByUserName(String userName){
        return userRoleRepository.findUserRoleByUserName(userName);
    }

    public List<RightsEntity> findRightsByGrantTypeAndGrantTo(Integer grantType, String grantTo){
        return rightsRepository.findRightsByTargetTypeAndTargetCode(grantType, grantTo);
    }
}
