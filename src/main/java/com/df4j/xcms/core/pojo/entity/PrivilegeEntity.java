package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_xcms_privilege")
public class PrivilegeEntity extends OrderedEntity<Long> {

    @Column(name = "grant_type", nullable = false)
    private Integer grantType;

    @Column(name = "grant_to", length = 100, nullable = false)
    private String grantTo;

    @Column(name = "resource_type", nullable = false)
    private String resourceCode;

    @Column(name = "resource_type", length = 100, nullable = false)
    private Integer resourceType;

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
