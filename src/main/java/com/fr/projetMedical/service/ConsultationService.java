package com.fr.projetMedical.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.projetMedical.model.Consultation;
import com.fr.projetMedical.repository.ConsultationRepository;

@Service
public class ConsultationService {
	
	@Autowired
	private ConsultationRepository consultationRepository;

	@Transactional(readOnly = true)
	public List<Consultation> findAll() {
		List<Consultation> listeConsultations = consultationRepository.findAll();
		return listeConsultations;
	}
	
	@Transactional(readOnly = true)
	public Consultation findByIdConsultation(Long id) {
		return consultationRepository.findByIdConsultation(id);
	}
	
	@Transactional(readOnly = true)
	public List<Consultation> findByIdDossierPatient(Long idDossierPatient) {
		List<Consultation> listeConsultations = consultationRepository.findByIdDossierPatient(idDossierPatient);
		return listeConsultations;
	}
	
	@Transactional
	public void add(Consultation consultation) {
		consultationRepository.save(consultation);
	}

	@Transactional
	public void addAll(Collection<Consultation> consultations) {
		for (Consultation consultation : consultations) {
			consultationRepository.save(consultation);
		}
	}

	@Transactional
	public void update(Consultation consultation) {
		consultationRepository.findByIdConsultation(consultation.getIdConsultation()).setAnnulee(consultation.isAnnulee());
		consultationRepository.findByIdConsultation(consultation.getIdConsultation()).setDate(consultation.getDate());
		consultationRepository.findByIdConsultation(consultation.getIdConsultation()).setDossierPatient(consultation.getDossierPatient());
		consultationRepository.findByIdConsultation(consultation.getIdConsultation()).setEffectuee(consultation.isEffectuee());
		consultationRepository.findByIdConsultation(consultation.getIdConsultation()).setFacture(consultation.getFacture());
		consultationRepository.findByIdConsultation(consultation.getIdConsultation()).setMedecin(consultation.getMedecin());
		
	}

	@Transactional
	public void delete(Collection<Consultation> consultations) {
		for (Consultation consultation : consultations) {
			consultationRepository.delete(consultation);
		}
	}

	@Transactional
	public void delete(Consultation consultation) {
		consultationRepository.delete(consultation);
	}
	
	@Transactional
	public void deleteById(Long consultationId) {
		consultationRepository.deleteById(consultationId);
	}
	
	

}
