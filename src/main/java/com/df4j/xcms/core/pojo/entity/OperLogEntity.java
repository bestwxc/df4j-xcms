package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.df4j.xcms.core.constants.Constants.*;
/**
 * 操作日志
 */
@Entity
@Table(catalog = DATABASE_CATALOG, schema = DATABASE_SCHEMA, name = DATABASE_TABLE_PREFIX + "oper_log")
public class OperLogEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 5054983658943450981L;

    /**
     * 系统代码
     */
    @Column(name = "sys_code", length = 100, nullable = false)
    private String sysCode;

    /**
     * 登陆用户名
     */
    @Column(name = "user_name", length = 100, nullable = false)
    private String userName;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name", length = 100, nullable = false)
    private String nickName;

    /**
     * 操作类型
     */
    @Column(name = "oper_type", length = 100, nullable = false)
    private String operType;

    /**
     * 子操作类型
     */
    @Column(name = "sub_oper_type", length = 100, nullable = true)
    private String subOperType;

    /**
     * 操作内容
     */
    @Column(name = "oper_content", length = 2000, nullable = false)
    private String operContent;

    /**
     * 操作备注
     */
    @Column(name = "remark", length = 2000, nullable = true)
    private String remark;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getSubOperType() {
        return subOperType;
    }

    public void setSubOperType(String subOperType) {
        this.subOperType = subOperType;
    }

    public String getOperContent() {
        return operContent;
    }

    public void setOperContent(String operContent) {
        this.operContent = operContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
