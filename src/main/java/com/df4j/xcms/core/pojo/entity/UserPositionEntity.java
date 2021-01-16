package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户与岗位绑定关系
 */
@Entity
@Table(name = "t_xcms_user_position")
public class UserPositionEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -8740934489688289675L;

    /**
     * 用户名称
     */
    @Column(name = "user_name", length = 100, nullable = false)
    private String userName;

    /**
     * 岗位代码
     */
    @Column(name = "position_code", length = 100, nullable = false)
    private String positionCode;

    /**
     * 用户与绑定关系说明
     */
    @Column(name = "user_position_desc", length = 400, nullable = false)
    private String userPositionDesc;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getUserPositionDesc() {
        return userPositionDesc;
    }

    public void setUserPositionDesc(String userPositionDesc) {
        this.userPositionDesc = userPositionDesc;
    }
}
