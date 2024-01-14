package com.ensiais.projetSI.Entities;





import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "acquerir"
)
public class Acquerir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idTypeStage;
    //@ManyToOne
    private String /*Competence*/ code_competence;
    private int niveau_exigé;
}

