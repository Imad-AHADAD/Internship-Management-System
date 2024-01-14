package com.ensiais.projetSI.Entities;




import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
        name = "Typestage"
)
public class Typestage {
    @Id
    private int code_type;
    private int nb_semaines;
    @JsonIgnore
    @OneToMany(mappedBy = "typestage")
    private List<Stage> stages=new ArrayList<>();


}
