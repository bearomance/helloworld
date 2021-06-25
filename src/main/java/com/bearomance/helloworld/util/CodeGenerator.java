package com.bearomance.helloworld.util;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.InputStream;
import java.util.Properties;

public class CodeGenerator {

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("xmj");
        gc.setOpen(false);
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        Properties properties = getProperties();
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(properties.getProperty("spring.datasource.url"));
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(properties.getProperty("spring.datasource.username"));
        dsc.setPassword(properties.getProperty("spring.datasource.password"));
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.bearomance.helloworld");
        pc.setEntity("model.entity");
        pc.setMapper("model.mapper");
        pc.setService("service");
        mpg.setPackageInfo(pc);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        templateConfig.setController(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    private static Properties getProperties() {

        Properties properties = new Properties();
        try {
            InputStream in = CodeGenerator.class.getResourceAsStream("/application.properties");
            properties.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
