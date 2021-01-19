package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.df4j.xcms.core.constants.Constants.*;
/**
 * 部门表
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "dept")
public class DeptEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -9049786094011574588L;

    /**
     * 系统代码
     */
    @Column(name = "sys_code", length = 100, nullable = false)
    private String sysCode;

    /**
     * 部门代码
     */
    @Column(name = "dept_code", length = 100, nullable = false)
    private String deptCode;

    /**
     * 部门名称
     */
    @Column(name = "dept_name", length = 100, nullable = false)
    private String deptName;

    /**
     * 部门全称
     */
    @Column(name = "dept_full_name", length = 1000, nullable = false)
    private String deptFullName;

    /**
     * 是否为根部门
     */
    @Column(name = "route_dept", nullable = false)
    private Integer routeNode;

    /**
     * 部门路径
     */
    @Column(name = "dept_path", length = 2000, nullable = false)
    private String deptPath;

    /**
     * 部门说明
     */
    @Column(name = "dept_desc", length = 400, nullable = true)
    private String deptDesc;

    @Override
    public String getSysCode() {
        return sysCode;
    }

    @Override
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptFullName() {
        return deptFullName;
    }

    public void setDeptFullName(String deptFullName) {
        this.deptFullName = deptFullName;
    }

    public Integer getRouteNode() {
        return routeNode;
    }

    public void setRouteNode(Integer routeNode) {
        this.routeNode = routeNode;
    }

    public String getDeptPath() {
        return deptPath;
    }

    public void setDeptPath(String deptPath) {
        this.deptPath = deptPath;
    }

    public String getDeptDesc() {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc;
    }
}
