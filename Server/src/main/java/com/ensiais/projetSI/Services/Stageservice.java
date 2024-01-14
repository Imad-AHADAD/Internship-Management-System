package com.ensiais.projetSI.Services;

import com.ensiais.projetSI.Entities.*;
import com.ensiais.projetSI.Repositories.EntrepriseRpository;
import com.ensiais.projetSI.Repositories.EtudianteRpository;
import com.ensiais.projetSI.Repositories.StageRepository;
import com.ensiais.projetSI.Repositories.TuteurRpository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class Stageservice {
    private EtudianteRpository etdrepo;
    private StageRepository stage;
    private EntrepriseRpository entreprise;
    private TuteurRpository tut;

    public Stage creer_stage(Stage e/*,long id*/){
        //Optional<Entreprise> ent = entreprise.findById(id);
        //Entreprise entt = ent.get();
        //e.setEntreprise(entt);
        //List<Stage> li= entt.getStages();
        //li.add(e);
        //entt.setStages(li);
        //entreprise.save(entt);
        /*Entreprise ent = e.getEntreprise();
        ent.getStages().add(e);
        Etudiante etudiante = e.getEtudiante();
        etudiante.getStageList().add(e);
        Tuteur tit = e.getTuteur();
        tit.getStages().add(e);*/
        return stage.save(e);
    }

    public void supprimer_stage(long id){
        Stage e =trouver_stage(id);
        stage.delete(e);
    }
    public Stage trouver_stage(long id){
        Optional<Stage> et = stage.findById(id);
        return et.get();
    }
    public List<Stage> listes_stage(){
        return stage.findAll();
    }
    public List<Stage> listes_stages_pr_types(String codetype){
        return  stage.findStageByTypeStage(codetype);
    }

    public void supprime_tout(){
        stage.findAll().forEach(e->stage.delete(e));
    }
}


