package com.myapp.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ApplicationController {

    @Autowired
    private InternshipRepository internshipRepository;

    @GetMapping("/application.html")
    public String displayApplicationDetailsForm(Model model) {
        model.addAttribute("studentId", "");
        model.addAttribute("password", "");
        return "application"; 
    }

    @PostMapping("/application.html")
    public String searchApplications(@RequestParam("studentId") Long studentId, @RequestParam("password") String password, Model model, RedirectAttributes redirectAttributes) {
        List<Internship> applications = internshipRepository.findAllByStudentIdAndPassword(studentId, password);

        if (!applications.isEmpty()) {
            model.addAttribute("successMessage", "Entries found successfully!");
            redirectAttributes.addFlashAttribute("app", applications);
            return "redirect:/displayapplications.html";
        } else {
            model.addAttribute("studentId", studentId);
            model.addAttribute("password", password);
            model.addAttribute("error", "No matching entries found");
            return "application";  
        }
    }
}


   