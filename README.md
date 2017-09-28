# myframework-autocode
### 自动生成mybatis代码
#### 可以根据excel文件数据库设计或者数据库定义生成java Dao Mybatis配置文件 实体类等代码
#### 目前支持了mysql，postgresql

## 怎么使用本项目？
* #### 克隆本项目源代码
    ```
    git clone https://github.com/zhaoweijsha/myframework-autocode
    ```
* #### 安装编译
    ```
    mvn package
    ```
* #### 配置autocode.xml文件
    拷贝resources下autocode.xml到生成的jar包同一目录下
    ```
    <?xml version="1.0" encoding="UTF-8"?>
    <autocode>
        <!--1:数据库定义xls   2:直接读数据库-->
        <generate-type>2</generate-type>
        <!--数据库定义文件地址 -->
        <db-define-file>/doc/数据表设计.xlsx</db-define-file>
        <!--数据库 MYSQL(1), SQLSERVER(2), ORACLE(3), POSTGRESQL(3); 目前只支持mysql postgresql -->
        <db-type>mysql</db-type>
        <!--数据库驱动 -->
        <db-driver>com.mysql.jdbc.Driver</db-driver>
        <!--数据库连接地址 -->
        <db-url>jdbc:mysql://127.0.0.1:3306/by_shop?useUnicode=true&characterEncoding=utf8</db-url>
        <!--数据库用户名 -->
        <db-user>test</db-user>
        <!--数据库密码 -->
        <db-password>test</db-password>
        <!--数据库表 -->
        <db-tables>test</db-tables>
    
        <!-- 1:原生javaDao  2:接口型dao，mybatis实例化 -->
        <dao-type>2</dao-type>
        <output-path>/out/</output-path>
        <output-package>com.autocode</output-package>
        <module-name>test</module-name>
        <db-prefix></db-prefix>
        <dao-suffix>Mapper</dao-suffix>
        <entity-suffix>Entity</entity-suffix>
    </autocode>
    ```
* #### 运行程序
    ```
    java -jar myframework-autocode-jar-with-dependencies.jar --configfile autocode.xml
    ```