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

    @ToLog
    public String publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
        return "Successfully published comment.";
    }
}
