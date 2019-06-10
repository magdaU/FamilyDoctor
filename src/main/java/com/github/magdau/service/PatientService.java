package com.github.magdau.service;

import com.github.magdau.model.Patient;
import com.github.magdau.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Patient> getById(Long id){
        return patientRepository.findById(id);
    }

    public void save(Patient patient) {
        Optional<Patient> foundPatient = patientRepository.findPatientByNicknameIgnoreCase(patient.getNickname());
        if (!foundPatient.isPresent()) {
            patientRepository.save(patient);
            LOGGER.debug("Not exist, so add new nickname: {}", patient.getNickname());
        }
    }

    public void delete(Long patientId) {
        if (patientRepository.existsById(patientId)) {
            patientRepository.deleteById(patientId);
        }
    }

    public void update(Patient patient){
        Optional<Patient> foundPatient = patientRepository.findById(patient.getId());
        if(foundPatient.isPresent()){
            patientRepository.save(patient);
        }
    }
}
