package com.backend.chorus;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String[] origins={"https://chorusplay.vercel.app","http://localhost:3000"};
        registry.addMapping("/**") // Allows all paths
                .allowedOrigins(origins) // Replace with your frontend's URL
                .allowedMethods("GET", "POST", "PUT", "DELETE") // HTTP methods you want to allow
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow credentials such as cookies
    }
}
