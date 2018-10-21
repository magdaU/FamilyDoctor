package pl.alburnus.familydoctor.resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.alburnus.familydoctor.model.Patient;
import pl.alburnus.familydoctor.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientResource {

    private final PatientService patientService;

    public PatientResource(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAll() {
        return patientService.getAllPatient();
    }

    @PostMapping
    public void create(@RequestBody Patient patient) {
        patientService.save(patient);
    }
}