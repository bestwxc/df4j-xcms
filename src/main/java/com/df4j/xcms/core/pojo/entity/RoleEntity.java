package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "t_xcms_role")
public class RoleEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 1622862623961122528L;

    @Column(name= "role_code", length = 100, nullable = false)
    private String roleCode;

    @Column(name= "role_name", length = 100, nullable = false)
    private String roleName;

    @Column(name= "role_desc", length = 1000, nullable = false)
    private String roleDesc;

    @Column(name= "role_type", nullable = false)
    private Integer roleType;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }
}
