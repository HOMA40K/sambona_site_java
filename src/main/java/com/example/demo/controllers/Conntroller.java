package com.example.demo.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Conntroller {
    @GetMapping("/{lang}/about")
    public String about(@PathVariable(value = "lang") String lang, Model model) {
        model.addAttribute("lang", lang);
        model.addAttribute("page_content", "about");
        model.addAttribute("page_text", "This is the about page");
        return "base";
    }
    @GetMapping("/{lang}/pricing")
    public String contact(@PathVariable(value = "lang") String lang, Model model) {
        model.addAttribute("page_content", "choose-crane");
        model.addAttribute("page_lang", lang);
        return "base";
    }
    @GetMapping("/{lang}")
    public String home(@PathVariable(value = "lang") String lang,Model model) {
        model.addAttribute("page_content", "home");
        model.addAttribute("page_text", "This is the home page");
        model.addAttribute("page_lang", lang);
        return "base";
    }
    @GetMapping("/{lang}/pricing/{crane_type}")
    public String contact(@PathVariable(value = "lang") String lang,@PathVariable(value = "crane_type") String crane_type, Model model) {

        model.addAttribute("page_content", "pricing");
        model.addAttribute("crane_type", crane_type);
        System.out.println(crane_type + " " + "crane_type");
        model.addAttribute("page_lang", lang);
        return "base";
    }
    @GetMapping("/{lang}/crane-info")
    public String craneInfo(@PathVariable(value = "lang") String lang, Model model) {
        model.addAttribute("page_content", "crane_info");
        model.addAttribute("page_lang", lang);
        return "base";
    }

    @GetMapping("/")
    public String redirectFromMain(Model model){
        return "redirect:/RU";
    }
}