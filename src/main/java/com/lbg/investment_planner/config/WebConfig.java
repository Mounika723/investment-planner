package com.lbg.investment_planner.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // or specify a more specific path
                .allowedOrigins("https://banking-empowerment-qfv5rs5xfa-uc.a.run.app") // allows only requests from this origin
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // specify the allowed methods
    }
}

