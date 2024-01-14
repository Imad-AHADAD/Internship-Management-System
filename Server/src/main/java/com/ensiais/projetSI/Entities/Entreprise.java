package com.ensiais.projetSI.Entities;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "entreprise"
)
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String raisonsociale;
    private String formejuridique;
    private String adresse;
    private long codepostal;
    private String ville;
    private String fax;
    private String contact;
    private String numeroTelephoneStandard;
    private String numeroTelephoneContact;
    @JsonIgnore
    @OneToMany(mappedBy = "entreprise",fetch = FetchType.EAGER)
    private List<Stage> stages = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "entreprise")
    private List<Tuteur> tuteurs = new ArrayList<>();

}
