package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_xcms_user")
public class UserEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -2001616547781405114L;

    @Column(name= "user_name", length = 100, nullable = false)
    private String userName;

    @Column(name = "nick_name", length = 100, nullable = false)
    private String nickName;

    @Column(name = "mobile_no", length = 20, nullable = true)
    private String mobileNo;

    @Column(name = "sex", nullable = false)
    private Integer sex;

    @Column(name = "user_type", nullable = false)
    private Integer userType;

    @Column(name = "source_type", nullable = false)
    private Integer sourceType;

    @Column(name = "head_picture", length = 1000, nullable = true)
    private String headPicture;

    @Column(name = "self_introduction", length = 2000, nullable = false)
    private String selfIntroduction;

    @Column(name = "enc_type", nullable = false)
    private Integer encType;

    @Column(name = "salt", length = 100, nullable = false)
    private String salt;

    @Column(name = "pass", length = 100, nullable = false)
    private String pass;

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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
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
