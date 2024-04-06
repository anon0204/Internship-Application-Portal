package com.myapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import org.springframework.ui.Model;

@Controller
public class LoginController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/login1.html")
    public String loginPage(Model model) {
        model.addAttribute("studentLoginRequest", new StudentLoginRequest()); 
        return "login1";
    }

    @PostMapping("/login1.html")
    public String loginSubmit(@ModelAttribute("studentLoginRequest") StudentLoginRequest loginRequest, Model model) {
        Long studentId = loginRequest.getStudentId();
        String password = loginRequest.getPassword();

        Student student = studentRepository.findByStudentId(studentId);
        if (student != null && student.getPassword().equals(password)) {
            model.addAttribute("successMessage", "Login successful!");
            return "redirect:/home.html";
        } else {
            return "redirect:/login1.html?error=true";
        }
    }
}




