package com.example.demo.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Conntroller {
    @GetMapping("/ru/about")
    public String about(Model model) {
        model.addAttribute("page_content", "about");
        model.addAttribute("page_text", "This is the about page");
        model.addAttribute("text_1", "lore ipsum");
        return "base";
    }
    // Change default lang to estonian
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("page_content", "home");
        model.addAttribute("page_lang", "ru");
        return "base";
    }
}
