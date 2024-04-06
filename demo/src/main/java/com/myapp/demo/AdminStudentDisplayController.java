package com.myapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdminStudentDisplayController {

    @GetMapping("/adminstudentdetails.html")
    public String displayResult(Model model) {
        Student student = (Student) model.getAttribute("student");
        model.addAttribute("student", student);
        return "adminstudentdetails";
    }
}



    


