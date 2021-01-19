package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

import static com.df4j.xcms.core.constants.Constants.*;
/**
 * 第三方用户绑定表
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "third_user")
public class ThirdUserEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -7309990801223749343L;

    /**
     * 系统代码
     */
    @Column(name = "sys_code", length = 100, nullable = false)
    private String sysCode;

    /**
     * 用户名
     */
    @Column(name = "user_name", length = 100, nullable = false)
    private String userName;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name", length = 100, nullable = false)
    private String nickName;

    /**
     * 第三方用户名
     */
    @Column(name = "third_user_name", length = 100, nullable = false)
    private String thirdUserName;

    /**
     * 第三方用户昵称
     */
    @Column(name = "third_nick_name", length = 100, nullable = true)
    private String thirdNickName;

    /**
     * 第三方系统代码
     */
    @Column(name = "third_sys_code", length = 200, nullable = false)
    private String thirdSysCode;

    /**
     * 最后验证时间
     */
    @Column(name = "last_auth_time", nullable = false)
    private LocalDateTime lastAuthTime;

    /**
     * 绑定过期时间
     */
    @Column(name = "expire_time", nullable = true)
    private LocalDateTime expireTime;

    /**
     * 加密类型
     */
    @Column(name = "enc_type", nullable = false)
    private Integer encType;

    /**
     * 加密salt
     */
    @Column(name = "salt", length = 100, nullable = false)
    private String salt;

    /**
     * 密码 不一定是密码原文
     */
    @Column(name = "pass", length = 100, nullable = false)
    private String pass;

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

    public String getThirdUserName() {
        return thirdUserName;
    }

    public void setThirdUserName(String thirdUserName) {
        this.thirdUserName = thirdUserName;
    }

    public String getThirdNickName() {
        return thirdNickName;
    }

    public void setThirdNickName(String thirdNickName) {
        this.thirdNickName = thirdNickName;
    }

    public String getThirdSysCode() {
        return thirdSysCode;
    }

    public void setThirdSysCode(String thirdSysCode) {
        this.thirdSysCode = thirdSysCode;
    }

    public LocalDateTime getLastAuthTime() {
        return lastAuthTime;
    }

    public void setLastAuthTime(LocalDateTime lastAuthTime) {
        this.lastAuthTime = lastAuthTime;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getEncType() {
        return encType;
    }

    public void setEncType(Integer encType) {
        this.encType = encType;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
