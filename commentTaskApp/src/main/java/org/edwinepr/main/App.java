package org.edwinepr.main;

import org.edwinepr.config.ProjectConfiguration;
import org.edwinepr.model.Comment;
import org.edwinepr.proxies.CommentNotificationProxy;
import org.edwinepr.proxies.EmailCommentNotificationProxy;
import org.edwinepr.repositories.CommentRepository;
import org.edwinepr.repositories.DBCommentRepository;
import org.edwinepr.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        CommentService commentService = context.getBean(CommentService.class);
        
        Comment comment = new Comment();
        comment.setAuthor("Marianne");
        comment.setText("Dios te cuide!");

        commentService.publishComment(comment);
    }
}
