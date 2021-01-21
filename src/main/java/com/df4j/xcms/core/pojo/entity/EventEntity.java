package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.df4j.xcms.core.constants.Constants.DATABASE_CATALOG;
import static com.df4j.xcms.core.constants.Constants.DATABASE_TABLE_PREFIX;

/**
 * 事件
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "event")
public class EventEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -2801942673018810233L;

    /**
     * 事件代码
     */
    @Column(name = "event_code", length = 100, nullable = false)
    private String eventCode;

    /**
     * 事件名称
     */
    @Column(name = "event_name", length = 100, nullable = false)
    private String eventName;

    /**
     * 事件类型
     */
    @Column(name = "event_type", nullable = false)
    private Integer eventType;

    /**
     * 事件内容
     */
    @Column(name = "event_content", length = 400, nullable = false)
    private String eventContent;

    /**
     * 事件说明
     */
    @Column(name = "event_desc", length = 2000, nullable = false)
    private String eventDesc;

    /**
     * 资源类型
     */
    @Column(name = "resource_type", length = 100, nullable = false)
    private Integer resourceType;

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public String getEventContent() {
        return eventContent;
    }

    public void setEventContent(String eventContent) {
        this.eventContent = eventContent;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }
}
