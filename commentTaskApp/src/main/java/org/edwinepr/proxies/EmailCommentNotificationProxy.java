package org.edwinepr.proxies;

import org.edwinepr.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("EMAIL")
public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendCommentNotification(Comment comment) {
        System.out.println("Sending comment notification to email: "
                            + comment.getText());
    }
}
