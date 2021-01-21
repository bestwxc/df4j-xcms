package com.df4j.xcms.core.dao;

import com.df4j.xcms.core.pojo.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    List<UserRoleEntity> findUserRoleByUserName(String userName);
}
