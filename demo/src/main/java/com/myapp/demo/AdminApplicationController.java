package com.myapp.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminApplicationController {

    @Autowired
    private InternshipRepository internshipRepository;

    @GetMapping("/adminapplication.html")
    public String displayApplicationDetailForm(Model model) {
        model.addAttribute("studentId", "");
        return "adminapplication"; 
    }

    @PostMapping("/adminapplication.html")
    public String searchforApplications(@RequestParam("studentId") Long studentId, Model model, RedirectAttributes redirectAttributes) {
        List<Internship> applications = internshipRepository.findAllByStudentId(studentId);

        if (!applications.isEmpty()) {
            model.addAttribute("successMessage", "Entries found successfully!");
            redirectAttributes.addFlashAttribute("ap", applications);
            return "redirect:/adminappdisplay.html";
        } else {
            model.addAttribute("studentId", studentId);
            model.addAttribute("error", "No matching entries found");
            return "adminapplication";  
        }
    }
}


   
