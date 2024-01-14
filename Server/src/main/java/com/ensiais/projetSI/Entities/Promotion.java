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
        name = "promotion"
)
public class Promotion {
    @Id
    private long année;
    private int nombreInscrits;
    private int nombreRecus;
    @ManyToOne
    private Professeur professeur;
    @JsonIgnore
    @OneToMany(mappedBy = "promotion")
    private List<Etudiante> etudiants=new ArrayList<>();


}
