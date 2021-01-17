package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.df4j.xcms.core.constants.Constants.*;
/**
 * 功能号
 */
@Entity
@Table(catalog = DATABASE_CATALOG, schema = DATABASE_SCHEMA, name = DATABASE_TABLE_PREFIX + "func")
public class FuncEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -4316399576059140494L;

    /**
     * 功能号所属应用
     */
    @Column(name = "application_name", length = 100, nullable = false)
    private String applicationName;

    /**
     * 功能号代码
     */
    @Column(name = "func_code", length = 100, nullable = false)
    private String funcCode;

    /**
     * 功能号名称
     */
    @Column(name = "func_name", length = 100, nullable = false)
    private String funcName;

    /**
     * 功能号说明
     */
    @Column(name = "func_desc", length = 1000, nullable = false)
    private String funcDesc;

    /**
     * 功能号内容
     */
    @Column(name = "func_content", length = 2000, nullable = false)
    private String funcContent;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getFuncDesc() {
        return funcDesc;
    }

    public void setFuncDesc(String funcDesc) {
        this.funcDesc = funcDesc;
    }

    public String getFuncContent() {
        return funcContent;
    }

    public void setFuncContent(String funcContent) {
        this.funcContent = funcContent;
    }
}
