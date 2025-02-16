package org.edwinepr.config;

import org.edwinepr.proxies.CommentNotificationProxy;
import org.edwinepr.proxies.EmailCommentNotificationProxy;
import org.edwinepr.repositories.CommentRepository;
import org.edwinepr.repositories.DBCommentRepository;
import org.edwinepr.services.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = {"org.edwinepr.proxies", "org.edwinepr.repositories", "org.edwinepr.services"}
)
public class ProjectConfiguration {}