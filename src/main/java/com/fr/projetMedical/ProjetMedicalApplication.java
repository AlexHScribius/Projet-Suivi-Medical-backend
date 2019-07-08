package com.fr.projetMedical;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableAutoConfiguration

@ComponentScan(basePackages="com.fr.projetMedical")

@EnableJpaRepositories("com.fr.projetMedical.repository")
public class ProjetMedicalApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/projetMedical");

		SpringApplication.run(ProjetMedicalApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

}
