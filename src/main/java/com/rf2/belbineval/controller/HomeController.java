package com.rf2.belbineval.controller;

import com.rf2.belbineval.model.Submission;
import com.rf2.belbineval.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final SubmissionService submissionService;

    // Landing page
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Start the test — creates a submission and redirects to section 1
    @PostMapping("/start")
    public String start(@RequestParam String participantName,
                        @RequestParam(defaultValue = "false") boolean skipToResults,
                        Model model) {

        if (participantName == null || participantName.isBlank()) {
            model.addAttribute("error", "Please enter your name to start.");
            return "index";
        }

        Submission submission = submissionService.createSubmission(participantName.trim());
        return "redirect:/test/" + submission.getId() + "/section/1";
    }
}