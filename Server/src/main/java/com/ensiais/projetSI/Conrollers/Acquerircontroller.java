package com.ensiais.projetSI.Conrollers;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//




import com.ensiais.projetSI.Entities.Acquerir;
import com.ensiais.projetSI.Entities.Competence;
import com.ensiais.projetSI.Entities.Entreprise;
import com.ensiais.projetSI.Services.Acquerirservice;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/acquerir"})
public class Acquerircontroller {
    @Autowired
    private Acquerirservice acquerirservice;


    @GetMapping
    public List<Acquerir> getAllacquerir() {
        return acquerirservice.lises_acquerir();
    }

    @GetMapping({"/{id_code}"})
    public Acquerir getacquerir(@PathVariable String id_code) {

        return acquerirservice.trouver_acqurir(id_code);
    }

    @PostMapping
    public String saveacqurir(@RequestBody Acquerir acquerir) {
        acquerirservice.creer_acqurir(acquerir);
        return "ajout est réussi";
    }
    @PutMapping
    public Acquerir misajouracquerir(@RequestBody Acquerir acquerir) {
        return acquerirservice.creer_acqurir(acquerir);
    }
    @DeleteMapping({"/{id_code}"})
    public String deleteacquerir(@PathVariable String id_code) {

        acquerirservice.supprimer_acqurir(id_code);
        return "la ligne acquerir est bien supprimée";
    }
    @GetMapping({"/{id}"}) //a revenir pour resoudre prob
    public List<Competence> listes_competences(@PathVariable int id){
        System.out.println("ID: " + id);
        return acquerirservice.listes_competence_pour_un_typestage(id);
    }
    @DeleteMapping
    public String suprime(){
        acquerirservice.supprime_tout();
        return "tout est supprimés";
    }
}


