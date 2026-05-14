package com.rf2.belbineval.service;

import com.rf2.belbineval.model.*;
import com.rf2.belbineval.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    // Creates a fresh submission for a participant
    @Transactional
    public Submission createSubmission(String participantName) {
        Submission submission = Submission.builder()
                .participantName(participantName)
                .takenAt(LocalDateTime.now())
                .build();
        return submissionRepository.save(submission);
    }

    // Saves answers for one section (map of questionId -> points)
    @Transactional
    public void saveAnswersForSection(Submission submission, Map<Long, Integer> sectionAnswers) {
        List<Answer> answers = new ArrayList<>();

        for (Map.Entry<Long, Integer> entry : sectionAnswers.entrySet()) {
            Question question = questionRepository.findById(entry.getKey())
                    .orElseThrow(() -> new IllegalArgumentException("Question not found: " + entry.getKey()));

            Answer answer = Answer.builder()
                    .submission(submission)
                    .question(question)
                    .points(entry.getValue())
                    .build();

            answers.add(answer);
        }

        answerRepository.saveAll(answers);
    }

    // Validates that points in a section sum to exactly 10
    public boolean isSectionValid(Map<Long, Integer> sectionAnswers) {
        int total = sectionAnswers.values().stream().mapToInt(Integer::intValue).sum();
        return total == 10;
    }

    // Fetches a submission with all its answers
    public Optional<Submission> getSubmissionById(Long id) {
        return submissionRepository.findById(id);
    }

    // Fetches all answers for a submission
    public List<Answer> getAnswersForSubmission(Submission submission) {
        return answerRepository.findBySubmission(submission);
    }

    // Fetches questions for a specific section in order
    public List<Question> getQuestionsForSection(int sectionNumber) {
        return questionRepository.findBySectionNumberOrderByStatementIndex(sectionNumber);
    }
}