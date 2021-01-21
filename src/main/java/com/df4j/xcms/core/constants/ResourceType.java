package com.df4j.xcms.core.constants;

import com.df4j.xcms.core.pojo.entity.*;

/**
 * 资源类型
 */
public enum ResourceType {

    Role(RoleEntity.class, 1),
    Position(PositionEntity.class, 2),
    SubSys(SubSysEntity.class, 11),
    Menu(MenuEntity.class, 12),
    Component(ComponentEntity.class, 13),
    Page(PageEntity.class, 14),
    Btn(BtnEntity.class, 15),
    Event(EventEntity.class, 16),
    Func(FuncEntity.class, 17);

    private Class entityClass;

    private Integer targetType;

    private ResourceType(Class entityClass, Integer targetType) {
        this.entityClass = entityClass;
        this.targetType = targetType;
    }

    public Class getEntityClass() {
        return entityClass;
    }

    public Integer getTargetType() {
        return targetType;
    }
}
