package com.github.magdau.controller;

import com.github.magdau.model.Patient;
import com.github.magdau.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@Controller
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public String patientList(Model theModel) {

        theModel.addAttribute("patients", patientService.getAllPatient());
        return "patientList";
    }

    @GetMapping(value = "/patients/detail/{id}")
    public String patientDetail(Model theModel, @PathVariable("id") Long id) {
        System.out.println(id);
        Optional<Patient> patient = patientService.getById(id);
        patient.ifPresent(p -> theModel.addAttribute("patient", p));
        return "patientDetail";
    }
}
