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
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service1 = context.getBean(CommentService.class);
        var service2 = context.getBean(CommentService.class);
        boolean isSameBean = service1 == service2;
        System.out.println("Is it the same bean? " + isSameBean);
    }
}
