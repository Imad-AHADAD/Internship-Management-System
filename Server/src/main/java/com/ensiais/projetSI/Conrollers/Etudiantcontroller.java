package com.ensiais.projetSI.Conrollers;

import com.ensiais.projetSI.Entities.Etudiante;
import com.ensiais.projetSI.Entities.Stage;
import com.ensiais.projetSI.Entities.Tuteur;
import com.ensiais.projetSI.Services.Etudiantservice;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/etudiants"})
@CrossOrigin("*")
public class Etudiantcontroller {
    @Autowired
    private Etudiantservice etudiantservice;

    @GetMapping
    public List<Etudiante> getetudiant(){

        return etudiantservice.listes_etudiant();
    }

    @GetMapping({"/{id}"})
    public Etudiante chercheretudiant(@PathVariable long id ){

        return etudiantservice.trouver_etudiant(id);
    }

    @DeleteMapping({"/{id}"})
    public String supprimer_etudiant(@PathVariable long id){
        etudiantservice.supprimer_etudinat(id);
        return "etudiant de numero "+ id +"est supprimé";
    }

    @PostMapping
    public Etudiante ajouter_etudiant(@RequestBody Etudiante e){

        return etudiantservice.creer_etudiant(e);
    }

    @PutMapping
    public Etudiante misajour_etudiant(@RequestBody Etudiante e){

        return etudiantservice.creer_etudiant(e);
    }

    @GetMapping("/stageetudiants{id}")
    public List<Stage> stagesetudiant(@PathVariable long id){

        return etudiantservice.stages_etudiant(id);
    }

    @GetMapping("/tuteuretudiant{id}")
    public Tuteur tuteuretudiant(@PathVariable long id){

        return etudiantservice.tuteur_etudiant(id);
    }

    @GetMapping("/promoetudiants{annee}")
    public List<Etudiante> promoetudiants(@PathVariable long anne){
        return etudiantservice.etudiants_par_promos(anne);
    }

    @DeleteMapping
    public String suprime(){
        etudiantservice.supprime_tout();
        return "tout est supprimés";
    }


}
