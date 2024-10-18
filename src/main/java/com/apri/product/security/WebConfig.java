package com.apri.product.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // mengizinkan semua endpoint
                .allowedOrigins("http://localhost:3000") // ganti dengan URL frontend Anda
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
