package com.github.magdau.controller;

import com.github.magdau.model.Patient;
import com.github.magdau.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/patients")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String patientList(Model theModel) {

        theModel.addAttribute("patients", patientService.getAllPatient());
        return "patientList";
    }

    @GetMapping(value = "/detail/{id}")
    public String patientDetail(Model theModel, @PathVariable("id") Long id) {
        System.out.println(id);
        Optional<Patient> patient = patientService.getById(id);
        patient.ifPresent(p -> theModel.addAttribute("patient", p));
        return "patientDetail";
    }

    @GetMapping("/delete/{patientId}")
    public String delete(@PathVariable("patientId") Long patientId) {
        patientService.delete(patientId);
        return "redirect:/patients";
    }

    @GetMapping(value = "/edit/{id}")
    public String patientEdit(Model theModel, @PathVariable("id") Long id) {
        System.out.println(id);
        Optional<Patient> patient = patientService.getById(id);
        patient.ifPresent(p -> theModel.addAttribute("patient", p));
        return "patientEdit";
    }

    @PostMapping("/save")
    public String savePatient(@ModelAttribute("patient") Patient thePatient) {
        patientService.save(thePatient);
        return "redirect:/patients";
    }
}