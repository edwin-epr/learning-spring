package org.edwinepr.implrestservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello, I am a Rest Service!";
    }

    @GetMapping(path = "/ciao")
    public String ciao() {
        return "Ciao!";
    }
}
