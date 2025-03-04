package org.edwinepr.springwebscopes.controllers;

import lombok.RequiredArgsConstructor;
import org.edwinepr.springwebscopes.model.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginProcessor loginProcessor;

    @GetMapping(path = "/")
    public String loginGet() {
        return "login";
    }

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
            model.addAttribute("message", "You are already logged in!");
        } else {
            model.addAttribute("message", "Login attempt failed!");
        }

        return "login";
    }
}
