package com.dialog.exam.shopping_cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author mchat
 *
 */
@SpringBootApplication
@EnableSwagger2
public class ShoppingCartApplication {
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(ShoppingCartApplication.class, args);
	}
}
