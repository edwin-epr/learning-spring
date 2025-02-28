package org.edwinepr.dynamicview.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.edwinepr.dynamicview")
public class DynamicViewApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicViewApplication.class, args);
    }

}
