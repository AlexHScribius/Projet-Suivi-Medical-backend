package com.fr.projetMedical.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.projetMedical.model.DossierPatient;
import com.fr.projetMedical.repository.DossierPatientRepository;

@Service
public class DossierPatientService {
	
	@Autowired
	private DossierPatientRepository dossierPatientRepository;

	@Transactional(readOnly = true)
	public List<DossierPatient> findAll() {
		List<DossierPatient> listeDossierPatients = dossierPatientRepository.findAll();
		return listeDossierPatients;
	}
	
	@Transactional(readOnly = true)
	public DossierPatient findByIdDossierPatient(Long id) {
		return dossierPatientRepository.findByIdDossierPatient(id);
	}
	
	@Transactional
	public void add(DossierPatient dossierPatient) {
		dossierPatientRepository.save(dossierPatient);
	}

	@Transactional
	public void addAll(Collection<DossierPatient> dossierPatients) {
		for (DossierPatient dossierPatient : dossierPatients) {
			dossierPatientRepository.save(dossierPatient);
		}
	}

	@Transactional
	public void update(DossierPatient dossierPatient) {
		dossierPatientRepository.findByIdDossierPatient(dossierPatient.getIdDossierPatient()).setPatient(dossierPatient.getPatient());
		dossierPatientRepository.findByIdDossierPatient(dossierPatient.getIdDossierPatient()).setListeConsultations(dossierPatient.getListeConsultations());
		dossierPatientRepository.findByIdDossierPatient(dossierPatient.getIdDossierPatient()).setListeMaladies(dossierPatient.getListeMaladies());
	}

	@Transactional
	public void delete(Collection<DossierPatient> dossierPatients) {
		for (DossierPatient dossierPatient : dossierPatients) {
			dossierPatientRepository.delete(dossierPatient);
		}
	}

	@Transactional
	public void delete(DossierPatient dossierPatient) {
		dossierPatientRepository.delete(dossierPatient);
	}
	
	@Transactional
	public void deleteById(Long dossierPatientId) {
		dossierPatientRepository.deleteById(dossierPatientId);
	}
	
	

}
