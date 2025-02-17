package org.edwinepr.services;

import lombok.Data;
import org.edwinepr.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
}
