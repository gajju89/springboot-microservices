package com.example.gallerymicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GallerymicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GallerymicroserviceApplication.class, args);
	}
}
