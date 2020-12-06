package com.cg.ohds;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class MySwaggerConfig {
	@Bean
	public Docket customerApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(customerData()).select().paths(regex("/Customer.*")).build();
	}
	private ApiInfo customerData() {
		return new ApiInfoBuilder().title("Online Home Decor Shopping").description("Operations on customer and cart").build();	
	}
}
