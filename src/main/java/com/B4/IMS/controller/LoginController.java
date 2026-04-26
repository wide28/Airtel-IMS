package com.B4.IMS.controller;

import com.B4.IMS.model.SystemUser;
import com.B4.IMS.repository.SystemUserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private SystemUserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               HttpSession session,
                               Model model) {
        
        Optional<SystemUser> userOpt = userRepository.findByUsername(username);

        if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
            session.setAttribute("loggedInUser", userOpt.get());
            // Updated to redirect to the new Welcome landing page
            return "redirect:/welcome"; 
        } else {
            model.addAttribute("error", "Invalid Username or Password!");
            return "login";
        }
    }

    // New Route for the Landing Page
    @GetMapping("/welcome")
    public String showWelcomePage(HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/login";
        }
        return "welcome";
    }
}