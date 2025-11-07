package com.example.Alumni.Security;

import org.springframework.context.annotation.*;
import org.springframework.web.cors.*;
import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        // ✅ Allow your Netlify app + localhost for development
        config.setAllowedOrigins(Arrays.asList(
            "https://nextstepcampusconnect.netlify.app",
            "http://localhost:3000",
            "http://localhost:5173"
        )); // frontend URLs
        config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        config.setAllowCredentials(true);
        

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
