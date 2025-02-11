package org.edwinepr.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class Person {
    private String name = "Marianne";

    @Autowired
    private Parrot parrot;
}
