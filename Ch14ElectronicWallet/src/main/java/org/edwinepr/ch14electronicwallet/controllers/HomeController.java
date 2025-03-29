package org.edwinepr.ch14electronicwallet.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(path = "/")
    public String home() {
        return "En Dios Confío!";
    }
}
