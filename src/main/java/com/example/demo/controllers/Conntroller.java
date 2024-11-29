package com.example.demo.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Conntroller {

    @Autowired
    private JavaMailSender emailSender;


    @PostMapping("/sendData")
    public ResponseEntity getAllParams(HttpServletRequest request, Model model) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, String> responseMap = new HashMap<>();

        parameterMap.forEach((key, value) -> {
            responseMap.put(key, String.join(", ", value));
        });

        parameterMap.forEach((key, value) -> {
            System.out.println("Parameter Name: " + key + ", Value: " + String.join(", ", value));
        });
        SimpleMailMessage userMail = new SimpleMailMessage();
        userMail.setTo(responseMap.get("email"));
        userMail.setFrom("test@tlb.ee");
        userMail.setSubject("Thank you for your message");
        userMail.setText("Dear " + responseMap.get("name") + ",\n\nThank you for reaching out. We have received your message \n\nBest regards,\nSambona OÜ");

        SimpleMailMessage ownerMail = new SimpleMailMessage();

        ownerMail.setFrom("test@tlb.ee");
        ownerMail.setTo("test@tlb.ee");
        ownerMail.setSubject("New message from " + responseMap.get("name"));
        ownerMail.setText("Новый заказ от " + responseMap.get("name") + "\n\n" +
                "Email :" + responseMap.get("email") + "):\n\n"+
                "телефон: " + responseMap.get("phone") + "\n\n" +
                "фирма: " + responseMap.get("firm") + "\n\n" +
                "страна: " + responseMap.get("country") + "\n\n" +
                "город: " + responseMap.get("city") + "\n\n" +
                "улица: " + responseMap.get("street") + "\n\n" +
                "индекс: " + responseMap.get("index") + "\n\n" +
                "Характеристики крана: " + "\n\n" +
                "Тип крана: " + responseMap.get("crane_type") + "\n\n" +
                "Тип строения крана: " + responseMap.get("building_type") + "\n\n" +
                "Пролеты: " + responseMap.get("spans") + " мм \n\n" +
                "Высота подъема: " + responseMap.get("lifting_height") + " мм \n\n" +
                "Скорость тельфера: " + responseMap.get("telfer_speed") + "\n\n" +
                "Скорость крана: " + responseMap.get("crane_speed") + "\n\n" +
                "Грузоподъемность: " + responseMap.get("load_capacity") + " кг \n\n"
        );

        emailSender.send(userMail);
        emailSender.send(ownerMail);


        return ResponseEntity.ok(responseMap);
    }

    @PostMapping("/send")
    public String send(@RequestParam(name = "name") String name, @RequestParam(name = "email") String email, @RequestParam(name = "message") String message) {
        System.out.println(name + " " + email + " " + message);

        // Send email to user
        SimpleMailMessage userMail = new SimpleMailMessage();
        userMail.setTo(email);
        userMail.setFrom("test@tlb.ee");
        userMail.setSubject("Thank you for your message");
        userMail.setText("Dear " + name + ",\n\nThank you for reaching out. We have received your message:\n\n" + message + "\n\nBest regards,\nYour Company");

        System.out.println("mail to user ------------------------------------------------------");
        emailSender.send(userMail);
        System.out.println("mail to user ------------------------------------------------------");

        // Send email to owner
        SimpleMailMessage ownerMail = new SimpleMailMessage();
        ownerMail.setTo("test@tlb.ee");
        ownerMail.setFrom("test@tlb.ee");
        ownerMail.setSubject("New message from " + name);
        ownerMail.setText("You have received a new message from " + name + " (" + email + "):\n\n" + message);

        System.out.println("mail to owner ------------------------------------------------------");
        emailSender.send(ownerMail);
        System.out.println("mail to owner ------------------------------------------------------");

        return "redirect:/contact?lang=ET";
    }

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

    @GetMapping("/testsend")
    public String testsend( @RequestParam(name = "lang", required = false) String lang, Model model) {
        if (lang == null) {
            lang = "ET";
        }
        model.addAttribute("page_content", "testsend");
        model.addAttribute("page_lang", lang);
        return "base";
    }

    @GetMapping("/pricing")
    public String pricing(@RequestParam(name = "lang", required = false) String lang, Model model) {
        if (lang == null) {
            lang = "ET";
        }
        model.addAttribute("page_content", "pricing");
//        model.addAttribute("crane_type", crane_type);
//        System.out.println(crane_type + " " + "crane_type");
        model.addAttribute("page_lang", lang);
        return "base";
    }
    @GetMapping("/crane-info/{crane_type}")
    public String info(@RequestParam(name = "lang", required = false) String lang, @PathVariable(value = "crane_type") String crane_type,  Model model) {
        if (lang == null) {
            lang = "ET";
        }
        model.addAttribute("page_content", "crane-info");
        model.addAttribute("crane_type", crane_type);
        model.addAttribute("page_lang", lang);
        return "base";
    }
    @GetMapping("/info")
    public String info(@RequestParam(name = "lang", required = false) String lang, Model model) {
        if (lang == null) {
            lang = "ET";
        }
        model.addAttribute("page_content", "info");
        model.addAttribute("page_lang", lang);
        return "base";
    }
    @GetMapping("/contact")
    public String contact(Model model, @RequestParam(name = "lang", required = false) String lang) {
        if (lang == null) {
            lang = "ET";
        }
        model.addAttribute("page_content", "contact");
        model.addAttribute("page_lang", lang);
        return "base";
    }


}