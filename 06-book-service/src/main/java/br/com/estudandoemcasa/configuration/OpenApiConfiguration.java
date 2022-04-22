package br.com.estudandoemcasa.configuration;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(info = @Info(title = "Book Sercive API", version = "v1", description = "Documentation of Book Service API"))
public class OpenApiConfiguration {

	@Bean
	private OpenAPI customOpenApi() {
		return new OpenAPI().components(new Components())
				.info(new io.swagger.v3.oas.models.info.Info().title("Book Sercive API").version("V1")
						.license(new License().name("Miguel Programmer S.A").url("http://springdoc.org")));
	}
}
