package net.dnadas.freeroam_gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class CorsConfig {
  private final String FRONTEND_URL;

  @Autowired
  CorsConfig(@Value("${FREEROAM_FRONTEND_URL}") String FRONTEND_URL) {
    this.FRONTEND_URL = FRONTEND_URL;
  }

  @Bean
  CorsWebFilter corsWebFilter() {
    CorsConfiguration corsConfig = new CorsConfiguration();
    corsConfig.setAllowedOrigins(Arrays.asList(FRONTEND_URL));
    corsConfig.setMaxAge(8000L);
    corsConfig.addAllowedMethod("GET");
    corsConfig.addAllowedMethod("POST");
    corsConfig.addAllowedMethod("PUT");
    corsConfig.addAllowedMethod("PATCH");
    corsConfig.addAllowedMethod("DELETE");
    UrlBasedCorsConfigurationSource source =
      new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig);
    return new CorsWebFilter(source);
  }
}
