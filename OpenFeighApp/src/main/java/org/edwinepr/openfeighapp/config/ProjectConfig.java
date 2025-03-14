package org.edwinepr.openfeighapp.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(
        basePackages = "org.edwinepr.openfeighapp.proxy")
public class ProjectConfig {
}
