package com.myapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
public class ProfileController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/profile.html")
    public String displayInputForm(Model model) {
        model.addAttribute("personalmail", "");
        model.addAttribute("password","");
        return "profile"; 
    }
  
    @PostMapping("/profile.html")
    public String searchAndDisplay(@RequestParam("personalmail") String personalmail,@RequestParam("password") String password, Model model, RedirectAttributes redirectAttributes) {
        Student student = studentRepository.findByPersonalmailAndPassword(personalmail, password);

        if (student != null) {
            model.addAttribute("successMessage", "Entry found successfully!");
            redirectAttributes.addFlashAttribute("student", student);
            return "redirect:/display.html"; 
        } else {
            model.addAttribute("personalmail", personalmail);
            model.addAttribute("password", password);
            model.addAttribute("error", "No matching entry found");
            return "profile";
        }
    }
}



    

