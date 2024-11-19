package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Add global CORS configuration for all endpoints under '/api/**'
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200")  // Allow only Angular app's origin
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow specific HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true)  // Allow sending credentials (cookies, authorization headers)
                .maxAge(3600);  // Cache preflight response for 1 hour (optional)
    }
}
