package com.ensiais.projetSI.Services;
import com.ensiais.projetSI.Entities.Entreprise;
import com.ensiais.projetSI.Entities.Stage;

import java.util.List;




import com.ensiais.projetSI.Entities.Promotion;

import com.ensiais.projetSI.Entities.Tuteur;

import com.ensiais.projetSI.Repositories.StageRepository;
import com.ensiais.projetSI.Repositories.TuteurRpository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class Tuteurservice {
    private TuteurRpository promorep;
    private StageRepository st;
    public Tuteur creer_Tuteur(Tuteur e){
       // Entreprise ent = e.getEntreprise();
        //ent.getTuteurs().add(e);
        return promorep.save(e);
    }
    public void supprimer_tuteur(String id){
        Tuteur e =trouver_tuteur(id);
        promorep.delete(e);
    }
    public Tuteur trouver_tuteur(String id){
        Optional<Tuteur> et = promorep.findById(id);
        return et.get();
    }
    public List<Tuteur> listes_tuteur(){
        return promorep.findAll();
    }
    public List<Stage> tuteur_stages(String id){
        Tuteur e =trouver_tuteur(id);
        return  st.findStageByTuteur(e);
        }
    public void supprime_tout(){
        promorep.findAll().forEach(e->promorep.delete(e));
    }
}


