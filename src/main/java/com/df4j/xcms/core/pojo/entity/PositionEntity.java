package com.df4j.xcms.core.pojo.entity;


import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.*;
import java.util.Set;

import static com.df4j.xcms.core.constants.Constants.DATABASE_CATALOG;
import static com.df4j.xcms.core.constants.Constants.DATABASE_TABLE_PREFIX;
/**
 * 岗位、职责
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "position")
public class PositionEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 5146351860876230728L;

    /**
     * 岗位代码
     */
    @Column(name = "position_code", length = 100, nullable = false, unique = true)
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

    /**
     * 部门代码
     */
    @Column(name = "dept_code", length = 100, nullable = true)
    private String deptCode;


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
                    @JoinColumn(name = "target_code", referencedColumnName = "position_code")},
            inverseJoinColumns = {@JoinColumn(name = "resource_type", referencedColumnName = "resource_type"),
                    @JoinColumn(name = "resource_code", referencedColumnName = "menu_code")})
    private Set<MenuEntity> menus;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "rights",
            joinColumns = {@JoinColumn(name = "target_type", referencedColumnName = "target_type"),
                    @JoinColumn(name = "target_code", referencedColumnName = "position_code")},
            inverseJoinColumns = {@JoinColumn(name = "resource_type", referencedColumnName = "resource_type"),
                    @JoinColumn(name = "resource_code", referencedColumnName = "btn_code")})
    private Set<BtnEntity> btns;



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

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
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
