package com.backend.chorus;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allows all paths
                .allowedOrigins("http://localhost:3000") // Replace with your frontend's URL
                .allowedMethods("GET", "POST", "PUT", "DELETE") // HTTP methods you want to allow
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow credentials such as cookies
    }
}
