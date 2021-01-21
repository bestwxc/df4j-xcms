package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.*;
import java.util.Set;

import static com.df4j.xcms.core.constants.Constants.DATABASE_CATALOG;
import static com.df4j.xcms.core.constants.Constants.DATABASE_TABLE_PREFIX;

/**
 * 页面
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "page")
public class PageEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = -3648493037989220570L;

    /**
     * 页面代码
     */
    @Column(name = "page_code", length = 100, nullable = false)
    private String pageCode;

    /**
     * 页面名称
     */
    @Column(name = "page_name", length = 200, nullable = false)
    private String pageName;

    /**
     * bundle代码
     */
    @Column(name = "component_code", length = 100, nullable = false)
    private String componentCode;

    /**
     * 页面说明
     */
    @Column(name = "page_desc", length = 1000)
    private String pageDesc;

    /**
     * 资源类型
     */
    @Column(name = "resource_type", length = 100, nullable = false)
    private Integer resourceType;

    /**
     * 是否是主页面
     */
    @Column(name = "main_page", nullable = false)
    private Integer mainPage;

    /**
     * 页面类型
     */
    @Column(name = "page_type", nullable = false)
    private Integer pageType;

    @Column(name = "page_content", length = 1000, nullable = false)
    private String pageContent;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "page_code", referencedColumnName = "page_code")
    private Set<BtnEntity> btns;

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

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public Set<BtnEntity> getBtns() {
        return btns;
    }

    public void setBtns(Set<BtnEntity> btns) {
        this.btns = btns;
    }

    public String getPageDesc() {
        return pageDesc;
    }

    public void setPageDesc(String pageDesc) {
        this.pageDesc = pageDesc;
    }

    public Integer getMainPage() {
        return mainPage;
    }

    public void setMainPage(Integer mainPage) {
        this.mainPage = mainPage;
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

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }
}
