package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;
import com.df4j.xcms.core.constants.Constants;

import javax.persistence.*;
import java.util.List;

import static com.df4j.xcms.core.constants.Constants.DATABASE_CATALOG;
import static com.df4j.xcms.core.constants.Constants.DATABASE_TABLE_PREFIX;

/**
 * 部门表
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "dept")
public class DeptEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -9049786094011574588L;

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
     * 父级部门代码
     */
    @Column(name = "parent_dept_code", length = 100, nullable = false, insertable = false, updatable = false)
    private String parentDeptCode;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_dept_code", referencedColumnName = "dept_code")
    private DeptEntity parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<DeptEntity> children;

    /**
     * 部门拥有的岗位
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(schema = Constants.DATABASE_CATALOG,
            name = DATABASE_TABLE_PREFIX + "dept_position",
            joinColumns = @JoinColumn(name = "dept_code", referencedColumnName = "dept_code"),
            inverseJoinColumns = @JoinColumn(name = "position_code", referencedColumnName = "position_code"))
    private List<PositionEntity> positions;

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

    public String getParentDeptCode() {
        return parentDeptCode;
    }

    public void setParentDeptCode(String parentDeptCode) {
        this.parentDeptCode = parentDeptCode;
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

    public DeptEntity getParent() {
        return parent;
    }

    public void setParent(DeptEntity parent) {
        this.parent = parent;
    }

    public List<DeptEntity> getChildren() {
        return children;
    }

    public void setChildren(List<DeptEntity> children) {
        this.children = children;
    }

    public List<PositionEntity> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionEntity> positions) {
        this.positions = positions;
    }
}
