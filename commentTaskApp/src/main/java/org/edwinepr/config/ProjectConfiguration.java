package org.edwinepr.config;

import org.edwinepr.proxies.CommentNotificationProxy;
import org.edwinepr.proxies.EmailCommentNotificationProxy;
import org.edwinepr.repositories.CommentRepository;
import org.edwinepr.repositories.DBCommentRepository;
import org.edwinepr.services.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {

    @Bean
    public CommentRepository commentRepository() {
        return new DBCommentRepository();
    }

    @Bean
    public CommentNotificationProxy commentNotificationProxy() {
        return new EmailCommentNotificationProxy();
    }

    @Bean
    public CommentService commentService() {
        return new CommentService();
    }
}