package com.df4j.xcms.core.dao;

import com.df4j.xcms.core.pojo.entity.RightsEntity;
import com.df4j.xcms.core.pojo.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RightsRepository extends JpaRepository<RightsEntity, Long> {
    List<RightsEntity> findRightsByUserName(String userName);
}
