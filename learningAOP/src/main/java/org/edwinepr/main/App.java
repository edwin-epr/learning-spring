package org.edwinepr.main;

import org.edwinepr.config.ProjectConfig;
import org.edwinepr.model.Comment;
import org.edwinepr.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Learning AOP
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var contex = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = contex.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("This is a comment");
        comment.setAuthor("Edwinepr");

        service.publishComment(comment);
    }
}
