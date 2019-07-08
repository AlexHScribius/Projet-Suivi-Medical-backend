package com.fr.projetMedical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fr.projetMedical.model.Administration;

@EnableJpaRepositories
@Repository
public interface AdministrationRepository extends JpaRepository<Administration, Long>{
	
	@Query("SELECT a FROM Administration a WHERE a.idAdministration=:idAdministration")
	public Administration findByIdAdministration(@Param("idAdministration") Long id);

}


