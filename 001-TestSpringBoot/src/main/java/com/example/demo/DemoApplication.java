package com.example.demo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

/**
 * @author xxx
 */
@SpringBootApplication
@MapperScan("com.example.demo.**.mapper")
public class DemoApplication {

//    private final LibraryProperties libraryProperties;
//
//    public DemoApplication(LibraryProperties libraryProperties) {
//        System.out.println(libraryProperties);
//        this.libraryProperties = libraryProperties;
//    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
//        Runnable runnable = () -> {
//            while (true) {
//                System.out.println("等待1....");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        Thread thread = new Thread(runnable);
//        thread.start();
    }

    /**
     * mp 逆向工程生成实体类
     */
    @Test
    void contextLoads() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/SSA?useUnicode=true&characterEncoding=utf8&useSSL=false&nullCatalogMeansCurrent=true&serverTimezone=Asia/Shanghai", "root", "123")
                .globalConfig(builder -> {
                    builder.author("xiongqiang ") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("/Users/xxx/IdeaProjects/data-structure-node/001-TestSpringBoot/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example") // 设置父包名
                            .moduleName("tsmybatis") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "/Users/xxx/IdeaProjects/data-structure-node/001-TestSpringBoot/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
