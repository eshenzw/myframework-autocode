package com.myframework.autocode.config;

import java.io.File;

/**
 * Created by zw on 2017/7/6.
 */
public class Config {
    public final static String DAO_TYPE = "2";  //1:原生javaDao  2:接口型dao，mybatis实例化
    public final static DbTypeEnum DB_TYPE = DbTypeEnum.MYSQL;  //1:mysql  2:oracle
    public final static String DB_DEFINE_FILE = "/doc/数据表设计.xlsx".replaceAll("/", File.separator);
    public final static String AUTOCODE_PATH = "../template";
    public final static String OUTPUT_PATH = "/out/AutoCodeGenerate/".replaceAll("/",File.separator);
    public final static String OUTPUT_PACKAGE = "com.zw";
    public final static String DB_PREFIX = "pt_";
    /**
     * 数据库配置
     */
    public static final String DB_URL = "jdbc:mysql://sunbiyun.com:3306/autocode?useUnicode=true&characterEncoding=utf8";
    public static final String DB_NAME = "com.mysql.jdbc.Driver";
    public static final String DB_USER = "zhaowei";
    public static final String DB_PASSWORD = "zw900730";
}
