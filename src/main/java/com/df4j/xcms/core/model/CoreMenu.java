package com.df4j.xcms.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_xcms_core_menu")
public class CoreMenu {
    /**
     * 主键ID
     */
    @Id
    private Long id;

    /**
     * 来源xcms
     */
    private String source;

    /**
     * 子系统ID
     */
    @Column(name = "sys_id")
    private Long sysId;

    /**
     * 系统代码
     */
    @Column(name = "sys_code")
    private String sysCode;

    /**
     * 菜单代码
     */
    @Column(name = "menu_code")
    private String menuCode;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 菜单说明
     */
    @Column(name = "menu_desc")
    private String menuDesc;

    /**
     * 上级菜单ID
     */
    @Column(name = "parent_menu_id")
    private Long parentMenuId;

    /**
     * 上级菜单代码
     */
    @Column(name = "parent_ment_code")
    private String parentMentCode;

    /**
     * 菜单路径
     */
    @Column(name = "menu_path")
    private String menuPath;

    /**
     * 菜单图标
     */
    @Column(name = "menu_icon")
    private String menuIcon;

    /**
     * 全局菜单
     */
    @Column(name = "global_menu")
    private Integer globalMenu;

    /**
     * 菜单类型
     */
    @Column(name = "menu_type")
    private Integer menuType;

    /**
     * 跳转类型
     */
    @Column(name = "jump_type")
    private Integer jumpType;

    /**
     * 排序值
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 菜单状态
     */
    @Column(name = "menu_state")
    private Integer menuState;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取来源xcms
     *
     * @return source - 来源xcms
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置来源xcms
     *
     * @param source 来源xcms
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 获取子系统ID
     *
     * @return sys_id - 子系统ID
     */
    public Long getSysId() {
        return sysId;
    }

    /**
     * 设置子系统ID
     *
     * @param sysId 子系统ID
     */
    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }

    /**
     * 获取系统代码
     *
     * @return sys_code - 系统代码
     */
    public String getSysCode() {
        return sysCode;
    }

    /**
     * 设置系统代码
     *
     * @param sysCode 系统代码
     */
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    /**
     * 获取菜单代码
     *
     * @return menu_code - 菜单代码
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * 设置菜单代码
     *
     * @param menuCode 菜单代码
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    /**
     * 获取菜单名称
     *
     * @return menu_name - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获取菜单说明
     *
     * @return menu_desc - 菜单说明
     */
    public String getMenuDesc() {
        return menuDesc;
    }

    /**
     * 设置菜单说明
     *
     * @param menuDesc 菜单说明
     */
    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    /**
     * 获取上级菜单ID
     *
     * @return parent_menu_id - 上级菜单ID
     */
    public Long getParentMenuId() {
        return parentMenuId;
    }

    /**
     * 设置上级菜单ID
     *
     * @param parentMenuId 上级菜单ID
     */
    public void setParentMenuId(Long parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    /**
     * 获取上级菜单代码
     *
     * @return parent_ment_code - 上级菜单代码
     */
    public String getParentMentCode() {
        return parentMentCode;
    }

    /**
     * 设置上级菜单代码
     *
     * @param parentMentCode 上级菜单代码
     */
    public void setParentMentCode(String parentMentCode) {
        this.parentMentCode = parentMentCode;
    }

    /**
     * 获取菜单路径
     *
     * @return menu_path - 菜单路径
     */
    public String getMenuPath() {
        return menuPath;
    }

    /**
     * 设置菜单路径
     *
     * @param menuPath 菜单路径
     */
    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    /**
     * 获取菜单图标
     *
     * @return menu_icon - 菜单图标
     */
    public String getMenuIcon() {
        return menuIcon;
    }

    /**
     * 设置菜单图标
     *
     * @param menuIcon 菜单图标
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    /**
     * 获取全局菜单
     *
     * @return global_menu - 全局菜单
     */
    public Integer getGlobalMenu() {
        return globalMenu;
    }

    /**
     * 设置全局菜单
     *
     * @param globalMenu 全局菜单
     */
    public void setGlobalMenu(Integer globalMenu) {
        this.globalMenu = globalMenu;
    }

    /**
     * 获取菜单类型
     *
     * @return menu_type - 菜单类型
     */
    public Integer getMenuType() {
        return menuType;
    }

    /**
     * 设置菜单类型
     *
     * @param menuType 菜单类型
     */
    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    /**
     * 获取跳转类型
     *
     * @return jump_type - 跳转类型
     */
    public Integer getJumpType() {
        return jumpType;
    }

    /**
     * 设置跳转类型
     *
     * @param jumpType 跳转类型
     */
    public void setJumpType(Integer jumpType) {
        this.jumpType = jumpType;
    }

    /**
     * 获取排序值
     *
     * @return order_num - 排序值
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置排序值
     *
     * @param orderNum 排序值
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取菜单状态
     *
     * @return menu_state - 菜单状态
     */
    public Integer getMenuState() {
        return menuState;
    }

    /**
     * 设置菜单状态
     *
     * @param menuState 菜单状态
     */
    public void setMenuState(Integer menuState) {
        this.menuState = menuState;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}