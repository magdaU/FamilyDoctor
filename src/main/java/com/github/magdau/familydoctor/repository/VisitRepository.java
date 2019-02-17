package com.github.magdau.familydoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.github.magdau.familydoctor.model.Visit;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    List<Visit> getAllByPatientId(Long patientId);

}

