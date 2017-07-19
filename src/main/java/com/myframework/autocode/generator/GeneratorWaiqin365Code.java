package com.myframework.autocode.generator;

import com.myframework.autocode.config.Config;
import com.myframework.autocode.entity.ClassInfo;
import com.myframework.autocode.entity.ColumnInfo;
import com.myframework.autocode.entity.PropertyInfo;
import com.myframework.autocode.entity.TableInfo;
import com.myframework.autocode.util.CodeGeneratorUtils;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zw on 2017/7/7.
 */
public class GeneratorWaiqin365Code {

    public static void autocode() throws IOException, TemplateException {
        List<TableInfo> tableInfoList = CodeGeneratorUtils.parseTable();
        List<ClassInfo> classInfoList = new ArrayList<ClassInfo>();
        for (TableInfo tableInfo : tableInfoList) {
            ClassInfo classInfo = new ClassInfo(tableInfo);
            classInfoList.add(classInfo);
        }

        System.out.println(tableInfoList);
        System.out.println(classInfoList);

        String basePath = System.getProperty("user.dir") + Config.OUTPUT_PATH;
        // 清空basePath下的文件
        clearBasePathFiles(basePath);

        for (int i = 0; i < tableInfoList.size(); i++) {
            TableInfo tableInfo = tableInfoList.get(i);
            ClassInfo classInfo = classInfoList.get(i);

            // 模板内使用的参数Map
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("tableName", tableInfo.getTableName());
            dataMap.put("tableDbName", tableInfo.getTableDbName());
            dataMap.put("tableDbNameLc", tableInfo.getTableDbName().toLowerCase());
            dataMap.put("prefixTableDbName", Config.DB_PREFIX + tableInfo.getTableDbName());
            //
            dataMap.put("classPackage", Config.OUTPUT_PACKAGE + "."
                    + tableInfo.getModuleName());
            dataMap.put("className", classInfo.getClassName());
            dataMap.put("classNameWithoutEntity", classInfo.getClassNameWithoutEntity());
            dataMap.put("classObjectName", classInfo.getClassObjectName());
            dataMap.put("iDaoName", classInfo.getIDaoName());
            dataMap.put("daoName", classInfo.getDaoName());

            List<Map<String, Object>> pros = new ArrayList<Map<String, Object>>();
            List<ColumnInfo> columnList = tableInfo.getColumns();
            List<PropertyInfo> propertyList = classInfo.getProperties();
            for (int j = 0; j < columnList.size(); j++) {
                ColumnInfo columnInfo = columnList.get(j);
                PropertyInfo propertyInfo = propertyList.get(j);
                Map<String, Object> proMap = new HashMap<String, Object>();
                proMap.put("proDescription", columnInfo.getDescription());
                proMap.put("proColumnName", columnInfo.getName());
                proMap.put("proColumnNameLc", columnInfo.getName().toLowerCase());
                proMap.put("proDbColumnType", columnInfo.getDbColumnType(Config.DB_TYPE.MYSQL));
                proMap.put("proDbColumnOracleType", columnInfo.getDbColumnType(Config.DB_TYPE.ORACLE));
                proMap.put("proNotNull", columnInfo.isNotNull());
                proMap.put("proType", propertyInfo.getPropertyType());
                proMap.put("proName", propertyInfo.getPropertyName());
                proMap.put("proMethodName", propertyInfo.getMethodName());
                pros.add(proMap);
            }
            dataMap.put("properties", pros);

            // Pojo生成
            File pathFile = new File(basePath + tableInfo.getModuleName() + "/pojo/" + classInfo.getClassName() + ".java");
            CodeGeneratorUtils.outFile(pathFile, "waiqin365/PojoTemplate", dataMap);
            // mapper生成
            pathFile = new File(basePath + tableInfo.getModuleName() + "/mapper/" + classInfo.getDaoName() + ".java");
            CodeGeneratorUtils.outFile(pathFile, "waiqin365/MapperTemplate", dataMap);
            // mapping生成
            pathFile = new File(basePath + tableInfo.getModuleName() + "/mybatis/" + tableInfo.getTableDbName() + "_mapping.xml");
            CodeGeneratorUtils.outFile(pathFile, "waiqin365/MappingTemplate", dataMap);
        }
    }

    public static void main(String[] args) throws IOException, TemplateException {
        autocode();
    }


    private static void clearBasePathFiles(String basePath) {
        File dir = new File(basePath);
        dir.mkdirs();
        clearBasePathFiles(dir);
    }

    private static void clearBasePathFiles(File file) {
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                clearBasePathFiles(child);
            }
        } else {
            file.delete();
        }
    }
}
