package com.myframework.autocode.util;

import com.myframework.autocode.config.Config;
import com.myframework.autocode.config.DbTypeEnum;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaowei
 */
public class DbType2Java
{
    /**
     * mysql 数据库类型到java类型映射
     */
    private static final List<ImmutablePair<String, String>> MYSQL_PAIR = new ArrayList<ImmutablePair<String, String>>()
    {
        {
            add(new ImmutablePair<String, String>("tinyint", "Integer"));
            add(new ImmutablePair<String, String>("smallint", "Integer"));
            add(new ImmutablePair<String, String>("mediumint", "Integer"));
            add(new ImmutablePair<String, String>("int", "Integer"));
            add(new ImmutablePair<String, String>("integer", "Integer"));
            add(new ImmutablePair<String, String>("bigint", "Long"));
            add(new ImmutablePair<String, String>("float", "Float"));
            add(new ImmutablePair<String, String>("double", "Double"));
            add(new ImmutablePair<String, String>("decimal", "BigDecimal"));
            //
            add(new ImmutablePair<String, String>("char", "String"));
            add(new ImmutablePair<String, String>("varchar", "String"));
            add(new ImmutablePair<String, String>("tinytext", "String"));
            add(new ImmutablePair<String, String>("text", "String"));
            add(new ImmutablePair<String, String>("mediumtext", "String"));
            add(new ImmutablePair<String, String>("longtext", "String"));
            //
            add(new ImmutablePair<String, String>("date", "Date"));
            add(new ImmutablePair<String, String>("datetime", "Date"));
            add(new ImmutablePair<String, String>("timestamp", "Date"));
        }
    };

    /**
     * sqlserver 数据库类型到java类型映射
     */
    private static final List<ImmutablePair<String, String>> SQLSERVER_PAIR = new ArrayList<ImmutablePair<String, String>>()
    {
        {
            add(new ImmutablePair<String, String>("tinyint", "Integer"));
            add(new ImmutablePair<String, String>("smallint", "Integer"));
            add(new ImmutablePair<String, String>("mediumint", "Integer"));
            add(new ImmutablePair<String, String>("int", "Integer"));
            add(new ImmutablePair<String, String>("integer", "Integer"));
            add(new ImmutablePair<String, String>("bigint", "Long"));
            add(new ImmutablePair<String, String>("float", "Float"));
            add(new ImmutablePair<String, String>("double", "Double"));
            add(new ImmutablePair<String, String>("decimal", "BigDecimal"));
            add(new ImmutablePair<String, String>("number", "BigDecimal"));
            //
            add(new ImmutablePair<String, String>("varchar2", "String"));
            add(new ImmutablePair<String, String>("varchar", "String"));
            add(new ImmutablePair<String, String>("tinytext", "String"));
            add(new ImmutablePair<String, String>("text", "String"));
            add(new ImmutablePair<String, String>("mediumtext", "String"));
            add(new ImmutablePair<String, String>("longtext", "String"));
            //
            add(new ImmutablePair<String, String>("date", "Date"));
            add(new ImmutablePair<String, String>("datetime", "Date"));
            add(new ImmutablePair<String, String>("timestamp", "Date"));
        }
    };

    /**
     * oracle 数据库类型到java类型映射
     */
    private static final List<ImmutablePair<String, String>> ORACLE_PAIR = new ArrayList<ImmutablePair<String, String>>()
    {
        {
            add(new ImmutablePair<String, String>("tinyint", "Integer"));
            add(new ImmutablePair<String, String>("smallint", "Integer"));
            add(new ImmutablePair<String, String>("mediumint", "Integer"));
            add(new ImmutablePair<String, String>("int", "Integer"));
            add(new ImmutablePair<String, String>("integer", "Integer"));
            add(new ImmutablePair<String, String>("bigint", "Long"));
            add(new ImmutablePair<String, String>("float", "Float"));
            add(new ImmutablePair<String, String>("double", "Double"));
            add(new ImmutablePair<String, String>("decimal", "BigDecimal"));
            add(new ImmutablePair<String, String>("number", "BigDecimal"));
            //
            add(new ImmutablePair<String, String>("varchar2", "String"));
            add(new ImmutablePair<String, String>("varchar", "String"));
            add(new ImmutablePair<String, String>("tinytext", "String"));
            add(new ImmutablePair<String, String>("text", "String"));
            add(new ImmutablePair<String, String>("mediumtext", "String"));
            add(new ImmutablePair<String, String>("longtext", "String"));
            //
            add(new ImmutablePair<String, String>("date", "Date"));
            add(new ImmutablePair<String, String>("datetime", "Date"));
            add(new ImmutablePair<String, String>("timestamp", "Date"));
        }
    };

    /**
     * postgresql 数据库类型到java类型映射
     */
    private static final List<ImmutablePair<String, String>> POSTGRESQL_PAIR = new ArrayList<ImmutablePair<String, String>>()
    {
        {
            add(new ImmutablePair<String, String>("tinyint", "Integer"));
            add(new ImmutablePair<String, String>("smallint", "Integer"));
            add(new ImmutablePair<String, String>("mediumint", "Integer"));
            add(new ImmutablePair<String, String>("int", "Integer"));
            add(new ImmutablePair<String, String>("integer", "Integer"));
            add(new ImmutablePair<String, String>("bigint", "Long"));
            add(new ImmutablePair<String, String>("float", "Float"));
            add(new ImmutablePair<String, String>("double", "Double"));
            add(new ImmutablePair<String, String>("decimal", "BigDecimal"));
            add(new ImmutablePair<String, String>("numeric", "BigDecimal"));
            //
            add(new ImmutablePair<String, String>("character", "String"));
            add(new ImmutablePair<String, String>("character varying", "String"));
            add(new ImmutablePair<String, String>("varchar", "String"));
            add(new ImmutablePair<String, String>("tinytext", "String"));
            add(new ImmutablePair<String, String>("text", "String"));
            add(new ImmutablePair<String, String>("mediumtext", "String"));
            add(new ImmutablePair<String, String>("longtext", "String"));
            //
            add(new ImmutablePair<String, String>("date", "Date"));
            add(new ImmutablePair<String, String>("datetime", "Date"));
            add(new ImmutablePair<String, String>("timestamp", "Date"));
        }
    };

    public static String parseSqlType(String columnType)
    {
        if (Config.DB_TYPE == DbTypeEnum.MYSQL)
        {
            return parseMysqlType(columnType);
        }
        else if (Config.DB_TYPE == DbTypeEnum.SQLSERVER)
        {
            return parseSqlserverType(columnType);
        }
        else if (Config.DB_TYPE == DbTypeEnum.ORACLE)
        {
            return parseOracleType(columnType);
        }
        else if (Config.DB_TYPE == DbTypeEnum.POSTGRESQL)
        {
            return parsePostgresqlType(columnType);
        }
        else
        {
            return parseMysqlType(columnType);
        }
    }

    public static String parseMysqlType(String columnType)
    {
        columnType = columnType.trim().toLowerCase();
        for (ImmutablePair<String, String> pair : MYSQL_PAIR)
        {
            String sqlType = pair.getLeft();
            if (sqlType.equals(columnType) || (columnType != null && columnType.startsWith(sqlType)))
            {
                return pair.getRight();
            }
        }
        return "Object";
    }

    public static String parseSqlserverType(String columnType)
    {
        columnType = columnType.trim().toLowerCase();
        for (ImmutablePair<String, String> pair : SQLSERVER_PAIR)
        {
            String sqlType = pair.getLeft();
            if (sqlType.equals(columnType) || (columnType != null && columnType.startsWith(sqlType)))
            {
                return pair.getRight();
            }
        }
        return "Object";
    }

    public static String parseOracleType(String columnType)
    {
        columnType = columnType.trim().toLowerCase();
        for (ImmutablePair<String, String> pair : ORACLE_PAIR)
        {
            String sqlType = pair.getLeft();
            if (sqlType.equals(columnType) || (columnType != null && columnType.startsWith(sqlType)))
            {
                return pair.getRight();
            }
        }
        return "Object";
    }

    public static String parsePostgresqlType(String columnType)
    {
        columnType = columnType.trim().toLowerCase();
        for (ImmutablePair<String, String> pair : POSTGRESQL_PAIR)
        {
            String sqlType = pair.getLeft();
            if (sqlType.equals(columnType) || (columnType != null && columnType.startsWith(sqlType)))
            {
                return pair.getRight();
            }
        }
        return "Object";
    }

}
