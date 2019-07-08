package com.fr.projetMedical.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="maladie")
@Data
public class Maladie{
	///////////////////////////////////////////////////////////////////////////
	// Attributs :
	private Long idMaladie;
	private String nom;
	private Date dateDebut;
	private Date dateFin;
	private String traitementPreconise;
	private String traitementEffectue;
	private String informationsSupplementaires;
	
	private DossierPatient dossierPatient;
	
	///////////////////////////////////////////////////////////////////////////
	// Getters && Setters :
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idMaladie")
	public Long getIdMaladie() {
		return idMaladie;
	}

	public void setIdMaladie(Long idMaladie) {
		this.idMaladie = idMaladie;
	}

	@Column(name="nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name="dateDebut")
	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	@Column(name="dateFin")
	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@Column(name="traitementPreconise")
	public String getTraitementPreconise() {
		return traitementPreconise;
	}

	public void setTraitementPreconise(String traitementPreconise) {
		this.traitementPreconise = traitementPreconise;
	}

	@Column(name="traitementEffectue")
	public String getTraitementEffectue() {
		return traitementEffectue;
	}

	public void setTraitementEffectue(String traitementEffectue) {
		this.traitementEffectue = traitementEffectue;
	}

	@Column(name="informationsSupplementaires")
	public String getInformationsSupplementaires() {
		return informationsSupplementaires;
	}

	public void setInformationsSupplementaires(String informationsSupplementaires) {
		this.informationsSupplementaires = informationsSupplementaires;
	}

	///////////////////////////////////////////////////////////////////////////
	// Associations :
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDossierPatient")
	@JsonIgnore
	public DossierPatient getDossierPatient() {
		return dossierPatient;
	}

	public void setDossierPatient(DossierPatient dossierPatient) {
		this.dossierPatient = dossierPatient;
	}

	///////////////////////////////////////////////////////////////////////////
	// ToString redéfini :
	@Override
	public String toString() {
		return "MaladieDto [idMaladie=" + idMaladie + ", nom=" + nom + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", traitementPreconise=" + traitementPreconise + ", traitementEffectue=" + traitementEffectue
				+ ", informationsSupplementaires=" + informationsSupplementaires + "]";
	}
	
	
}
