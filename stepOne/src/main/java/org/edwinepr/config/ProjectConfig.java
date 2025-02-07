package org.edwinepr.config;

import org.edwinepr.main.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean(name = "koko")
    @Primary
    Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("Koko");
        return parrot;
    }

    @Bean(name = "tiki")
    Parrot parrot1() {
        Parrot parrot = new Parrot();
        parrot.setName("Tiki");
        return parrot;
    }

    @Bean(name = "miki")
    Parrot parrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("Miki");
        return parrot;
    }

    @Bean(name = "riki") // Si le doy un nombre al bean se anula el nombre de la funcion
    Parrot parrot3() {
        Parrot parrot = new Parrot();
        parrot.setName("Riki");
        return parrot;
    }

    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer ten() {
        return 10;
    }
}
