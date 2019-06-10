package com.paqui.openBankRestAPI.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan(basePackages = "com.cpaqui.openBankRestAPI")
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket produceApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cpaqui.openBankRestAPI.controller"))
                .paths(PathSelectors.regex("/*"))
                .build();
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Open Bank Management Rest APIs")
                .description("This page lists all the rest apis for Open Bank Management App.")
                .version("1.0-SNAPSHOT")
                .build();
    }
}