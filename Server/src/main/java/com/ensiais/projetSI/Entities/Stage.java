package com.ensiais.projetSI.Entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "stage"
)
//@JsonIgnoreProperties({"entreprise", "tuteur", "etudiante", "typestage"})

public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeStage;
    private int dureeSemaines;
    private String competences;
    private String compteRendu;
    @ManyToOne
    //@JsonBackReference
    private Tuteur tuteur;
    @ManyToOne
    //@JsonBackReference
    private Entreprise entreprise;
    @ManyToOne
    //@JsonBackReference
    private Etudiante etudiante;
    @ManyToOne
    //@JsonBackReference
    private Typestage typestage;

}
