package com.rf2.belbineval.controller;

import com.rf2.belbineval.model.Question;
import com.rf2.belbineval.model.Submission;
import com.rf2.belbineval.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/test/{submissionId}")
public class TestController {

    private final SubmissionService submissionService;
    private static final int TOTAL_SECTIONS = 7;

    // Show a section's questions
    @GetMapping("/section/{sectionNumber}")
    public String showSection(@PathVariable Long submissionId,
                              @PathVariable int sectionNumber,
                              Model model) {

        Submission submission = submissionService.getSubmissionById(submissionId)
                .orElseThrow(() -> new IllegalArgumentException("Submission not found"));

        List<Question> questions = submissionService.getQuestionsForSection(sectionNumber);

        model.addAttribute("submission", submission);
        model.addAttribute("questions", questions);
        model.addAttribute("sectionNumber", sectionNumber);
        model.addAttribute("totalSections", TOTAL_SECTIONS);
        model.addAttribute("isLastSection", sectionNumber == TOTAL_SECTIONS);

        return "section";
    }

    // Handle section form submission
    @PostMapping("/section/{sectionNumber}")
    public String submitSection(@PathVariable Long submissionId,
                                @PathVariable int sectionNumber,
                                @RequestParam Map<String, String> formData,
                                RedirectAttributes redirectAttributes) {

        Submission submission = submissionService.getSubmissionById(submissionId)
                .orElseThrow(() -> new IllegalArgumentException("Submission not found"));

        // Parse questionId -> points from form data
        // Form fields are named "answer_<questionId>"
        Map<Long, Integer> sectionAnswers = formData.entrySet().stream()
                .filter(e -> e.getKey().startsWith("answer_"))
                .collect(Collectors.toMap(
                        e -> Long.parseLong(e.getKey().replace("answer_", "")),
                        e -> {
                            try {
                                return Integer.parseInt(e.getValue());
                            } catch (NumberFormatException ex) {
                                return 0;
                            }
                        }
                ));

        // Validate points sum to 10
        if (!submissionService.isSectionValid(sectionAnswers)) {
            redirectAttributes.addFlashAttribute("error",
                    "Points must add up to exactly 10. Please adjust your answers.");
            return "redirect:/test/" + submissionId + "/section/" + sectionNumber;
        }

        // Save answers
        submissionService.saveAnswersForSection(submission, sectionAnswers);

        // Move to next section or results
        if (sectionNumber == TOTAL_SECTIONS) {
            return "redirect:/results/" + submissionId;
        }
        return "redirect:/test/" + submissionId + "/section/" + (sectionNumber + 1);
    }
}