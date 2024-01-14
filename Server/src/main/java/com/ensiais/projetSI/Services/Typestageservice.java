package com.ensiais.projetSI.Services;

import java.util.List;




import com.ensiais.projetSI.Entities.Promotion;

import com.ensiais.projetSI.Entities.Typestage;

import com.ensiais.projetSI.Repositories.StageRepository;
import com.ensiais.projetSI.Repositories.TypestageRpository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class Typestageservice {
    private TypestageRpository typ;
    private StageRepository st;
    public Typestage creer_typestage(Typestage e){
        return typ.save(e);
    }
    public void supprimer_typestage(int id){
        Typestage e =trouver_typestage(id);
        typ.delete(e);
    }
    public Typestage trouver_typestage(int id){
        Optional<Typestage> et = typ.findById(id);
        return et.get();
    }
    public List<Typestage> listes_types(){
        return typ.findAll();
    }
    public void supprime_tout(){
       typ.findAll().forEach(e->typ.delete(e));
    }

}


