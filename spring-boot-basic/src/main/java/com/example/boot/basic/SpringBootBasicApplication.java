package com.example.boot.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author dell
 */

@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})
@EnableOpenApi
public class SpringBootBasicApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootBasicApplication.class, args);
    }

}
