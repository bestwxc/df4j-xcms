package com.df4j.xcms.core.utils;

import javax.persistence.Table;

public class IdentityUtils {

    public static String getName(Class clazz) {
        return ((Table) clazz.getAnnotation(Table.class)).name();
    }
}
