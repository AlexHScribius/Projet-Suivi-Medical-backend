package com.fr.projetMedical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fr.projetMedical.model.Medecin;

@EnableJpaRepositories
@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Long>{
	
	@Query("SELECT m FROM Medecin m WHERE m.idMedecin=:idMedecin")
	public Medecin findByIdMedecin(@Param("idMedecin") Long id);

}


