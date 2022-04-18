package top.vchao.dream.generate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import top.vchao.dream.generate.util.StringUtil;

import java.util.Collections;

public class GenCommon {
    public static String url = "jdbc:mysql://182.92.235.182:3306/dream?autoReconnect=true&useUnicode=true" +
            "&characterEncoding=utf8&zeroDateTimeBehavior=CONVERT_TO_NULL" +
            "&useSSL=false&serverTimezone=Asia/Shanghai&nullCatalogMeansCurrent=true";
    public static String username = "vchao";
    public static String password = "vchao123";
    public static String packageName = "top.vchao.dream";
    public static String version = "v1";

    public static FastAutoGenerator getAutoGenerator(String moduleName, String tableName) {
        String projectDir = System.getProperty("user.dir");

        return FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("vchao")
                            .disableOpenDir()
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(projectDir + "/src/main/java/"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(packageName + "." + version + ".modules") // 设置父包名
                            .moduleName(moduleName)
                            .other("")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, projectDir + "/src/main/resources/mybatis")); // 设置mapperXml生成路径
                })
                .injectionConfig(builder -> {
                    builder.customMap(Collections.singletonMap("apiVersion", version))
                            .customFile(Collections.singletonMap("request/" + StringUtil.firstUp(moduleName) + "Request.java", "/templates/request.java.ftl"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tableName) // 设置需要生成的表名
                            .addTablePrefix("pro_", "t_")// 设置过滤表前缀
                            .entityBuilder()
                            .idType(IdType.AUTO)
                            .enableLombok()
                            .addIgnoreColumns("create_user", "update_user")
                            .enableTableFieldAnnotation()
                            .logicDeleteColumnName("deleted")
                            .controllerBuilder()
                            .enableRestStyle()
                            .mapperBuilder()
                            .enableMapperAnnotation();
                })
                .templateEngine(new FreemarkerTemplateEngine());
    }


}
