package com.df4j.xcms.core.dao;

import com.df4j.xcms.core.pojo.entity.DictEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictRepository extends JpaRepository<DictEntity, Long> {
}
