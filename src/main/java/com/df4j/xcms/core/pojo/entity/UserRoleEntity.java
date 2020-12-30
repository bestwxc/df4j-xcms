package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_xcms_user_role")
public class UserRoleEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -127458126349141819L;

    @Column(name= "user_name", length = 100, nullable = false)
    private String userName;

    @Column(name= "role_code", length = 100, nullable = false)
    private String roleCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
