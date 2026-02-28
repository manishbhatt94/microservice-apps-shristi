package com.productcatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShipkartProductcatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShipkartProductcatalogServiceApplication.class, args);
	}

}
