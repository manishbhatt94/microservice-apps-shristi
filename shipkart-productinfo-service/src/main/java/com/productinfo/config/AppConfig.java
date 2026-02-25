package com.productinfo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

	// 1. Eureka-Client and External APIs use this RestClient.Builder bean
	// (No Load Balancing) using standard DNS.
	// Marked as Primary so that Eureka-Client picks up this RestClient.Builder bean
	// for connecting to Eureka-Server (i.e. to http://localhost:8761)
	@Bean
	@Primary
	RestClient.Builder standardRestClientBuilder() {
		return RestClient.builder();
	}

	// 2. Our application uses this RestClient.Builder bean for inter-service
	// communication to services registered on Eureka-Registry like
	// 'product-catalog' (With Load Balancing using logical host-names like
	// http://product-cataglog/ instead of actual physical host-names)
	@Bean
	@LoadBalanced
	RestClient.Builder loadBalancedRestClientBuilder() {
		return RestClient.builder();
	}

}
