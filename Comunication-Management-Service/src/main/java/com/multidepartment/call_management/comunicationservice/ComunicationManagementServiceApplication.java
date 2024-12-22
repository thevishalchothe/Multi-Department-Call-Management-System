package com.multidepartment.call_management.comunicationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@SpringBootApplication
public class ComunicationManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComunicationManagementServiceApplication.class, args);
	}
	

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
