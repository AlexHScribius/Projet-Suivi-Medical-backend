package com.fr.projetMedical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fr.projetMedical.model.DossierPatient;

@EnableJpaRepositories
@Repository
public interface DossierPatientRepository extends JpaRepository<DossierPatient, Long>{
	
	@Query("SELECT dp FROM DossierPatient dp WHERE dp.idDossierPatient=:idDossierPatient")
	public DossierPatient findByIdDossierPatient(@Param("idDossierPatient") Long id);

}


