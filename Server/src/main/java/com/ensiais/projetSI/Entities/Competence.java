package com.ensiais.projetSI.Entities;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "competences")
public class Competence {
    @Id
    private String code;
    private String libelle;
    private String description;
    //@OneToMany(mappedBy = "code_competence")
    //private List<Acquerir> acquerirs;


}
