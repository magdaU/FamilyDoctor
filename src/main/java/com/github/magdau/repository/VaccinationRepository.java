package com.github.magdau.repository;

import com.github.magdau.model.Vaccination;
import com.github.magdau.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {

    List<Vaccination> getAllByPatientId(Long patientId);

}
