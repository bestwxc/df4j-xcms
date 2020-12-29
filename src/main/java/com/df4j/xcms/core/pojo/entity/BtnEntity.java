package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_xcms_btn")
public class BtnEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -5399326611222489727L;

    @Column(name = "btn_code", length = 100, nullable = false)
    private String btnCode;

    @Column(name = "btn_name", length = 200, nullable = false)
    private String btnName;

    @Column(name = "btn_desc", length = 100, nullable = false)
    private String btnDesc;

    @Column(name = "btn_style", length = 400, nullable = true)
    private String btnStyle;

    public String getBtnCode() {
        return btnCode;
    }

    public void setBtnCode(String btnCode) {
        this.btnCode = btnCode;
    }

    public String getBtnName() {
        return btnName;
    }

    public void setBtnName(String btnName) {
        this.btnName = btnName;
    }

    public String getBtnDesc() {
        return btnDesc;
    }

    public void setBtnDesc(String btnDesc) {
        this.btnDesc = btnDesc;
    }

    public String getBtnStyle() {
        return btnStyle;
    }

    public void setBtnStyle(String btnStyle) {
        this.btnStyle = btnStyle;
    }
}
