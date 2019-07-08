package com.fr.projetMedical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fr.projetMedical.model.BulletinSalaire;

@EnableJpaRepositories
@Repository
public interface BulletinSalaireRepository extends JpaRepository<BulletinSalaire, Long>{
	
	@Query("SELECT bs FROM BulletinSalaire bs WHERE bs.idBulletinSalaire=:idBulletinSalaire")
	public BulletinSalaire findByIdBulletinSalaire(@Param("idBulletinSalaire") Long id);

}


