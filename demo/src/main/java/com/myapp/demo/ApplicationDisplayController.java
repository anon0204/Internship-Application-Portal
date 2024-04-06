package com.myapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ApplicationDisplayController {

    @GetMapping("/displayapplications.html")
    public String displayApplications(Model model) {
        return "displayapplications";
    }
}



    


