package com.fr.projetMedical.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.projetMedical.model.Administration;
import com.fr.projetMedical.repository.AdministrationRepository;

@Service
public class AdministrationService {
	
	@Autowired
	private AdministrationRepository administrationRepository;

	@Transactional(readOnly = true)
	public List<Administration> findAll() {
		List<Administration> listeAdministrations = administrationRepository.findAll();
		return listeAdministrations;
	}
	
	@Transactional(readOnly = true)
	public Administration findByIdAdministration(Long id) {
		return administrationRepository.findByIdAdministration(id);
	}
	
	@Transactional
	public void add(Administration administration) {
		administrationRepository.save(administration);
	}

	@Transactional
	public void addAll(Collection<Administration> administrations) {
		for (Administration administration : administrations) {
			administrationRepository.save(administration);
		}
	}

	@Transactional
	public void update(Administration administration) {
		administrationRepository.findByIdAdministration(administration.getIdAdministration()).setLogin(administration.getLogin());
		administrationRepository.findByIdAdministration(administration.getIdAdministration()).setPwd(administration.getPwd());
	}

	@Transactional
	public void delete(Collection<Administration> administrations) {
		for (Administration administration : administrations) {
			administrationRepository.delete(administration);
		}
	}

	@Transactional
	public void delete(Administration administration) {
		administrationRepository.delete(administration);
	}
	
	@Transactional
	public void deleteById(Long administrationId) {
		administrationRepository.deleteById(administrationId);
	}
	
	

}
