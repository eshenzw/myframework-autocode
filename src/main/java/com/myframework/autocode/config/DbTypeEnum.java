package com.myframework.autocode.config;

import java.util.Arrays;

/**
 * Created by zw on 2017/7/6.
 */
public enum DbTypeEnum {
    MYSQL(1), SQLSERVER(2), ORACLE(3), POSTGRESQL(4);

    private int value;

    DbTypeEnum(int v) {
        this.value = v;
    }

    public final static DbTypeEnum get(String db) {
        for(DbTypeEnum dbTypeEnum:DbTypeEnum.values()){
            if(dbTypeEnum.value == Arrays.asList(new String[]{"", "msyql", "sqlserver", "oracle", "postgresql"}).indexOf(db.toLowerCase())){
                return dbTypeEnum;
            }
        }
        return null;
    }
}
