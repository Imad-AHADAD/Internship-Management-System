package com.ensiais.projetSI.Conrollers;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//




import com.ensiais.projetSI.Entities.Entreprise;
import com.ensiais.projetSI.Entities.Stage;
import com.ensiais.projetSI.Entities.Tuteur;
import com.ensiais.projetSI.Services.Entrepriseservice;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/entreprises"})
@CrossOrigin("*")
public class EnrepriseController {
    @Autowired
    private Entrepriseservice entrepriseService;


    @GetMapping
    public List<Entreprise> getAllEntreprises() {
        return entrepriseService.listes_entreprise();


    }

    @GetMapping({"/{id}"})
    public Entreprise getEntrepriseById(@PathVariable Long id) {
        return entrepriseService.trouver_entreprise(id);
    }

    @PostMapping
    public Entreprise saveEntreprise(@RequestBody Entreprise entreprise) {
        return entrepriseService.save(entreprise);
    }
    @PutMapping
    public Entreprise misajourEntreprise(@RequestBody Entreprise entreprise) {
        return entrepriseService.save(entreprise);
    }

    @DeleteMapping({"/{id}"})
    public void deleteEntreprise(@PathVariable Long id) {
        entrepriseService.supprimer_entreprise(id);
    }
    @GetMapping("/listesstages/{id}")
    public List<Stage> stagesentrepris(@PathVariable long id){
        return entrepriseService.stages_entreprise(id);
    }
    @GetMapping("/listestuteurs{id}")
    public List<Tuteur> tuteursentrepris(@PathVariable long id){
        return entrepriseService.tuteurs_entreprise(id);
    }
    @DeleteMapping
    public String suprime(){
        entrepriseService.supprime_tout();
        return "tout est supprimés";
    }
}

