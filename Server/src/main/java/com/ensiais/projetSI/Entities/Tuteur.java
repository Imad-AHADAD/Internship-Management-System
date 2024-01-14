package com.ensiais.projetSI.Entities;




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
        name = "tuteur"
)
public class Tuteur {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String sex;
    private String numeroTelephone;
    @OneToMany(mappedBy = "tuteur")
    @JsonIgnore
    private List<Stage> stages=new ArrayList<>();
    @ManyToOne
    private Entreprise entreprise;
    @OneToMany(mappedBy = "tuteur")
    @JsonIgnore
    private List<Etudiante> Etudiantes;
    //@OneToOne(mappedBy = "tuteur")
    //private Professeur professeur;  a ne pas revenir

}