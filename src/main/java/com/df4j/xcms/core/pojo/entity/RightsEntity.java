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
     * 系统代码
     */
    @Column(name = "sys_code", length = 100, nullable = false)
    private String sysCode;

    /**
     * 授予类型
     */
    @Column(name = "grant_type", nullable = false)
    private Integer grantType;

    /**
     * 授予对象
     */
    @Column(name = "grant_to", length = 100, nullable = false)
    private String grantTo;

    /**
     * 资源类型
     */
    @Column(name = "resource_code", nullable = false)
    private String resourceCode;

    /**
     * 授予对象
     */
    @Column(name = "resource_type", length = 100, nullable = false)
    private Integer resourceType;

    @Override
    public String getSysCode() {
        return sysCode;
    }

    @Override
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public Integer getGrantType() {
        return grantType;
    }

    public void setGrantType(Integer grantType) {
        this.grantType = grantType;
    }

    public String getGrantTo() {
        return grantTo;
    }

    public void setGrantTo(String grantTo) {
        this.grantTo = grantTo;
    }

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
