package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.df4j.xcms.core.constants.Constants.*;

@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "catalog")
public class CatalogEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 2273357939554177140L;

    /**
     * 系统代码
     */
    @Column(name = "sys_code", length = 100, nullable = false)
    private String sysCode;

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
    @Column(name = "parent_catalog_code", length = 100, nullable = false)
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

    @Override
    public String getSysCode() {
        return sysCode;
    }

    @Override
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

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
}
