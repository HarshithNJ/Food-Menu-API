package org.food_menu.food_menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Food Menu API", version = "1.0", description = "A API for Managing Food Menu Items",
				contact = @Contact(name = "Harshith N J", email = "Harshith.dev2024@outlook.com")))
public class FoodMenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodMenuApplication.class, args);
	}

}
