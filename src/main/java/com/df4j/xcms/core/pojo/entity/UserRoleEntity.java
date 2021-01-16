package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户和角色的关联关系
 */
@Entity
@Table(name = "t_xcms_user_role")
public class UserRoleEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -127458126349141819L;

    /**
     * 用户名称
     */
    @Column(name= "user_name", length = 100, nullable = false)
    private String userName;

    /**
     * 角色代码
     */
    @Column(name= "role_code", length = 100, nullable = false)
    private String roleCode;

    @Column(name = "user_role_desc", length = 400, nullable = true)
    private String userRoleDesc;

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

    public String getUserRoleDesc() {
        return userRoleDesc;
    }

    public void setUserRoleDesc(String userRoleDesc) {
        this.userRoleDesc = userRoleDesc;
    }
}
