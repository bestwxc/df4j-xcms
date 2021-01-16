package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 菜单
 */
@Entity
@Table(name = "t_xcms_menu")
public class MenuEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -2474766501928107802L;

    /**
     * 菜单类型
     */
    @Column(name = "menu_type", nullable = false)
    private Integer menuType;

    /**
     * 上级菜单代码
     */
    @Column(name = "parent_menu_code", length = 100, nullable = false)
    private String parentMenuCode;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name", length = 100, nullable = false)
    private String menuName;

    /**
     * 菜单代码
     */
    @Column(name = "menu_code", length = 100, nullable = false)
    private String menuCode;

    /**
     * 菜单说明
     */
    @Column(name = "menu_desc", length = 200, nullable = true)
    private String menuDesc;

    /**
     * 菜单级别
     */
    @Column(name = "menu_level", nullable = false)
    private Integer menuLevel;

    /**
     * 菜单路径
     */
    @Column(name = "menu_path", length = 1000)
    private String menuPath;

    /**
     * 菜单图标
     */
    @Column(name = "menu_icon", length = 400)
    private String menuIcon;

    /**
     * 跳转类型
     */
    @Column(name = "jump_type", nullable = false)
    private Integer jumpType;

    /**
     * 跳转说明
     */
    @Column(name = "jump_spec", nullable = true)
    private String jumpSpec;

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public String getParentMenuCode() {
        return parentMenuCode;
    }

    public void setParentMenuCode(String parentMenuCode) {
        this.parentMenuCode = parentMenuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Integer getJumpType() {
        return jumpType;
    }

    public void setJumpType(Integer jumpType) {
        this.jumpType = jumpType;
    }

    public String getJumpSpec() {
        return jumpSpec;
    }

    public void setJumpSpec(String jumpSpec) {
        this.jumpSpec = jumpSpec;
    }
}
