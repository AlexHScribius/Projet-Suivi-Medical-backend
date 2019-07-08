package com.fr.projetMedical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "patient")
@Data
public class Patient {
	///////////////////////////////////////////////////////////////////////////
	// Attributs :
	private Long idPatient;
	private String login;
	private String pwd;
	private String nom;
	private String prenom;
	private Long age;
	private String adresse;
	private String mail;
	private Long telephone;
	private String numeroSecuriteSociale;

	private DossierPatient dossierPatient;

	///////////////////////////////////////////////////////////////////////////
	// Getters && Setters :
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idPatient")
	public Long getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}
	@Column(name="login")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name="pwd")
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name="nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name="prenom")
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name="age")
	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	@Column(name="adresse")
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name="mail")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name="telephone")
	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	@Column(name="numeroSecuriteSociale")
	public String getNumeroSecuriteSociale() {
		return numeroSecuriteSociale;
	}

	public void setNumeroSecuriteSociale(String numeroSecuriteSociale) {
		this.numeroSecuriteSociale = numeroSecuriteSociale;
	}

	///////////////////////////////////////////////////////////////////////////
	// Associations :
	@OneToOne(mappedBy = "patient")
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
		return "PatientDto [idPatient=" + idPatient + ", login=" + login + ", pwd=" + pwd + ", nom=" + nom + ", prenom="
				+ prenom + ", age=" + age + ", adresse=" + adresse + ", mail=" + mail + ", telephone=" + telephone
				+ ", numeroSecuriteSociale=" + numeroSecuriteSociale + "]";
	}
}
