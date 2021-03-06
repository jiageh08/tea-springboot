package com.bdxh.client.configration.common;


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
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket buildDocket() {
        List<Parameter> list = Arrays.asList(
                new ParameterBuilder()
                        .name("Authorization")
                        .defaultValue("BDXH_TEST")
                        .description("访问令牌")
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .build()
        );
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo()).globalOperationParameters(list).select()
                .apis(RequestHandlerSelectors.basePackage("com.bdxh.client"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("北斗星航核心业务系统")
                .description("学校管理平台")
                .version("1.0")
                .build();
    }

}
