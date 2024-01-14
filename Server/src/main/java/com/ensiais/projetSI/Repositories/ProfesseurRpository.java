package com.ensiais.projetSI.Repositories;

import com.ensiais.projetSI.Entities.Etudiante;
import com.ensiais.projetSI.Entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesseurRpository extends JpaRepository<Professeur,String> {
}
