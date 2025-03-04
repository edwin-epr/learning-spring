package org.edwinepr.springwebscopes.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "org.edwinepr.springwebscopes")
public class SpringWebScopesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebScopesApplication.class, args);
    }

}
