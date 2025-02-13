package org.edwinepr.proxies;

import org.edwinepr.model.Comment;

public interface CommentNotificationProxy {
    void sendCommentNotification(Comment comment);
}
