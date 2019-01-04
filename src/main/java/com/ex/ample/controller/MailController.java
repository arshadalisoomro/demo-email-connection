package com.ex.ample.controller;

import com.ex.ample.contact.model.Email;
import com.ex.ample.contact.service.EmailService;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ADMIN on 1/4/2019.
 */

@Controller
public class MailController {

    private static Logger log = LoggerFactory.getLogger(MailController.class);

    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/")
    public String getContactPage(Model model){
        model.addAttribute("mail", new Email());
        return "home";
    }

    @PostMapping(value = "/")
    public String postContactPage(@ModelAttribute(value = "contact") Email mail) throws Exception{
        log.info("Sending Email with Thymeleaf HTML Template Example");

        mail.setTo("info@memorynotfound.com");

        Map<String, Object> model = new HashMap<>();
        model.put("name", mail.getName());
        model.put("location", "Belgium");
        model.put("signature", "https://memorynotfound.com");
        mail.setModel(model);

        emailService.sendSimpleMessage(mail);

        return "redirect:/";
    }

}
