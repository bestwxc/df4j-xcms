package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.*;
import java.util.Set;

import static com.df4j.xcms.core.constants.Constants.DATABASE_CATALOG;
import static com.df4j.xcms.core.constants.Constants.DATABASE_TABLE_PREFIX;
/**
 * 用户
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "user")
public class UserEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -2001616547781405114L;

    /**
     * 用户名称
     */
    @Column(name= "user_name", length = 100, nullable = false)
    private String userName;

    /**
     * 昵称
     */
    @Column(name = "nick_name", length = 100, nullable = false)
    private String nickName;

    /**
     * 手机好吗
     */
    @Column(name = "mobile_no", length = 20, nullable = true)
    private String mobileNo;

    /**
     * 邮件
     */
    @Column(name = "email", length = 100, nullable = true)
    private String email;

    /**
     * 性别
     */
    @Column(name = "sex", nullable = false)
    private Integer sex;

    /**
     * 部门编号
     */
    @Column(name = "dept_code", length = 100, nullable = true)
    private String deptCode;

    /**
     * 用户类型
     */
    @Column(name = "user_type", nullable = false)
    private Integer userType;

    /**
     * 授予类型
     */
    @Column(name = "target_type", nullable = false)
    private Integer targetType;

    /**
     * 来源类型
     */
    @Column(name = "source_type", nullable = false)
    private Integer sourceType;

    /**
     * 头像
     */
    @Column(name = "avatar", length = 1000, nullable = true)
    private String avatar;

    /**
     * 自我介绍
     */
    @Column(name = "self_introduction", length = 2000, nullable = false)
    private String selfIntroduction;

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
     * 密码
     */
    @Column(name = "pass", length = 100, nullable = false)
    private String pass;

    /**
     * 角色
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "rights",
            joinColumns = {@JoinColumn(name = "target_type", referencedColumnName = "target_type"),
                    @JoinColumn(name = "target_code", referencedColumnName = "user_name")},
            inverseJoinColumns = {@JoinColumn(name = "resource_type", referencedColumnName = "resource_type"),
                    @JoinColumn(name = "resource_code", referencedColumnName = "role_code")})
    private Set<RoleEntity> roles;

    /**
     * 岗位
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "rights",
            joinColumns = {@JoinColumn(name = "target_type", referencedColumnName = "target_type"),
                    @JoinColumn(name = "target_code", referencedColumnName = "user_name")},
            inverseJoinColumns = {@JoinColumn(name = "resource_type", referencedColumnName = "resource_type"),
                    @JoinColumn(name = "resource_code", referencedColumnName = "position_code")})
    private Set<PositionEntity> positions;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "rights",
            joinColumns = {@JoinColumn(name = "target_type", referencedColumnName = "target_type"),
                    @JoinColumn(name = "target_code", referencedColumnName = "user_name")},
            inverseJoinColumns = {@JoinColumn(name = "resource_type", referencedColumnName = "resource_type"),
                    @JoinColumn(name = "resource_code", referencedColumnName = "menu_code")})
    private Set<MenuEntity> menus;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "rights",
            joinColumns = {@JoinColumn(name = "target_type", referencedColumnName = "target_type"),
                    @JoinColumn(name = "target_code", referencedColumnName = "user_name")},
            inverseJoinColumns = {@JoinColumn(name = "resource_type", referencedColumnName = "resource_type"),
                    @JoinColumn(name = "resource_code", referencedColumnName = "btn_code")})
    private Set<BtnEntity> btns;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public Set<PositionEntity> getPositions() {
        return positions;
    }

    public void setPositions(Set<PositionEntity> positions) {
        this.positions = positions;
    }

    public Set<MenuEntity> getMenus() {
        return menus;
    }

    public void setMenus(Set<MenuEntity> menus) {
        this.menus = menus;
    }

    public Set<BtnEntity> getBtns() {
        return btns;
    }

    public void setBtns(Set<BtnEntity> btns) {
        this.btns = btns;
    }
}
