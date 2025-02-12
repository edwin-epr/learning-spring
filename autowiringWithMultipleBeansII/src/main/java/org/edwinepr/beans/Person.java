package org.edwinepr.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@Component
public class Person {
    private String name = "Marianne";

    private final Parrot parrot;

    public Person(@Qualifier("parrotB") Parrot parrot) {
        this.parrot = parrot;
    }

}
