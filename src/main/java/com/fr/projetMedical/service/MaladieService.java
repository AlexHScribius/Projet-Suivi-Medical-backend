package com.fr.projetMedical.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.projetMedical.model.Maladie;
import com.fr.projetMedical.repository.MaladieRepository;

@Service
public class MaladieService {
	
	@Autowired
	private MaladieRepository maladieRepository;

	@Transactional(readOnly = true)
	public List<Maladie> findAll() {
		List<Maladie> listeMaladies = maladieRepository.findAll();
		return listeMaladies;
	}
	
	@Transactional(readOnly = true)
	public Maladie findByIdMaladie(Long id) {
		return maladieRepository.findByIdMaladie(id);
	}
	
	@Transactional(readOnly = true)
	public List<Maladie> findByIdDossierPatient(Long idDossierPatient) {
		List<Maladie> listeMaladies = maladieRepository.findByIdDossierPatient(idDossierPatient);
		return listeMaladies;
	}
	
	@Transactional
	public void add(Maladie maladie) {
		maladieRepository.save(maladie);
	}

	@Transactional
	public void addAll(Collection<Maladie> maladies) {
		for (Maladie maladie : maladies) {
			maladieRepository.save(maladie);
		}
	}

	@Transactional
	public void update(Maladie maladie) {
		maladieRepository.findByIdMaladie(maladie.getIdMaladie()).setDateDebut(maladie.getDateDebut());
		maladieRepository.findByIdMaladie(maladie.getIdMaladie()).setDateFin(maladie.getDateFin());
		maladieRepository.findByIdMaladie(maladie.getIdMaladie()).setDossierPatient(maladie.getDossierPatient());
		maladieRepository.findByIdMaladie(maladie.getIdMaladie()).setInformationsSupplementaires(maladie.getInformationsSupplementaires());
		maladieRepository.findByIdMaladie(maladie.getIdMaladie()).setNom(maladie.getNom());
		maladieRepository.findByIdMaladie(maladie.getIdMaladie()).setTraitementEffectue(maladie.getTraitementEffectue());
		maladieRepository.findByIdMaladie(maladie.getIdMaladie()).setTraitementPreconise(maladie.getTraitementPreconise());
	}

	@Transactional
	public void delete(Collection<Maladie> maladies) {
		for (Maladie maladie : maladies) {
			maladieRepository.delete(maladie);
		}
	}

	@Transactional
	public void delete(Maladie maladie) {
		maladieRepository.delete(maladie);
	}
	
	@Transactional
	public void deleteById(Long maladieId) {
		maladieRepository.deleteById(maladieId);
	}
	
	

}
