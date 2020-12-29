package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class OperLogEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 5054983658943450981L;

    @Column(name = "user_name", length = 100, nullable = false)
    private String userName;

    @Column(name = "nick_name", length = 100, nullable = false)
    private String nickName;

    @Column(name = "oper_type", length = 100, nullable = false)
    private String oper_type;

    @Column(name = "sub_oper_type", length = 100, nullable = true)
    private String regionCode;

    @Column(name = "oper_content", length = 2000, nullable = false)
    private String operContent;

    @Column(name = "remark", length = 2000, nullable = true)
    private String remark;

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

    public String getOper_type() {
        return oper_type;
    }

    public void setOper_type(String oper_type) {
        this.oper_type = oper_type;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
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
