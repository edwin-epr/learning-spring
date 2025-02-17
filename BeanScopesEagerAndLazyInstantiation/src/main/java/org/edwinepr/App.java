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
        System.out.println("Before retrieving the CommentService");
        var service = context.getBean(CommentService.class);
        System.out.println("After retrieving the CommentService");
    }
}
