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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="consultation")
public class Consultation {

	///////////////////////////////////////////////////////////////////////////
	// Attributs :
	private Long idConsultation;
	private Date date;
	private Boolean effectuee;
	private Boolean annulee;
	
	private Medecin medecin;
	private DossierPatient dossierPatient;
	private Facture facture;
	
	///////////////////////////////////////////////////////////////////////////
	// Getters && Setters :
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idConsultation")
	public Long getIdConsultation() {
		return idConsultation;
	}

	public void setIdConsultation(Long idConsultation) {
		this.idConsultation = idConsultation;
	}

	@Column(name="date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name="effectuee")
	public Boolean isEffectuee() {
		return effectuee;
	}

	public void setEffectuee(Boolean effectuee) {
		this.effectuee = effectuee;
	}

	@Column(name="annulee")
	public Boolean isAnnulee() {
		return annulee;
	}

	public void setAnnulee(Boolean annulee) {
		this.annulee = annulee;
	}
	
	/////////////////////////////////////////////////////////
	// Associations :	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idMedecin")
	@JsonIgnore
	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idDossierPatient")
	@JsonIgnore
	public DossierPatient getDossierPatient() {
		return dossierPatient;
	}

	public void setDossierPatient(DossierPatient dossierPatient) {
		this.dossierPatient = dossierPatient;
	}

	@OneToOne(mappedBy = "consultation")
	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}	

	///////////////////////////////////////////////////////////////////////////
	// ToString redéfini :
	@Override
	public String toString() {
		return "ConsultationDto [idConsultation=" + idConsultation + ", date=" + date + ", effectuee=" + effectuee
				+ ", annulee=" + annulee + "]";
	}
	
	
}
