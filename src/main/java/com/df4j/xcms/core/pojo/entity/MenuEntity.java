package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.*;
import java.util.List;

import static com.df4j.xcms.core.constants.Constants.DATABASE_CATALOG;
import static com.df4j.xcms.core.constants.Constants.DATABASE_TABLE_PREFIX;

/**
 * 菜单
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "menu")
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
    @Column(name = "parent_menu_code", length = 100, nullable = false, insertable = false, updatable = false)
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
     * 资源类型
     */
    @Column(name = "resource_type", length = 100, nullable = false)
    private Integer resourceType;

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
     * 关联的组件
     */
    @Column(name = "component_code", nullable = true)
    private String componentCode;

    @OneToOne
    @JoinColumn(name = "component_code", referencedColumnName = "component_code", insertable = false, updatable = false)
    private ComponentEntity component;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_menu_code", referencedColumnName = "menu_code")
    private MenuEntity parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<MenuEntity> children;

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

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
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

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public ComponentEntity getComponent() {
        return component;
    }

    public void setComponent(ComponentEntity component) {
        this.component = component;
    }

    public MenuEntity getParent() {
        return parent;
    }

    public void setParent(MenuEntity parent) {
        this.parent = parent;
    }

    public List<MenuEntity> getChildren() {
        return children;
    }

    public void setChildren(List<MenuEntity> children) {
        this.children = children;
    }
}
