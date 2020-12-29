package com.df4j.xcms.core.dao;

import com.df4j.xcms.core.pojo.entity.LoginLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginLogRepository extends JpaRepository<LoginLogEntity, Long> {
}
