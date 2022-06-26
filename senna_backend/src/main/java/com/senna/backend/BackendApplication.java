package com.senna.backend;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import antlr.StringUtils;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	// @Bean
	// public Docket productApi() {
	// return new Docket(DocumentationType.SWAGGER_2).select()
	// .apis(RequestHandlerSelectors.basePackage("com.senna.backend")).build();
	// }

	// @Bean
	// public <ServletEndpointsSupplier,
	// ControllerEndpointsSupplier,WebMvcEndpointHandlerMapping,
	// WebEndpointsSupplier, EndpointMediaTypes, CorsEndpointProperties,
	// WebEndpointProperties, Environment> WebMvcEndpointHandlerMapping
	// webEndpointServletHandlerMapping(WebEndpointsSupplier webEndpointsSupplier,
	// ServletEndpointsSupplier servletEndpointsSupplier,
	// ControllerEndpointsSupplier controllerEndpointsSupplier,
	// EndpointMediaTypes endpointMediaTypes, CorsEndpointProperties corsProperties,
	// WebEndpointProperties webEndpointProperties, Environment environment) {
	// List<ExposableEndpoint<?>> allEndpoints = new ArrayList();
	// Collection<ExposableWebEndpoint> webEndpoints =
	// webEndpointsSupplier.getEndpoints();
	// allEndpoints.addAll(webEndpoints);
	// allEndpoints.addAll(servletEndpointsSupplier.getEndpoints());
	// allEndpoints.addAll(controllerEndpointsSupplier.getEndpoints());
	// String basePath = webEndpointProperties.getBasePath();
	// EndpointMapping endpointMapping = new EndpointMapping(basePath);
	// boolean shouldRegisterLinksMapping =
	// this.shouldRegisterLinksMapping(webEndpointProperties, environment,
	// basePath);
	// return new WebMvcEndpointHandlerMapping(endpointMapping, webEndpoints,
	// endpointMediaTypes,
	// corsProperties.toCorsConfiguration(), new EndpointLinksResolver(allEndpoints,
	// basePath),
	// shouldRegisterLinksMapping, null);
	// }

	// private boolean shouldRegisterLinksMapping(WebEndpointProperties
	// webEndpointProperties, Environment environment,
	// String basePath) {
	// return webEndpointProperties.getDiscovery().isEnabled() &&
	// (StringUtils.hasText(basePath)
	// || ManagementPortType.get(environment).equals(ManagementPortType.DIFFERENT));
	// }

}
