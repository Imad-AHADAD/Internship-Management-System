package com.ensiais.projetSI.Conrollers;

import com.ensiais.projetSI.Entities.Competence;
import com.ensiais.projetSI.Entities.Tuteur;
import com.ensiais.projetSI.Services.Competenceservice;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/competences"})
@NoArgsConstructor
public class Competencecontroller {
    @Autowired
    private Competenceservice competenceservice;

    @GetMapping
    public List<Competence> getAllcompetence(){
        return competenceservice.listes_copetence();
    }
    @GetMapping({"/{id}"})
    public Competence getcompetence(@PathVariable String id){
        return competenceservice.trouver_competence(id);
    }
    @PostMapping
    public String ajouter_competence(@RequestBody Competence comp){
        competenceservice.creer_competence(comp);
        return "Félicitation la competence a été ajouté avec succès";
    }
    @DeleteMapping({"/{id}"})
    public String supprimer_competence(@PathVariable String id){
        competenceservice.supprimer_competence(id);
        return "la competence a été supprimé avec succès";
    }
    @PutMapping
    public Competence misajour_competence(@RequestBody Competence com){
        return competenceservice.creer_competence(com);
    }
    @GetMapping({"listescompetenceparnivaue_{id}"})
    public List<Competence> listes_parniv(@PathVariable int id){
         return competenceservice.listes_competence_pour_un_niveau(id);
    }
    @DeleteMapping
    public String suprime(){
        competenceservice.supprime_tout();
        return "tout est supprimés";
    }
}



