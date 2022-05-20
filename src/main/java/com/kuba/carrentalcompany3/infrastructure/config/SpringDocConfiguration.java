package com.kuba.carrentalcompany3.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("carrentalcompany-public")
                .pathsToMatch("/employee/**","/office/**")
                .build();
    }

    @Bean
    public OpenAPI applicationOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("CarRentalComapany3 API")
                        .description("CarRentalCompany3 API application")
                        .version("v0.0.1"));
    }
}
