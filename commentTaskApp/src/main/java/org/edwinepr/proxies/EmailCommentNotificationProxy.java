package org.edwinepr.proxies;

import org.edwinepr.model.Comment;

public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendCommentNotification(Comment comment) {
        System.out.println("Sending comment notification to email: "
                            + comment.getText());
    }
}
