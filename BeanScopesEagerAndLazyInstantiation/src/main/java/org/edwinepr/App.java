package org.edwinepr;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var service = new AnnotationConfigApplicationContext(ProjectConfig.class);
    }
}
