package com.github.magdau.repository;

import com.github.magdau.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // FIXME ignoreCaseSensitive
    Boolean existsByNicknameIsNot(String nickname);

}