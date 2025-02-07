package org.edwinepr.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot parrot = new Parrot();
        parrot.setName("Pako");

        Supplier<Parrot> parrotSupplier = () -> parrot;

//        context.registerBean(Parrot.class, parrotSupplier);
//        context.registerBean("parrotA", Parrot.class, parrotSupplier);
        context.registerBean("parrotA", Parrot.class, parrotSupplier, bc -> bc.setPrimary(true));
        Parrot parrotA = context.getBean(Parrot.class);
        System.out.println(parrotA.getName());
    }
}
