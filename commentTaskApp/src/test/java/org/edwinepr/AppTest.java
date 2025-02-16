package org.edwinepr;

import org.edwinepr.model.Comment;
import org.edwinepr.proxies.CommentNotificationProxy;
import org.edwinepr.repositories.CommentRepository;
import org.edwinepr.services.CommentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

/**
 * Unit test for simple App.
 */
@ExtendWith(MockitoExtension.class)
public class AppTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private CommentNotificationProxy commentNotificationProxy;

    @InjectMocks
    private CommentService commentService;

    @Test
    @DisplayName("Verify that dependencies of the" +
    "CommentService object are correctly called.")
    public void verifyDependenciesOfTheCommentService() {
        Comment comment = new Comment();

        commentService.publishComment(comment);

        verify(commentRepository).storeComment(comment);
        verify(commentNotificationProxy).sendCommentNotification(comment);
    }
}
