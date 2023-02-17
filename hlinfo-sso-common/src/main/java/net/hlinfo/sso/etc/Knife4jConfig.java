package net.hlinfo.sso.etc;

import java.util.ArrayList;
import java.util.List;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.collect.Lists;

import net.hlinfo.opt.Jackson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
@EnableKnife4j
public class Knife4jConfig {
	@Value("${spring.application.name}")
	private String name;
	
    @Bean
    public Docket createRestApi() {
    	String serverName = name.replace("sso", "");
    	String basePackages = "net.hlinfo.sso."+serverName+".controller";
        Docket docket=new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                   //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage(basePackages))
                .paths(PathSelectors.any())
                .build()
                .globalRequestParameters(getGlobalRequestParameters());
        return docket;
    }
    
    private ApiInfo apiInfo() {
        Contact contact = new Contact("hlinfo.net","http://github.com/hlinfocc/","service@hlinfo.net");
        return new ApiInfoBuilder()
                .title("hlinfo-SSO文档中心")
                .description("hlinfo-SSO服务接口模块")
                .termsOfServiceUrl("http://hlinfo.net/")
                .contact(contact)
                .version("2.0")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("BearerToken", "Authorization", "header");
    }
    private ApiKey apiKey1() {
        return new ApiKey("BearerToken1", "Authorization-x", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }
    private SecurityContext securityContext1() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth1())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }
    List<SecurityReference> defaultAuth1() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("BearerToken1", authorizationScopes));
    }
    
    //生成全局通用参数 v3.x
    private List<RequestParameter> getGlobalRequestParameters() {
	    List<RequestParameter> parameters = new ArrayList<>();
	    parameters.add(new RequestParameterBuilder()
	            .name("satoken")
	            .description("接口校验参数")
	            .required(false)
	            .in(ParameterType.HEADER)
	            .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
	            .required(false)
	            .build());
	     return parameters;
	}
}