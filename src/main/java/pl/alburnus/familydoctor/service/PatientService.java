package pl.alburnus.familydoctor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.alburnus.familydoctor.model.Patient;
import pl.alburnus.familydoctor.repository.PatientRepository;

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
}
