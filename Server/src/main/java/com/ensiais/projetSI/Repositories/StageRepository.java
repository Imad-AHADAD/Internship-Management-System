package com.ensiais.projetSI.Repositories;

import com.ensiais.projetSI.Entities.Entreprise;
import com.ensiais.projetSI.Entities.Etudiante;
import com.ensiais.projetSI.Entities.Stage;
import com.ensiais.projetSI.Entities.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StageRepository extends JpaRepository<Stage, Long> {
    public List<Stage> findStageByEtudiante(Etudiante e);
    public List<Stage> findStageByEntreprise(Entreprise e);
    List<Stage>  findStageByTuteur(Tuteur t);
    List<Stage> findStageByTypeStage(String type);
}
