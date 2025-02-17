package org.edwinepr;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
@Data
public class CommentService {
    public CommentService() {
        System.out.println("Comment Service instance created");
    }
}
