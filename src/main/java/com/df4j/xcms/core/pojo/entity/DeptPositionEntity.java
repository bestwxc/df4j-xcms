package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.df4j.xcms.core.constants.Constants.*;
/**
 * 部门和岗位的对应关系
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "dept_position")
public class DeptPositionEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 1219311541479612880L;

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
     * 岗位代码
     */
    @Column(name = "position_code", length = 100, nullable = false)
    private String positionCode;

    /**
     * 部门岗位关联关系说明
     */
    @Column(name = "dept_position_desc", length = 400, nullable = true)
    private String deptPositionDesc;

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

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getDeptPositionDesc() {
        return deptPositionDesc;
    }

    public void setDeptPositionDesc(String deptPositionDesc) {
        this.deptPositionDesc = deptPositionDesc;
    }
}
