package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用来定义功能号的依赖关系
 */
@Entity
@Table(name = "t_xcms_func_dep")
public class FuncDepEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -2660854198193681126L;
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
     * 功能号代码
     */
    @Column(name = "func_code", length = 100, nullable = false)
    private String funcCode;

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

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }
}
