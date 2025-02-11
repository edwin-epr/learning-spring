package org.edwinepr.config;

import org.edwinepr.beans.Parrot;
import org.edwinepr.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("Pako");
        return parrot;
    }

    @Bean
//    public Person person() { // firsts way
    public Person person(Parrot parrot) { // second way
        Person person = new Person();
        person.setName("Marianne");
//        person.setParrot(parrot()); // First way
        person.setParrot(parrot); // Second way

        return person;
    }
}
