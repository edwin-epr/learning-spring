package org.edwinepr;

import org.edwinepr.services.CommentService;
import org.edwinepr.services.UserService;
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
        var service2 = context.getBean(UserService.class);
        boolean isSameBean = service1.getCommentRepository() == service2.getCommentRepository();
        System.out.println("Is it the same bean? " + isSameBean);
    }
}
