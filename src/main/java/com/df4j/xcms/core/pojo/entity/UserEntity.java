package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_xcms_user")
public class UserEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -2001616547781405114L;
}
