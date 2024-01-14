package com.ensiais.projetSI.Conrollers;

import com.ensiais.projetSI.Entities.Professeur;
import com.ensiais.projetSI.Entities.Promotion;
import com.ensiais.projetSI.Entities.Stage;
import com.ensiais.projetSI.Entities.Tuteur;
import com.ensiais.projetSI.Services.Promoservice;
import com.ensiais.projetSI.Services.Tuteurservice;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/tuteurs"})
@NoArgsConstructor
public class Tuteurcontroller {
    @Autowired
    private Tuteurservice promoservice;

    @GetMapping
    public List<Tuteur> getAllpromo(){
        return promoservice.listes_tuteur();
    }
    @GetMapping({"/{id}"})
    public Tuteur getprof(@PathVariable String id){
        return promoservice.trouver_tuteur(id);
    }
    @PostMapping
    public String ajouter_professeur(@RequestBody Tuteur promo){
        promoservice.creer_Tuteur(promo);
        return "Félicitation le tuteur a été ajouté avec succès";
    }
    @DeleteMapping({"/{id}"})
    public String supprimer_prof(@PathVariable String id){
        promoservice.supprimer_tuteur(id);
        return "le promo a été supprimé avec succès";
    }
    @PutMapping
    public Tuteur misajour_prof(@RequestBody Tuteur pr){
        return promoservice.creer_Tuteur(pr);
    }
    @GetMapping("/listestuteurs{id}")
    public List<Stage> tuteurstages(@PathVariable String id){
        return promoservice.tuteur_stages(id);
    }
    @DeleteMapping
    public String suprime(){
        promoservice.supprime_tout();
        return "tout est supprimés";
    }
}


