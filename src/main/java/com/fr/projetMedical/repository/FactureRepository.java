package com.fr.projetMedical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fr.projetMedical.model.Facture;

@EnableJpaRepositories
@Repository
public interface FactureRepository extends JpaRepository<Facture, Long>{
	
	@Query("SELECT f FROM Facture f WHERE f.idFacture=:idFacture")
	public Facture findByIdFacture(@Param("idFacture") Long id);

}


