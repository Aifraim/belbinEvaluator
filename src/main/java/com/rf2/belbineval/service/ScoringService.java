package com.rf2.belbineval.service;

import com.rf2.belbineval.model.Answer;
import com.rf2.belbineval.model.BelbinRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScoringService {

    // Takes a list of answers and returns a map of role -> total points
    public Map<BelbinRole, Integer> calculateScores(List<Answer> answers) {
        Map<BelbinRole, Integer> scores = new EnumMap<>(BelbinRole.class);

        // Initialize all roles with 0
        for (BelbinRole role : BelbinRole.values()) {
            scores.put(role, 0);
        }

        // Sum points per role
        for (Answer answer : answers) {
            BelbinRole role = answer.getQuestion().getRole();
            scores.merge(role, answer.getPoints(), Integer::sum);
        }

        return scores;
    }

    // Returns roles sorted by score descending
    public List<Map.Entry<BelbinRole, Integer>> getRankedRoles(Map<BelbinRole, Integer> scores) {
        return scores.entrySet().stream()
                .sorted(Map.Entry.<BelbinRole, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
    }

    // Returns the top N roles
    public List<BelbinRole> getTopRoles(Map<BelbinRole, Integer> scores, int topN) {
        return getRankedRoles(scores).stream()
                .limit(topN)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // Converts raw scores to percentages (relative to total points given)
    public Map<BelbinRole, Double> calculatePercentages(Map<BelbinRole, Integer> scores) {
        int total = scores.values().stream().mapToInt(Integer::intValue).sum();
        if (total == 0) return scores.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> 0.0));

        Map<BelbinRole, Double> percentages = new EnumMap<>(BelbinRole.class);
        scores.forEach((role, points) ->
                percentages.put(role, Math.round((points * 100.0 / total) * 10.0) / 10.0)
        );
        return percentages;
    }
}