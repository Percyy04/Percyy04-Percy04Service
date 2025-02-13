package com.percy04demo1.percy04demo1;

import org.mapstruct.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.percy04demo1.percy04demo1.entity")
@EnableJpaRepositories(basePackages = "com.percy04demo1.percy04demo1.repository")
public class Percy04demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Percy04demo1Application.class, args);

	}

}
