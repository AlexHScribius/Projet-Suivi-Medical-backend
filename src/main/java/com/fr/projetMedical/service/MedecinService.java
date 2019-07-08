package com.fr.projetMedical.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.projetMedical.model.Medecin;
import com.fr.projetMedical.repository.MedecinRepository;

@Service
public class MedecinService {
	
	@Autowired
	private MedecinRepository medecinRepository;

	@Transactional(readOnly = true)
	public List<Medecin> findAll() {
		List<Medecin> listeMedecins = medecinRepository.findAll();
		return listeMedecins;
	}
	
	@Transactional(readOnly = true)
	public Medecin findByIdMedecin(Long id) {
		return medecinRepository.findByIdMedecin(id);
	}
	
	@Transactional
	public void add(Medecin medecin) {
		medecinRepository.save(medecin);
	}

	@Transactional
	public void addAll(Collection<Medecin> medecins) {
		for (Medecin medecin : medecins) {
			medecinRepository.save(medecin);
		}
	}

	@Transactional
	public void update(Medecin medecin) {
		medecinRepository.findByIdMedecin(medecin.getIdMedecin()).setLogin(medecin.getLogin());
		medecinRepository.findByIdMedecin(medecin.getIdMedecin()).setPwd(medecin.getPwd());
		medecinRepository.findByIdMedecin(medecin.getIdMedecin()).setAdresse(medecin.getAdresse());
		medecinRepository.findByIdMedecin(medecin.getIdMedecin()).setAge(medecin.getAge());
		medecinRepository.findByIdMedecin(medecin.getIdMedecin()).setListeConsultations(medecin.getListeConsultations());
		medecinRepository.findByIdMedecin(medecin.getIdMedecin()).setMail(medecin.getMail());
		medecinRepository.findByIdMedecin(medecin.getIdMedecin()).setNom(medecin.getNom());
		medecinRepository.findByIdMedecin(medecin.getIdMedecin()).setPrenom(medecin.getPrenom());
		medecinRepository.findByIdMedecin(medecin.getIdMedecin()).setSalaire(medecin.getSalaire());
		medecinRepository.findByIdMedecin(medecin.getIdMedecin()).setTelephone(medecin.getTelephone());
	}

	@Transactional
	public void delete(Collection<Medecin> medecins) {
		for (Medecin medecin : medecins) {
			medecinRepository.delete(medecin);
		}
	}

	@Transactional
	public void delete(Medecin medecin) {
		medecinRepository.delete(medecin);
	}
	
	@Transactional
	public void deleteById(Long medecinId) {
		medecinRepository.deleteById(medecinId);
	}
	
	

}
