package com.myapp.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdminHomeController {

    @GetMapping("/adminhome.html")
    public String showAdminHomePage(Model model) {
        return "adminhome";
    }
}

    





