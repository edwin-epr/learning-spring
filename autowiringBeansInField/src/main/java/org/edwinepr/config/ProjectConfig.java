package org.edwinepr.config;

import org.edwinepr.beans.Parrot;
import org.edwinepr.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.edwinepr.beans")
public class ProjectConfig {
}
