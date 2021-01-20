package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.df4j.xcms.core.constants.Constants.*;
/**
 * 登陆日志
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "login_log")
public class LoginLogEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 37184009423584057L;

    /**
     * 用户名称
     */
    @Column(name = "user_name", length = 100, nullable = false)
    private String userName;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name", length = 100, nullable = false)
    private String nickName;

    /**
     * 网络地址
     */
    @Column(name = "net_address", length = 100, nullable = false)
    private String netAddress;

    /**
     * 设备信息
     */
    @Column(name = "device_info", length = 1000, nullable = false)
    private String deviceInfo;

    /**
     * 区域代码
     */
    @Column(name = "region_code", length = 100, nullable = true)
    private String regionCode;

    /**
     * 备注
     */
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
