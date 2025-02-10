package org.edwinepr;

import org.edwinepr.beans.Parrot;
import org.edwinepr.beans.Person;
import org.edwinepr.config.ProjectConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
public class AppTest {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Test that a Parrot instance has been added to the Spring context")
    public void testKokoIsInTheSpringContext() {
        Parrot p = context.getBean(Parrot.class);

        assertEquals("Pako", p.getName());
    }

    @Test
    @DisplayName("Test that a Person instance has been added to the Spring context")
    public void testEllaIsInTheSpringContext() {
        Person p = context.getBean(Person.class);

        assertEquals("Marianne", p.getName());
    }

    @Test
    @DisplayName("Test that the Person instance in the Spring context" +
            "doesn't own the Parrot instance from the Spring context")
    public void testEllaDoesNotOwnKoko() {
        Person p = context.getBean(Person.class);

        assertNull(p.getParrot());
    }
}
