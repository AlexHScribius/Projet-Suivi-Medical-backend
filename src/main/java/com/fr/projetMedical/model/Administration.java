package com.fr.projetMedical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="administration")
public class Administration {

	///////////////////////////////////////////////////////////////////////////
	// Attributs :
	private Long idAdministration;
	private String login;
	private String pwd;
	
	///////////////////////////////////////////////////////////////////////////
	// Getters && Setters :
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idAdministration")
	public Long getIdAdministration() {
		return idAdministration;
	}

	public void setIdAdministration(Long idAdministration) {
		this.idAdministration = idAdministration;
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

	///////////////////////////////////////////////////////////////////////////
	// Associations :
	
	///////////////////////////////////////////////////////////////////////////
	// ToString redéfini :
	@Override
	public String toString() {
		return "AdministrationDto [idAdministration=" + idAdministration + ", login=" + login + ", pwd=" + pwd + "]";
	}
}
