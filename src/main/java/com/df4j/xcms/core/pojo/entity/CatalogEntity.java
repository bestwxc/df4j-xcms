package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.*;
import java.util.List;

import static com.df4j.xcms.core.constants.Constants.DATABASE_CATALOG;
import static com.df4j.xcms.core.constants.Constants.DATABASE_TABLE_PREFIX;

@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "catalog")
public class CatalogEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 2273357939554177140L;

    /**
     * 分类代码
     */
    @Column(name = "catalog_code", length = 100, nullable = false)
    private String catalogCode;

    /**
     * 分类名称
     */
    @Column(name = "catalog_name", length = 100, nullable = false)
    private String catalogMame;

    /**
     * 分类类型
     */
    @Column(name = "catalog_type", nullable = false)
    private Integer catalogType;

    /**
     * 上级分类代码
     */
    @Column(name = "parent_catalog_code", length = 100, nullable = false, insertable = false, updatable = false)
    private String parentCatalogCode;

    /**
     * 分类路径
     */
    @Column(name = "catalog_path", length = 1000, nullable = false)
    private String catalogPath;

    /**
     * 分类说明
     */
    @Column(name = "catalog_desc", length = 1000, nullable = false)
    private String catalogDesc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_catalog_code", referencedColumnName = "catalog_code")
    private CatalogEntity parent;

    /**
     * 子分类
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<CatalogEntity> children;

    public String getCatalogCode() {
        return catalogCode;
    }

    public void setCatalogCode(String catalogCode) {
        this.catalogCode = catalogCode;
    }

    public String getCatalogMame() {
        return catalogMame;
    }

    public void setCatalogMame(String catalogMame) {
        this.catalogMame = catalogMame;
    }

    public Integer getCatalogType() {
        return catalogType;
    }

    public void setCatalogType(Integer catalogType) {
        this.catalogType = catalogType;
    }

    public String getParentCatalogCode() {
        return parentCatalogCode;
    }

    public void setParentCatalogCode(String parentCatalogCode) {
        this.parentCatalogCode = parentCatalogCode;
    }

    public String getCatalogPath() {
        return catalogPath;
    }

    public void setCatalogPath(String catalogPath) {
        this.catalogPath = catalogPath;
    }

    public String getCatalogDesc() {
        return catalogDesc;
    }

    public void setCatalogDesc(String catalogDesc) {
        this.catalogDesc = catalogDesc;
    }

    public CatalogEntity getParent() {
        return parent;
    }

    public void setParent(CatalogEntity parent) {
        this.parent = parent;
    }

    public List<CatalogEntity> getChildren() {
        return children;
    }

    public void setChildren(List<CatalogEntity> children) {
        this.children = children;
    }
}
