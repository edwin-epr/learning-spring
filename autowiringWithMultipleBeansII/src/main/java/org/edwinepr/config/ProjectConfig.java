package org.edwinepr.config;

import org.edwinepr.beans.Parrot;
import org.edwinepr.beans.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "org.edwinepr.beans")
public class ProjectConfig {
    @Bean
    public Parrot parrotA() {
        Parrot parrot = new Parrot();
        parrot.setName("Pako");
        return parrot;
    }

    @Bean
    public Parrot parrotB() {
        Parrot parrot = new Parrot();
        parrot.setName("Mako");
        return parrot;
    }
}
