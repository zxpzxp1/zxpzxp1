package com.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @className: StartupApplication
 * @description: TODO 启动类
 * @author: zxp
 * @date: 2022-03-01 19:37
 **/
@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
@EnableConfigurationProperties
@EnableTransactionManagement
@EnableCaching
@EnableSwagger2
@EnableAsync
public class StartupApplication {
    private static Logger logger = LoggerFactory.getLogger(StartupApplication.class);
    public static void main(String[] args) {
        String path = "http://127.0.0.1:3333/doc.html";
        SpringApplication.run(StartupApplication.class, args);
        logger.info(
                "\nAccess URLs:\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\t"
                        + path + "\n\t" +
                        "\t\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\t"
        );
    }
}

