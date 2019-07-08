package com.fr.projetMedical.dto;

public class PatientDto {
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

	private Long idDossierPatient;

	///////////////////////////////////////////////////////////////////////////
	// Getters && Setters :
	public Long getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
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

	public String getNumeroSecuriteSociale() {
		return numeroSecuriteSociale;
	}

	public void setNumeroSecuriteSociale(String numeroSecuriteSociale) {
		this.numeroSecuriteSociale = numeroSecuriteSociale;
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
		return "PatientDto [idPatient=" + idPatient + ", login=" + login + ", pwd=" + pwd + ", nom=" + nom + ", prenom="
				+ prenom + ", age=" + age + ", adresse=" + adresse + ", mail=" + mail + ", telephone=" + telephone
				+ ", numeroSecuriteSociale=" + numeroSecuriteSociale + ", idDossierPatient=" + idDossierPatient + "]";
	}
	
}
