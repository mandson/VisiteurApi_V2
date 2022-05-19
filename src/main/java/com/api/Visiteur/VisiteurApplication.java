package com.api.Visiteur;

import com.api.Visiteur.services.initService.serviceInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication

public class VisiteurApplication   implements CommandLineRunner {

	@Autowired
	private serviceInit initialise;

	public static void main(String[] args) {
		SpringApplication.run(VisiteurApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//initialise.initMenu();
	//	initialise.initRole();
	//	initialise.initEntreprise();
	//	initialise.initDepartement();
		//initialise.initUser();
		//initialise.initMenuContent();
	}
}
