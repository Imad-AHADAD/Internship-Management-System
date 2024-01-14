package com.ensiais.projetSI.Conrollers;

import com.ensiais.projetSI.Entities.Etudiante;
import com.ensiais.projetSI.Entities.Professeur;
import com.ensiais.projetSI.Services.Profservice;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/professeurs"})
@NoArgsConstructor
public class Profcontroller {
    @Autowired
    private Profservice profservice;

    @GetMapping
    public List<Professeur> getAllprof(){
       return profservice.listes_prof();
    }
    @GetMapping({"/{id}"})
    public Professeur getprof(@PathVariable String id){
       return profservice.trouver_prof(id);
    }
    @PostMapping
    public String ajouter_professeur(@RequestBody Professeur prof){
        profservice.creer_prof(prof);
        return "Félicitation le prof a été ajouté avec succès";
    }
    @DeleteMapping({"/{id}"})
    public String supprimer_prof(@PathVariable String id){
        profservice.supprimer_prof(id);
        return "le prof a été supprimé avec succès";
    }
    @PutMapping
    public Professeur misajour_prof(@RequestBody Professeur pr){
        return profservice.creer_prof(pr);
    }
    @GetMapping("/listesetudiantsparprofesseurs{id}")
    public List<Etudiante> getprofetudiants(@PathVariable String id){
        return profservice.listsetud(id);
    }
    @DeleteMapping
    public String suprime(){
        profservice.supprime_tout();
        return "tout est supprimés";
    }
}
