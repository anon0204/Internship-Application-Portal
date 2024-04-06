package com.myapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import org.springframework.validation.BindingResult;

@Controller
public class InternshipController {

    @Autowired
    private InternshipRepository internshipRepository;

    @GetMapping("/internship.html")
    public String showInternshipForm(Model model) {
        model.addAttribute("internship", new Internship());
        return "internship";
    }

    @PostMapping("/internship.html")
    public String fillInternshipDetails(@ModelAttribute("internship") Internship internship, BindingResult bindingResult, Model model) {

        
        if (bindingResult.hasErrors()) {
            return "internship"; 
        }

        try {
           
            Internship savedInternship = internshipRepository.save(internship);

            model.addAttribute("detailStoredSuccessfully", true);
            model.addAttribute("internshipId", savedInternship.getInternshipId());
        } catch (Exception e) {
            
            model.addAttribute("detailStoredSuccessfully", false);
        }

        if (model.getAttribute("detailStoredSuccessfully") != null && 
        model.getAttribute("detailStoredSuccessfully").equals(true)) {
        return "redirect:/home.html"; 
    }

    return "internship";
}
}





