package com.df4j.xcms.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_xcms_core_sub_sys")
public class CoreSubSys {
    /**
     * 主键ID
     */
    @Id
    private Long id;

    /**
     * 系统代码
     */
    @Column(name = "sys_code")
    private String sysCode;

    /**
     * 系统名称
     */
    @Column(name = "sys_name")
    private String sysName;

    /**
     * 系统描述
     */
    @Column(name = "sys_desc")
    private String sysDesc;

    /**
     * 子系统Logo
     */
    private String logo;

    /**
     * 子系统小版图标
     */
    private String favicon;

    /**
     * 子系统首页模板
     */
    @Column(name = "index_tpl")
    private String indexTpl;

    /**
     * 网站版权所属信息
     */
    private String copyright;

    /**
     * 子系统登录后默认首页
     */
    @Column(name = "welcome_page")
    private String welcomePage;

    /**
     * 排序值
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 子系统状态
     */
    @Column(name = "sub_sys_state")
    private Integer subSysState;

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
     * 获取系统名称
     *
     * @return sys_name - 系统名称
     */
    public String getSysName() {
        return sysName;
    }

    /**
     * 设置系统名称
     *
     * @param sysName 系统名称
     */
    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    /**
     * 获取系统描述
     *
     * @return sys_desc - 系统描述
     */
    public String getSysDesc() {
        return sysDesc;
    }

    /**
     * 设置系统描述
     *
     * @param sysDesc 系统描述
     */
    public void setSysDesc(String sysDesc) {
        this.sysDesc = sysDesc;
    }

    /**
     * 获取子系统Logo
     *
     * @return logo - 子系统Logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 设置子系统Logo
     *
     * @param logo 子系统Logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 获取子系统小版图标
     *
     * @return favicon - 子系统小版图标
     */
    public String getFavicon() {
        return favicon;
    }

    /**
     * 设置子系统小版图标
     *
     * @param favicon 子系统小版图标
     */
    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }

    /**
     * 获取子系统首页模板
     *
     * @return index_tpl - 子系统首页模板
     */
    public String getIndexTpl() {
        return indexTpl;
    }

    /**
     * 设置子系统首页模板
     *
     * @param indexTpl 子系统首页模板
     */
    public void setIndexTpl(String indexTpl) {
        this.indexTpl = indexTpl;
    }

    /**
     * 获取网站版权所属信息
     *
     * @return copyright - 网站版权所属信息
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * 设置网站版权所属信息
     *
     * @param copyright 网站版权所属信息
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * 获取子系统登录后默认首页
     *
     * @return welcome_page - 子系统登录后默认首页
     */
    public String getWelcomePage() {
        return welcomePage;
    }

    /**
     * 设置子系统登录后默认首页
     *
     * @param welcomePage 子系统登录后默认首页
     */
    public void setWelcomePage(String welcomePage) {
        this.welcomePage = welcomePage;
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
     * 获取子系统状态
     *
     * @return sub_sys_state - 子系统状态
     */
    public Integer getSubSysState() {
        return subSysState;
    }

    /**
     * 设置子系统状态
     *
     * @param subSysState 子系统状态
     */
    public void setSubSysState(Integer subSysState) {
        this.subSysState = subSysState;
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