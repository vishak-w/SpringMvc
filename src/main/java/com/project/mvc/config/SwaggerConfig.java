package com.project.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}
		Predicate<String> postPaths() {
			return or(regex("/employees.*"), regex("/employees.*"));
		}

		private ApiInfo apiInfo() {
			return new ApiInfoBuilder().title("Employee Details API")
					.description(" API reference for developers")
					.termsOfServiceUrl("http://vishak.com")
					.contact("vishak634@gmail.com").license(" License")
					.licenseUrl("vishak634@gmail.com").version("1.0").build();
		}
	}
	

