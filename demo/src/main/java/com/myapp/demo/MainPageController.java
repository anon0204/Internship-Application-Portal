package com.myapp.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainPageController {

    @GetMapping("/")
    public String showMainPage(Model model) {
        return "mainpage";
    }
}

    





