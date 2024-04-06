package com.myapp.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    @GetMapping("/home.html")
    public String showHomePage(Model model) {
        return "home";
    }
}

    





