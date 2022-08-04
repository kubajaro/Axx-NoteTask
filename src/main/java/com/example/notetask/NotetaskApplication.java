package com.example.notetask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class NotetaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotetaskApplication.class, args);
	}

	@Bean
	Validator validate() {
		return new LocalValidatorFactoryBean();
	}
}
