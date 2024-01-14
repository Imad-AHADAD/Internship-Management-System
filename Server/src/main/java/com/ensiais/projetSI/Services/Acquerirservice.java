package com.ensiais.projetSI.Services;

import com.ensiais.projetSI.Entities.Acquerir;

import com.ensiais.projetSI.Entities.Competence;
import com.ensiais.projetSI.Repositories.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class Acquerirservice {
    private CompetenceRpository comp;
    private AcquerirRpository acq;
    public Acquerir creer_acqurir(Acquerir c){
        return acq.save(c);
    }
    public void supprimer_acqurir(String id_code){
        String [] parts = id_code.split("_");
        int idtypestage= Integer.parseInt(parts[0]);
        String code=parts[1];
        Acquerir et = acq.findByCodeCompetenceAndIdTypeStage(code,idtypestage);
        acq.delete(et);
    }
    public List<Acquerir> lises_acquerir(){
        return acq.findAll();
    }
    public Acquerir trouver_acqurir(String id_code){
        String [] parts = id_code.split("_");
        int idtypestage= Integer.parseInt(parts[0]);
        String code=parts[1];
        Acquerir et = acq.findByCodeCompetenceAndIdTypeStage(code,idtypestage);
        return et;
    }
    public List<Competence> listes_competence_pour_un_typestage(int id){
        return acq.findCompetenceByIdTypeStage(id);
    }
    public void supprime_tout(){
        acq.findAll().forEach(e->acq.delete(e));
    }
}


