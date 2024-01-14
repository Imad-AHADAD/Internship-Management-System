package com.ensiais.projetSI.Entities;




import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "etudiant"
)
public class Etudiante {
    @Id
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private int codepostale;
    private Date dateNaissance;
    private String ville;
    private String sexe;
    private String numeroTelephone;
    private String mention;
    @ManyToOne

    //@JsonIgnore
    private Promotion promotion;
    @ManyToOne

    //@JsonIgnore
    private Tuteur tuteur;
    @ManyToOne


    //
    private Professeur professeur;
    @OneToMany(mappedBy = "etudiante")
    @JsonIgnore
    private List<Stage> stageList=new ArrayList<>();


}
