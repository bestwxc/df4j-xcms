package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.df4j.xcms.core.constants.Constants.*;
/**
 * 权限
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "right")
public class RightsEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -7119451976703077442L;

    /**
     * 授予类型
     */
    @Column(name = "target_type", nullable = false)
    private Integer targetType;

    /**
     * 授予对象
     */
    @Column(name = "target_code", length = 100, nullable = false)
    private String targetCode;

    /**
     * component代码
     */
    @Column(name = "resource_code", nullable = false)
    private String resourceCode;

    /**
     * 资源类型
     */
    @Column(name = "resource_type", length = 100, nullable = false)
    private Integer resourceType;

    /**
     * 授权说明
     */
    @Column(name = "grant_desc", length = 1000, nullable = true)
    private String grantDesc;

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }
}
