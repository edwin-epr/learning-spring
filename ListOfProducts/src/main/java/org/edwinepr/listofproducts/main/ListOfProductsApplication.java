package org.edwinepr.listofproducts.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.edwinepr.listofproducts")
public class ListOfProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListOfProductsApplication.class, args);
    }

}
