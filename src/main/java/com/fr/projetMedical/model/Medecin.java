package com.fr.projetMedical.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "medecin")
@Data
public class Medecin {
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

	private List<Consultation> listeConsultations;
	private List<BulletinSalaire> listeBulletinSalaires;

	///////////////////////////////////////////////////////////////////////////
	// Getters && Setters :
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idMedecin")
	public Long getIdMedecin() {
		return idMedecin;
	}

	public void setIdMedecin(Long idMedecin) {
		this.idMedecin = idMedecin;
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

	@Column(name="salaire")
	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	///////////////////////////////////////////////////////////////////////////
	// Association :
	@OneToMany(fetch = FetchType.LAZY, mappedBy="medecin")
	@JsonIgnore
	public List<Consultation> getListeConsultations() {
		return listeConsultations;
	}

	public void setListeConsultations(List<Consultation> listeConsultations) {
		this.listeConsultations = listeConsultations;
	}
	
	@OneToMany(mappedBy = "medecin")
	public List<BulletinSalaire> getListeBulletinSalaires() {
		return listeBulletinSalaires;
	}

	public void setListeBulletinSalaires(List<BulletinSalaire> listeBulletinSalaires) {
		this.listeBulletinSalaires = listeBulletinSalaires;
	}	

	///////////////////////////////////////////////////////////////////////////
	// ToString redéfini :
	@Override
	public String toString() {
		return "MedecinDto [idMedecin=" + idMedecin + ", login=" + login + ", pwd=" + pwd + ", nom=" + nom + ", prenom="
				+ prenom + ", age=" + age + ", adresse=" + adresse + ", mail=" + mail + ", telephone=" + telephone
				+ ", salaire=" + salaire + "]";
	}

}
