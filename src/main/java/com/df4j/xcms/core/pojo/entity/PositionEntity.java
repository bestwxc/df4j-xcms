package com.df4j.xcms.core.pojo.entity;


import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 岗位、职责
 */
@Entity
@Table(name = "t_xcms_position")
public class PositionEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 5146351860876230728L;

    /**
     * 岗位代码
     */
    @Column(name = "position_code", length = 100, nullable = false)
    private String positionCode;

    /**
     * 岗位名称
     */
    @Column(name = "position_name", length = 100, nullable = false)
    private String positionName;

    /**
     * 岗位说明
     */
    @Column(name = "position_desc", length = 400, nullable = true)
    private String positionDesc;

    /**
     * 岗位类型
     */
    @Column(name = "position_type", nullable = false)
    private Integer positionType;

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionDesc() {
        return positionDesc;
    }

    public void setPositionDesc(String positionDesc) {
        this.positionDesc = positionDesc;
    }

    public Integer getPositionType() {
        return positionType;
    }

    public void setPositionType(Integer positionType) {
        this.positionType = positionType;
    }
}
