package com.df4j.xcms.core.dao;

import com.df4j.xcms.core.pojo.entity.UserPositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPositionRepository extends JpaRepository<UserPositionEntity, Long> {
    List<UserPositionEntity> findByUserName(String userName);
}