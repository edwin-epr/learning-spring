package org.edwinepr.main;

import org.edwinepr.config.ProjectConfig;
import org.edwinepr.model.Comment;
import org.edwinepr.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

/**
 * Learning AOP
 *
 */
public class App 
{
    public static Logger logger = Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("This is a comment");
        comment.setAuthor("Edwinepr");

        String value = service.publishComment(comment);

        logger.info(value);
    }
}
