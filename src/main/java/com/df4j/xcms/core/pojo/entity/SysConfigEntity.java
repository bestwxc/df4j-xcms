package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 系统配置
 */
@Entity
@Table(name = "t_xcms_sys_config")
public class SysConfigEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 4408996824670958280L;

    /**
     * 配置代码
     */
    @Column(name = "config_code", length = 100, nullable = false)
    private String configCode;

    /**
     * 配置名称
     */
    @Column(name = "config_name", length = 100, nullable = false)
    private String configName;

    /**
     * 配置说明
     */
    @Column(name = "config_desc", length = 1000, nullable = false)
    private String configDesc;

    /**
     * 配置值
     */
    @Column(name = "config_value", length = 1000, nullable = false)
    private String configValue;

    /**
     * 配置值2
     */
    @Column(name = "config_value2", length = 1000, nullable = false)
    private String configValue2;

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigDesc() {
        return configDesc;
    }

    public void setConfigDesc(String configDesc) {
        this.configDesc = configDesc;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String getConfigValue2() {
        return configValue2;
    }

    public void setConfigValue2(String configValue2) {
        this.configValue2 = configValue2;
    }
}
