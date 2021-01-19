package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.df4j.xcms.core.constants.Constants.*;

/**
 * 管理bundle，包含一组页面，同时包含页面的按钮等
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "bundle")
public class bundleEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -5837187438364444611L;

    /**
     * bundle代码
     */
    @Column(name = "bundle_code", length = 100, nullable = false)
    private String bundleCode;

    /**
     * bundle名称
     */
    @Column(name = "bundle_name", length = 100, nullable = false)
    private String bundleName;

    /**
     * bundle说明
     */
    @Column(name = "bundle_desc", length = 400, nullable = true)
    private String bundleDesc;

    public String getBundleCode() {
        return bundleCode;
    }

    public void setBundleCode(String bundleCode) {
        this.bundleCode = bundleCode;
    }

    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }

    public String getBundleDesc() {
        return bundleDesc;
    }

    public void setBundleDesc(String bundleDesc) {
        this.bundleDesc = bundleDesc;
    }
}
