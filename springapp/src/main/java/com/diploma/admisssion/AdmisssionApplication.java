package com.diploma.admisssion;


import com.diploma.admisssion.service.FileStorageProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class AdmisssionApplication {

	public static void main(String[] args) {
		System.setProperty("spring.main.lazy-initialization", "true");
		SpringApplication.run(AdmisssionApplication.class, args);

		// main 

		
		
	}

}
