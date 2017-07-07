package com.myframework.autocode.config;

import java.io.File;

/**
 * Created by zw on 2017/7/6.
 */
public class Config {
    public final static String GENERATE_TYPE = "2"; //1:数据库定义xls 2:直接读数据库
    /**
     * 数据定义xls文件路径
     * GENERATE_TYPE 为1时用到
     */
    public final static String DB_DEFINE_FILE = "/doc/数据表设计.xlsx".replaceAll("/", File.separator);
    /**
     * 数据库配置
     * GENERATE_TYPE 为2时用到
     */
    /*public final static DbTypeEnum DB_TYPE = DbTypeEnum.MYSQL;  //1:mysql  2:oracle
    public static final String DB_URL = "jdbc:mysql://sunbiyun.com:3306/autocode?useUnicode=true&characterEncoding=utf8";
    public static final String DB_NAME = "com.mysql.jdbc.Driver";
    public static final String DB_USER = "zhaowei";
    public static final String DB_PASSWORD = "zw900730";
    public static final String DB_TABLES = "tmpl_tbl";*/
    /**
     * 生产文件配置
     */
    /*public final static String DAO_TYPE = "2";  //1:原生javaDao  2:接口型dao，mybatis实例化
    public final static String AUTOCODE_PATH = "../template";
    public final static String OUTPUT_PATH = "/out/AutoCodeGenerate/".replaceAll("/",File.separator);
    public final static String OUTPUT_PACKAGE = "com.zw";
    public final static String MODULE_NAME = "test";
    public final static String DB_PREFIX = "pt_";
    public final static String DAO_SUFFIX = "Dao";
    public final static String CLASS_SUFFIX = "Entity";*/


    /**
     * for waiqin365
     */
    public final static DbTypeEnum DB_TYPE = DbTypeEnum.POSTGRESQL;
    public static final String DB_URL = "jdbc:postgresql://172.31.3.206:5432/u8958085892090750662?useUnicode=true&characterEncoding=utf8";
    public static final String DB_NAME = "org.postgresql.Driver";
    public static final String DB_USER = "iorder_master";
    public static final String DB_PASSWORD = "FHuma025";
    public static final String DB_TABLES = "stdom_order";

    public final static String DAO_TYPE = "2";  //1:原生javaDao  2:接口型dao，mybatis实例化
    public final static String AUTOCODE_PATH = "../template";
    public final static String OUTPUT_PATH = "/out/AutoCodeGenerate/".replaceAll("/",File.separator);
    public final static String OUTPUT_PACKAGE = "com.zw";
    public final static String MODULE_NAME = "test";
    public final static String DB_PREFIX = "";
    public final static String DAO_SUFFIX = "Mapper";
    public final static String CLASS_SUFFIX = "";


}
