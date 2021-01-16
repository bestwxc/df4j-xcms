package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 部门和岗位的对应关系
 */
@Entity
@Table(name = "t_xcms_dept_position")
public class DeptPositionEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 1219311541479612880L;

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
}
