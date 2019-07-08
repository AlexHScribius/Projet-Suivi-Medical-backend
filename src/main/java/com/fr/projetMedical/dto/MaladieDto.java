package com.fr.projetMedical.dto;

import java.util.Date;

public class MaladieDto {
	///////////////////////////////////////////////////////////////////////////
	// Attributs :
	private Long idMaladie;
	private String nom;
	private Date dateDebut;
	private Date dateFin;
	private String traitementPreconise;
	private String traitementEffectue;
	private String informationsSupplementaires;

	private Long idDossierPatient;

	///////////////////////////////////////////////////////////////////////////
	// Getters && Setters :
	public Long getIdMaladie() {
		return idMaladie;
	}

	public void setIdMaladie(Long idMaladie) {
		this.idMaladie = idMaladie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getTraitementPreconise() {
		return traitementPreconise;
	}

	public void setTraitementPreconise(String traitementPreconise) {
		this.traitementPreconise = traitementPreconise;
	}

	public String getTraitementEffectue() {
		return traitementEffectue;
	}

	public void setTraitementEffectue(String traitementEffectue) {
		this.traitementEffectue = traitementEffectue;
	}

	public String getInformationsSupplementaires() {
		return informationsSupplementaires;
	}

	public void setInformationsSupplementaires(String informationsSupplementaires) {
		this.informationsSupplementaires = informationsSupplementaires;
	}

	public Long getIdDossierPatient() {
		return idDossierPatient;
	}

	public void setIdDossierPatient(Long idDossierPatient) {
		this.idDossierPatient = idDossierPatient;
	}

	///////////////////////////////////////////////////////////////////////////
	// ToString :
	@Override
	public String toString() {
		return "MaladieDto [idMaladie=" + idMaladie + ", nom=" + nom + ", dateDebut=" + dateDebut + ", dateFin="
				+ dateFin + ", traitementPreconise=" + traitementPreconise + ", traitementEffectue="
				+ traitementEffectue + ", informationsSupplementaires=" + informationsSupplementaires
				+ ", idDossierPatient=" + idDossierPatient + "]";
	}

}
