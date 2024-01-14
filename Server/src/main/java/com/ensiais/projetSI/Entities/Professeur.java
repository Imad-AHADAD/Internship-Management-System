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
        name = "professeur"
)
public class Professeur {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String adresse;
    private String codepostal;
    private String ville;
    private String telephoneecole;
    private String telephonedomicile;
    private Date dateEmbauche;
    private Date datededepart;
    @JsonIgnore
    @OneToMany(mappedBy = "professeur")

    private List<Promotion> promotions=new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "professeur")
    private List<Etudiante> etudiante=new ArrayList<>();
    //@OneToOne
    //@JsonBackReference
    //private Tuteur tuteur;(a ne pas revenir)


}
