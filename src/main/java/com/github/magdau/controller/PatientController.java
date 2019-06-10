package com.github.magdau.controller;

import com.github.magdau.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients/list")
    public String patientList(Model theModel) {

        theModel.addAttribute("patients", patientService.getAllPatient());
        return "patientList";
    }
}
