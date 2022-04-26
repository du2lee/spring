package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstContoller{

    @GetMapping("/hi")
    public String meet(Model model){
        model.addAttribute("username", "두희");
        return "greetings";         // templates/greetings.mustache
    }

    @GetMapping("/bye")
    public String bye(Model model){
        model.addAttribute("username", "duhui");
        return "bye";         // templates/bye.mustache
    }
}