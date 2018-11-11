package com.dialog.exam.shopping_cart.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfoBuilder()
						.title("Shopping Cart APIs")
						.description("Shopping Cart Description")
						.version("v1").build())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.dialog.exam.shopping_cart.controller"))
				.build();
	}
}
