package org.edwinepr;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class CommentService {
    public CommentService() {
        System.out.println("Comment Service instance created");
    }
}
