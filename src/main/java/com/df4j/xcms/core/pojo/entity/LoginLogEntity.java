package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_xcms_login_log")
public class LoginLogEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 37184009423584057L;

    @Column(name = "user_name", length = 100, nullable = false)
    private String userName;

    @Column(name = "nick_name", length = 100, nullable = false)
    private String nickName;

    @Column(name = "net_address", length = 100, nullable = false)
    private String netAddress;

    @Column(name = "device_info", length = 1000, nullable = false)
    private String deviceInfo;

    @Column(name = "region_code", length = 100, nullable = true)
    private String regionCode;

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

    public String getNetAddress() {
        return netAddress;
    }

    public void setNetAddress(String netAddress) {
        this.netAddress = netAddress;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
