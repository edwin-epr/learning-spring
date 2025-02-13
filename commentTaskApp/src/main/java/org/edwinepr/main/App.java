package org.edwinepr.main;

import org.edwinepr.model.Comment;
import org.edwinepr.proxies.CommentNotificationProxy;
import org.edwinepr.proxies.EmailCommentNotificationProxy;
import org.edwinepr.repositories.CommentRepository;
import org.edwinepr.repositories.DBCommentRepository;
import org.edwinepr.services.CommentService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CommentRepository commentRepository = new DBCommentRepository();
        CommentNotificationProxy commentNotificationProxy = new EmailCommentNotificationProxy();

        CommentService commentService =
                new CommentService(
                        commentRepository, commentNotificationProxy);

        Comment comment = new Comment();
        comment.setAuthor("Marianne");
        comment.setText("Dios te cuide!");

        commentService.publishComment(comment);
    }
}
