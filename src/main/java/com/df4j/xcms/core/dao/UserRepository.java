package com.df4j.xcms.core.dao;

import com.df4j.xcms.core.pojo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
