package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 事件
 */
@Entity
@Table(name = "t_xcms_event")
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
}
