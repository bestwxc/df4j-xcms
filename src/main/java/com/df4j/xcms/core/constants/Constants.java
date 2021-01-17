package com.df4j.xcms.core.constants;

public class Constants {

    /**
     * 系统名称
     */
    public static final String SYSTEM_NAME = "XCMS";


    /**
     * 定义数据库表前缀 schema catalog
     * 后续可以通过加载指定常量类等特定方法统一设置
     */


    /**
     * 用来定义系统的表前缀
     */
    public static final String DATABASE_TABLE_PREFIX = "t_xcms_";

    /**
     * 数据库catalog
     * mysql支持atalog
     */
    public static final String DATABASE_CATALOG = "xcms";

    /**
     * 数据库schema
     * mysql不支持schema
     */
    public static final String DATABASE_SCHEMA = "xcms";
}
