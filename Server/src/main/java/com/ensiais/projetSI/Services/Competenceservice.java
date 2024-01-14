package com.ensiais.projetSI.Services;

import com.ensiais.projetSI.Entities.Competence;
import com.ensiais.projetSI.Repositories.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class Competenceservice {
    private CompetenceRpository comp;
    private AcquerirRpository acq;
    public Competence creer_competence(Competence c){
        return comp.save(c);
    }
    public void supprimer_competence(String code){
        Competence e =trouver_competence(code);
        comp.delete(e);
    }
    public List<Competence> listes_copetence(){
        return comp.findAll();
    }
    public Competence trouver_competence(String code){
        Optional<Competence> et = comp.findById(code);
        return et.get();
    }
    public List<Competence> listes_competence_pour_un_niveau(int niv){
        return acq.findByNiveauExigé(niv);
    }
    public void supprime_tout(){
        acq.findAll().forEach(e->acq.delete(e));
    }
}


