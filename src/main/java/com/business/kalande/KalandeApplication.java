package com.business.kalande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class KalandeApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(KalandeApplication.class, args);
	}
}
