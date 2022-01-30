package com.df4j.xcms.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_xcms_core_dep")
public class CoreDep {
    /**
     * 主键id
     */
    @Id
    private Long id;

    /**
     * 部门代码
     */
    @Column(name = "dep_code")
    private String depCode;

    /**
     * 部门名称
     */
    @Column(name = "dep_name")
    private String depName;

    /**
     * 部门描述
     */
    @Column(name = "dep_desc")
    private String depDesc;

    /**
     * 上级部门ID
     */
    @Column(name = "parent_dep_id")
    private Long parentDepId;

    /**
     * 上级部门代码
     */
    @Column(name = "parent_dep_code")
    private String parentDepCode;

    /**
     * 一级部门ID
     */
    @Column(name = "head_dep_id")
    private Long headDepId;

    /**
     * 一级部门代码
     */
    @Column(name = "head_dep_code")
    private String headDepCode;

    /**
     * 部门级别
     */
    @Column(name = "dep_level")
    private Integer depLevel;

    /**
     * 部门ID路径
     */
    @Column(name = "dep_id_path")
    private String depIdPath;

    /**
     * 部门代码路径
     */
    @Column(name = "dep_code_path")
    private String depCodePath;

    /**
     * 部门名称路径
     */
    @Column(name = "dep_name_path")
    private String depNamePath;

    /**
     * 排序值
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 部门状态
     */
    @Column(name = "dep_state")
    private Integer depState;

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
     * 获取部门名称
     *
     * @return dep_name - 部门名称
     */
    public String getDepName() {
        return depName;
    }

    /**
     * 设置部门名称
     *
     * @param depName 部门名称
     */
    public void setDepName(String depName) {
        this.depName = depName;
    }

    /**
     * 获取部门描述
     *
     * @return dep_desc - 部门描述
     */
    public String getDepDesc() {
        return depDesc;
    }

    /**
     * 设置部门描述
     *
     * @param depDesc 部门描述
     */
    public void setDepDesc(String depDesc) {
        this.depDesc = depDesc;
    }

    /**
     * 获取上级部门ID
     *
     * @return parent_dep_id - 上级部门ID
     */
    public Long getParentDepId() {
        return parentDepId;
    }

    /**
     * 设置上级部门ID
     *
     * @param parentDepId 上级部门ID
     */
    public void setParentDepId(Long parentDepId) {
        this.parentDepId = parentDepId;
    }

    /**
     * 获取上级部门代码
     *
     * @return parent_dep_code - 上级部门代码
     */
    public String getParentDepCode() {
        return parentDepCode;
    }

    /**
     * 设置上级部门代码
     *
     * @param parentDepCode 上级部门代码
     */
    public void setParentDepCode(String parentDepCode) {
        this.parentDepCode = parentDepCode;
    }

    /**
     * 获取一级部门ID
     *
     * @return head_dep_id - 一级部门ID
     */
    public Long getHeadDepId() {
        return headDepId;
    }

    /**
     * 设置一级部门ID
     *
     * @param headDepId 一级部门ID
     */
    public void setHeadDepId(Long headDepId) {
        this.headDepId = headDepId;
    }

    /**
     * 获取一级部门代码
     *
     * @return head_dep_code - 一级部门代码
     */
    public String getHeadDepCode() {
        return headDepCode;
    }

    /**
     * 设置一级部门代码
     *
     * @param headDepCode 一级部门代码
     */
    public void setHeadDepCode(String headDepCode) {
        this.headDepCode = headDepCode;
    }

    /**
     * 获取部门级别
     *
     * @return dep_level - 部门级别
     */
    public Integer getDepLevel() {
        return depLevel;
    }

    /**
     * 设置部门级别
     *
     * @param depLevel 部门级别
     */
    public void setDepLevel(Integer depLevel) {
        this.depLevel = depLevel;
    }

    /**
     * 获取部门ID路径
     *
     * @return dep_id_path - 部门ID路径
     */
    public String getDepIdPath() {
        return depIdPath;
    }

    /**
     * 设置部门ID路径
     *
     * @param depIdPath 部门ID路径
     */
    public void setDepIdPath(String depIdPath) {
        this.depIdPath = depIdPath;
    }

    /**
     * 获取部门代码路径
     *
     * @return dep_code_path - 部门代码路径
     */
    public String getDepCodePath() {
        return depCodePath;
    }

    /**
     * 设置部门代码路径
     *
     * @param depCodePath 部门代码路径
     */
    public void setDepCodePath(String depCodePath) {
        this.depCodePath = depCodePath;
    }

    /**
     * 获取部门名称路径
     *
     * @return dep_name_path - 部门名称路径
     */
    public String getDepNamePath() {
        return depNamePath;
    }

    /**
     * 设置部门名称路径
     *
     * @param depNamePath 部门名称路径
     */
    public void setDepNamePath(String depNamePath) {
        this.depNamePath = depNamePath;
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
     * 获取部门状态
     *
     * @return dep_state - 部门状态
     */
    public Integer getDepState() {
        return depState;
    }

    /**
     * 设置部门状态
     *
     * @param depState 部门状态
     */
    public void setDepState(Integer depState) {
        this.depState = depState;
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