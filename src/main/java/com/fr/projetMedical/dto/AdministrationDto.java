package com.fr.projetMedical.dto;

public class AdministrationDto {

	///////////////////////////////////////////////////////////////////////////
	// Attributs :
	private Long idAdministration;
	private String login;
	private String pwd;
	
	///////////////////////////////////////////////////////////////////////////
	// Getters && Setters :
	public Long getIdAdministration() {
		return idAdministration;
	}

	public void setIdAdministration(Long idAdministration) {
		this.idAdministration = idAdministration;
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
	
	///////////////////////////////////////////////////////////////////////////
	// ToString :
	@Override
	public String toString() {
		return "AdministrationDto [idAdministration=" + idAdministration + ", login=" + login + ", pwd=" + pwd + "]";
	}
}
