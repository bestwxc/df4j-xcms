package com.df4j.xcms.core.constants;

import com.df4j.xcms.core.pojo.entity.FuncEntity;

/**
 * 事件类型
 */
public enum EventType {
    Func(FuncEntity.class, 1);

    private Class entityClass;

    private Integer eventType;

    private EventType(Class entityClass, Integer eventType) {
        this.entityClass = entityClass;
        this.eventType = eventType;
    }

    public Class getEntityClass() {
        return entityClass;
    }

    public Integer getEventType() {
        return eventType;
    }
}
