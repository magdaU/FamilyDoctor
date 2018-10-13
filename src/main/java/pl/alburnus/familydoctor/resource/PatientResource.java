package pl.alburnus.familydoctor.resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.alburnus.familydoctor.model.Patient;
import pl.alburnus.familydoctor.repository.PatientRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientResource {

    private final PatientRepository patientRepository;

    public PatientResource(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @PostMapping
    public void create(@RequestBody Patient patient) {
        patientRepository.save(patient);
    }
}