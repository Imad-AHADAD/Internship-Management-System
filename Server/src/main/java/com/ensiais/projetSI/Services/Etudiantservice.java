package com.ensiais.projetSI.Services;

import com.ensiais.projetSI.Entities.*;
import com.ensiais.projetSI.Repositories.EtudianteRpository;
//import com.ensiais.projetSI.Repositories.ProfesseurRpository;
import com.ensiais.projetSI.Repositories.StageRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
@Transactional
public class Etudiantservice {
    private EtudianteRpository etdrepo;
    private StageRepository stage;
//    private ProfesseurRpository professeurRpository;
    //static List<Etudiante> li=new ArrayList<>();
    public Etudiante creer_etudiant(Etudiante e){
        //Professeur ent = e.getProfesseur();
        //li.add(e);
        //ent.setEtudiante(li);
        //professeurRpository.save(ent);
        //Promotion pr = e.getPromotion();
        //pr.setEtudiants((List<Etudiante>) e);
        //Etudiante et=new Etudiante();
        //et=e;
        return etdrepo.save(e);
    }
    public void supprimer_etudinat(long id){
        Etudiante e =trouver_etudiant(id);
        etdrepo.delete(e);
    }
    public Etudiante trouver_etudiant(long id) {
        return etdrepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No etudiant found with ID: " + id));
    }

    public List<Etudiante> listes_etudiant() {
        List<Etudiante> etudiants = etdrepo.findAll();

        if (etudiants.isEmpty()) {
            throw new NoSuchElementException("No students found");
        }
        return etudiants;
    }
    public List<Stage> stages_etudiant(long id){
        Etudiante e =trouver_etudiant(id);
        return stage.findStageByEtudiante(e);
    }
    public Tuteur tuteur_etudiant(long id) {
        Etudiante e = trouver_etudiant(id);
        return e.getTuteur();
    }
    public List<Etudiante> etudiants_par_promos(long annee){

        return etdrepo.findByPromotion(annee);
    }
    public void supprime_tout(){
        etdrepo.findAll().forEach(e->etdrepo.delete(e));
    }
}
