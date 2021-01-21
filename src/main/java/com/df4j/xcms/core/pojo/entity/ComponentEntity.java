package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.*;
import java.util.Set;

import static com.df4j.xcms.core.constants.Constants.DATABASE_CATALOG;
import static com.df4j.xcms.core.constants.Constants.DATABASE_TABLE_PREFIX;

/**
 * 管理component，包含一组页面，同时包含页面的按钮等
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "component")
public class ComponentEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -5837187438364444611L;

    /**
     * component代码
     */
    @Column(name = "component_code", length = 100, nullable = false, unique = true)
    private String componentCode;

    /**
     * component名称
     */
    @Column(name = "component_name", length = 100, nullable = false)
    private String componentName;

    /**
     * component说明
     */
    @Column(name = "component_desc", length = 400, nullable = true)
    private String componentDesc;

    /**
     * 资源类型
     */
    @Column(name = "resource_type", length = 100, nullable = false)
    private Integer resourceType;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "component_code", referencedColumnName = "component_code")
    private Set<PageEntity> pages;

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentDesc() {
        return componentDesc;
    }

    public void setComponentDesc(String componentDesc) {
        this.componentDesc = componentDesc;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public Set<PageEntity> getPages() {
        return pages;
    }

    public void setPages(Set<PageEntity> pages) {
        this.pages = pages;
    }
}
