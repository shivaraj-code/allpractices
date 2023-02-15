
package com.kavanant.codesystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket swaggerCodeSystemApi() {
		return new Docket(DocumentationType.SWAGGER_2).enableUrlTemplating(false).select()
				.apis(RequestHandlerSelectors.basePackage("com.kavanant.codesystem")).paths(PathSelectors.any()).build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("CodeSystem API")
						.description("Documentation for CodeSystem Api").build());
	}

}
