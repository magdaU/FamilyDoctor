package com.github.magdau.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate dateOfVaccination;

    private String name;

    private String comment;

    @ManyToOne
    private Patient patient;
}
