package com.df4j.xcms.core.dao;


import com.df4j.xcms.core.pojo.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
}
