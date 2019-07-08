package com.fr.projetMedical.dto;

public class BulletinSalaireDto {
	///////////////////////////////////////////////////////////////////////////
	// Attributs :
	private Long idBulletinSalaire;
	private double montant;

	private Long idMedecin;
	private String prenomMedecin;
	private String nomMedecin;

	///////////////////////////////////////////////////////////////////////////
	// Getters & Setters :
	public Long getIdBulletinSalaire() {
		return idBulletinSalaire;
	}

	public void setIdBulletinSalaire(Long idBulletinSalaire) {
		this.idBulletinSalaire = idBulletinSalaire;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
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

	///////////////////////////////////////////////////////////////////////////
	// ToString :
	@Override
	public String toString() {
		return "BulletinSalaireDto [idBulletinSalaire=" + idBulletinSalaire + ", montant=" + montant + ", idMedecin="
				+ idMedecin + ", prenomMedecin=" + prenomMedecin + ", nomMedecin=" + nomMedecin + "]";
	}

}
