package com.myapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration.html")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("dataStoredSuccessfully", false); 
        return "registration";
    }

    @PostMapping("/registration.html")
    public String registerUser(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

        if (!user.getPassword().equals(user.getPasswordCheck())) {
            bindingResult.rejectValue("passwordCheck", "error.user", "Passwords do not match");
            return "registration";
        }

        if (bindingResult.hasErrors()) {
            return "registration"; 
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            bindingResult.rejectValue("email", "error.user", "Email already exists");
            return "registration";
        }

        
        try {
            
            User savedUser = userRepository.save(user);
            model.addAttribute("dataStoredSuccessfully", true);
            model.addAttribute("userId", savedUser.getId());
        } catch (Exception e) {
            
            model.addAttribute("dataStoredSuccessfully", false);
        }

        if (model.getAttribute("dataStoredSuccessfully") != null && 
            model.getAttribute("dataStoredSuccessfully").equals(true)) {
            return "redirect:/student.html"; 
        }

        return "registration";
    }
}

        
     
