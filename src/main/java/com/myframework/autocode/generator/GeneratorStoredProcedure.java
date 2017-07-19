package com.myframework.autocode.generator;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myframework.autocode.config.Config;
import com.myframework.autocode.entity.ColumnInfo;
import com.myframework.autocode.entity.TableInfo;
import com.myframework.autocode.util.CodeGeneratorUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class GeneratorStoredProcedure {

    public static void autocode() throws IOException, TemplateException {
// TODO Auto-generated method stub
        List<TableInfo> tableInfoList = CodeGeneratorUtils.parseTable();

        String basePath = System.getProperty("user.dir") + Config.OUTPUT_PATH;

        Map<String, Object> dataMap = new HashMap<String, Object>();
        List<Map<String, Object>> pros = new ArrayList<Map<String, Object>>();
        for (TableInfo tableInfo : tableInfoList) {
            Map<String, Object> proMap = new HashMap<String, Object>();
            proMap.put("tableName", tableInfo.getTableName());
            proMap.put("tableDbName", tableInfo.getTableDbName());
            proMap.put("tableDbNameLc", tableInfo.getTableDbName().toLowerCase());
            proMap.put("prefixTableDbName", Config.DB_PREFIX + tableInfo.getTableDbName());

            List<Map<String, Object>> columnPros = new ArrayList<Map<String, Object>>();
            List<ColumnInfo> columnInfoList = tableInfo.getColumns();
            for (ColumnInfo columnInfo : columnInfoList) {
                Map<String, Object> columnMap = new HashMap<String, Object>();
                columnMap.put("columnName", columnInfo.getName());
                columnMap.put("description", columnInfo.getDescription());
                columnMap.put("example", columnInfo.getExample());
                columnPros.add(columnMap);
            }
            proMap.put("columnList", columnPros);

            pros.add(proMap);
        }
        dataMap.put("properties", pros);

        File pathFile = new File(basePath + "StoredProcedure.txt");
        CodeGeneratorUtils.outFile(pathFile, "StoredProcedureGeneratorTemplate", dataMap);
        System.out.println("导出成功：" + pathFile.getAbsolutePath());
    }

    public static void main(String[] args) throws Exception {
        autocode();
    }

}
