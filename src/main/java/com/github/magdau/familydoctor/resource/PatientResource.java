package com.github.magdau.familydoctor.resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.github.magdau.familydoctor.model.Patient;
import com.github.magdau.familydoctor.service.PatientService;

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

    @DeleteMapping("/{patientId}")
    public void delete(@PathVariable("patientId") Patient patient) {
        patientService.delete(patient);
    }

    @PutMapping
    public void update(@RequestBody Patient patient) {
        patientService.update(patient);
    }
}