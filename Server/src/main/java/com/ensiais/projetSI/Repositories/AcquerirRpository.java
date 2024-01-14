package com.ensiais.projetSI.Repositories;
import java.lang.*;
import java.util.List;

import com.ensiais.projetSI.Entities.Acquerir;
import com.ensiais.projetSI.Entities.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AcquerirRpository extends JpaRepository<Acquerir, Integer> {
    @Query("SELECT code_competence FROM Acquerir where niveau_exigé = : niv")
    public List<Competence> findByNiveauExigé(int niv);
    @Query("SELECT a FROM Acquerir a WHERE a.code_competence = :codeCompetence AND a.idTypeStage = :idTypeStage")
    Acquerir findByCodeCompetenceAndIdTypeStage(String codeCompetence, int idTypeStage);
    public List<Competence> findCompetenceByIdTypeStage(int id);
}
