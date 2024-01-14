package com.ensiais.projetSI.Services;


import com.ensiais.projetSI.Entities.Entreprise;
import com.ensiais.projetSI.Entities.Professeur;
import com.ensiais.projetSI.Entities.Promotion;

import com.ensiais.projetSI.Repositories.PromotionRpository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class Promoservice {
    private PromotionRpository promorep;
    public Promotion creer_promo(Promotion e){
        Professeur ent = e.getProfesseur();
        ent.getPromotions().add(e);
        return promorep.save(e);
    }
    public void supprimer_promo(long id){
        Promotion e =trouver_promo(id);
        promorep.delete(e);
    }
    public Promotion trouver_promo(long id){
        Optional<Promotion> et = promorep.findById(id);
        return et.get();
    }
    public List<Promotion> listes_promo(){
        return promorep.findAll();
    }
    public void supprime_tout(){
        promorep.findAll().forEach(e->promorep.delete(e));
    }
}

