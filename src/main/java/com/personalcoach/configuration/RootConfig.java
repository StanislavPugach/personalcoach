package com.personalcoach.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistenceConfig.class, ServiceConfig.class, SecurityConfig.class})
public class RootConfig {
}
