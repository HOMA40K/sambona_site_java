package com.example.demo.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Conntroller {
    // RU lang page
    @GetMapping("/RU/about")
    public String about(Model model) {
        model.addAttribute("page_content", "about");
        model.addAttribute("page_text", "This is the about page");
        model.addAttribute("text_1", "lore ipsum");
        return "base";
    }
    // Change default lang to estonian
    @GetMapping("/RU")
    public String home(Model model) {
        model.addAttribute("page_content", "home");
        model.addAttribute("page_text", "This is the home page");
        model.addAttribute("page_lang", "RU");
        return "base";
    }

    @GetMapping("/RU/pricing")
    public String pricing(Model model) {
        model.addAttribute("page_content", "pricing");
        model.addAttribute("page_text", "This is the pricing page");
        model.addAttribute("page_lang", "RU");
        model.addAttribute("text_1", "lore ipsum");
        return "base";
    }

    //EN lang page

    //EE lang page

    //Redirect to default lang page
    @GetMapping("/")
    public String redirectHome(Model model){
        return "redirect:/RU";
    }
}