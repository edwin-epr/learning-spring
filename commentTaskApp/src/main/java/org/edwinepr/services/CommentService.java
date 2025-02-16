package org.edwinepr.services;

import org.edwinepr.model.Comment;
import org.edwinepr.proxies.CommentNotificationProxy;
import org.edwinepr.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendCommentNotification(comment);
    }
}
