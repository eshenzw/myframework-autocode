package com.myframework.autocode.util;

import com.myframework.autocode.config.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zw on 2017/7/6.
 */
public class DBHelper {

    private String url = null;
    private String name = null;
    private String user = null;
    private String password = null;

    private Connection conn = null;
    private PreparedStatement pst = null;

    public DBHelper(String sql)
    {
        this.url = Config.DB_URL;
        this.name = Config.DB_DRIVER;
        this.user = Config.DB_USER;
        this.password = Config.DB_PASSWORD;
        try
        {
            Class.forName(name);// 指定连接类型
            conn = DriverManager.getConnection(url, user, password);// 获取连接
            pst = conn.prepareStatement(sql);// 准备执行语句
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void close()
    {
        try
        {
            this.conn.close();
            this.pst.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static Map queryOne(String sql, Object ...params){
        List<Map> list = DBHelper.query(sql,params);
        if(list !=null && list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }

    public static List<Map> query(String sql, Object ...params){
        int ret = 0;
        DBHelper hunDb = new DBHelper(sql);
        List<Map> list = new ArrayList<Map>();
        try
        {
            for(int i = 0;i < params.length;i++){
                hunDb.getPst().setObject(i+1,params[i]);
            }
            ResultSet rs  = hunDb.getPst().executeQuery();
            ResultSetMetaData md = rs.getMetaData(); //得到结果集(rs)的结构信息，比如字段数、字段名等
            int columnCount = md.getColumnCount(); //返回此 ResultSet 对象中的列数
            Map rowData = new HashMap();
            while (rs.next()) {
                rowData = new HashMap(columnCount);
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnLabel(i), rs.getObject(i));
                }
                list.add(rowData);
                //System.out.println("list:" + list.toString());
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            hunDb.close();
        }
        return list;
    }

    public static int update(String sql, Object ...params){
        int ret = 0;
        DBHelper hunDb = new DBHelper(sql);
        try {
            for (int i = 0; i < params.length; i++) {
                hunDb.getPst().setObject(i + 1, params[i]);
            }
            ret =hunDb.getPst().executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            hunDb.close();
        }
        return ret;
    }

    public Connection getConn()
    {
        return conn;
    }

    public void setConn(Connection conn)
    {
        this.conn = conn;
    }

    public PreparedStatement getPst()
    {
        return pst;
    }

    public void setPst(PreparedStatement pst)
    {
        this.pst = pst;
    }

    public static void main(String[] args){
        List<Map> list =  DBHelper.query("select column_name columnName, data_type dataType, column_comment columnComment, column_key columnKey, extra from information_schema.columns\n" +
                " where table_name = 'tmpl_tbl' and table_schema = (select database()) order by ordinal_position");
        System.out.println(list.toString());
    }
}
