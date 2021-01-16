package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 功能页面与按钮的绑定关系
 */
@Entity
@Table(name = "t_xcms_page")
public class PageBtnEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 2759915184060657096L;

    /**
     * 页面代码
     */
    @Column(name = "page_code", length = 100, nullable = false)
    private String pageCode;

    /**
     * 按钮代码
     */
    @Column(name = "btn_code", length = 100, nullable = false)
    private String btnCode;

    /**
     * 页面及按钮关联关系说明
     */
    @Column(name = "page_btn_desc", length = 400, nullable = true)
    private String pageBtnDesc;

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

    public String getPageBtnDesc() {
        return pageBtnDesc;
    }

    public void setPageBtnDesc(String pageBtnDesc) {
        this.pageBtnDesc = pageBtnDesc;
    }
}
