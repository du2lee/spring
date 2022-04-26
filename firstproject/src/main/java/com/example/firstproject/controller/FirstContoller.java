package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstContoller{

    @GetMapping("/hi")
    public String niceMeet(Model model){
        model.addAttribute("username", "두희");
        return "greetings";         // templates/greetings.mustache
    }
}