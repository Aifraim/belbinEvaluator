package com.rf2.belbineval.repository;

import com.rf2.belbineval.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    List<Submission> findByParticipantNameIgnoreCase(String name);
}
