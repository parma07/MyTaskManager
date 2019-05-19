package com.cts.taskmanagerservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories
public class TaskManagerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerServiceApplication.class, args);
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build().apiInfo(apiInfo());                                         
    }
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Task Manger API", 
	      "Some custom description of API.", 
	      "API TOS", 
	      "", 
	      new Contact("Parmanand Singh", "https://cognizant.com", "parmanand.singh@cognizant.com"), 
	      "License of API", "API license URL", Collections.emptyList());
	}

}
