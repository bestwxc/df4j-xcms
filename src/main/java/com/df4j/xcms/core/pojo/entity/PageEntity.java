package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_xcms_page")
public class PageEntity extends OrderedEntity<Long> {
    private static final long serialVersionUID = -3648493037989220570L;

    @Column(name = "page_code", length = 100, nullable = false)
    private String pageCode;

    @Column(name = "page_name", length = 200, nullable = false)
    private String pageName;

    @Column(name = "page_desc", length = 1000)
    private String pageDesc;

    @Column(name = "page_type", nullable = false)
    private Integer pageType;

    @Column(name = "page_content", length = 1000, nullable = false)
    private String pageContent;

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageDesc() {
        return pageDesc;
    }

    public void setPageDesc(String pageDesc) {
        this.pageDesc = pageDesc;
    }

    public Integer getPageType() {
        return pageType;
    }

    public void setPageType(Integer pageType) {
        this.pageType = pageType;
    }

    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }
}
