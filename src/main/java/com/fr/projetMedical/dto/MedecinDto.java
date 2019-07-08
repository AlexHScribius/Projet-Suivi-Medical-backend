package com.fr.projetMedical.dto;

import java.util.Date;
import java.util.List;

public class MedecinDto {
	///////////////////////////////////////////////////////////////////////////
	// Attributs :
	private Long idMedecin;
	private String login;
	private String pwd;
	private String nom;
	private String prenom;
	private Long age;
	private String adresse;
	private String mail;
	private Long telephone;
	private Double salaire;

	private List<Long> listeIdConsultation;
	private List<Date> listeDateConsultation;
	
	private List<Long> listeIdBulletinSalaire;
	private List<Double> listeMontantBulletinSalaire;

	///////////////////////////////////////////////////////////////////////////
	// Getters && Setters :
	public Long getIdMedecin() {
		return idMedecin;
	}

	public void setIdMedecin(Long idMedecin) {
		this.idMedecin = idMedecin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
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

	public List<Long> getListeIdBulletinSalaire() {
		return listeIdBulletinSalaire;
	}

	public void setListeIdBulletinSalaire(List<Long> listeIdBulletinSalaire) {
		this.listeIdBulletinSalaire = listeIdBulletinSalaire;
	}

	public List<Double> getListeMontantBulletinSalaire() {
		return listeMontantBulletinSalaire;
	}

	public void setListeMontantBulletinSalaire(List<Double> listeMontantBulletinSalaire) {
		this.listeMontantBulletinSalaire = listeMontantBulletinSalaire;
	}

	///////////////////////////////////////////////////////////////////////////
	// ToString :
	@Override
	public String toString() {
		return "MedecinDto [idMedecin=" + idMedecin + ", login=" + login + ", pwd=" + pwd + ", nom=" + nom + ", prenom="
				+ prenom + ", age=" + age + ", adresse=" + adresse + ", mail=" + mail + ", telephone=" + telephone
				+ ", salaire=" + salaire + ", listeIdConsultation=" + listeIdConsultation + ", listeDateConsultation="
				+ listeDateConsultation + ", listeIdBulletinSalaire=" + listeIdBulletinSalaire
				+ ", listeMontantBulletinSalaire=" + listeMontantBulletinSalaire + "]";
	}

	
}
