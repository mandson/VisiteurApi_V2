package com.api.Visiteur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication

public class VisiteurApplication  {

	public static void main(String[] args) {
		SpringApplication.run(VisiteurApplication.class, args);
	}

}
