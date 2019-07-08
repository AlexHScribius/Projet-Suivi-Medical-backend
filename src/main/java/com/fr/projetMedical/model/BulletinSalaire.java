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
@Table(name = "bulletinSalaire")
@Data
public class BulletinSalaire {
	///////////////////////////////////////////////////////////////////////////
	// Attributs :
	private Long idBulletinSalaire;
	private Double montant;

	private Medecin medecin;

	///////////////////////////////////////////////////////////////////////////
	// Getters & Setters :
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idBulletinSalaire")
	public Long getIdBulletinSalaire() {
		return idBulletinSalaire;
	}

	public void setIdBulletinSalaire(Long idBulletinSalaire) {
		this.idBulletinSalaire = idBulletinSalaire;
	}

	@Column(name="montant")
	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	///////////////////////////////////////////////////////////////////////////
	// Associations :
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idMedecin")
	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	///////////////////////////////////////////////////////////////////////////
	// ToString redéfini :
	@Override
	public String toString() {
		return "BulletinSalaireDto [idBulletinSalaire=" + idBulletinSalaire + ", montant=" + montant + "]";
	}

}
