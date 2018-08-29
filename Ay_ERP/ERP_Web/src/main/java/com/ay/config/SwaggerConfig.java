package com.ay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author AndyLi
 * using this Configureation class to initiate Swagger ui CREATED by spring application
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(createApiInfo())
				.select()
				//select()method return back  ApiSelectorBuilder instance to control which API should be shown using Swagger , in this configuration we will scan the the class underlyying specifical package
				//，Swagger will scan all the controller under package:com.aiatss.coast to create document except for method annotated @ApiIgnore
				.apis(RequestHandlerSelectors.basePackage("com.ay"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo createApiInfo() {
		return  new ApiInfoBuilder()
				.title("restful API")
				//.description("")
				.termsOfServiceUrl("http://google.com")
				//.contact("COAST NFR")
				.version("0.0.1-SNAPSHOT")
				.build();
	}
}
