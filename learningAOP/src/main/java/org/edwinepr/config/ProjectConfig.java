package org.edwinepr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.edwinepr.services"})
public class ProjectConfig {
}
