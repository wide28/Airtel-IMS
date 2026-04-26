package com.B4.IMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // We pass this attribute to the HTML template
        model.addAttribute("message", "Welcome to the Equipment Inventory Management System");
        
        // This tells Spring to look for a file named "index.html" in the templates folder
        return "index"; 
    }
}