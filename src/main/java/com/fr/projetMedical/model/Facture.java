package com.fr.projetMedical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "facture")
@Data
public class Facture {
	///////////////////////////////////////////////////////////////////////////
	// Attributs :
	private Long idFacture;
	private Double montant;
	private Boolean payee;

	private Consultation consultation;

	///////////////////////////////////////////////////////////////////////////
	// Getters && Setters :
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idFacture")
	public Long getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}

	@Column(name="montant")
	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	@Column(name="payee")
	public Boolean isPayee() {
		return payee;
	}

	public void setPayee(Boolean payee) {
		this.payee = payee;
	}
	
	///////////////////////////////////////////////////////////////////////////
	// Associations :
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idConsultation")
	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	///////////////////////////////////////////////////////////////////////////
	// ToString redéfini :
	@Override
	public String toString() {
		return "FactureDto [idFacture=" + idFacture + ", montant=" + montant + ", payee=" + payee + "]";
	}

}
