package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.*;
import java.util.Set;

import static com.df4j.xcms.core.constants.Constants.DATABASE_CATALOG;
import static com.df4j.xcms.core.constants.Constants.DATABASE_TABLE_PREFIX;
/**
 * 角色
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "role")
public class RoleEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 1622862623961122528L;

    /**
     * 角色代码
     */
    @Column(name= "role_code", length = 100, nullable = false, unique = true)
    private String roleCode;

    /**
     * 角色名称
     */
    @Column(name= "role_name", length = 100, nullable = false)
    private String roleName;

    /**
     * 角色说明
     */
    @Column(name= "role_desc", length = 1000, nullable = false)
    private String roleDesc;

    /**
     * 角色类型
     */
    @Column(name= "role_type", nullable = false)
    private Integer roleType;

    /**
     * 授予类型
     */
    @Column(name = "target_type", nullable = false)
    private Integer targetType;

    /**
     * 资源类型
     */
    @Column(name = "resource_type", nullable = false)
    private Integer resourceType;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "rights",
            joinColumns = {@JoinColumn(name = "target_type", referencedColumnName = "target_type"),
                    @JoinColumn(name = "target_code", referencedColumnName = "role_code")},
            inverseJoinColumns = {@JoinColumn(name = "resource_type", referencedColumnName = "resource_type"),
                    @JoinColumn(name = "resource_code", referencedColumnName = "menu_code")})
    private Set<MenuEntity> menus;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "rights",
            joinColumns = {@JoinColumn(name = "target_type", referencedColumnName = "target_type"),
                    @JoinColumn(name = "target_code", referencedColumnName = "role_code")},
            inverseJoinColumns = {@JoinColumn(name = "resource_type", referencedColumnName = "resource_type"),
                    @JoinColumn(name = "resource_code", referencedColumnName = "btn_code")})
    private Set<BtnEntity> btns;

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

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public Set<MenuEntity> getMenus() {
        return menus;
    }

    public void setMenus(Set<MenuEntity> menus) {
        this.menus = menus;
    }

    public Set<BtnEntity> getBtns() {
        return btns;
    }

    public void setBtns(Set<BtnEntity> btns) {
        this.btns = btns;
    }
}
