package com.github.magdau.resource;

import com.github.magdau.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.github.magdau.service.PatientService;

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
    public void delete(@PathVariable("patientId") Long patientId) {
        patientService.delete(patientId);
    }

    @PutMapping
    public void update(@RequestBody Patient patient) {
        patientService.update(patient);
    }
}