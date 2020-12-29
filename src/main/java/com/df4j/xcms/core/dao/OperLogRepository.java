package com.df4j.xcms.core.dao;

import com.df4j.xcms.core.pojo.entity.OperLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperLogRepository extends JpaRepository<OperLogEntity, Long> {
}
