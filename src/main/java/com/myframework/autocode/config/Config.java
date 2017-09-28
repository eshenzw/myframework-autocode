package com.myframework.autocode.config;

import java.io.File;

/**
 * Created by zw on 2017/7/6.
 */
public class Config {
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    public final static String GENERATE_TYPE = XmlConfig.get("generate-type"); //1:数据库定义xls 2:直接读数据库
    /**
     * 数据定义xls文件路径
     * GENERATE_TYPE 为1时用到
     */
    public final static String DB_DEFINE_FILE = XmlConfig.get("db-define-file").replace("/", FILE_SEPARATOR);
    /**
     * 数据库配置
     * GENERATE_TYPE 为2时用到
     */
    public final static DbTypeEnum DB_TYPE = DbTypeEnum.get(XmlConfig.get("db-type")); //1:mysql  2:oracle
    public static final String DB_DRIVER = XmlConfig.get("db-driver");
    public static final String DB_URL = XmlConfig.get("db-url");
    public static final String DB_USER = XmlConfig.get("db-user");
    public static final String DB_PASSWORD = XmlConfig.get("db-password");
    public static final String DB_TABLES = XmlConfig.get("db-tables");
    /**
     * 生产文件配置
     */
    public final static String DAO_TYPE = XmlConfig.get("db-type");  //1:原生javaDao  2:接口型dao，mybatis实例化
    public final static String TEMPLATE_PATH = "../template";
    public final static String OUTPUT_PATH = XmlConfig.get("output-path").replaceAll("/",File.separator);
    public final static String OUTPUT_PACKAGE = XmlConfig.get("output-package");
    public final static String MODULE_NAME = XmlConfig.get("module-name");
    public final static String DB_PREFIX = XmlConfig.get("db-prefix");
    public final static String DAO_SUFFIX =XmlConfig.get("dao-suffix");
    public final static String CLASS_SUFFIX = XmlConfig.get("entity-suffix");

}
