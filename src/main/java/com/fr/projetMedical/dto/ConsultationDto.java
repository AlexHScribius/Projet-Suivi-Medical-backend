package com.fr.projetMedical.dto;

import java.util.Date;

public class ConsultationDto {

	///////////////////////////////////////////////////////////////////////////
	// Attributs :
	private Long idConsultation;
	private Date date;
	private boolean effectuee;
	private boolean annulee;
	
	private Long idMedecin;
	private String prenomMedecin;
	private String nomMedecin;
	
	private Long idPatient;
	private String prenomPatient;
	private String nomPatient;
	private Long idDossierPatient;
	
	private Long idFacture;
	private boolean facturePayee;
	
	///////////////////////////////////////////////////////////////////////////
	// Getters && Setters :
	public Long getIdConsultation() {
		return idConsultation;
	}
	public void setIdConsultation(Long idConsultation) {
		this.idConsultation = idConsultation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isEffectuee() {
		return effectuee;
	}
	public void setEffectuee(boolean effectuee) {
		this.effectuee = effectuee;
	}
	public boolean isAnnulee() {
		return annulee;
	}
	public void setAnnulee(boolean annulee) {
		this.annulee = annulee;
	}
	public Long getIdMedecin() {
		return idMedecin;
	}
	public void setIdMedecin(Long idMedecin) {
		this.idMedecin = idMedecin;
	}
	public String getPrenomMedecin() {
		return prenomMedecin;
	}
	public void setPrenomMedecin(String prenomMedecin) {
		this.prenomMedecin = prenomMedecin;
	}
	public String getNomMedecin() {
		return nomMedecin;
	}
	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
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
	public Long getIdDossierPatient() {
		return idDossierPatient;
	}
	public void setIdDossierPatient(Long idDossierPatient) {
		this.idDossierPatient = idDossierPatient;
	}
	public Long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}
	public boolean isFacturePayee() {
		return facturePayee;
	}
	public void setFacturePayee(boolean facturePayee) {
		this.facturePayee = facturePayee;
	}
	
	///////////////////////////////////////////////////////////////////////////
	// ToString :
	@Override
	public String toString() {
		return "ConsultationDto [idConsultation=" + idConsultation + ", date=" + date + ", effectuee=" + effectuee
				+ ", annulee=" + annulee + ", idMedecin=" + idMedecin + ", prenomMedecin=" + prenomMedecin
				+ ", nomMedecin=" + nomMedecin + ", idPatient=" + idPatient + ", prenomPatient=" + prenomPatient
				+ ", nomPatient=" + nomPatient + ", idDossierPatient=" + idDossierPatient + ", idFacture=" + idFacture
				+ ", facturePayee=" + facturePayee + "]";
	}
	

	
	
}
