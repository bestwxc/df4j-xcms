package com.df4j.xcms.core.dao;

import com.df4j.xcms.core.pojo.entity.BtnEntity;
import com.df4j.xcms.core.pojo.entity.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<CatalogEntity, Long> {
}
