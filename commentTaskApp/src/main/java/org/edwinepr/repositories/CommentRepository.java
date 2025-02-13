package org.edwinepr.repositories;

import org.edwinepr.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
