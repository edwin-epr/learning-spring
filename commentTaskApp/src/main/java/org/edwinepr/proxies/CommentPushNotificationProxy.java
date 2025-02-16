package org.edwinepr.proxies;

import org.edwinepr.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PUSH")
public class CommentPushNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendCommentNotification(Comment comment) {
        System.out.println("Sending push comment notification for comment: "
                + comment.getText());
    }
}
