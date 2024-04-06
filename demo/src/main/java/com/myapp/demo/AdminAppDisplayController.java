package com.myapp.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdminAppDisplayController {

    @Autowired
    private InternshipRepository internshipRepository;

    @GetMapping("/adminappdisplay.html")
    public String displayApplications(Model model) {
        List<Internship> applications = internshipRepository.findAll();
        model.addAttribute("ap", applications);
        return "adminappdisplay";
    }

    @PostMapping("/adminappdisplay.html")
    public String updateStatus(@RequestParam("internshipId") String internshipId, @RequestParam("status") String status) {
        Internship application = internshipRepository.findByInternshipId(internshipId);

        if (application != null) {
            try {
               
                Status statusEnum = Status.valueOf(status);

                
                application.setStatus(statusEnum);

                internshipRepository.save(application);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid status");
            }
        }

        return "redirect:/adminappdisplay.html";
    }
}

  



    


