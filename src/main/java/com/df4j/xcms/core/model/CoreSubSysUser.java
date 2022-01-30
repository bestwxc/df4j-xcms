package com.df4j.xcms.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_xcms_core_sub_sys_user")
public class CoreSubSysUser {
    /**
     * 主键id
     */
    @Id
    private Long id;

    /**
     * 子系统id
     */
    @Column(name = "sub_sys_id")
    private Long subSysId;

    /**
     * 子系统代码
     */
    @Column(name = "sub_sys_code")
    private String subSysCode;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 部门ID
     */
    @Column(name = "dep_id")
    private Long depId;

    /**
     * 部门代码
     */
    @Column(name = "dep_code")
    private String depCode;

    /**
     * 子系统用户状态
     */
    @Column(name = "sub_sys_user_state")
    private Integer subSysUserState;

    /**
     * 子系统用户过期时间
     */
    @Column(name = "sub_sys_user_expire_time")
    private Date subSysUserExpireTime;

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
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取子系统id
     *
     * @return sub_sys_id - 子系统id
     */
    public Long getSubSysId() {
        return subSysId;
    }

    /**
     * 设置子系统id
     *
     * @param subSysId 子系统id
     */
    public void setSubSysId(Long subSysId) {
        this.subSysId = subSysId;
    }

    /**
     * 获取子系统代码
     *
     * @return sub_sys_code - 子系统代码
     */
    public String getSubSysCode() {
        return subSysCode;
    }

    /**
     * 设置子系统代码
     *
     * @param subSysCode 子系统代码
     */
    public void setSubSysCode(String subSysCode) {
        this.subSysCode = subSysCode;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取部门ID
     *
     * @return dep_id - 部门ID
     */
    public Long getDepId() {
        return depId;
    }

    /**
     * 设置部门ID
     *
     * @param depId 部门ID
     */
    public void setDepId(Long depId) {
        this.depId = depId;
    }

    /**
     * 获取部门代码
     *
     * @return dep_code - 部门代码
     */
    public String getDepCode() {
        return depCode;
    }

    /**
     * 设置部门代码
     *
     * @param depCode 部门代码
     */
    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    /**
     * 获取子系统用户状态
     *
     * @return sub_sys_user_state - 子系统用户状态
     */
    public Integer getSubSysUserState() {
        return subSysUserState;
    }

    /**
     * 设置子系统用户状态
     *
     * @param subSysUserState 子系统用户状态
     */
    public void setSubSysUserState(Integer subSysUserState) {
        this.subSysUserState = subSysUserState;
    }

    /**
     * 获取子系统用户过期时间
     *
     * @return sub_sys_user_expire_time - 子系统用户过期时间
     */
    public Date getSubSysUserExpireTime() {
        return subSysUserExpireTime;
    }

    /**
     * 设置子系统用户过期时间
     *
     * @param subSysUserExpireTime 子系统用户过期时间
     */
    public void setSubSysUserExpireTime(Date subSysUserExpireTime) {
        this.subSysUserExpireTime = subSysUserExpireTime;
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