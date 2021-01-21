package com.df4j.xcms.core.pojo.entity;

import com.df4j.xcframework.jpa.hibernate.entity.OrderedEntity;

import javax.persistence.*;
import java.util.List;

import static com.df4j.xcms.core.constants.Constants.DATABASE_CATALOG;
import static com.df4j.xcms.core.constants.Constants.DATABASE_TABLE_PREFIX;

/**
 * 数据字典
 */
@Entity
@Table(catalog = DATABASE_CATALOG, name = DATABASE_TABLE_PREFIX + "dict")
public class DictEntity extends OrderedEntity<Long> {

    private static final long serialVersionUID = 7087384740985341819L;

    /**
     * 上级字典代码
     */
    @Column(name = "parent_dict_code", length = 100, nullable = false, unique = true, insertable = false, updatable = false)
    private String parentDictCode;

    /**
     * 字典代码
     */
    @Column(name = "dict_code", length = 100, nullable = false)
    private String dictCode;

    /**
     * 字典值
     */
    @Column(name = "dict_value", length = 200, nullable = false)
    private String dictValue;

    /**
     * 字典名称
     */
    @Column(name = "dict_name", length = 200, nullable = false)
    private String dictName;

    /**
     * 字典说明
     */
    @Column(name = "dict_desc", length = 400, nullable = false)
    private String dictDesc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_dict_code", referencedColumnName = "dict_code")
    private DictEntity parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<DictEntity> children;

    public String getParentDictCode() {
        return parentDictCode;
    }

    public void setParentDictCode(String parentDictCode) {
        this.parentDictCode = parentDictCode;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictDesc() {
        return dictDesc;
    }

    public void setDictDesc(String dictDesc) {
        this.dictDesc = dictDesc;
    }

    public DictEntity getParent() {
        return parent;
    }

    public void setParent(DictEntity parent) {
        this.parent = parent;
    }

    public List<DictEntity> getChildren() {
        return children;
    }

    public void setChildren(List<DictEntity> children) {
        this.children = children;
    }
}
