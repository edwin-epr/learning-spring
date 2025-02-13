package org.edwinepr.services;

import org.edwinepr.model.Comment;
import org.edwinepr.proxies.CommentNotificationProxy;
import org.edwinepr.repositories.CommentRepository;

public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(
            CommentRepository commentRepository,
            CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendCommentNotification(comment);
    }
}
