package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.df4j.xcms.core.constants.Constants.*;
/**
 * 用户和角色的关联关系
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "user_role")
public class UserRoleEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -127458126349141819L;

    /**
     * 系统代码
     */
    @Column(name = "sys_code", length = 100, nullable = false)
    private String sysCode;

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

    /**
     * 用户与角色绑定关系说明
     */
    @Column(name = "user_role_desc", length = 400, nullable = true)
    private String userRoleDesc;

    @Override
    public String getSysCode() {
        return sysCode;
    }

    @Override
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

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
