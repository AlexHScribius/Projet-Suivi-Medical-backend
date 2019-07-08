package com.fr.projetMedical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fr.projetMedical.model.Patient;

@EnableJpaRepositories
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	@Query("SELECT p FROM Patient p WHERE p.idPatient=:idPatient")
	public Patient findByIdPatient(@Param("idPatient") Long id);

}


