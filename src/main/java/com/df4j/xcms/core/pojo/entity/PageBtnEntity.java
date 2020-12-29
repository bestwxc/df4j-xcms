package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_xcms_page")
public class PageBtnEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 2759915184060657096L;

    @Column(name = "sys_code", length = 100, nullable = false)
    private String sysCode;

    @Column(name = "page_code", length = 100, nullable = false)
    private String pageCode;

    @Column(name = "btn_code", length = 100, nullable = false)
    private String btnCode;

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    public String getBtnCode() {
        return btnCode;
    }

    public void setBtnCode(String btnCode) {
        this.btnCode = btnCode;
    }
}
