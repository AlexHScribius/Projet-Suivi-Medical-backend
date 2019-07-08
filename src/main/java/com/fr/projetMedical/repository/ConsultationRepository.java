package com.fr.projetMedical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fr.projetMedical.model.Consultation;

@EnableJpaRepositories
@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long>{
	
	@Query("SELECT c FROM Consultation c WHERE c.idConsultation=:idConsultation")
	public Consultation findByIdConsultation(@Param("idConsultation") Long id);
	
	@Query("SELECT c FROM Consultation c,DossierPatient dp WHERE dp.idDossierPatient=:idDossierPatient")
	public List<Consultation> findByIdDossierPatient(@Param("idDossierPatient") Long idDossierPatient);

}


