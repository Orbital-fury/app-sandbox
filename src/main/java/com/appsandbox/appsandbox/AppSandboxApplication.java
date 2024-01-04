package com.appsandbox.appsandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Sandbox API", version = "1.0", description = "REST API of personnal sandbox application"))
public class AppSandboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSandboxApplication.class, args);
	}

}
