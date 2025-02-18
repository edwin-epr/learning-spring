package org.edwinepr.services;

import lombok.Data;
import org.edwinepr.aspects.ToLog;
import org.edwinepr.model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@Data
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    public void publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
    }

    @ToLog
    public void deleteComment(Comment comment) {
        logger.info("Deleting comment: " + comment.getText());
    }

    @ToLog
    public void editComment(Comment comment) {
        logger.info("Editing comment: " + comment.getText());
    }
}
