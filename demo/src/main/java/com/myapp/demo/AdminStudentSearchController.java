package com.myapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
public class AdminStudentSearchController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/adminrollnumber.html")
    public String displayInputForm(Model model) {
        model.addAttribute("studentId", "");
        return "adminrollnumber"; 
    }
  
    @PostMapping("/adminrollnumber.html")
    public String searchAndDisplay(@RequestParam("studentId") Long studentId, Model model, RedirectAttributes redirectAttributes) {

        Student student = studentRepository.findByStudentId(studentId);
        if (student != null) {
            model.addAttribute("successMessage", "Entry found successfully!");
            redirectAttributes.addFlashAttribute("student", student);
            return "redirect:/adminstudentdetails.html"; 
        } else {
            model.addAttribute("studentId", studentId);
            model.addAttribute("error", "No matching entry found");
            return "adminrollnumber";
        }
    }
}



    

