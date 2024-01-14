package com.ensiais.projetSI.Repositories;

import com.ensiais.projetSI.Entities.Etudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EtudianteRpository extends JpaRepository<Etudiante, Long> {
    @Query("SELECT a FROM Etudiante a WHERE a.promotion = : annee")
    List<Etudiante> findByPromotion(long annee);
    @Query("SELECT a FROM Etudiante a WHERE a.professeur.id = : id")
    List<Etudiante> findEtudianteByProfesseurId(String id);
}
