package com.ensiais.projetSI.Services;

import com.ensiais.projetSI.Entities.Entreprise;

import com.ensiais.projetSI.Entities.Stage;
import com.ensiais.projetSI.Entities.Tuteur;
import com.ensiais.projetSI.Repositories.EntrepriseRpository;
import com.ensiais.projetSI.Repositories.StageRepository;
import com.ensiais.projetSI.Repositories.TuteurRpository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class Entrepriseservice {
    private EntrepriseRpository entre;
    private StageRepository stage;
    private TuteurRpository tuteur;

    public Entreprise save(Entreprise e){
        return entre.save(e);
    }
    public void supprimer_entreprise(long id){
        Entreprise e =trouver_entreprise(id);
        entre.delete(e);
    }
    public Entreprise trouver_entreprise(long id){
        Optional<Entreprise> et = entre.findById(id);
        return et.get();
    }
    public List<Entreprise> listes_entreprise(){
        List<Entreprise> entreprises = entre.findAll();
        return entreprises.isEmpty() ? null : entreprises;
    }
    public List<Stage> stages_entreprise(long id){
        Entreprise e =trouver_entreprise(id);
        return e.getStages();
    }
    public List<Tuteur> tuteurs_entreprise(long id){

        return null ;// tuteur.findByEntreprise_Id(id);
    }
    public void supprime_tout(){

        entre.findAll().forEach(e->entre.delete(e));
    }
}

