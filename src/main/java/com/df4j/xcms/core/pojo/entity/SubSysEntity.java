package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.df4j.xcms.core.constants.Constants.DATABASE_CATALOG;
import static com.df4j.xcms.core.constants.Constants.DATABASE_TABLE_PREFIX;
/**
 * 子系统
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "sub_sys")
public class SubSysEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 1266579908825855948L;

    /**
     * 子系统名称
     */
    @Column(name = "sys_name", length = 100, nullable = false)
    private String sysName;

    /**
     * 子系统说明
     */
    @Column(name = "sys_desc", length = 1000, nullable = false)
    private String sysDesc;

    /**
     * 资源类型
     */
    @Column(name = "resource_type", length = 100, nullable = false)
    private Integer resourceType;


    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysDesc() {
        return sysDesc;
    }

    public void setSysDesc(String sysDesc) {
        this.sysDesc = sysDesc;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }
}
