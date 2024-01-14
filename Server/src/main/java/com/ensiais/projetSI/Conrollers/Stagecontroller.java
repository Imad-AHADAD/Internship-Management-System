package com.ensiais.projetSI.Conrollers;

import com.ensiais.projetSI.Entities.Stage;
import com.ensiais.projetSI.Services.Stageservice;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/stages"})
@NoArgsConstructor
public class Stagecontroller {
    @Autowired
    private Stageservice stageservice;

    @GetMapping
    public List<Stage> getAllstage(){
        return stageservice.listes_stage();
    }
    @GetMapping({"/{id}"})
    public Stage getstage(@PathVariable long id){
        return stageservice.trouver_stage(id);
    }
    @PostMapping(/*"/creer/{id}"*/)
    public String ajouter_stag(@RequestBody Stage st/*,@PathVariable long id*/){
        stageservice.creer_stage(st/*,id*/);
        return "Félicitation le stagea été ajouté avec succès";
    }
    @DeleteMapping({"/{id}"})
    public String supprimer_stag(@PathVariable long id){
        stageservice.supprimer_stage(id);
        return "le promo a été supprimé avec succès";
    }
    @PutMapping("/mettreajour/{id}")
    public Stage misajour_stag(@RequestBody Stage st/*,@PathVariable long id*/){
        return stageservice.creer_stage(st);
    }
    @GetMapping("/listes_stages_pr_types{id}")
    public List<Stage> getstage(@PathVariable String id){
        return stageservice.listes_stages_pr_types(id);
    }
    @DeleteMapping
    public String suprime(){
        stageservice.supprime_tout();
        return "tout est supprimés";
    }
}


