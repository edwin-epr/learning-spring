package org.edwinepr.resttemplateapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProjectConfig {

    @Bean
    RestTemplate rest() {
        return new RestTemplate();
    }
}
