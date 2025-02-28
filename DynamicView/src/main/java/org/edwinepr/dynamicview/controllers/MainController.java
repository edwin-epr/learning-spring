package org.edwinepr.dynamicview.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/home")
    public String home(Model page) {
        page.addAttribute("username", "Mariana");
        page.addAttribute("color", "blue");
        return "home";
    }

}
