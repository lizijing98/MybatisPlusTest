package com.example.mybatisplustest.component;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {

    private static final String author = "LiZijing";
    private static final String url = "jdbc:mysql://localhost:3306/my_testdb?autoReconnect=true&autoReconnectForPools=true&useUnicode=true&character_set_server=utf8mb4&serverTimezone=Asia/Shanghai";
    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "123456";
    private static final String parent = "com.example.mybatisplustest";
    private static final String projectModule = "";
    private static final String functionModule = "";
    private static final String tableName = "tb_user";
    private static final String projectPath = System.getProperty("user.dir");

    public static void main(String[] args) {
        generator(author, url, driverName, username, password, parent, projectModule, functionModule, tableName);
    }

    /**
     * Mybatis一键生成entity,mapper,mapper.xml,service,serviceImpl,controller
     *
     * @param author         开发人员
     * @param url            驱动连接的URL
     * @param driverName     驱动名称
     * @param username       数据库连接用户名
     * @param password       数据库连接密码
     * @param parent         父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
     * @param projectModule  项目模块包名
     * @param functionModule 功能模块包名
     * @param tableName      表名，多个英文逗号分割
     */
    public static void generator(String author,
                                 String url,
                                 String driverName,
                                 String username,
                                 String password,
                                 String parent,
                                 String projectModule,
                                 String functionModule,
                                 String tableName) {
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(globalConfig(author, projectModule));
        mpg.setDataSource(dataSourceConfig(url, driverName, username, password));
        mpg.setPackageInfo(packageConfig(parent, functionModule));
        mpg.setTemplate(templateConfig());
        mpg.setStrategy(strategyConfig(tableName));
        mpg.setCfg(injectionConfig());
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }

    /**
     * 全局配置
     *
     * @param author        开发人员
     * @param projectModule 项目模块包名
     * @return GlobalConfig
     */
    private static GlobalConfig globalConfig(String author, String projectModule) {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(projectPath + "/" + projectModule + "/src/main/java");
        globalConfig.setFileOverride(true);
        globalConfig.setAuthor(author);
        globalConfig.setSwagger2(true);
        globalConfig.setOpen(false);
        globalConfig.setEnableCache(false);
        globalConfig.setKotlin(false);
        globalConfig.setActiveRecord(true);
        globalConfig.setBaseResultMap(false);
        globalConfig.setBaseColumnList(false);
        globalConfig.setIdType(IdType.AUTO);
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setEntityName("");
        globalConfig.setMapperName("");
        globalConfig.setXmlName("");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sImpl");
        globalConfig.setControllerName("%sController");
        return globalConfig;
    }

    /**
     * 数据源设置
     *
     * @param url        驱动连接的URL
     * @param driverName 驱动名称
     * @param username   数据库连接用户名
     * @param password   数据库连接密码
     * @return DataSourceConfig
     */
    private static DataSourceConfig dataSourceConfig(String url,
                                                     String driverName,
                                                     String username,
                                                     String password) {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl(url);
        dataSourceConfig.setDriverName(driverName);
        dataSourceConfig.setUsername(username);
        dataSourceConfig.setPassword(password);
        return dataSourceConfig;
    }

    /**
     * 包配置
     *
     * @param parent         父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
     * @param functionModule 功能模块包名
     * @return PackageConfig
     */
    private static PackageConfig packageConfig(String parent, String functionModule) {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(parent);
        String fM;
        if (functionModule.equals("")) {
            fM = "";
        } else {
            fM = "." + functionModule;
        }
        packageConfig.setEntity("entity" + fM);
        packageConfig.setService("service" + fM);
        packageConfig.setServiceImpl("service.impl" + fM);
        packageConfig.setMapper("mapper" + fM);
        packageConfig.setController("controller" + fM);
        return packageConfig;
    }

    /**
     * 模板路径配置项
     *
     * @return TemplateConfig
     */
    private static TemplateConfig templateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        return templateConfig;
    }

    /**
     * 自定义配置项
     *
     * @return InjectionConfig
     */
    private static InjectionConfig injectionConfig() {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/" + projectModule + "/src/main/resources/mapper/" + projectModule
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(focList);
        return injectionConfig;
    }

    /**
     * 策略配置
     *
     * @param tableName 数据库表名称，多个用英文逗号隔开
     * @return StrategyConfig
     */
    private static StrategyConfig strategyConfig(String tableName) {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setSuperEntityColumns("id");
        strategyConfig.setInclude(tableName);
        strategyConfig.setControllerMappingHyphenStyle(true);
        strategyConfig.setLogicDeleteFieldName("is_deleted");
        strategyConfig.setTablePrefix("tb_");

        // 自动填充设置
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategyConfig.setTableFillList(tableFills);

        // 乐观锁
        strategyConfig.setVersionFieldName("version");
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setControllerMappingHyphenStyle(true);

        return strategyConfig;
    }
}