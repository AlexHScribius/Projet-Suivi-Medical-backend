package com.fr.projetMedical.dto;

import java.util.Date;

public class FactureDto {
	///////////////////////////////////////////////////////////////////////////
	// Attributs :
	private Long idFacture;
	private Double montant;
	private Boolean payee;

	private Long idConsultation;
	private Date dateConsultation;
	
	private Long idPatient;
	private String nomPatient;
	private String prenomPatient;
	
	private Long idDossierPatient;
	
	private Long idMedecin;
	private String nomMedecin;
	private String prenomMedecin;

	///////////////////////////////////////////////////////////////////////////
	// Getters && Setters :
	public Long getIdFacture() {
		return idFacture;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Boolean isPayee() {
		return payee;
	}

	public void setPayee(Boolean payee) {
		this.payee = payee;
	}

	public Long getIdConsultation() {
		return idConsultation;
	}

	public void setIdConsultation(Long idConsultation) {
		this.idConsultation = idConsultation;
	}

	public Date getDateConsultation() {
		return dateConsultation;
	}

	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}

	public Long getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}

	public String getNomPatient() {
		return nomPatient;
	}

	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}

	public String getPrenomPatient() {
		return prenomPatient;
	}

	public void setPrenomPatient(String prenomPatient) {
		this.prenomPatient = prenomPatient;
	}

	public Long getIdDossierPatient() {
		return idDossierPatient;
	}

	public void setIdDossierPatient(Long idDossierPatient) {
		this.idDossierPatient = idDossierPatient;
	}

	public Long getIdMedecin() {
		return idMedecin;
	}

	public void setIdMedecin(Long idMedecin) {
		this.idMedecin = idMedecin;
	}

	public String getNomMedecin() {
		return nomMedecin;
	}

	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}

	public String getPrenomMedecin() {
		return prenomMedecin;
	}

	public void setPrenomMedecin(String prenomMedecin) {
		this.prenomMedecin = prenomMedecin;
	}

	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}

	///////////////////////////////////////////////////////////////////////////
	// ToString :
	@Override
	public String toString() {
		return "FactureDto [idFacture=" + idFacture + ", montant=" + montant + ", payee=" + payee + ", idConsultation="
				+ idConsultation + ", dateConsultation=" + dateConsultation + ", idPatient=" + idPatient
				+ ", nomPatient=" + nomPatient + ", prenomPatient=" + prenomPatient + ", idDossierPatient="
				+ idDossierPatient + ", idMedecin=" + idMedecin + ", nomMedecin=" + nomMedecin + ", prenomMedecin="
				+ prenomMedecin + "]";
	}


}
