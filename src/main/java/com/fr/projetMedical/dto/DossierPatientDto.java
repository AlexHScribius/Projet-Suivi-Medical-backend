package com.fr.projetMedical.dto;

import java.util.Date;
import java.util.List;

public class DossierPatientDto {

	///////////////////////////////////////////////////////////////////////////
	// Attributs :
	private Long idDossierPatient;

	private List<Long> listeIdConsultation;
	private List<Date> listeDateConsultation;
	
	private Long idPatient;
	private String prenomPatient;
	private String nomPatient;
	
	private List<Long> listeIdMaladie;
	private List<Long> listeNomMaladie;
	private List<Date> listeDateDebutMaladie;
	private List<Date> listeDateFinMaladie;
	private List<String> listeTraitementEffectueMaladie;
	private List<String> listeInformationsSupplementairesMaladie;
	
	///////////////////////////////////////////////////////////////////////////
	// Getters && Setters :
	public Long getIdDossierPatient() {
		return idDossierPatient;
	}

	public void setIdDossierPatient(Long idDossierPatient) {
		this.idDossierPatient = idDossierPatient;
	}
	
	public List<Long> getListeIdConsultation() {
		return listeIdConsultation;
	}	

	public void setListeIdConsultation(List<Long> listeIdConsultation) {
		this.listeIdConsultation = listeIdConsultation;
	}

	public List<Date> getListeDateConsultation() {
		return listeDateConsultation;
	}

	public void setListeDateConsultation(List<Date> listeDateConsultation) {
		this.listeDateConsultation = listeDateConsultation;
	}

	public Long getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}

	public String getPrenomPatient() {
		return prenomPatient;
	}

	public void setPrenomPatient(String prenomPatient) {
		this.prenomPatient = prenomPatient;
	}

	public String getNomPatient() {
		return nomPatient;
	}

	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}

	public List<Long> getListeIdMaladie() {
		return listeIdMaladie;
	}

	public void setListeIdMaladie(List<Long> listeIdMaladie) {
		this.listeIdMaladie = listeIdMaladie;
	}

	public List<Long> getListeNomMaladie() {
		return listeNomMaladie;
	}

	public void setListeNomMaladie(List<Long> listeNomMaladie) {
		this.listeNomMaladie = listeNomMaladie;
	}

	public List<Date> getListeDateDebutMaladie() {
		return listeDateDebutMaladie;
	}

	public void setListeDateDebutMaladie(List<Date> listeDateDebutMaladie) {
		this.listeDateDebutMaladie = listeDateDebutMaladie;
	}

	public List<Date> getListeDateFinMaladie() {
		return listeDateFinMaladie;
	}

	public void setListeDateFinMaladie(List<Date> listeDateFinMaladie) {
		this.listeDateFinMaladie = listeDateFinMaladie;
	}

	public List<String> getListeTraitementEffectueMaladie() {
		return listeTraitementEffectueMaladie;
	}

	public void setListeTraitementEffectueMaladie(List<String> listeTraitementEffectueMaladie) {
		this.listeTraitementEffectueMaladie = listeTraitementEffectueMaladie;
	}

	public List<String> getListeInformationsSupplementairesMaladie() {
		return listeInformationsSupplementairesMaladie;
	}

	public void setListeInformationsSupplementairesMaladie(List<String> listeInformationsSupplementairesMaladie) {
		this.listeInformationsSupplementairesMaladie = listeInformationsSupplementairesMaladie;
	}

	///////////////////////////////////////////////////////////////////////////
	// ToString :
	@Override
	public String toString() {
		return "DossierPatientDto [idDossierPatient=" + idDossierPatient + ", listeIdConsultation="
				+ listeIdConsultation + ", listeDateConsultation=" + listeDateConsultation + ", idPatient=" + idPatient
				+ ", prenomPatient=" + prenomPatient + ", nomPatient=" + nomPatient + ", listeIdMaladie="
				+ listeIdMaladie + ", listeNomMaladie=" + listeNomMaladie + ", listeDateDebutMaladie="
				+ listeDateDebutMaladie + ", listeDateFinMaladie=" + listeDateFinMaladie
				+ ", listeTraitementEffectueMaladie=" + listeTraitementEffectueMaladie
				+ ", listeInformationsSupplementairesMaladie=" + listeInformationsSupplementairesMaladie + "]";
	}

	
}
