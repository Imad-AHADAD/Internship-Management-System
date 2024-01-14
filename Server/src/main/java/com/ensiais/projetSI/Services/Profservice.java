package com.ensiais.projetSI.Services;


import com.ensiais.projetSI.Entities.Etudiante;
import com.ensiais.projetSI.Entities.Professeur;
import com.ensiais.projetSI.Entities.Stage;
import com.ensiais.projetSI.Entities.Tuteur;
import com.ensiais.projetSI.Repositories.EtudianteRpository;
import com.ensiais.projetSI.Repositories.ProfesseurRpository;
import com.ensiais.projetSI.Repositories.StageRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class Profservice {
    private ProfesseurRpository profrepo;
    private EtudianteRpository etud;
    public Professeur creer_prof(Professeur e){
        return profrepo.save(e);
    }
    public void supprimer_prof(String id){
        Professeur e =trouver_prof(id);
        profrepo.delete(e);
    }
    public Professeur trouver_prof(String id){
        Optional<Professeur> et = profrepo.findById(id);
        return et.get();
    }
    public List<Professeur> listes_prof(){
        return profrepo.findAll();
    }
    public List<Etudiante> listsetud(String id){
        return etud.findEtudianteByProfesseurId(id);
    }
    public void supprime_tout(){
        profrepo.findAll().forEach(e->profrepo.delete(e));
    }

}

