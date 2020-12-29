package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_xcms_sys_config")
public class SysConfigEntity extends OrderedEntity<Long> {
    private static final long serialVersionUID = 4408996824670958280L;
}
