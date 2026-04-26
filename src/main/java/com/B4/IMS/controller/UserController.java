package com.B4.IMS.controller;

import com.B4.IMS.model.SystemUser;
import com.B4.IMS.repository.SystemUserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private SystemUserRepository userRepository;

    // Helper method to check if the current session belongs to a SysAdmin
    private boolean isSysAdmin(HttpSession session) {
        SystemUser currentUser = (SystemUser) session.getAttribute("loggedInUser");
        return currentUser != null && "SYSADMIN".equals(currentUser.getRole());
    }

    // 1. List all users (Protected)
    @GetMapping("/users")
    public String listUsers(HttpSession session, Model model) {
        if (!isSysAdmin(session)) return "redirect:/dashboard"; // Kick out non-admins
        
        model.addAttribute("users", userRepository.findAll());
        return "users"; 
    }

    // 2. Show add user form (Protected)
    @GetMapping("/users/add")
    public String showAddUserForm(HttpSession session, Model model) {
        if (!isSysAdmin(session)) return "redirect:/dashboard";
        
        model.addAttribute("user", new SystemUser());
        return "add-user"; 
    }

    // 3. Save new user (Protected + Duplicate Check)
    @PostMapping("/users/add")
    public String saveUser(@ModelAttribute("user") SystemUser user, HttpSession session, Model model) {
        if (!isSysAdmin(session)) return "redirect:/dashboard";

        // CHECK FOR DUPLICATES: Prevent the 500 Error crash!
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            model.addAttribute("error", "Error: That Username is already taken!");
            return "add-user"; // Send them back to the form with the error message
        }

        userRepository.save(user);
        return "redirect:/users";
    }

    // 4. Delete user (Protected)
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, HttpSession session) {
        if (!isSysAdmin(session)) return "redirect:/dashboard";
        
        userRepository.deleteById(id);
        return "redirect:/users";
    }
}