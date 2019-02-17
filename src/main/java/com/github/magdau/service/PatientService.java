package com.github.magdau.service;

import com.github.magdau.model.Patient;
import com.github.magdau.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final static Logger LOGGER = LoggerFactory.getLogger(PatientService.class);

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    public void save(Patient patient) {
        if (patientRepository.existsByNicknameIsNot(patient.getNickname())) {
            patientRepository.save(patient);
            LOGGER.debug("Not exist, so add new nickname: {}", patient.getNickname());
        }
    }
    public void delete(Patient patientId) {
        if (patientRepository.existsById(patientId.getId())) {
            //Logger.info("Czy chcesz usunuąć danego pacjenta")
            patientRepository.delete(patientId);
        }
    }
    public void update(Patient patient){
        if(patientRepository.existsByNicknameIsNot(patient.getNickname())){
            patientRepository.save(patient);

        }
    }
}
