package com.ensiais.projetSI.Conrollers;

import com.ensiais.projetSI.Entities.Promotion;
import com.ensiais.projetSI.Entities.Typestage;
import com.ensiais.projetSI.Services.Typestageservice;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/typesstage"})
@NoArgsConstructor
public class Typestagecontroller {
    @Autowired
    private Typestageservice typestageservice;

    @GetMapping
    public List<Typestage> getAlltypesstage(){
        return typestageservice.listes_types();
    }
    @GetMapping({"/{id}"})
    public Typestage getprof(@PathVariable int id){
        return typestageservice.trouver_typestage(id);
    }
    @PostMapping
    public String ajouter_professeur(@RequestBody Typestage typestage){
        typestageservice.creer_typestage(typestage);
        return "Félicitation le type stage a été ajouté avec succès";
    }
    @DeleteMapping({"/{id}"})
    public String supprimer_prof(@PathVariable int id){
        typestageservice.supprimer_typestage(id);
        return "le type de stage a été supprimé avec succès";
    }
    @PutMapping
    public Typestage misajour_prof(@RequestBody Typestage pr){
        return typestageservice.creer_typestage(pr);
    }
    @DeleteMapping
    public String suprime(){
        typestageservice.supprime_tout();
        return "tout est supprimés";
    }
}


