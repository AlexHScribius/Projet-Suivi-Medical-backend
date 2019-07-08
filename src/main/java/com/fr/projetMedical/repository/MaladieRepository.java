package com.fr.projetMedical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fr.projetMedical.model.Maladie;

@EnableJpaRepositories
@Repository
public interface MaladieRepository extends JpaRepository<Maladie, Long>{
	
	@Query("SELECT m FROM Maladie m GROUP BY m.nom")
	public List<Maladie> findAll();
	
	@Query("SELECT m FROM Maladie m WHERE m.idMaladie=:idMaladie")
	public Maladie findByIdMaladie(@Param("idMaladie") Long id);
	
	@Query("SELECT m FROM Maladie m,DossierPatient dp WHERE dp.idDossierPatient=:idDossierPatient")
	public List<Maladie> findByIdDossierPatient(@Param("idDossierPatient") Long idDossierPatient);

}


