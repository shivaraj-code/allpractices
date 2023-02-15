package com.kavanant.codesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import exceptions.GlobalControllerExceptionHandler;

@SpringBootApplication
//(exclude = {ErrorMvcAutoConfiguration.class})


@Import(GlobalControllerExceptionHandler.class)

public class CodesystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodesystemApplication.class, args);
	}
    
}


