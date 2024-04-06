package com.myapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import org.springframework.ui.Model;

@Controller
public class AdminLoginController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/adminlogin.html")
    public String adminloginPage(Model model) {
        model.addAttribute("adminLogRequest", new AdminLogRequest()); 
        return "adminlogin";
    }

    @PostMapping("/adminlogin.html")
    public String adminloginSubmit(@ModelAttribute("adminLogRequest") AdminLogRequest logRequest, Model model) {
        String username = logRequest.getUsername();
        String adminpassword = logRequest.getAdminPassword();

        Admin admin = adminRepository.findByUsername(username);
        if (admin != null && admin.getAdminpassword().equals(adminpassword)) {
            model.addAttribute("successMessage", "Login successful!");
            return "redirect:/adminhome.html";
        } else {
            return "redirect:/adminhome.html";
        }
    }
}




