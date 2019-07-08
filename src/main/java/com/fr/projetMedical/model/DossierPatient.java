package com.fr.projetMedical.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="dossierPatient")
public class DossierPatient {

	///////////////////////////////////////////////////////////////////////////
	// Attributs :
	private Long idDossierPatient;

	private List<Consultation> listeConsultations;
	private Patient patient;
	private List<Maladie> listeMaladies;
	
	///////////////////////////////////////////////////////////////////////////
	// Getters && Setters :
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idDossierPatient")
	public Long getIdDossierPatient() {
		return idDossierPatient;
	}

	public void setIdDossierPatient(Long idDossierPatient) {
		this.idDossierPatient = idDossierPatient;
	}

	///////////////////////////////////////////////////////////////////////////
	// Associations :
	@OneToMany(fetch = FetchType.LAZY, mappedBy="dossierPatient")
	@JsonIgnore
	public List<Consultation> getListeConsultations() {
		return listeConsultations;
	}

	public void setListeConsultations(List<Consultation> listeConsultations) {
		this.listeConsultations = listeConsultations;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idPatient")
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy="dossierPatient")
	@JsonIgnore
	public List<Maladie> getListeMaladies() {
		return listeMaladies;
	}

	public void setListeMaladies(List<Maladie> listeMaladies) {
		this.listeMaladies = listeMaladies;
	}

	///////////////////////////////////////////////////////////////////////////
	// ToString redéfini :
	@Override
	public String toString() {
		return "DossierPatientDto [idDossierPatient=" + idDossierPatient + "]";
	}
	
}
