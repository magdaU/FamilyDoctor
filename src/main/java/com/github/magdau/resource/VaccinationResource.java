package com.github.magdau.resource;

import com.github.magdau.model.Vaccination;
import com.github.magdau.service.VaccinationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vaccinations")
public class VaccinationResource {

    private final VaccinationService vaccinationService;

    public VaccinationResource(VaccinationService vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    @PostMapping
    public ResponseEntity<Vaccination> create(@RequestBody Vaccination vaccination) {
        return new ResponseEntity<>(vaccinationService.create(vaccination), HttpStatus.CREATED);
    }

    @GetMapping("/patient/{idPatient}")
    public ResponseEntity<List<Vaccination>> getAllVaccinationByPatientId(@PathVariable("idPatient") Long idPatient) {
        return new ResponseEntity<>(vaccinationService.getAllByPatientId(idPatient), HttpStatus.OK);
    }

}