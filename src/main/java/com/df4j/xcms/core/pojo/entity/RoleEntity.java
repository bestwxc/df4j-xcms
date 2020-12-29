package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "t_xcms_role")
public class RoleEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 1622862623961122528L;
}
