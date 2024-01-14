package com.ensiais.projetSI.Conrollers;

import com.ensiais.projetSI.Entities.Promotion;
import com.ensiais.projetSI.Services.Promoservice;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/promotions"})
@NoArgsConstructor
public class Promocontroller {
    @Autowired
    private Promoservice promoservice;

    @GetMapping
    public List<Promotion> getAllpromo(){
        return promoservice.listes_promo();
    }
    @GetMapping({"/{id}"})
    public Promotion getprof(@PathVariable long id){
        return promoservice.trouver_promo(id);
    }
    @PostMapping
    public String ajouter_professeur(@RequestBody Promotion promo){
        promoservice.creer_promo(promo);
        return "Félicitation le promo a été ajouté avec succès";
    }
    @DeleteMapping({"/{id}"})
    public String supprimer_prof(@PathVariable long id){
        promoservice.supprimer_promo(id);
        return "le promo a été supprimé avec succès";
    }
    @PutMapping
    public Promotion misajour_prof(@RequestBody Promotion pr){
        return promoservice.creer_promo(pr);
    }
    @DeleteMapping
    public String suprime(){
        promoservice.supprime_tout();
        return "tout est supprimés";
    }
}

