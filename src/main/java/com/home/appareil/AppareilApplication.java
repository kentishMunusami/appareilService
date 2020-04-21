package com.home.appareil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={
"com.home.dao", "com.home.service", "com.home.controller", "com.home.filter"})
@EntityScan("com.home.bean")
@EnableJpaRepositories(basePackages = {
	    "com.home.dao"
	})
public class AppareilApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppareilApplication.class, args);
	}

}
