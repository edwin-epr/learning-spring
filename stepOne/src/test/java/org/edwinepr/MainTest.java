package org.edwinepr;

import org.edwinepr.config.ProjectConfig;
import org.edwinepr.main.Parrot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class MainTest {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Test that a Parrot instance " +
            "with the attribute name having the value Koko " +
            "has been added to the Spring context.")
    public void testKokoIsInTheSpringContext() {
        Parrot p = context.getBean("parrot", Parrot.class);
//        Parrot p = context.getBean(Parrot.class); // Si no hubiera varios beans del mismo tipo

        assertEquals("Koko", p.getName());
    }

    @Test
    @DisplayName("Test that Parrot instance named parrot1 has the name Tiki.")
    public void testParrot1HasTheNameTiki() {
        Parrot parrot = context.getBean("parrot1", Parrot.class);
        assertEquals("Tiki", parrot.getName());
    }

    @Test
    @DisplayName("Test that Parrot instance named parrot2 has the name Miki.")
    public void testParrot2HasTheNameMiki() {
        Parrot parrot = context.getBean("parrot2", Parrot.class);
        assertEquals("Miki", parrot.getName());
    }

    @Test
    @DisplayName("Test that Parrot instance named parrot1 has the name Tiki.")
    public void testParrot3HasTheNameRiki() {
        Parrot parrot = context.getBean("parrot3", Parrot.class);
        assertEquals("Riki", parrot.getName());
    }

    @Test
    @DisplayName("Test that Parrot instance named miki has the name Miki.")
    public void testParrotMikiHasTheNameMiki() {
        Parrot p = context.getBean("miki", Parrot.class);

        assertEquals("Miki", p.getName());
    }

    @Test
    @DisplayName("Test that the Parrot instance parrot named Koko is primary")
    public void testParrot2IsPrimary() {
        Parrot p = context.getBean(Parrot.class);

        assertEquals("Koko", p.getName());
    }

    @Test
    @DisplayName("Test that the String 'hello' " +
            "has been added to the Spring context.")
    public void testHelloIsInTheSpringContext() {
        String s = context.getBean(String.class);

        assertEquals("Hello", s);
    }

    @Test
    @DisplayName("Test that the Integer 10 " +
            "has been added to the Spring context.")
    public void test10IsInTheSpringContext() {
        Integer i = context.getBean(Integer.class);

        assertEquals(10, i);
    }
}
