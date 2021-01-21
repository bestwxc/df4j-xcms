package com.df4j.xcms.core.constants;

import com.df4j.xcms.core.pojo.entity.*;

/**
 * 资源类型
 */
public enum ResourceType {

    SubSys(SubSysEntity.class, 1),
    Menu(MenuEntity.class, 2),
    Component(ComponentEntity.class, 3),
    Page(PageEntity.class, 4),
    Btn(BtnEntity.class, 5),
    Event(EventEntity.class, 6),
    Func(FuncEntity.class, 7);

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
