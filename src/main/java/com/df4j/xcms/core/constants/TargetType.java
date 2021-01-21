package com.df4j.xcms.core.constants;

import com.df4j.xcms.core.pojo.entity.PositionEntity;
import com.df4j.xcms.core.pojo.entity.RoleEntity;
import com.df4j.xcms.core.pojo.entity.UserEntity;

/**
 * 授予权限的目标类型
 */
public enum TargetType {

    User(UserEntity.class, 1),
    Role(RoleEntity.class, 2),
    Position(PositionEntity.class, 3);

    private Class entityClass;

    private Integer targetType;

    private TargetType(Class entityClass, Integer targetType){
        this.entityClass = entityClass;
        targetType = targetType;
    }

    public Class getEntityClass() {
        return entityClass;
    }

    public Integer getTargetType() {
        return targetType;
    }
}
