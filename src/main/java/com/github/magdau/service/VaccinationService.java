package com.github.magdau.service;

import com.github.magdau.model.Vaccination;
import com.github.magdau.repository.VaccinationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VaccinationService {

    private final VaccinationRepository vaccinationRepository;

    public VaccinationService(VaccinationRepository vaccinationRepository) {
        this.vaccinationRepository = vaccinationRepository;
    }

    public Vaccination create(Vaccination vaccination) {
        log.info("Creating object: [{}]", vaccination);
        return vaccinationRepository.save(vaccination);
    }

    public List<Vaccination> getAllByPatientId(Long idPatient) {
        return vaccinationRepository.getAllByPatientId(idPatient);
    }
}
