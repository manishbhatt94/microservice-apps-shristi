package com.demo.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceRegistry01Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceRegistry01Application.class, args);
	}

}
