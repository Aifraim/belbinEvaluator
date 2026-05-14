package com.rf2.belbineval.controller;

import com.rf2.belbineval.model.Answer;
import com.rf2.belbineval.model.BelbinRole;
import com.rf2.belbineval.model.Submission;
import com.rf2.belbineval.service.ScoringService;
import com.rf2.belbineval.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ResultsController {

    private final SubmissionService submissionService;
    private final ScoringService scoringService;

    @GetMapping("/results/{submissionId}")
    public String showResults(@PathVariable Long submissionId, Model model) {

        Submission submission = submissionService.getSubmissionById(submissionId)
                .orElseThrow(() -> new IllegalArgumentException("Submission not found"));

        List<Answer> answers = submissionService.getAnswersForSubmission(submission);

        Map<BelbinRole, Integer> scores = scoringService.calculateScores(answers);
        Map<BelbinRole, Double> percentages = scoringService.calculatePercentages(scores);
        List<BelbinRole> topRoles = scoringService.getTopRoles(scores, 3);
        List<Map.Entry<BelbinRole, Integer>> rankedRoles = scoringService.getRankedRoles(scores);

        model.addAttribute("submission", submission);
        model.addAttribute("scores", scores);
        model.addAttribute("percentages", percentages);
        model.addAttribute("topRoles", topRoles);
        model.addAttribute("rankedRoles", rankedRoles);

        return "results";
    }
}