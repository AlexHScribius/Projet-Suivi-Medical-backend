package com.fr.projetMedical.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.projetMedical.model.BulletinSalaire;
import com.fr.projetMedical.repository.BulletinSalaireRepository;

@Service
public class BulletinSalaireService {
	
	@Autowired
	private BulletinSalaireRepository bulletinSalaireRepository;

	@Transactional(readOnly = true)
	public List<BulletinSalaire> findAll() {
		List<BulletinSalaire> listeBulletinSalaires = bulletinSalaireRepository.findAll();
		return listeBulletinSalaires;
	}
	
	@Transactional(readOnly = true)
	public BulletinSalaire findByIdBulletinSalaire(Long id) {
		return bulletinSalaireRepository.findByIdBulletinSalaire(id);
	}
	
	@Transactional
	public void add(BulletinSalaire bulletinSalaire) {
		bulletinSalaireRepository.save(bulletinSalaire);
	}

	@Transactional
	public void addAll(Collection<BulletinSalaire> bulletinSalaires) {
		for (BulletinSalaire bulletinSalaire : bulletinSalaires) {
			bulletinSalaireRepository.save(bulletinSalaire);
		}
	}

	@Transactional
	public void update(BulletinSalaire bulletinSalaire) {
		bulletinSalaireRepository.findByIdBulletinSalaire(bulletinSalaire.getIdBulletinSalaire()).setMedecin(bulletinSalaire.getMedecin());
		bulletinSalaireRepository.findByIdBulletinSalaire(bulletinSalaire.getIdBulletinSalaire()).setMontant(bulletinSalaire.getMontant());
	}

	@Transactional
	public void delete(Collection<BulletinSalaire> bulletinSalaires) {
		for (BulletinSalaire bulletinSalaire : bulletinSalaires) {
			bulletinSalaireRepository.delete(bulletinSalaire);
		}
	}

	@Transactional
	public void delete(BulletinSalaire bulletinSalaire) {
		bulletinSalaireRepository.delete(bulletinSalaire);
	}
	
	@Transactional
	public void deleteById(Long bulletinSalaireId) {
		bulletinSalaireRepository.deleteById(bulletinSalaireId);
	}
	
	

}
