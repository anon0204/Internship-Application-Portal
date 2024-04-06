package com.myapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import org.springframework.validation.BindingResult;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/student.html")
    public String showDetailsForm(Model model) {
        model.addAttribute("student", new Student());
        return "student";
    }

    @PostMapping("/student.html")
    public String fillDetails(@ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {

        if (!student.getPassword().equals(student.getPasswordCheck())) {
            bindingResult.rejectValue("passwordCheck", "error.user", "Passwords do not match");
            return "student";
        }

        if (bindingResult.hasErrors()) {
            return "student"; 
        }

        if (studentRepository.existsByEmail(student.getEmail())) {
            bindingResult.rejectValue("email", "error.user", "Email already exists");
            return "student";
        }

        
        try {
            Student savedStudent = studentRepository.save(student);

            model.addAttribute("detailStoredSuccessfully", true);
            model.addAttribute("userId", savedStudent.getId());
        } catch (Exception e) {
            
            model.addAttribute("detailStoredSuccessfully", false);
        }

        if (model.getAttribute("detailStoredSuccessfully") != null && 
        model.getAttribute("detailStoredSuccessfully").equals(true)) {
        return "redirect:/home.html"; 
    }

    return "student";
}
}


      


