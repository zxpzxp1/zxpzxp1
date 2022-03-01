package com.homework.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Swagger3Config {
    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        //header中的token参数非必填，传空也可以
        tokenPar.name("token").description("请求接口所需Token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.homework.core.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

    /**
     * 设置Swagger2
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("图像数据质量评估 API文档")
                .description("图像数据质量评估 API文档")
                .version("1.0")
                .build();
    }
}
