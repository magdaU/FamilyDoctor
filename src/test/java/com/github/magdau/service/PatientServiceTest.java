package com.github.magdau.service;

import com.github.magdau.model.Patient;
import com.github.magdau.repository.PatientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {

    @InjectMocks
    private PatientService patientService;

    @Mock
    private PatientRepository patientRepository;


    @Test
    public void whenPatientNotExists_thenDoNothing() {
        // given
        Mockito.when(patientRepository.existsById(1L)).thenReturn(false);

        // when
        patientService.delete(1L);

        // then
        Mockito.verify(patientRepository, Mockito.times(0)).deleteById(1L);
    }

    @Test
    public void whenPatientExists_thenInvokeDelete() {
        // given
        Mockito.when(patientRepository.existsById(1L)).thenReturn(true);

        // when
        patientService.delete(1L);

        // then
        Mockito.verify(patientRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    public void whenPatientFound_thenUpdateIt() {
        //given
        Patient patient = new Patient();
        patient.setId(2L);
        Mockito.when(patientRepository.findById(patient.getId())).thenReturn(Optional.of(new Patient()));
        //when
        patientService.update(patient);
        //then
        Mockito.verify(patientRepository, Mockito.times(1)).save(patient);
    }

    @Test
    public void whenPatientNotFound_thenDoNothing() {
        //given
        Mockito.when(patientRepository.findById(1L)).thenReturn(Optional.empty());
        //when
        patientService.update(new Patient());
        //then
        Mockito.verify(patientRepository, Mockito.times(0)).save(new Patient());
    }
}