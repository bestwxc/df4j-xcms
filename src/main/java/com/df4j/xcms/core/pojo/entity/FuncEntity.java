package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.df4j.xcms.core.constants.Constants.DATABASE_CATALOG;
import static com.df4j.xcms.core.constants.Constants.DATABASE_TABLE_PREFIX;

/**
 * 功能号
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "func")
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
    @Column(name = "func_code", length = 100, nullable = false, unique = true)
    private String funcCode;

    /**
     * 功能号名称
     */
    @Column(name = "func_name", length = 100, nullable = false)
    private String funcName;

    /**
     * 功能号说明
     */
    @Column(name = "func_desc", length = 1000, nullable = true)
    private String funcDesc;

    /**
     * 类名
     */
    @Column(name = "class_name", length = 1000, nullable = false)
    private String className;

    /**
     * 方法名
     */
    @Column(name = "method_name", length = 100, nullable = false)
    private String methodName;

    /**
     * 功能号内容
     */
    @Column(name = "func_content", length = 2000, nullable = false)
    private String funcContent;

    /**
     * 资源类型
     */
    @Column(name = "resource_type", length = 100, nullable = false)
    private Integer resourceType;

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getFuncContent() {
        return funcContent;
    }

    public void setFuncContent(String funcContent) {
        this.funcContent = funcContent;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }
}
