package com.ensiais.projetSI.Repositories;

import com.ensiais.projetSI.Entities.Tuteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TuteurRpository extends JpaRepository<Tuteur,String> {
    @Query("SELECT a FROM Tuteur a WHERE a.entreprise.id = : id")
    List<Tuteur> findByEntreprise_Id(long id);

}
