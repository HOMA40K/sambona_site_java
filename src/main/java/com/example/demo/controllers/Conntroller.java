package com.example.demo.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Conntroller {
    @GetMapping("/")
    public String home(@RequestParam(name = "lang", required = false) String lang,Model model) {
        if (lang == null) {
            lang = "ET";
        }
        model.addAttribute("page_content", "home");
        model.addAttribute("page_text", "This is the home page");
        model.addAttribute("page_lang", lang);
        return "base";
    }
    @GetMapping("/pricing")
    public String pricing(@RequestParam(name = "lang", required = false) String lang, Model model) {

        model.addAttribute("page_content", "pricing");
//        model.addAttribute("crane_type", crane_type);
//        System.out.println(crane_type + " " + "crane_type");
        model.addAttribute("page_lang", lang);
        return "base";
    }
    @GetMapping("/crane-info/{crane_type}")
    public String info(@RequestParam(name = "lang", required = false) String lang, @PathVariable(value = "crane_type") String crane_type,  Model model) {
        model.addAttribute("page_content", "crane-info");
        model.addAttribute("crane_type", crane_type);
        model.addAttribute("page_lang", lang);
        return "base";
    }
    @GetMapping("/info")
    public String info(@RequestParam(name = "lang", required = false) String lang, Model model) {
        model.addAttribute("page_content", "info");
        model.addAttribute("page_lang", lang);
        return "base";
    }
    @GetMapping("/contact")
    public String contact(Model model, @RequestParam(name = "lang", required = false) String lang) {
        model.addAttribute("page_content", "contact");
        model.addAttribute("page_lang", lang);
        return "base";
    }


}