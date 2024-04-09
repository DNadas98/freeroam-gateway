package net.dnadas.freeroam_gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "file:./.env", ignoreResourceNotFound = true)
public class PropertyConfig {
}
