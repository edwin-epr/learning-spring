package org.edwinepr.webdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.edwinepr.webdemo.model.LoginProcessor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginProcessor loginProcessor;

    @PostMapping(path = "/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.login();

        if (loggedIn) {
            return "Login successful!";
        }

        return "Login attempt failed!";
    }
}
