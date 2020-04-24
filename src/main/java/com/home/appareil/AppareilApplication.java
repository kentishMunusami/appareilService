package com.home.appareil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages={
"com.home.dao", "com.home.service", "com.home.controller", "com.home.security"})
@EntityScan("com.home.bean")
@EnableJpaRepositories(basePackages = {
	    "com.home.dao"
	})
public class AppareilApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppareilApplication.class, args);
	}
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
