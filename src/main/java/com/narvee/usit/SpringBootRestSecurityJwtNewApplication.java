package com.narvee.usit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringBootRestSecurityJwtNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestSecurityJwtNewApplication.class, args);
	}

}
