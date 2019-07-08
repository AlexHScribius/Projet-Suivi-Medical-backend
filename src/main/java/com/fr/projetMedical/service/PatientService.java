package com.fr.projetMedical.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.projetMedical.model.Patient;
import com.fr.projetMedical.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;

	@Transactional(readOnly = true)
	public List<Patient> findAll() {
		List<Patient> listePatients = patientRepository.findAll();
		return listePatients;
	}
	
	@Transactional(readOnly = true)
	public Patient findByIdPatient(Long id) {
		return patientRepository.findByIdPatient(id);
	}
	
	@Transactional
	public void add(Patient patient) {
		patientRepository.save(patient);
	}

	@Transactional
	public void addAll(Collection<Patient> patients) {
		for (Patient patient : patients) {
			patientRepository.save(patient);
		}
	}

	@Transactional
	public void update(Patient patient) {
		patientRepository.findByIdPatient(patient.getIdPatient()).setLogin(patient.getLogin());
		patientRepository.findByIdPatient(patient.getIdPatient()).setPwd(patient.getPwd());
		patientRepository.findByIdPatient(patient.getIdPatient()).setAdresse(patient.getAdresse());
		patientRepository.findByIdPatient(patient.getIdPatient()).setAge(patient.getAge());
		patientRepository.findByIdPatient(patient.getIdPatient()).setMail(patient.getMail());
		patientRepository.findByIdPatient(patient.getIdPatient()).setNom(patient.getNom());
		patientRepository.findByIdPatient(patient.getIdPatient()).setPrenom(patient.getPrenom());
		patientRepository.findByIdPatient(patient.getIdPatient()).setTelephone(patient.getTelephone());
		patientRepository.findByIdPatient(patient.getIdPatient()).setDossierPatient(patient.getDossierPatient());
		patientRepository.findByIdPatient(patient.getIdPatient()).setNumeroSecuriteSociale(patient.getNumeroSecuriteSociale());
	}

	@Transactional
	public void delete(Collection<Patient> patients) {
		for (Patient patient : patients) {
			patientRepository.delete(patient);
		}
	}

	@Transactional
	public void delete(Patient patient) {
		patientRepository.delete(patient);
	}
	
	@Transactional
	public void deleteById(Long patientId) {
		patientRepository.deleteById(patientId);
	}
	
	

}
