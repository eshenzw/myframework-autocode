package com.myframework.autocode.util;

import com.myframework.autocode.config.Config;
import com.myframework.autocode.config.DbTypeEnum;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zw on 2017/7/7.
 */
public class DbType2Java {
    /**
     * mysql 数据库类型到java类型映射
     */
    private static final List<Pair> MYSQL_PAIR = new ArrayList<Pair>(){{
        add(new Pair("tinyint","Integer"));
        add(new Pair("smallint","Integer"));
        add(new Pair("mediumint","Integer"));
        add(new Pair("int","Integer"));
        add(new Pair("integer","Integer"));
        add(new Pair("bigint","Long"));
        add(new Pair("float","Float"));
        add(new Pair("double","Double"));
        add(new Pair("decimal","BigDecimal"));
        //
        add(new Pair("char","String"));
        add(new Pair("varchar","String"));
        add(new Pair("tinytext","String"));
        add(new Pair("text","String"));
        add(new Pair("mediumtext","String"));
        add(new Pair("longtext","String"));
        //
        add(new Pair("date","Date"));
        add(new Pair("datetime","Date"));
        add(new Pair("timestamp","Date"));
    }};

    /**
     * sqlserver 数据库类型到java类型映射
     */
    private static final List<Pair> SQLSERVER_PAIR = new ArrayList<Pair>(){{
        add(new Pair("tinyint","Integer"));
        add(new Pair("smallint","Integer"));
        add(new Pair("mediumint","Integer"));
        add(new Pair("int","Integer"));
        add(new Pair("integer","Integer"));
        add(new Pair("bigint","Long"));
        add(new Pair("float","Float"));
        add(new Pair("double","Double"));
        add(new Pair("decimal","BigDecimal"));
        add(new Pair("number","BigDecimal"));
        //
        add(new Pair("varchar2","String"));
        add(new Pair("varchar","String"));
        add(new Pair("tinytext","String"));
        add(new Pair("text","String"));
        add(new Pair("mediumtext","String"));
        add(new Pair("longtext","String"));
        //
        add(new Pair("date","Date"));
        add(new Pair("datetime","Date"));
        add(new Pair("timestamp","Date"));
    }};

    /**
     * oracle 数据库类型到java类型映射
     */
    private static final List<Pair> ORACLE_PAIR = new ArrayList<Pair>(){{
        add(new Pair("tinyint","Integer"));
        add(new Pair("smallint","Integer"));
        add(new Pair("mediumint","Integer"));
        add(new Pair("int","Integer"));
        add(new Pair("integer","Integer"));
        add(new Pair("bigint","Long"));
        add(new Pair("float","Float"));
        add(new Pair("double","Double"));
        add(new Pair("decimal","BigDecimal"));
        add(new Pair("number","BigDecimal"));
        //
        add(new Pair("varchar2","String"));
        add(new Pair("varchar","String"));
        add(new Pair("tinytext","String"));
        add(new Pair("text","String"));
        add(new Pair("mediumtext","String"));
        add(new Pair("longtext","String"));
        //
        add(new Pair("date","Date"));
        add(new Pair("datetime","Date"));
        add(new Pair("timestamp","Date"));
    }};

    /**
     * postgresql 数据库类型到java类型映射
     */
    private static final List<Pair> POSTGRESQL_PAIR = new ArrayList<Pair>(){{
        add(new Pair("tinyint","Integer"));
        add(new Pair("smallint","Integer"));
        add(new Pair("mediumint","Integer"));
        add(new Pair("int","Integer"));
        add(new Pair("integer","Integer"));
        add(new Pair("bigint","Long"));
        add(new Pair("float","Float"));
        add(new Pair("double","Double"));
        add(new Pair("decimal","BigDecimal"));
        add(new Pair("numeric","BigDecimal"));
        //
        add(new Pair("character","String"));
        add(new Pair("character varying","String"));
        add(new Pair("varchar","String"));
        add(new Pair("tinytext","String"));
        add(new Pair("text","String"));
        add(new Pair("mediumtext","String"));
        add(new Pair("longtext","String"));
        //
        add(new Pair("date","Date"));
        add(new Pair("datetime","Date"));
        add(new Pair("timestamp","Date"));
    }};

    public static String parseSqlType(String columnType){
        if(Config.DB_TYPE == DbTypeEnum.MYSQL){
            return parseMysqlType(columnType);
        }else if(Config.DB_TYPE == DbTypeEnum.SQLSERVER){
            return parseSqlserverType(columnType);
        }else if(Config.DB_TYPE == DbTypeEnum.ORACLE){
            return parseOracleType(columnType);
        }else if(Config.DB_TYPE == DbTypeEnum.POSTGRESQL){
            return parsePostgresqlType(columnType);
        }else{
            return parseMysqlType(columnType);
        }
    }

    public static String parseMysqlType(String columnType){
        columnType = columnType.trim().toLowerCase();
        for(Pair pair:MYSQL_PAIR){
            String sqlType = String.valueOf(pair.getKey());
            if(sqlType.equals(columnType) || (columnType != null && columnType.startsWith(sqlType))){
                return String.valueOf(pair.getValue());
            }
        }
        return "Object";
    }

    public static String parseSqlserverType(String columnType){
        columnType = columnType.trim().toLowerCase();
        for(Pair pair:SQLSERVER_PAIR){
            String sqlType = String.valueOf(pair.getKey());
            if(sqlType.equals(columnType) || (columnType != null && columnType.startsWith(sqlType))){
                return String.valueOf(pair.getValue());
            }
        }
        return "Object";
    }

    public static String parseOracleType(String columnType){
        columnType = columnType.trim().toLowerCase();
        for(Pair pair:ORACLE_PAIR){
            String sqlType = String.valueOf(pair.getKey());
            if(sqlType.equals(columnType) || (columnType != null && columnType.startsWith(sqlType))){
                return String.valueOf(pair.getValue());
            }
        }
        return "Object";
    }

    public static String parsePostgresqlType(String columnType){
        columnType = columnType.trim().toLowerCase();
        for(Pair pair:POSTGRESQL_PAIR){
            String sqlType = String.valueOf(pair.getKey());
            if(sqlType.equals(columnType) || (columnType != null && columnType.startsWith(sqlType))){
                return String.valueOf(pair.getValue());
            }
        }
        return "Object";
    }


}
