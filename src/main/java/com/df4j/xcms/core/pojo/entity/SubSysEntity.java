package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_xcms_sub_sys")
public class SubSysEntity extends OrderedEntity<Long> {

    @Column(name = "sys_name", length = 100, nullable = false)
    private String sysName;

    @Column(name = "sys_desc", length = 1000, nullable = false)
    private String sysDesc;

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysDesc() {
        return sysDesc;
    }

    public void setSysDesc(String sysDesc) {
        this.sysDesc = sysDesc;
    }
}
